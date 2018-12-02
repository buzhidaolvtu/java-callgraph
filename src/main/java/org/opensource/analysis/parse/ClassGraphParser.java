package org.opensource.analysis.parse;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.opensource.analysis.classloader.ClassGraphClassLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class ClassGraphParser {

    public static void main(String[] args) throws IOException {
        String cp = "/Users/lvtu/workspace/java-callgraph/target/classes/,/Users/lvtu/workspace/sandbox-boot-agent/sandbox-boot-loader/target/classes,/Users/lvtu/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar";
        List<URL> urls = parseToUrls(cp);
        List<String> allClasses = new ClassGraphParser().findAllClasses(urls);
        ClassGraphClassLoader classGraphClassLoader = new ClassGraphClassLoader(toUrlArray(urls));

        System.out.println(allClasses);
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


    private List<String> findAllClasses(List<URL> urls) throws IOException {
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

    private List<String> findAllClassesInJar(File jarFile) throws IOException {
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
    }


}
