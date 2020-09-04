package cn.sysu.circuitQA;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("cn.sysu.circuitQA.mapper")
public class CircuitQA extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CircuitQA.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CircuitQA.class);
	}
}
