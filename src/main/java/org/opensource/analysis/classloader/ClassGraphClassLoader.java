package org.opensource.analysis.classloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class ClassGraphClassLoader extends URLClassLoader{


    public ClassGraphClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public ClassGraphClassLoader(URL[] urls) {
        super(urls);
    }

    public ClassGraphClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }



}
