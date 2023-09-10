package org.lightning.digital.log.gate.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WeRn
 */
@Data
@AllArgsConstructor
public class LogTemplate {

    @JsonProperty("id")
    private int id;

    @JsonProperty("system_id")
    private int systemId;

    @JsonProperty("log_level") //ERROR, WARN, INFO
    private String logLevel;

    @JsonProperty("message")
    private String message;

    @JsonProperty("at_create")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS")
    private LocalDateTime atCreate;
}
