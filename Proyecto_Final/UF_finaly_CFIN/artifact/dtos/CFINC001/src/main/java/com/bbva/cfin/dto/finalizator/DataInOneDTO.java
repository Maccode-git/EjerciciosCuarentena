package com.bbva.cfin.dto.finalizator;

import com.bbva.apx.dto.AbstractDTO;

public class DataInOneDTO extends AbstractDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947123099123366215L;
	private String Origen;
	private String Destino;
	private String Pan;
	private int NumCuotas;
	
	
	/**
	 * Constructor DataInOneDTO
	 */
	public DataInOneDTO(){}
	
	/**
	 * @param origen
	 * @param destino
	 * @param pan
	 * @param numCuotas
	 * Constructor DataInOneDTO
	 */
	public DataInOneDTO(String origen, String destino, String pan, int numCuotas) {
		super();
		Origen = origen;
		Destino = destino;
		Pan = pan;
		NumCuotas = numCuotas;
	}
	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return Origen;
	}
	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		Origen = origen;
	}
	/**
	 * @return the destino
	 */
	public String getDestino() {
		return Destino;
	}
	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		Destino = destino;
	}
	/**
	 * @return the pan
	 */
	public String getPan() {
		return Pan;
	}
	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		Pan = pan;
	}
	/**
	 * @return the numCuotas
	 */
	public int getNumCuotas() {
		return NumCuotas;
	}
	/**
	 * @param numCuotas the numCuotas to set
	 */
	public void setNumCuotas(int numCuotas) {
		NumCuotas = numCuotas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataInOneDTO [Origen=" + Origen + ", Destino=" + Destino + ", Pan=" + Pan + ", NumCuotas=" + NumCuotas
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Destino == null) ? 0 : Destino.hashCode());
		result = prime * result + NumCuotas;
		result = prime * result + ((Origen == null) ? 0 : Origen.hashCode());
		result = prime * result + ((Pan == null) ? 0 : Pan.hashCode());
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
		DataInOneDTO other = (DataInOneDTO) obj;
		if (Destino == null) {
			if (other.Destino != null)
				return false;
		} else if (!Destino.equals(other.Destino))
			return false;
		if (NumCuotas != other.NumCuotas)
			return false;
		if (Origen == null) {
			if (other.Origen != null)
				return false;
		} else if (!Origen.equals(other.Origen))
			return false;
		if (Pan == null) {
			if (other.Pan != null)
				return false;
		} else if (!Pan.equals(other.Pan))
			return false;
		return true;
	}
	
	
	
	
	
}
