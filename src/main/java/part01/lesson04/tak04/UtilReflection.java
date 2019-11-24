package part01.lesson04.tak04;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;


public class UtilReflection {


    static  void cleanup(Object o, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) throws IllegalAccessException, NoSuchFieldException {

        if (o instanceof Map) {
            getValues(o, fieldsToCleanup, fieldsToOutput);

        } else {
            getFields(o, fieldsToCleanup, fieldsToOutput);
        }
    }


    /**
     *  In this method  get Elements Map by list keys Set
     * @param o
     * @param fieldsToCleanup
     * @param fieldsToOutput
     */
    private static void getValues(Object o, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
        Map map= (Map) o;
        Set setKey= map.keySet();
        Iterator iterator=setKey.iterator();

        while (iterator.hasNext()) {
            Object key=iterator.next();
            if (fieldsToCleanup.contains((String)key)) {
                iterator.remove();
            }
            if (fieldsToOutput.contains((String) key)) {
                System.out.println(key + "=" + map.get(key));

            }

        }

    }


    /**
     * In this get fields object by list from Set
     * @param o
     * @param fieldsToCleanup
     * @param fieldsToOutput
     * @throws IllegalAccessException
     */
    private static void getFields(Object o, Set<String> fieldsToCleanup, Set<String> fieldsToOutput)  throws  IllegalAccessException{
        Class clazz=o.getClass();
        Field[] fields=clazz.getDeclaredFields();
        for (Field field : fields) {
            outputRemove(field,o,fieldsToCleanup);
            fieldAvailability(field,o,fieldsToOutput);
             
        }
    }

    /**
     * In this method  the presence the output is checked
     * @param field
     * @param o
     * @param fieldsToOutput
     * @throws IllegalAccessException
     */
    private static void fieldAvailability(Field field, Object o, Set<String> fieldsToOutput)  throws IllegalAccessException{
        if (fieldsToOutput.contains(field.getName())) {
            if (field.getType().isPrimitive()) {
                String str=String.valueOf(field.get(o));
                System.out.println(str);
            }else  {
                if (field.get(o)== null)
                    return;
                String s=field.get(o).toString();
                System.out.println(s);
            }
        }else  {
            throw new IllegalArgumentException("there is no such field for output");
        }
    }

    /**
     * in this method the checks for a field to set default values
     * @param field
     * @param o
     * @param fieldsToCleanup
     * @throws IllegalAccessException
     */
    private static void outputRemove(Field field, Object o, Set<String> fieldsToCleanup) throws IllegalAccessException {
        if (fieldsToCleanup.contains(field.getName())){
            if (Modifier.isPrivate(field.getModifiers())) field.setAccessible(true);
                defaultValues(field,o);
        }else  {
            throw new IllegalArgumentException(" there is no such field in Set ");
        }
    }

    /**
     * Setting values by default
     * @param field
     * @param o
     * @throws IllegalAccessException
     */
    private static void defaultValues(Field field, Object o)  throws  IllegalAccessException {
        switch (field.getType().toString()){
            case "byte":
                field.setByte(o, (byte) 0);
                break;
            case "short":
                field.setShort(o, (short) 0);
                break;
            case "int":
                field.setInt(o,0);
                break;
            case "long":
                field.setLong(o,0);
                break;
            case "float":
                field.setFloat(o,0);
                break;
            case "double":
                field.setDouble(o,0);
                break;
            case "boolean":
                field.setBoolean(0,false);
                break;
            case "char":
                field.setChar(0,'\u0000');
                break;
            default:
                field.set(o,null);
                break;
        }
      }
    }






