package org.lightning.digital.log.gate.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WeRn
 */
@Data
@AllArgsConstructor
public class IndexResponse {

    @JsonProperty("status")
    private int status;

    @JsonProperty("version")
    private String version;

    @JsonProperty("message")
    private String message;
}
