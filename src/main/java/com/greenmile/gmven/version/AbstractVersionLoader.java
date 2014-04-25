/*
 * Copyright 2010 Sagarana Tech.  All rigths reserved.
 *
 * This software is the confidential and proprietary information of
 * Sagarana Tech ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Sagarana Tech.
 */
package com.greenmile.gmven.version;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Abstract model class to load version informations from properties file. 
 * @author andre@sagaranatech.com
 * @since 04/03/2010
 * @version $Revision:  $ <br>
 *          $Date:  $ <br> 
 *          $Author:  $
 */
public class AbstractVersionLoader {

	protected Properties properties; 
	
	public static final String BUILD_VERSION = "version"; 
	public static final String BUILD_NUMBER = "buildNumber";
	public static final String PROPERTIES_FILE = "version.properties";
	
	public AbstractVersionLoader() { 
		loadProperties(PROPERTIES_FILE);
	}
	
	public AbstractVersionLoader(String propertyFileName) { 
		loadProperties(propertyFileName);
	}
	
	private void loadProperties(String propertyFileName) {
		properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream(propertyFileName));
		} catch (IOException e) {
			// unable to load 
			Logger.getLogger(AbstractVersionLoader.class.getName()).warning(e.getMessage());
		}
	}

	public String getVersion() { 
		if(properties == null) { 
			return null;
		}
		return (String) properties.get(BUILD_VERSION);
	}
	
	public String getBuild() { 
		if(properties == null) { 
			return null;
		}
		return (String) properties.get(BUILD_NUMBER);
	}
	
	public String getValue(String property) { 
		if(properties == null) { 
			return null;
		}
		return (String) properties.get(property);
	}
}
