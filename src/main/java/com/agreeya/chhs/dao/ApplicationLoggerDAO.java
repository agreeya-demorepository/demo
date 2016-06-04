package com.agreeya.chhs.dao;

import com.agreeya.chhs.model.ApplicationLog;

/**
 * @author amit.sharma
 *
 */
public interface ApplicationLoggerDAO extends BaseDAO {
	void saveLog(ApplicationLog log);
}
