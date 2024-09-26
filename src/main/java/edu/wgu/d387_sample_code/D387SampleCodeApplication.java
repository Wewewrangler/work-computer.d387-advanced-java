package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {
	//todo	THE PROFESSOR HAD LINES 36,37 and 40,41 commented out

	//todo FIX THE PARAMETERS() FOR THE "newFixedThreadPool()"
	static ExecutorService messageExecutor = newFixedThreadPool();

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);
		Properties properties = new Properties();

		/***********************************************************/
		/*		FROM THE MULTITHREADING VIOEO		*/
			//the french output

		//todo	THE PROFESSOR HAD LINES 36,37 and 40,41 commented out
		messageExecutor.execute(() -> {
			try {
				InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
//				stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
//				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
//				stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
//				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

			//english output
		messageExecutor.execute(() -> {
			try {
				InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
//				stream = new ClassPathResource("translation_en_US.properties").getInputStream();
//				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
//				stream = new ClassPathResource("translation_en_US.properties").getInputStream();
//				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		/***********************************************************/
	}

}
