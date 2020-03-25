package com.bbva.cint.dto.creditator;

import java.util.Arrays;

import com.bbva.apx.dto.AbstractDTO;

public class DataOutCreDTO extends AbstractDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2243468874834826612L;
	private String entBancaria;
	private String centro;
	private String producto;
	private String numContrato;
	private String titular;
	private String direccion;
	private float tasaInteres;
	private float deuda;
	private float[][] calCuotas;
	/**
	 * @return the entBancaria
	 */
	public String getEntBancaria() {
		return entBancaria;
	}
	/**
	 * @param entBancaria the entBancaria to set
	 */
	public void setEntBancaria(String entBancaria) {
		this.entBancaria = entBancaria;
	}
	/**
	 * @return the centro
	 */
	public String getCentro() {
		return centro;
	}
	/**
	 * @param centro the centro to set
	 */
	public void setCentro(String centro) {
		this.centro = centro;
	}
	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the numContrato
	 */
	public String getNumContrato() {
		return numContrato;
	}
	/**
	 * @param numContrato the numContrato to set
	 */
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	/**
	 * @return the titular
	 */
	public String getTitular() {
		return titular;
	}
	/**
	 * @param titular the titular to set
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the tasaInteres
	 */
	public float getTasaInteres() {
		return tasaInteres;
	}
	/**
	 * @param tasaInteres the tasaInteres to set
	 */
	public void setTasaInteres(float tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	/**
	 * @return the deuda
	 */
	public float getDeuda() {
		return deuda;
	}
	/**
	 * @param deuda the deuda to set
	 */
	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}
	/**
	 * @return the calCuotas
	 */
	public float[][] getCalCuotas() {
		return calCuotas;
	}
	/**
	 * @param calCuotas the calCuotas to set
	 */
	public void setCalCuotas(float[][] calCuotas) {
		this.calCuotas = calCuotas;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String toStringArray = "";
		
		for (int i = 0; i <= calCuotas.length -1; i++) {
			toStringArray += "[Cuota #"+(i+1)+": Abono Capital: $"+calCuotas[i][0]+ " ,Valor Interes: " + calCuotas[i][1] +"]";
		}
		
		return "DataOutCreDTO [entBancaria=" + entBancaria + ", centro=" + centro + ", producto=" + producto
				+ ", numContrato=" + numContrato + ", titular=" + titular + ", direccion=" + direccion
				+ ", tasaInteres=" + tasaInteres + ", deuda=" + deuda + ", calCuotas=" + toStringArray
				+ "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(calCuotas);
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		result = prime * result + Float.floatToIntBits(deuda);
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((entBancaria == null) ? 0 : entBancaria.hashCode());
		result = prime * result + ((numContrato == null) ? 0 : numContrato.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + Float.floatToIntBits(tasaInteres);
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
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
		DataOutCreDTO other = (DataOutCreDTO) obj;
		if (!Arrays.deepEquals(calCuotas, other.calCuotas))
			return false;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		if (Float.floatToIntBits(deuda) != Float.floatToIntBits(other.deuda))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (entBancaria == null) {
			if (other.entBancaria != null)
				return false;
		} else if (!entBancaria.equals(other.entBancaria))
			return false;
		if (numContrato == null) {
			if (other.numContrato != null)
				return false;
		} else if (!numContrato.equals(other.numContrato))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (Float.floatToIntBits(tasaInteres) != Float.floatToIntBits(other.tasaInteres))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}
	/**
	 * @param entBancaria
	 * @param centro
	 * @param producto
	 * @param numContrato
	 * @param titular
	 * @param direccion
	 * @param tasaInteres
	 * @param deuda
	 * @param calCuotas
	 * 
	 * Constructor DataOutCreDTO
	 */
	public DataOutCreDTO(String entBancaria, String centro, String producto, String numContrato, String titular,
			String direccion, float tasaInteres, float deuda, float[][] calCuotas) {
		super();
		this.entBancaria = entBancaria;
		this.centro = centro;
		this.producto = producto;
		this.numContrato = numContrato;
		this.titular = titular;
		this.direccion = direccion;
		this.tasaInteres = tasaInteres;
		this.deuda = deuda;
		this.calCuotas = calCuotas;
	}
	
	/**
	 * Constructor DataOutCreDTO
	 */
	public DataOutCreDTO(){}
	
	
	
		
}
