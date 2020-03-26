package com.bbva.capi.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DataFileThree {
	
	private String numRelacion;
	private String entidad;
	private String oficina;
	private String cuenta;
	private String mesMora;
	private String tcPrincipal;
	private String tcAsociada;
	
	public DataFileThree(){}
	
	/**
	 * @param numRelacion
	 * @param entidad
	 * @param oficina
	 * @param cuenta
	 * @param mesMora
	 * @param tcPrincipal
	 * @param tcAsociada
	 */
	public DataFileThree(String numRelacion, String entidad, String oficina, String cuenta, String mesMora,
			String tcPrincipal, String tcAsociada) {
		super();
		this.numRelacion = numRelacion;
		this.entidad = entidad;
		this.oficina = oficina;
		this.cuenta = cuenta;
		this.mesMora = mesMora;
		this.tcPrincipal = tcPrincipal;
		this.tcAsociada = tcAsociada;
	}
	/**
	 * @return the numRelacion
	 */
	public String getNumRelacion() {
		return numRelacion;
	}
	/**
	 * @param numRelacion the numRelacion to set
	 */
	public void setNumRelacion(String numRelacion) {
		this.numRelacion = numRelacion;
	}
	/**
	 * @return the entidad
	 */
	public String getEntidad() {
		return entidad;
	}
	/**
	 * @param entidad the entidad to set
	 */
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	/**
	 * @return the oficina
	 */
	public String getOficina() {
		return oficina;
	}
	/**
	 * @param oficina the oficina to set
	 */
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	/**
	 * @return the cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}
	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	/**
	 * @return the mesMora
	 */
	public String getMesMora() {
		return mesMora;
	}
	/**
	 * @param mesMora the mesMora to set
	 */
	public void setMesMora(String mesMora) {
		this.mesMora = mesMora;
	}
	/**
	 * @return the tcPrincipal
	 */
	public String getTcPrincipal() {
		return tcPrincipal;
	}
	/**
	 * @param tcPrincipal the tcPrincipal to set
	 */
	public void setTcPrincipal(String tcPrincipal) {
		this.tcPrincipal = tcPrincipal;
	}
	/**
	 * @return the tcAsociada
	 */
	public String getTcAsociada() {
		return tcAsociada;
	}
	/**
	 * @param tcAsociada the tcAsociada to set
	 */
	public void setTcAsociada(String tcAsociada) {
		this.tcAsociada = tcAsociada;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return entidad + ";" + oficina + ";" + cuenta + ";" + mesMora + ";" + tcPrincipal + ";" + tcAsociada;
	}
	
	public static void lineaBalance(String rutaBase, String nomArchOne, String nomArchTwo){
		try {
			ArrayList<DataFileOne> listOne = DataFileOne.toFileDataFile(rutaBase+nomArchOne);
			ArrayList<DataFileTwo> listTwo = DataFileTwo.toFileDataFile(rutaBase+nomArchTwo);
			ArrayList<DataFileThree> listThree = new ArrayList<DataFileThree>();

			int indiceOne = 0;
			int indiceTwo = 0;
			boolean whilePadre = true;
			while(whilePadre == true ){
				long innerNumeroOne = 0;
				long innerNumeroTwo = 0;
				
				if((indiceOne <= listOne.size()-1 && indiceTwo <= listTwo.size()-1)){
					innerNumeroOne = Long.parseLong((listOne.get(indiceOne)).getNumOrden());
					innerNumeroTwo = Long.parseLong((listTwo.get(indiceTwo)).getNumOrden());

					if(innerNumeroOne < innerNumeroTwo && indiceOne < listOne.size()-1){
						while(innerNumeroOne < innerNumeroTwo && indiceOne < listOne.size()-1){
							indiceOne++;
							innerNumeroOne = Long.parseLong((listOne.get(indiceOne)).getNumOrden());
						}
					}else if(innerNumeroTwo < innerNumeroOne && indiceTwo < listTwo.size()-1){
						while(innerNumeroTwo < innerNumeroOne && indiceTwo < listTwo.size()-1){
							indiceTwo++;
							innerNumeroTwo = Long.parseLong((listTwo.get(indiceTwo)).getNumOrden());
						}
					}else if (innerNumeroTwo == innerNumeroOne){
						DataFileOne one = listOne.get(indiceOne);
						DataFileTwo two = listTwo.get(indiceTwo);
						
						listThree.add(new DataFileThree(one.getNumOrden(), two.getEntidad(),two.getOficina()
											,two.getCuenta(),two.getMesMora(),one.getBin()+one.getIai(),two.getTcAsociada()));
						
						indiceOne++;
						indiceTwo++;
					}else{
						whilePadre = false;
					}
				}else{
					whilePadre = false;
				}
			}
			
			toFile(listThree,rutaBase);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void toFile(ArrayList<DataFileThree> listThree,String rutaBase){
		try {
			File file = new File(rutaBase+"DataFileThree.txt");
			if(file.exists())
				file.delete();
				
			file.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (DataFileThree dataFileThree : listThree) {
				bw.write(dataFileThree.toString()+"\n");
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
}
