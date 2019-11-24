package io.pivotal.issuesdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties.class)
public class BrianclozelApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrianclozelApplication.class, args);
	}

}
