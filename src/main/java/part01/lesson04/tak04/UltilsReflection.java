package part01.lesson04.tak04;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UltilsReflection {
    public static void cleanup(Object to, Object from) {
        List<Method> listTo = methods("set", to);
        List<Method> listFrom = methods("get", to);
        Iterator<Method> iterator=listTo.iterator();
        for (Method methodFrom : listFrom) {
            if (iterator.hasNext()) {
                try {
                    iterator.next().invoke(to, methodFrom.invoke(from,null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }


private static List<Method> methods(String name, Object o) {
        List<Method> list = new ArrayList<Method>();
        Class clazz= o.getClass();
    Method[] methods = clazz.getMethods();
    String s;
    for (Method method : methods) {
        String s2=" ";
        s=method.getName();
        for (int i = 0; i < s.length(); i++) {
            s2 +=s.charAt(i);
            if (s2.equals(name)) {
                list.add(method);
                break;
            }

        }
    }

    return list;
    }

}