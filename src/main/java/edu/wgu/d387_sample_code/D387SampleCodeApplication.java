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
	}

}
