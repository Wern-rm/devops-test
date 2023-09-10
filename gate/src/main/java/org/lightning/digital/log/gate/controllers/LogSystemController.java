package org.lightning.digital.log.gate.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.lightning.digital.log.gate.models.request.LogSystemsTemplateRequest;
import org.lightning.digital.log.gate.models.response.AddSystemResponse;
import org.lightning.digital.log.gate.models.response.LogSystemsTemplateResponse;
import org.lightning.digital.log.gate.servers.ILoggingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author WeRn
 */
@Log4j2
@RequiredArgsConstructor
@RestController
@Tag(name = "Log Systems")
@RequestMapping("/api/v1.0/log/system")
public class LogSystemController {

    private final ILoggingService loggingService;

    @Operation(summary = "System List")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogSystemsTemplateResponse> index() {
        log.info("[LogSystemController]: Select all systems");
        return new ResponseEntity<>(new LogSystemsTemplateResponse(loggingService.getLogSystems()), HttpStatus.OK);
    }

    @Operation(summary = "Add System")
    @PostMapping(
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddSystemResponse> addSystem(@RequestBody LogSystemsTemplateRequest request) {
        log.info("[LogSystemController]: RequestParams: {}.", request.toString());
        loggingService.insertLogSystem(request);
        return new ResponseEntity<>(new AddSystemResponse(true, "Success add new system."), HttpStatus.OK);
    }
}