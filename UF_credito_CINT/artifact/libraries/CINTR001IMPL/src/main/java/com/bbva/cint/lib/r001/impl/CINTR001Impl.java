package com.bbva.cint.lib.r001.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.cint.dto.creditator.DataOutCreDTO;
import com.bbva.cint.lib.r001.CINTR001;

public class CINTR001Impl extends CINTR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CINTR001.class);

	/* (non-Javadoc)
	 * @see com.bbva.cint.lib.r001.CINTR001#execute(java.lang.String, java.lang.String)
	 */
	@Override
	public DataOutCreDTO execute(String pan, String rutaBase) {
		DataOutCreDTO out = null;
		try {
			LOGGER.info("Starting execute");
			out = toDataOutArray(obtenerRegistroxPan(pan,rutaBase));
			writeDataOutCreDTOJson(out,pan);
			
			LOGGER.info("Finaly execute");
		} catch (Exception e) {
			return null;
		}	
		return out;
	}
	
	
	/**
	 * @param pan
	 * @param rutaBase
	 * @return
	 */
	private String[] obtenerRegistroxPan(String pan, String rutaBase){
		String[] lineResult = null;
		try {
			String line = "";
		    BufferedReader bfr = new BufferedReader(new FileReader(new File(rutaBase)));
			
		    while((line = bfr.readLine()) != null){
		    	String[] arrayLine = line.split(";");
		    	if(pan.equals(arrayLine[0].trim()+arrayLine[1].trim())){
		    		lineResult = arrayLine;
		    		break;
		    	}
		    }
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
		return lineResult;
	}
	
	/**
	 * @param arrStr
	 * @return
	 */
	private DataOutCreDTO toDataOutArray(String[] arrStr){
		DataOutCreDTO out = new DataOutCreDTO();
		
		out.setEntBancaria(arrStr[2]);
		out.setCentro(arrStr[3]);
		out.setProducto(arrStr[4]);
		out.setNumContrato(arrStr[5]);
		out.setTitular(arrStr[6]);
		out.setDireccion(arrStr[7]);
		out.setTasaInteres(Float.parseFloat(arrStr[8].replace(',', '.').trim()));
		out.setDeuda(Float.parseFloat(arrStr[9].trim()));
		out.setCalCuotas(calcularCuotas(out.getTasaInteres(),out.getDeuda(),3));
		
		return out;
	}
	
	/**
	 * @param tasa
	 * @param deuda
	 * @param meses
	 * @return
	 */
	private float[][] calcularCuotas(float tasa, float deuda,int meses){
		float[][] calculo = new float[meses][2];
		for (int i = 0; i <= calculo.length - 1; i++) {
			calculo[i][0] = deuda / meses;
			switch (i) {
				case 0:	calculo[i][1] = 0;break;
				case 1: calculo[i][1] = (deuda *(tasa/100)) + (deuda - (deuda / meses)) * ((tasa/100)); break;
				case 2: calculo[i][1] = ((deuda / meses) *(tasa/100)); break;
			}
		}
		return calculo;
	}
	
	/**
	 * @param out
	 */
	private void writeDataOutCreDTOJson(DataOutCreDTO out,String pan){
		try {
			File file = new File("C:/Users/formacion/Desktop/IDE_APX_win64/IDE_APX_win64/workspace/UF_credito_CINT/DataOutCreDTO.json");
			if(!file.exists())
				file.createNewFile();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.valueToTree(out);
			((ObjectNode)node).put("PAN", pan);
			objectMapper.writeValue(file, node);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
