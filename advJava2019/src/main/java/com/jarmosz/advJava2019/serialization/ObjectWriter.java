package com.jarmosz.advJava2019.serialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;

@Component
public class ObjectWriter {
    private static final Logger logger = LoggerFactory.getLogger(ObjectWriter.class);

//     14. Return EOF Exception
    @PostConstruct
    private void writeObjectFromFile() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            while( inputStream.available() > 0){
                logger.info(inputStream.readObject().toString());
            }
            inputStream.close();
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }

    }
}
