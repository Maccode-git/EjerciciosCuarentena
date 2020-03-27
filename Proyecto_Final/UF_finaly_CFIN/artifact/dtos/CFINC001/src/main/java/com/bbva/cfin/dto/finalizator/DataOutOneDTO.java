package com.bbva.cfin.dto.finalizator;

import java.util.Arrays;

import com.bbva.apx.dto.AbstractDTO;

public class DataOutOneDTO extends AbstractDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -192769942639109605L;
	private String Pan;
	private String Entidad;
	private String Centro;
	private String Producto;
	private String Contrato;
	private String Titular;
	private String Direccion;
	private String NumCuotas;
	private float  TasaInteres;
	private float  TotalPagar;
	private float[][] ArrayValorCuotas;
	
	
	/**
	 * Constructor DataOutOneDTO
	 */
	public DataOutOneDTO(){}
	
	
	/**
	 * @param pan
	 * @param entidad
	 * @param centro
	 * @param producto
	 * @param contrato
	 * @param titular
	 * @param direccion
	 * @param numCuotas
	 * @param tasaInteres
	 * @param totalPagar
	 * @param arrayValorCuotas
	 * Constructor DataOutOneDTO
	 */
	public DataOutOneDTO(String pan, String entidad, String centro, String producto, String contrato, String titular,
			String direccion, String numCuotas, float tasaInteres, float totalPagar, float[][] arrayValorCuotas) {
		super();
		Pan = pan;
		Entidad = entidad;
		Centro = centro;
		Producto = producto;
		Contrato = contrato;
		Titular = titular;
		Direccion = direccion;
		NumCuotas = numCuotas;
		TasaInteres = tasaInteres;
		TotalPagar = totalPagar;
		ArrayValorCuotas = arrayValorCuotas;
	}



	/**
	 * @return the tasaInteres
	 */
	public float getTasaInteres() {
		return TasaInteres;
	}

	/**
	 * @param tasaInteres the tasaInteres to set
	 */
	public void setTasaInteres(float tasaInteres) {
		TasaInteres = tasaInteres;
	}

	/**
	 * @return the totalPagar
	 */
	public float getTotalPagar() {
		return TotalPagar;
	}

	/**
	 * @param totalPagar the totalPagar to set
	 */
	public void setTotalPagar(float totalPagar) {
		TotalPagar = totalPagar;
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
	 * @return the entidad
	 */
	public String getEntidad() {
		return Entidad;
	}
	/**
	 * @param entidad the entidad to set
	 */
	public void setEntidad(String entidad) {
		Entidad = entidad;
	}
	/**
	 * @return the centro
	 */
	public String getCentro() {
		return Centro;
	}
	/**
	 * @param centro the centro to set
	 */
	public void setCentro(String centro) {
		Centro = centro;
	}
	/**
	 * @return the producto
	 */
	public String getProducto() {
		return Producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		Producto = producto;
	}
	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return Contrato;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		Contrato = contrato;
	}
	/**
	 * @return the titular
	 */
	public String getTitular() {
		return Titular;
	}
	/**
	 * @param titular the titular to set
	 */
	public void setTitular(String titular) {
		Titular = titular;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return Direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	/**
	 * @return the numCuotas
	 */
	public String getNumCuotas() {
		return NumCuotas;
	}
	/**
	 * @param numCuotas the numCuotas to set
	 */
	public void setNumCuotas(String numCuotas) {
		NumCuotas = numCuotas;
	}
	/**
	 * @return the arrayValorCuotas
	 */
	public float[][] getArrayValorCuotas() {
		return ArrayValorCuotas;
	}
	/**
	 * @param arrayValorCuotas the arrayValorCuotas to set
	 */
	public void setArrayValorCuotas(float[][] arrayValorCuotas) {
		ArrayValorCuotas = arrayValorCuotas;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String toStringArray = "";
		for (int i = 0; i <= ArrayValorCuotas.length -1; i++) {
			toStringArray += "[Cuota #"+(i+1)+": Abono Capital: $"+ArrayValorCuotas[i][0]+ " ,Valor Interes: " + ArrayValorCuotas[i][1] +"]";
		}
		return "DataOutOneDTO [Pan=" + Pan + ", Entidad=" + Entidad + ", Centro=" + Centro + ", Producto=" + Producto
				+ ", Contrato=" + Contrato + ", Titular=" + Titular + ", Direccion=" + Direccion + ", NumCuotas="
				+ NumCuotas + ", TasaInteres=" + TasaInteres + ", TotalPagar=" + TotalPagar + ", ArrayValorCuotas="
				+ toStringArray + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(ArrayValorCuotas);
		result = prime * result + ((Centro == null) ? 0 : Centro.hashCode());
		result = prime * result + ((Contrato == null) ? 0 : Contrato.hashCode());
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + ((Entidad == null) ? 0 : Entidad.hashCode());
		result = prime * result + ((NumCuotas == null) ? 0 : NumCuotas.hashCode());
		result = prime * result + ((Pan == null) ? 0 : Pan.hashCode());
		result = prime * result + ((Producto == null) ? 0 : Producto.hashCode());
		result = prime * result + Float.floatToIntBits(TasaInteres);
		result = prime * result + ((Titular == null) ? 0 : Titular.hashCode());
		result = prime * result + Float.floatToIntBits(TotalPagar);
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
		DataOutOneDTO other = (DataOutOneDTO) obj;
		if (!Arrays.deepEquals(ArrayValorCuotas, other.ArrayValorCuotas))
			return false;
		if (Centro == null) {
			if (other.Centro != null)
				return false;
		} else if (!Centro.equals(other.Centro))
			return false;
		if (Contrato == null) {
			if (other.Contrato != null)
				return false;
		} else if (!Contrato.equals(other.Contrato))
			return false;
		if (Direccion == null) {
			if (other.Direccion != null)
				return false;
		} else if (!Direccion.equals(other.Direccion))
			return false;
		if (Entidad == null) {
			if (other.Entidad != null)
				return false;
		} else if (!Entidad.equals(other.Entidad))
			return false;
		if (NumCuotas == null) {
			if (other.NumCuotas != null)
				return false;
		} else if (!NumCuotas.equals(other.NumCuotas))
			return false;
		if (Pan == null) {
			if (other.Pan != null)
				return false;
		} else if (!Pan.equals(other.Pan))
			return false;
		if (Producto == null) {
			if (other.Producto != null)
				return false;
		} else if (!Producto.equals(other.Producto))
			return false;
		if (Float.floatToIntBits(TasaInteres) != Float.floatToIntBits(other.TasaInteres))
			return false;
		if (Titular == null) {
			if (other.Titular != null)
				return false;
		} else if (!Titular.equals(other.Titular))
			return false;
		if (Float.floatToIntBits(TotalPagar) != Float.floatToIntBits(other.TotalPagar))
			return false;
		return true;
	}

	
	
}
