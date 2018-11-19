package org.opensource.analysis.byclass;

import java.util.List;

public class ConcreteClass extends GenericClass<String> {

    public static void callMethod() {
        String o = genericMethod("abc");
    }


    public static <T> T genericMethod(T parameter) {
        return (T) "genericMethod";
    }

    public static <T, K> T genericMethod2(List<K> parameter) {
        return null;
    }


}
