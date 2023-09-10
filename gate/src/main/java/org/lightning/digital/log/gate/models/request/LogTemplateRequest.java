package org.lightning.digital.log.gate.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WeRn
 */
@Data
@AllArgsConstructor
public class LogTemplateRequest {

    @JsonProperty("system_id")
    private int systemId;

    @JsonProperty("log_level")
    private String logLevel;

    @JsonProperty("message")
    private String message;
}
