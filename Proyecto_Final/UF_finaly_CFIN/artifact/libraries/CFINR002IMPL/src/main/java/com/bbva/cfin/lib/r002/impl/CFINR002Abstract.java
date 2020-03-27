package com.bbva.cfin.lib.r002.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.cfin.lib.r002.CFINR002;

public abstract class CFINR002Abstract extends AbstractLibrary implements CFINR002 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CFINR002.class);
	
	protected ApplicationConfigurationService applicationConfigurationService;
	
	/**
	 * @param applicationConfigurationService the applicationConfigurationService to set
	 */
	public void setApplicationConfigurationService(
			ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}
	
}
