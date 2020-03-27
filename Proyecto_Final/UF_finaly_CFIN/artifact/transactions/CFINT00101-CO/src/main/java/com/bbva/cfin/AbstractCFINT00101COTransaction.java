package com.bbva.cfin;

import com.bbva.cfin.dto.finalizator.DataInOneDTO;
import com.bbva.cfin.dto.finalizator.DataOutOneDTO;

import com.bbva.elara.transaction.AbstractTransaction;

public abstract class AbstractCFINT00101COTransaction extends AbstractTransaction {

	public AbstractCFINT00101COTransaction(){
	}
	
	
	/**
	 * Return value for input parameter dataInOneDTO
	 */
	protected DataInOneDTO getDatainonedto(){
		return (DataInOneDTO)getParameter("dataInOneDTO");
	}
	/**
	 * Set value for output parameter DataInOneDTO
	 */
	protected void setDataInOneDTO(final DataInOneDTO field){
		this.addParameter("dataInOneDTO", field);
	}	
	

	/**
	 * Return value for input parameter dataOutOneDTO
	 */
	protected DataOutOneDTO getDataoutonedto(){
		return (DataOutOneDTO)getParameter("dataOutOneDTO");
	}
	/**
	 * Set value for output parameter dataOutOneDTO
	 */
	protected void setDataoutonedto(final DataOutOneDTO field){
		this.addParameter("dataOutOneDTO", field);
	}			
	
}
