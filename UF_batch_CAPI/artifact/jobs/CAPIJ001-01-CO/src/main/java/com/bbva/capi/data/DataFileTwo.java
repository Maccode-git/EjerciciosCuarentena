package com.bbva.capi.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataFileTwo {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataFileTwo.class);
	private String numOrden;
	private String entidad;
	private String oficina;
	private String cuenta;
	private String mesMora;
	private String codTransf;
	private String tcAsociada;
	
	public DataFileTwo(){}
	
	/**
	 * @param numOrden
	 * @param entidad
	 * @param oficina
	 * @param cuenta
	 * @param mesMora
	 * @param codTransf
	 * @param tcAsociada
	 */
	public DataFileTwo(String numOrden, String entidad, String oficina, String cuenta, String mesMora, String codTransf,
			String tcAsociada) {
		super();
		this.numOrden = numOrden;
		this.entidad = entidad;
		this.oficina = oficina;
		this.cuenta = cuenta;
		this.mesMora = mesMora;
		this.codTransf = codTransf;
		this.setTcAsociada(tcAsociada);
	}



	public DataFileTwo(String[] arrayLine) {
		super();
		this.entidad = arrayLine[0];
		this.oficina = arrayLine[1];
		this.cuenta = arrayLine[2];
		this.mesMora = arrayLine[3];
		this.codTransf = arrayLine[4];
		this.setTcAsociada(arrayLine[5]);
		this.numOrden = this.entidad+this.oficina+this.cuenta;
	}
	
	public DataFileTwo(String[] arrayLine,int val) {
		super();
		this.numOrden = arrayLine[0];
		this.entidad = arrayLine[1];
		this.oficina = arrayLine[2];
		this.cuenta = arrayLine[3];
		this.mesMora = arrayLine[4];
		this.codTransf = arrayLine[5];
		this.setTcAsociada(arrayLine[6]);
		
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
	 * @return the numOrden
	 */
	public String getNumOrden() {
		return numOrden;
	}
	/**
	 * @param numOrden the numOrden to set
	 */
	public void setNumOrden(String numOrden) {
		this.numOrden = numOrden;
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
	 * @return the codTransf
	 */
	public String getCodTransf() {
		return codTransf;
	}
	/**
	 * @param codTransf the codTransf to set
	 */
	public void setCodTransf(String codTransf) {
		this.codTransf = codTransf;
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
		
		if(tcAsociada.indexOf("A") != -1)
			tcAsociada = tcAsociada.replace('A', tcAsociada.charAt(tcAsociada.indexOf("A")+1));
		
		if(tcAsociada.indexOf("B") != -1)
			tcAsociada = tcAsociada.replace('B', tcAsociada.charAt(tcAsociada.indexOf("B")-1));
		
		if(tcAsociada.indexOf("X") != -1)
			tcAsociada = tcAsociada.replace('X', tcAsociada.charAt(tcAsociada.length()-1));
		
		if(tcAsociada.indexOf("W") != -1)
			tcAsociada = tcAsociada.replace('W', tcAsociada.charAt(6));
		
		if(tcAsociada.indexOf("Z") != -1)
			tcAsociada = tcAsociada.replace('Z', '9');
		
		this.tcAsociada = tcAsociada;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return numOrden + ";" + entidad + ";" + oficina + ";" + cuenta + ";" +  mesMora + ";" +  codTransf + ";" + tcAsociada;
	}
	
	public static void ordenarFile(String rutaBase, String nombreArcOne){
		LinkedList<DataFileTwo> listaDatos = new LinkedList<DataFileTwo>();
		
		try {
			String line = "";
		    BufferedReader bfr = new BufferedReader(new FileReader(new File(rutaBase+nombreArcOne)));
		    while((line = bfr.readLine()) != null){
		    	if(!line.split(";")[0].contains("ENTIDAD")){
		    		
		    		listaDatos.add(new DataFileTwo(line.split(";")));
		    	}
		    }
		    Collections.sort(listaDatos,Comparator.comparing(DataFileTwo::getNumOrden));
		    bfr.close();
		    
		    File file = new File(rutaBase+"DataFileTwoOrder.txt");
			if(file.exists())
				file.delete();
			
				
			file.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (DataFileTwo dataFileTwo : listaDatos) {
		    	bw.write(dataFileTwo.toString()+"\n");
			}
			bw.close();
					
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
	}
	
	public static ArrayList<DataFileTwo> toFileDataFile(String rutaArchivo){
		ArrayList<DataFileTwo> listFileTwo = new ArrayList<DataFileTwo>();
		
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
			while((line = br.readLine()) != null ){
				listFileTwo.add(new DataFileTwo(line.split(";"),0));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listFileTwo;
	}
	
	
}
