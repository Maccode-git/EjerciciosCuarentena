package com.bbva.cfin.lib.r002.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DataContractOut {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataContractOut.class);
	private String Entidad;
	private String Oficina;
	private String Contrato;
	private String  Saldo;
	private Date   Feuliq;
	private float  Tea;
	private char EstadoBatch; 
	
	
	/**
	 * Constructor DataContractOut
	 */
	public DataContractOut(){}

	
	/**
	 * @param entidad
	 * @param oficina
	 * @param contrato
	 * @param saldo
	 * @param feuliq
	 * @param tea
	 * @param estadoBatch
	 */
	public DataContractOut(String entidad, String oficina, String contrato, String saldo, String feuliq, String tea,
			char estadoBatch) {
		super();
		try {
			Entidad = entidad;
			Oficina = oficina;
			Contrato = contrato;
			Saldo = saldo;
			Feuliq = new SimpleDateFormat("yyyy/MM/dd").parse(feuliq);
			Tea = Float.parseFloat(tea);
			EstadoBatch = estadoBatch;
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
	}
	/**
	 * @param registro
	 */
	public DataContractOut(String[] registro) {
		super();
		try {
			Entidad 	= registro[0];
			Oficina 	= registro[1];
			Contrato 	= registro[2];
			Saldo 		= registro[3];
			Feuliq 		= new SimpleDateFormat("yyyy/MM/dd").parse(registro[4]);
			Tea 		= Float.parseFloat(registro[5]);
			if(registro.length == 7)
				EstadoBatch = registro[6].toCharArray()[0];
			else
				EstadoBatch = 'N';
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
		
	}
	
	/**
	 * @return the estadoBatch
	 */
	public char getEstadoBatch() {
		return EstadoBatch;
	}
	/**
	 * @param estadoBatch the estadoBatch to set
	 */
	public void setEstadoBatch(char estadoBatch) {
		EstadoBatch = estadoBatch;
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
	 * @return the oficina
	 */
	public String getOficina() {
		return Oficina;
	}
	/**
	 * @param oficina the oficina to set
	 */
	public void setOficina(String oficina) {
		Oficina = oficina;
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
	 * @return the saldo
	 */
	public String getSaldo() {
		return Saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(String saldo) {
		Saldo = saldo;
	}
	/**
	 * @return the feuliq
	 */
	public Date getFeuliq() {
		return Feuliq;
	}
	/**
	 * @param feuliq the feuliq to set
	 */
	public void setFeuliq(Date feuliq) {
		Feuliq = feuliq;
	}
	/**
	 * @return the tea
	 */
	public float getTea() {
		return Tea;
	}
	/**
	 * @param tea the tea to set
	 */
	public void setTea(float tea) {
		Tea = tea;
	}
	
	/**
	 * @param rutaArchivo
	 * @return
	 */
	public static ArrayList<DataContractOut> toFileDataFile(String rutaArchivo){
		ArrayList<DataContractOut> listFile = new ArrayList<DataContractOut>();
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
			while((line = br.readLine()) != null ){
				System.out.println("==============");
				System.out.println(line);
				if(!line.split(";")[0].contains("ENTIDAD"))
					listFile.add(new DataContractOut(line.split(";")));
			}
			br.close();
		} catch (Exception e) {
			//
		}
		return listFile;
	}
	
	/**
	 * @param rutaBase
	 * @param listaDatos
	 */
	public static void createFile(String rutaBase,ArrayList<DataContractOut> listaDatos){
		try {
		    File file = new File(rutaBase+"DataContractOut.txt");
			if(file.exists())
				file.delete();
				
			file.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (DataContractOut dataFile : listaDatos) {
		    	bw.write(dataFile.toString()+"\n");
			}
			bw.close();
					
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return Entidad + ";" + Oficina + ";" + Contrato + ";" + Saldo + ";" + (new SimpleDateFormat("yyyy-MM-dd")).format(Feuliq)+ ";" + Tea + ";" + EstadoBatch;
	}
	
}
