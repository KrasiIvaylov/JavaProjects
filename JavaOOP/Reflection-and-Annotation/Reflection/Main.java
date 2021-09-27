package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.sql.Ref;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        Scanner scan = new Scanner(System.in);

        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getSuperclass().getSimpleName());
        Class<?>[ ] interfaces = clazz.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }

        Reflection instance =
                (Reflection) clazz.getDeclaredConstructor().newInstance();

        System.out.println(instance.toString());
    }
}
