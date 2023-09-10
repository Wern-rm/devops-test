package org.lightning.digital.log.gate.db;

import org.apache.ibatis.annotations.*;
import org.lightning.digital.log.gate.models.LogSystemsTemplate;
import org.lightning.digital.log.gate.models.LogTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WeRn
 */
@Mapper
@Repository
public interface LogsDAO {

	@Select("SELECT id, system_id, log_level, message, at_create FROM logging_history;")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "systemId", column = "system_id"),
			@Result(property = "logLevel", column = "log_level"),
			@Result(property = "message", column = "message"),
			@Result(property = "atCreate", column = "at_create"),
	})
	List<LogTemplate> getLogs();

	@Insert("INSERT INTO logging_history (system_id, log_level, message) VALUES (#{system_id}, #{log_level}, #{message});")
	void createNewLog(@Param("system_id") int systemId, @Param("log_level") String logLevel, @Param("message") String message);

	@Select("SELECT id, name, sys_name, status FROM logging_system;")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "sysName", column = "sys_name"),
			@Result(property = "status", column = "status"),
	})
	List<LogSystemsTemplate> getLogSystems();

	@Select("SELECT COUNT(0) > 0 FROM logging_system WHERE id = #{id};")
	boolean isExitsLogSystem(@Param("id") int id);

	@Insert("INSERT INTO logging_system (name, sys_name) VALUES (#{name}, #{sys_name});")
	void createNewLogSystem(@Param("name") String name, @Param("sys_name") String sysName);
}