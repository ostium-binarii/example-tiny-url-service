package com.danieloh.tinyurl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starts the Tiny URL Service on the local host.
 */
@SpringBootApplication
@Slf4j
public class Application implements ApplicationRunner {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(final ApplicationArguments args) {
		try {
			log.info("The tiny URL service is running.");
			// in real life would do other things like init the DB, etc.
		} finally {
			log.info("The tiny URL service is shutting down.");
			// in real life would engage in clean up activities.
		}
	}

}
