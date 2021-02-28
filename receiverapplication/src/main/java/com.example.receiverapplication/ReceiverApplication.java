package com.example.httpresponse;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Log4j2
public class ReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiverApplication.class, args);
	}

	@GetMapping ("/test")
	public ResponseEntity<String> testMethod(){
		log.info("call made");
		MultiValueMap<String, String>  headers = new HttpHeaders();
		headers.add("myname","realname");
		headers.add("time", "12");
		headers.add("myname1","realname");
		headers.add("time1", "12");
		headers.add("myname2","realname");
		headers.add("time2", "12");
		headers.add("myname3","realname");
		headers.add("time3", "12");

		return new ResponseEntity<>("Hello World!",headers, HttpStatus.OK);
	}

}
