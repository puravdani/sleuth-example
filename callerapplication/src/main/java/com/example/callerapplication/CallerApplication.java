package com.example.callerapplication;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
@Log4j2
public class CallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallerApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	@Autowired
	private RestTemplate template;

	@PostMapping("/call/{name}")
	public ResponseEntity<String> call(@PathVariable String name){

		log.info("got request for name - {}", name );
		String fooResourceUrl
				= "http://localhost:9001/test";
		log.info("sending request to service test - {}", fooResourceUrl);
		ResponseEntity<String> response
				= template.getForEntity(fooResourceUrl, String.class);
		log.info("received response - {}", response.getBody());
		return new ResponseEntity<>(response.getBody(),response.getHeaders(), HttpStatus.OK);
	}

}
