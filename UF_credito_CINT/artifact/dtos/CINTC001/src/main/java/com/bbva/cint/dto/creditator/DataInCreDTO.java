package com.bbva.cint.dto.creditator;

import com.bbva.apx.dto.AbstractDTO;

public class DataInCreDTO extends AbstractDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1783574840855890309L;
	private String pan;
	private String rutaBase;
	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}
	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}
	/**
	 * @return the rutaBase
	 */
	public String getRutaBase() {
		return rutaBase;
	}
	/**
	 * @param rutaBase the rutaBase to set
	 */
	public void setRutaBase(String rutaBase) {
		this.rutaBase = rutaBase;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataInCreDTO [pan=" + pan + ", rutaBase=" + rutaBase + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pan == null) ? 0 : pan.hashCode());
		result = prime * result + ((rutaBase == null) ? 0 : rutaBase.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataInCreDTO other = (DataInCreDTO) obj;
		if (pan == null) {
			if (other.pan != null)
				return false;
		} else if (!pan.equals(other.pan))
			return false;
		if (rutaBase == null) {
			if (other.rutaBase != null)
				return false;
		} else if (!rutaBase.equals(other.rutaBase))
			return false;
		return true;
	}
	
	/**
	 * @param pan
	 * @param rutaBase
	 * Constructor DataInCreDTO
	 */
	public DataInCreDTO(String pan, String rutaBase) {
		super();
		this.pan = pan;
		this.rutaBase = rutaBase;
	}
	
	
	/**
	 * 
	 */
	public DataInCreDTO(){}
	
	
	
}
