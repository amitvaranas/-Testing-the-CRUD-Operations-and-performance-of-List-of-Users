package com.test.RA;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getLogger(TestLogs.class.getName());
		
		logger.debug("Debugging");
		logger.info("Info for run");
		
		
		
	}

}
