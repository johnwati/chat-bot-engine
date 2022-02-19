package com.jonwat.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@ComponentScan("com.myapp.repositories")
//@RefreshScope
//@EnableDiscoveryClient
@EnableJpaAuditing 
@EnableScheduling
public class BotApplication {

	public static void main(String[] args)  {
		SpringApplication.run(BotApplication.class, args);
	}

}
