package org.lightning.digital.log.gate.servers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.lightning.digital.log.gate.db.LogsDAO;
import org.lightning.digital.log.gate.models.LogSystemsTemplate;
import org.lightning.digital.log.gate.models.LogTemplate;
import org.lightning.digital.log.gate.models.request.LogSystemsTemplateRequest;
import org.lightning.digital.log.gate.models.request.LogTemplateRequest;
import org.lightning.digital.log.gate.servers.ILoggingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WeRn
 */
@Getter
@Log4j2
@Service
@RequiredArgsConstructor
public class LoggingService implements ILoggingService {

    private final ObjectMapper objectMapper;

    private final LogsDAO logsDAO;

    @Override
    public List<LogTemplate> getLogs() {
        return logsDAO.getLogs();
    }

    @Override
    public boolean insertLog(LogTemplateRequest request) {
        if (!logsDAO.isExitsLogSystem(request.getSystemId())) {
            return false;
        }
        logsDAO.createNewLog(request.getSystemId(), request.getLogLevel(), request.getMessage());
        return true;
    }

    @Override
    public List<LogSystemsTemplate> getLogSystems() {
        return logsDAO.getLogSystems();
    }

    @Override
    public void insertLogSystem(LogSystemsTemplateRequest request) {
        logsDAO.createNewLogSystem(request.getName(), request.getSysName());
    }
}