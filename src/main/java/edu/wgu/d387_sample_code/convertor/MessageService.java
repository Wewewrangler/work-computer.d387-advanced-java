package edu.wgu.d387_sample_code.convertor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;
/*		FROM THE MULTITHREADING VIOEO		*/
//todo             !!!!and FROM C3P0!!!
public class MessageService {

    private final ExecutorService messageExecutor = newFixedThreadPool(5);

    public List<String> getMessage() {
        //creating the list used to store the messages
        //and the properties needed
        Properties properties = new Properties();
        List<String> messages = new ArrayList<>();

        //Execute message retrieval in threads
        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                messages.add(properties.getProperty("welcome"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                messages.add(properties.getProperty("welcome"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Wait for the threads to complete and return the JSON array

        //this tells the console to shut down the Executor
        messageExecutor.shutdown();
        //this doubles check that the executor is shut down
        while (!messageExecutor.isTerminated()) {
            // Wait for all threads to finish
        }
        return messages;
    }
}
