package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendFinalApplication.class, args);
	}
@Bean
 public WebMvcConfigurer corsConfigurer2(){
     return new WebMvcConfigurer(){
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                @CrossOrigin(origins = "https://ejercicio20-86165.web.app/", methods= {RequestMethod.GET,RequestMethod.POST})
                .allowCredentials(true)
                .allowedHeaders("Origin", "Authorization", "Content-Type")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
   };
 }


}
