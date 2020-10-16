package com.atmecs.employee_details.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.employee_details.constants.Constants;

public class Logging 
{
	Logger log = null;
		
	public Logging()
	{
		getLogger();
		log = Logger.getLogger(Logging.class);
	}
	
	public void getLogger()
	{
		PropertyConfigurator.configure(Constants.LOG4J_FILE);
	}
	
	public void warn(String message)
	{
		log.warn(message);
	}
	
	public  void info(String message)
	{
		log.info(message);
	}

	public  void debug(String message)
	{
		log.debug(message);
	}
	
	public void error(String message)
	{
		log.error(message);
	}
	
	public void fatal(String message)
	{
		log.fatal(message);
	}
}
