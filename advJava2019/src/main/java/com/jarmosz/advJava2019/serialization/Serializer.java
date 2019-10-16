package com.jarmosz.advJava2019.serialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.function.Supplier;

@Component
public class Serializer implements Serializable {

    private String name;
    private int age;
    private static final Logger logger = LoggerFactory.getLogger(Serializer.class);
    private static final long serialVersionUID = 11L;
    //    12. It will return java.io.NotSerializableException
    private Supplier<Integer> supplier = () -> this.age = 12;

    @PostConstruct
    private void saveAndReadFromFile() {
        try {
            Object newObject = Serializer.class.newInstance();
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("objectSaved.dat"));
            outputStream.writeObject(newObject);

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("objectSaved.dat"));
            Object readerObject = (Serializer) inputStream.readObject();

            outputStream.close();
            inputStream.close();


            // 10. These objects are different
            // 11. InvalidClassException will be return, because one of the objects (from output stream) doesn't have serialVersionUID field,
            // and in result they are incompatibile.
            logger.info("Are objects from Input / Output Stream the same? {}", String.valueOf(newObject.equals(readerObject)));

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }



}
