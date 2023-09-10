package org.lightning.digital.log.gate.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author WeRn
 */
@Getter
@Configuration
public class SpringSwaggerConfig {

	@Value("${info.backend.name}")
	private String name;

	@Value("${info.backend.version}")
	private String version;

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(
						new Info()
								.title(getName())
								.version(getVersion()))
				.servers(List.of(
						new Server()
								.description("Local server")
								.url("http://localhost:8080/api")));
	}
}