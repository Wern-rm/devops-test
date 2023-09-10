package org.lightning.digital.log.gate.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WeRn
 */
@Data
@AllArgsConstructor
public class LogSystemsTemplate {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sys_name")
    private String sysName;

    @JsonProperty("status")
    private boolean status;
}
