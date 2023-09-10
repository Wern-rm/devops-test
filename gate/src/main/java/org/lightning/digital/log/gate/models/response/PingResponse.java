package org.lightning.digital.log.gate.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PingResponse {

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("message")
    private String message;
}

