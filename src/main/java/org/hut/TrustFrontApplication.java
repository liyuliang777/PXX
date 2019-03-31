package org.hut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.hut.dao")
public class TrustFrontApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrustFrontApplication.class, args);
	}
}
