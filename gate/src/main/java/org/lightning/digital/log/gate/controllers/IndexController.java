package org.lightning.digital.log.gate.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.lightning.digital.log.gate.models.response.IndexResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@Tag(name = "System")
public class IndexController {

	@Value("${info.backend.version}")
	private String version;

	@Value("${info.backend.name}")
	private String name;

	@Operation(summary = "LogGate info")
	@GetMapping(
			value = "/",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<IndexResponse> index() {
		return new ResponseEntity<>(new IndexResponse(200, version, name), HttpStatus.OK);
	}
}