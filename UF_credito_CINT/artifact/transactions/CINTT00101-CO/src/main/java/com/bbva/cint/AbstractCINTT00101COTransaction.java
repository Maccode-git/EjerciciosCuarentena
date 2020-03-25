package com.bbva.cint;

import com.bbva.cint.dto.creditator.DataOutCreDTO;
import com.bbva.cint.dto.creditator.DataInCreDTO;

import com.bbva.elara.transaction.AbstractTransaction;

public abstract class AbstractCINTT00101COTransaction extends AbstractTransaction {

	public AbstractCINTT00101COTransaction(){
	}
	
	

	/**
	 * Return value for input parameter dataInCreDTO
	 */
	protected DataInCreDTO getDataincredto(){
		return (DataInCreDTO)getParameter("dataInCreDTO");
	}
	/**
	 * Set value for output parameter dataInCreDTO
	 */
	protected void setDataoincredto(final DataInCreDTO field){
		this.addParameter("dataInCreDTO", field);
	}	
	
	
	/**
	 * Return value for input parameter dataOutCreDTO
	 */
	protected DataOutCreDTO getDataoutcredto(){
		return (DataOutCreDTO)getParameter("dataOutCreDTO");
	}
	/**
	 * Set value for output parameter dataOutCreDTO
	 */
	protected void setDataoutcredto(final DataOutCreDTO field){
		this.addParameter("dataOutCreDTO", field);
	}			
	
}
