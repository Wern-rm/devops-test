package org.lightning.digital.log.gate.servers;

import org.lightning.digital.log.gate.models.LogSystemsTemplate;
import org.lightning.digital.log.gate.models.LogTemplate;
import org.lightning.digital.log.gate.models.request.LogSystemsTemplateRequest;
import org.lightning.digital.log.gate.models.request.LogTemplateRequest;

import java.util.List;

/**
 * @author WeRn
 */
public interface ILoggingService {

    List<LogTemplate> getLogs();

    boolean insertLog(LogTemplateRequest request);

    List<LogSystemsTemplate> getLogSystems();

    void insertLogSystem(LogSystemsTemplateRequest request);
}
