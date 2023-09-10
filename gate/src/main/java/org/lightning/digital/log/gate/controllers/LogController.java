package org.lightning.digital.log.gate.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.lightning.digital.log.gate.models.request.LogTemplateRequest;
import org.lightning.digital.log.gate.models.response.AddLogResponse;
import org.lightning.digital.log.gate.models.response.LogTemplateResponse;
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
@Tag(name = "Logs")
@RequestMapping("/api/v1.0/log")
public class LogController {

    private final ILoggingService loggingService;

    @Operation(summary = "Log List")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogTemplateResponse> index() {
        log.info("[LogController]: Select all logs");
        return new ResponseEntity<>(new LogTemplateResponse(loggingService.getLogs()), HttpStatus.OK);
    }

    @Operation(summary = "Add Log")
    @PostMapping(
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddLogResponse> addSystem(@RequestBody LogTemplateRequest request) {
        log.info("[LogController]: RequestParams: {}.", request.toString());
        if (loggingService.insertLog(request)) {
            return new ResponseEntity<>(new AddLogResponse(true, "Success add new log."), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new AddLogResponse(false, "Error add new log. System ID is none."), HttpStatus.OK);
        }
    }
}