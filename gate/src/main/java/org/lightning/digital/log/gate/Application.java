package org.lightning.digital.log.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author WeRn
 */
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"org.lightning.digital.log.gate"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}