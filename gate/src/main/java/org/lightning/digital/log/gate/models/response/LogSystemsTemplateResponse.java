package org.lightning.digital.log.gate.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.lightning.digital.log.gate.models.LogSystemsTemplate;

import java.util.List;

/**
 * @author WeRn
 */
@Data
@AllArgsConstructor
public class LogSystemsTemplateResponse {

    @JsonProperty("systems")
    private List<LogSystemsTemplate> systems;
}
