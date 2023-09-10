package org.lightning.digital.log.gate.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddLogResponse {

    @JsonProperty("status")
    private boolean status;

    @JsonProperty("message")
    private String message;
}

