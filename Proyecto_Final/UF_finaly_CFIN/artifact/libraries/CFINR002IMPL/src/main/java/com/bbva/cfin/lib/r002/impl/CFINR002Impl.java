package com.bbva.cfin.lib.r002.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.cfin.lib.r002.CFINR002;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CFINR002Impl extends CFINR002Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CFINR002.class);

	/* (non-Javadoc)
	 * @see com.bbva.cfin.lib.r002.CFINR002#execute()
	 */
	@Override
	public void execute() {
		try {
			
			String rutaBase = "C:/Users/formacion/Desktop/IDE_APX_win64/IDE_APX_win64/workspace/UF_finaly_CFIN/";
			String[] info = obtenerRegistroxContrato(obtenerContratoJson(rutaBase),rutaBase);
			
			DataContractOut contract = new DataContractOut(info[0],info[5],info[6],info[7],info[8],info[9],'I');
			DataContractOut.createFile(rutaBase, addAndOrderToBatch(rutaBase, contract));
			
		} catch (Exception e) {
			LOGGER.info("Error: "+ e.getMessage());
		}
	}
	
	/**
	 * @param rutaBase
	 * @return
	 */
	private String obtenerContratoJson(String rutaBase){
		String contrato = "";
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(new File(rutaBase + "DataOutOneDTO.json"));
			contrato = node.get("contrato").textValue();
		} catch (Exception e) {
			LOGGER.info("Error: "+ e.getMessage());
		}
		return contrato;
	}
	
	/**
	 * @param contrato
	 * @param rutaBase
	 * @return
	 */
	private String[] obtenerRegistroxContrato(String contrato, String rutaBase){
		String[] registro = null;
		try {
			String linea = "";
			BufferedReader br = new BufferedReader(new FileReader(rutaBase + "ArchivoPortafolio.txt"));
			while((linea=br.readLine()) != null){
				String[] array = linea.split(";");
				if(array[3].equals(contrato))
					return array;
				
			}
		} catch (Exception e) {
			LOGGER.info("Error: "+ e.getMessage());
		}
		return registro;
	}
	
	/**
	 * @param rutaArchivo
	 * @param out
	 * @return
	 */
	public static ArrayList<DataContractOut> addAndOrderToBatch(String rutaArchivo,DataContractOut out ){
		ArrayList<DataContractOut> listout = new ArrayList<DataContractOut>();
		try {
			listout = DataContractOut.toFileDataFile(rutaArchivo+"ContratosFeuliq.txt");		
			listout.add(out);
			
			Collections.sort(listout,Comparator.comparing(DataContractOut::getEntidad)
					.thenComparing(DataContractOut::getOficina).thenComparing(DataContractOut::getContrato));
			
			for (int i = (listout.indexOf(out)+1); i <= listout.size() - 1; i++) {
				listout.get(i).setEstadoBatch('P');
			}  
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
		return listout;
	}
}
