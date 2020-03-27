package com.bbva.cbat.batch.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	 * Contructor DataContractOut
	 */
	public DataContractOut(String entidad, String oficina, String contrato, String saldo, String feuliq, String tea,
			char estadoBatch) {
		super();
		try {
			Entidad = entidad;
			Oficina = oficina;
			Contrato = contrato;
			Saldo = saldo;
			Feuliq = new SimpleDateFormat("yyyy-MM-dd").parse(feuliq);
			Tea = Float.parseFloat(tea);
			EstadoBatch = estadoBatch;
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
	}
	
	/**
	 * @param registro
	 * Contructor DataContractOut
	 */
	public DataContractOut(String[] registro) {
		super();
		try {
			Entidad 	= registro[0];
			Oficina 	= registro[1];
			Contrato 	= registro[2];
			Saldo 		= registro[3];
			Feuliq 		= new SimpleDateFormat("yyyy-MM-dd").parse(registro[4]);
			Tea 		= Float.parseFloat(registro[5]);
			if(registro.length == 7)
				EstadoBatch = registro[6].toCharArray()[0];
			else
				EstadoBatch = 'N';
		} catch (Exception e) {
			//LOGGER.info("Error: " + e.getMessage());
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
	 * Method toFileDataFile
	 */
	public static ArrayList<DataContractOut> toFileDataFile(String rutaArchivo){
		ArrayList<DataContractOut> listFile = new ArrayList<DataContractOut>();
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
			while((line = br.readLine()) != null ){
				if(!line.split(";")[0].contains("ENTIDAD"))
					listFile.add(new DataContractOut(line.split(";")));
			}
			br.close();
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
		return listFile;
	}
	
	/**
	 * @param rutaBase
	 * @param listaDatos
	 * Method createFile
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
	
	/**
	 * @param rutaArchivo
	 * @return
	 * Method OrderToBatch
	 */
	public static ArrayList<DataContractOut> OrderToBatch(String rutaArchivo){
		ArrayList<DataContractOut> listout = new ArrayList<DataContractOut>();
		try {
			listout = toFileDataFile(rutaArchivo+"DataContractOut.txt");
			
			Collections.sort(listout,Comparator.comparing(DataContractOut::getEntidad)
					.thenComparing(DataContractOut::getOficina).thenComparing(DataContractOut::getContrato));
			
			int indexIni = -1;
			for (int i = 0; i <= listout.size() - 1; i++) {
				
				if(listout.get(i).getEstadoBatch() == 'I')
					indexIni = i;
			
				if(indexIni >= 0 && i > indexIni && (listout.get(i).getEstadoBatch() != 'G' && listout.get(i).getEstadoBatch() != 'E'))
					listout.get(i).setEstadoBatch('P');
				
			}
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
		return listout;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Entidad + ";" + Oficina + ";" + Contrato + ";" + Saldo + ";" + (new SimpleDateFormat("yyyy-MM-dd")).format(Feuliq)+ ";" + Tea + ";" + EstadoBatch;
	}
	
	/**
	 * @param interes
	 * @return
	 * Method toString
	 */
	public String toString(long interes) {
		return Entidad + ";" + Oficina + ";" + Contrato + ";" + Saldo + ";" + (new SimpleDateFormat("yyyy-MM-dd")).format(Feuliq)+ ";" + Tea + ";" + interes;
	}
	
	/**
	 * @param fechaInicial
	 * @return
	 */
	public static int diaFiniFActual(Date fechaInicial){
		Date fechaFinal = new Date();
		return (int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
	}
	
	/**
	 * @param dias
	 * @param tasaAct
	 * @return
	 */
	public static float calTasaDias(int dias,float tasaAct){
		int porcnNew = 0;
		porcnNew =  Integer.parseInt(String.valueOf((dias/30)));
		if(porcnNew > 3) porcnNew = 3;
		tasaAct += (porcnNew*2);
		return tasaAct;
	}
	
	/**
	 * @param saldo
	 * @param dias
	 * @param tasa
	 * @return
	 */
	public static Long calInteres(String saldo,int dias, float tasa){
		return (long) ((Long.valueOf(saldo)*(tasa/100)*dias)/360);
	}
	
	/**
	 * @param rutaBase
	 */
	public static void procesoCalculoArchivo(String rutaBase){
		try {
			ArrayList<DataContractOut> listPrev = new ArrayList<DataContractOut>();
			ArrayList<DataContractOut> listProcesada = new ArrayList<DataContractOut>();
			ArrayList<String> listResult = new ArrayList<String>();
			listPrev = toFileDataFile(rutaBase +"DataContractOut.txt");
			boolean error = false;
			for (DataContractOut dataContractOut : listPrev) {
				System.out.println(dataContractOut.toString()); 
				float tasaOld = dataContractOut.getTea();
				try {
					if((dataContractOut.getEstadoBatch() == 'E' || dataContractOut.getEstadoBatch() == 'P') && error == false){
						int dias = diaFiniFActual(dataContractOut.getFeuliq());
						float tasaNew = calTasaDias(dias,dataContractOut.getTea());
						long interes = calInteres(dataContractOut.getSaldo(),dias,tasaNew);
						dataContractOut.setEstadoBatch('G');
						dataContractOut.setTea(tasaNew);
						System.out.println(interes);
						listResult.add(dataContractOut.toString(interes));
					}else if ((dataContractOut.getEstadoBatch() == 'E' || dataContractOut.getEstadoBatch() == 'P') && error == true){
						dataContractOut.setTea(tasaOld);
						dataContractOut.setEstadoBatch('E');
					}
					
				} catch (Exception e) {
					dataContractOut.setTea(tasaOld);
					dataContractOut.setEstadoBatch('E');
					error = true;
					LOGGER.info("Error: " + e.getMessage());
					
				}
				listProcesada.add(dataContractOut);
			}
			
			createFile(rutaBase,listProcesada);
			createFileResult(rutaBase,listResult);
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
	}
	
	
	
	/**
	 * @param rutaBase
	 * @param listaDatos
	 */
	public static void validateFileResult(String rutaBase,ArrayList<DataContractOut> listaDatos){
		try {
			boolean deleteFileResult = true;
			for (DataContractOut dataContractOut : listaDatos) {
				if(dataContractOut.getEstadoBatch() == 'G' || dataContractOut.getEstadoBatch() == 'E'){
					deleteFileResult = false;
					break;
				}	
			}
			
			File file = new File(rutaBase+"DataContractOutResult.txt");
		    if (file.exists() && deleteFileResult == true) {
		    	file.delete();
		    	file.createNewFile();
			}else if (!file.exists()){
				file.createNewFile();
			}
		    
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
	}
	
	/**
	 * @param rutaBase
	 * @param listFile
	 */
	public static void createFileResult(String rutaBase,ArrayList<String> listFile){
		try {
		    File file = new File(rutaBase+"DataContractOutResult.txt");
		    if (file.exists()) {
		    	String linea ="";
		    	String todo = "";
		    	BufferedReader br = new BufferedReader(new FileReader(file));
		    	while((linea = br.readLine())!= null){
		    		todo+=linea+"\n"; 
		    	}
		    	br.close();
		    	
		    	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		    	bw.write(todo);
				for (String dataFile : listFile) {
					bw.write(dataFile+"\n");
				}
				bw.close();
			}
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
}
