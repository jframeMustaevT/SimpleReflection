package part01.lesson04.tak04;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UtilReflection {
    public static void main(String[] args) {
    }

    /**
     * @param o
     * @param fieldsToCleanup name fields
     * @param fieldsToOutput name fields
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
     void cleanup(Object o, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) throws IllegalAccessException, NoSuchFieldException {

        Class<?> clazz = o.getClass();
        Class obj = clazz;
        Class[] interfaces = obj.getInterfaces();

        Set<String> setToClean = new HashSet<String>();
        Set<String> setToOut = new HashSet<String>();

        boolean isExecuteMap = false;
        for (Class anInterface : interfaces) {
            if (anInterface.getName().equals(Map.class)) {
                isExecuteMap = true;
                break;
            }
        }

        if (isExecuteMap) {
            Set<?> setContainsKey = ((Map) o).keySet();
            for (Object objSet : setContainsKey) {
                setToClean = cleanTo(((Map) o).get(objSet), fieldsToCleanup);
                setToOut = cleanToOut(((Map) o).get(objSet), fieldsToOutput);
                cleanToObject(((Map)o).get(objSet),setToClean);
                cleanToOutputObject(((Map)o).get(objSet),setToOut);
            }
        } else {

        }

    }

    /**
     * @param o
     * @param fieldsToCleanup
     * @return
     */
    private static Set<String> cleanTo(Object o, Set<String> fieldsToCleanup) {
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Set<String> setToClean = new HashSet<>();
        for (Field field : fields) {
            if (fieldsToCleanup.contains(field.getName())) {
                setToClean.add(field.getName());
            }
        }
        return setToClean;

    }

    /**
     * @param o
     * @param fieldsToOutput
     * @return
     */
    private static Set<String> cleanToOut(Object o, Set<String> fieldsToOutput) {
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Set<String> setToOut = new HashSet<>();
        for (Field field : fields) {
            if (fieldsToOutput.contains(field.getName())) {
                setToOut.add(field.getName());
            }
        }
        return setToOut;
    }


    /**
     * @param o
     * @param fieldsToCleanup
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static void cleanToObject(Object o, Set<String> fieldsToCleanup) throws
            NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        for (String fieldsOutObject : fieldsToCleanup) {
            Field field = clazz.getDeclaredField(fieldsOutObject);

            if (!field.isAccessible()) field.setAccessible(true);
            if (field.getType().isPrimitive()) {

            } else {
                field.set(o, null);
            }
        }
    }


    /**
     * @param o
     * @param fieldsToOutput
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static void cleanToOutputObject(Object o, Set<String> fieldsToOutput) throws
            NoSuchFieldException, IllegalAccessException {
            Class<?> clazz = o.getClass();
            for (String fieldsOutObject : fieldsToOutput) {
                Field field = clazz.getDeclaredField(fieldsOutObject);

                if (!field.isAccessible()) field.setAccessible(true);
                if (field.getType().isPrimitive()) {

                } else {
                    field.set(o, null);
                }
            }
        }
    }






