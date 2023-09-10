package org.lightning.digital.log.gate.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WeRn
 */
@Data
@AllArgsConstructor
public class LogSystemsTemplateRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("sys_name")
    private String sysName;
}
