package org.zerock.mrerview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MrerviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrerviewApplication.class, args);
	}

}
