package com.huahouye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerEmbeddedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerEmbeddedApplication.class, args);
	}

}

@RestController
@RequestMapping("/api/simple")
class TestController {

	@Autowired
	private Environment environment;

	@Value("${info.foo}")
	private String barFromValue;

	@GetMapping
	public String simple() {
		var barFromEnv = environment.getProperty("info.foo");
		return "simple test, barFromValue = " + barFromValue + ", barFromEnv = " + barFromEnv;
	}

}
