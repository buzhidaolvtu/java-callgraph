package org.opensource.analysis.parse;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.opensource.analysis.classloader.ClassGraphClassLoader;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class GraphClassResolver {

    private ClassLoader classLoader;

    private ResolvedTable resolvedTable;

    private String classpath;

    private GraphMethodResolver methodResolver;

    public GraphClassResolver(String cp) {
        this.classpath = cp;
        List<URL> urlList = parseToUrls(cp);
        classLoader = new ClassGraphClassLoader(toUrlArray(urlList));
        resolvedTable = new ResolvedTable();
        methodResolver = new GraphMethodResolver(this);
    }

    public boolean resolveClass(String className) {
        if (resolvedTable.containsClass(className)) {
            return true;
        }
        try {
            InputStream resourceAsStream = classLoader.getResourceAsStream(className + ".class");
            ClassReader cr = new ClassReader(resourceAsStream);
            ClassVisitor cw = new GraphClassVisitor(this);
            cr.accept(cw, ClassReader.EXPAND_FRAMES);
            return true;
        } catch (Exception ex) {
            resolvedTable.addFailedClass(className);
            ex.printStackTrace();
            return false;
        }
    }

    public void resolveAllClasses() {
        try {
            List<URL> urlList = parseToUrls(classpath);
            List<String> allClasses = findAllClasses(urlList);

            for (int i = 0; i < allClasses.size(); i++) {
                InputStream ins = classLoader.getResourceAsStream(allClasses.get(i));
                ClassReader cr = new ClassReader(ins);
                ClassVisitor cw = new GraphClassVisitor(this);
                cr.accept(cw, ClassReader.EXPAND_FRAMES);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static URL[] toUrlArray(List<URL> urls) {
        URL[] urlArr = new URL[urls.size()];
        for (int i = 0; i < urls.size(); i++) {
            urlArr[i] = urls.get(i);
        }
        return urlArr;
    }

    private static List<URL> parseToUrls(String classpath) {
        List<String> strings = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(classpath);
        return strings.stream().map(str -> toURL(str)).collect(Collectors.toList());
    }

    private static URL toURL(String url) {
        try {
            return Paths.get(url).toUri().toURL();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    private List<String> findAllClasses(List<URL> urls) {
        if (CollectionUtils.isEmpty(urls)) {
            return Lists.newArrayList();
        }

        List<String> classes = Lists.newArrayList();

        for (int i = 0; i < urls.size(); i++) {
            URL url = urls.get(i);
            File file = new File(url.getFile());
            if (file.isDirectory()) {
                classes.addAll(findAllClassesInDir(file));
            } else if (file.getName().endsWith(".jar")) {
                classes.addAll(findAllClassesInJar(file));
            }

        }
        return classes;
    }

    private List<String> findAllClassesInDir(File dir) {
        Collection<File> files = FileUtils.listFiles(dir, TrueFileFilter.TRUE, TrueFileFilter.TRUE);
        List<String> collect = files.stream()
                .filter(file -> file.getName().endsWith(".class"))
                .map(file -> StringUtils.substring(file.getPath(), dir.getPath().length() + 1))
                .collect(Collectors.toList());
        return collect;
    }

    private List<String> findAllClassesInJar(File jarFile) {
        try {
            JarFile jar = new JarFile(jarFile);
            Enumeration<JarEntry> entries = jar.entries();
            List<String> classes = Lists.newArrayList();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().endsWith(".class")) {
                    classes.add(entry.getName());
                }
            }
            return classes;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public ResolvedTable getResolvedTable() {
        return resolvedTable;
    }

    public String getClasspath() {
        return classpath;
    }
}
