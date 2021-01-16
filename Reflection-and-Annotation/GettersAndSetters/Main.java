package GettersAndSetters;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }
    public static void main(String[] args) throws
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);


        Class<?> clazz = Class.forName("GettersAndSetters.Reflection");

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Set<Method> getters = new TreeSet<>(new MethodComparator());
        Set<Method> setters = new TreeSet<>(new MethodComparator());

        for (Method method : declaredMethods) {
            if (method.getName().startsWith("get")
            && method.getParameterCount() == 0
            && method.getReturnType() != void.class){
                getters.add(method);
            }else if (method.getName().startsWith("set")
                    && method.getParameterCount() == 1
                    && method.getReturnType() == void.class){
                setters.add(method);
            }
        }
        System.out.println(getters.stream()
                .map(g -> String.format("%s will return %s",
                        g.getName(), g.getReturnType()))
        .collect(Collectors.joining(System.lineSeparator())));
        System.out.println(setters.stream()
                .map(g -> String.format("%s and will set field of %s",
                        g.getName(), g.getParameterTypes()[0]))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
