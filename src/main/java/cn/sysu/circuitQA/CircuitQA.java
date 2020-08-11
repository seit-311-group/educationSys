package cn.sysu.circuitQA;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.sysu.circuitQA.mapper")
public class CircuitQA {

	public static void main(String[] args) {
		SpringApplication.run(CircuitQA.class, args);
	}
}
