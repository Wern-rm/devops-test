package org.lightning.digital.log.gate.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.lightning.digital.log.gate.models.response.PingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@Tag(name = "System")
public class PingController {
    @Operation(summary = "LogGate ping")
    @GetMapping(
            value = "/ping",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PingResponse> ping(HttpServletRequest request) {
        return new ResponseEntity<>(new PingResponse(request.getRemoteAddr(), "OK"), HttpStatus.OK);
    }
}
