package org.lightning.digital.log.gate.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.lightning.digital.log.gate.models.LogTemplate;

import java.util.List;

/**
 * @author WeRn
 */
@Data
@AllArgsConstructor
public class LogTemplateResponse {

    @JsonProperty("logs")
    private List<LogTemplate> logs;
}
