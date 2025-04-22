package com.mca.Thirun;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController
public class ThirunApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirunApplication.class, args);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello from Spring Boot New Function !";
	}
}
