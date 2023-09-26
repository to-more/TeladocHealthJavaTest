package com.teladoc.teladocJavaTest;

import com.teladoc.teladocJavaTest.models.NaturalAddition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class TeladocJavaTestApplication implements CommandLineRunner {
	private static Logger LOG = LoggerFactory.getLogger(TeladocJavaTestApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(TeladocJavaTestApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		NaturalAddition naturalAddition = new NaturalAddition();
		try {
			if(args.length == 2){
				LOG.info("Addition with arguments");
				LOG.info("Addition {} + {} = {}", args[0], args[1], naturalAddition.addNumbers(args[0], args[1]));
			} else {
				LOG.info("Addition without arguments");
				LOG.info("Addition ==> 123456789012345678901 + 12345678 = {}", naturalAddition.addNumbers("123456789012345678901", "012345678"));
				LOG.info("Addition ==> 123 + 11 = {}", naturalAddition.addNumbers("123", "11"));
			}
		} catch (Exception e){
			LOG.error("There was an error in the given args args[0] => {} args[0] => {}", args[0], args[1]);
			LOG.error(e.getMessage());
		}
	}
}
