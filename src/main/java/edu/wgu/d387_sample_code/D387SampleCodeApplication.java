package edu.wgu.d387_sample_code;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {

	//todo MAYBE CHANGE THE "newFixedThreadPool(5)" to "Executors.newSingleThreadExecutor()"
	static ExecutorService messageExecutor = newFixedThreadPool(5);

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);
		Properties properties = new Properties();

		//initializing the list that WILL hold the 2 properties
		List<String> messages = new ArrayList<>();
		/***********************************************************/
		/*		FROM THE MULTITHREADING VIOEO		*/
			//the french output

		messageExecutor.execute(() -> {
			try {
				InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
				properties.load(stream);
				messages.add(properties.getProperty("welcome"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

			//english output
		messageExecutor.execute(() -> {
			try {
				InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
				properties.load(stream);
				messages.add(properties.getProperty("welcome"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		/***********************************************************/

		// Wait for the threads to complete and return the JSON array

		//this tells the console to shut down the Executor
		messageExecutor.shutdown();
		//this doubles check that the executor is shut down
		while (!messageExecutor.isTerminated()) {
			// Wait for all threads to finish
		}

		try {
			// Convert the messages list to a JSON array
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonArray = objectMapper.writeValueAsString(messages);
			System.out.println("Messages in JSON format: " + jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
