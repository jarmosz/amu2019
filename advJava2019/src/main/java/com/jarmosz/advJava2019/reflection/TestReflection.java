package com.jarmosz.advJava2019.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class TestReflection {

    private static final Logger logger = LoggerFactory.getLogger(TestReflection.class);
    public String firstField;
    private int secondField;
    private ArrayList<Double> thirdField;

    public TestReflection() {
        logger.info("Hello from public constructor!");
    }

    private void sayHello(int testParameter, float secondTestParameter){
        logger.info("Hello!");
    }

    public void sayGoodbye(char testParameter){
        logger.info("Goodbye");
    }

    public static Object createObjectFromName(String name) {
        try {
            Class newClass = Class.forName(name);
            Constructor privateConstructor = newClass.getDeclaredConstructor();
            privateConstructor.setAccessible(true);
            Method privateMethod = newClass.getDeclaredMethod("sayName");
            privateMethod.setAccessible(true);
            Field privateField = newClass.getDeclaredField("name");
            privateField.setAccessible(true);
            Object newObject = privateConstructor.newInstance();
            privateField.set(newObject, "Tom");
            privateMethod.invoke(newObject);
            return newObject;
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | NoSuchFieldException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @PostConstruct
    public void testReflection()  {

        // Methods from TestReflection class.
        logger.info("1. Methods: {}", Arrays.toString(TestReflection.class.getDeclaredMethods()));
        // Methods types parameters from TestReflection class.
        ArrayList<Class> parameterTypes = new ArrayList<>();
        for(Method method : TestReflection.class.getDeclaredMethods()) {
            for (Class cls : method.getParameterTypes()) {
                parameterTypes.add(cls);
            }
        }
        logger.info("2. Methods arguments types: {}", parameterTypes);
        // Fields from TestReflection class.
        logger.info("3. Fields: {} {}", TestReflection.class.getFields(), TestReflection.class.getDeclaredFields());
        // Constructors from TestReflection class.
        logger.info("4. Constructors: {}", TestReflection.class.getDeclaredConstructors());

        // Instantiate class TestReflection
        try{
            Object newObject = TestReflection.class.newInstance();
        }
        catch(IllegalAccessException | InstantiationException ex){
            ex.printStackTrace();
        }

        // Instantiate class from name, access to private constructor, private method and change private field value.
        Object secondNewObject = createObjectFromName("com.jarmosz.advJava2019.reflection.TestClass");
    }
}
