package com.username.service.test.utils;

import org.apache.log4j.Logger;

public class LogApp {
	Logger logger;

	public LogApp(Object o) {
		logger = Logger.getLogger(o.getClass().getName());
	}

	public void logInfo(String message) {
		logger.info(message);
	}

	public void logWarning(String message) {
		logger.warn(message);
	}

	public void logError(String message) {
		logger.error(message);
	}

	public void logDebug(String message) {
		logger.debug(message);
	}

	public void logFatal(String message) {
		logger.fatal(message);
		;
	}
}
