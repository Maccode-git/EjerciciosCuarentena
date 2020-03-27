package com.bbva.cfin.lib.r001.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.cfin.dto.finalizator.DataOutOneDTO;
import com.bbva.cfin.lib.r001.CFINR001;

import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class CFINR001Impl extends CFINR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CFINR001.class);

	/* (non-Javadoc)
	 * @see com.bbva.cfin.lib.r001.CFINR001#execute(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public DataOutOneDTO execute(String origen, String destino, String pan, int numCuotas) {
		DataOutOneDTO out = new DataOutOneDTO();
		LOGGER.info("Starting execute");
		try {
			String rutaBase= "C:/Users/formacion/Desktop/IDE_APX_win64/IDE_APX_win64/workspace/UF_finaly_CFIN/";
			
			out = toDataOutArray(obtenerRegistroxPan(pan,rutaBase),obtenerValorTotal(origen,destino),numCuotas);
			writeDataOutCreDTOJson(out,rutaBase);
			
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
			return null;
		}
		LOGGER.info("Finaly execute");
		return out;
		
	}
	
	/**
	 * @param pan
	 * @param rutaBase
	 * @return
	 * Method obtenerRegistroxPan
	 */
	private String[] obtenerRegistroxPan(String pan, String rutaBase){
		String[] lineResult = null;
		try {
			String line = "";
		    BufferedReader bfr = new BufferedReader(new FileReader(new File(rutaBase+"ListadoTarjetas2.txt")));
			
		    while((line = bfr.readLine()) != null){
		    	String[] arrayLine = line.split(";");
		    	if(pan.equals(arrayLine[0].trim()+arrayLine[1].trim())){
		    		lineResult = arrayLine;
		    		break;
		    	}
		    }
		    bfr.close();
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
		return lineResult;
	}
	
	
	
	/**
	 * @param origen
	 * @param destino
	 * @return
	 * Method obtenerValorTotal
	 */
	private float obtenerValorTotal(String origen, String destino){
		
		float valorTotal = 0;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String json = restTemplate.getForObject("https://maps.googleapis.com/maps/api/directions/json?origin=" + origen + "&destination=" + destino + "&key=AIzaSyByPeqwGB3sb1BXGhEkzfzmnOodqugTM6Q", String.class);
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonTotal = objectMapper.readValue(json, JsonNode.class);
			
			JsonNode jsonInfo = jsonTotal.get("routes").get(0).get("legs").get(0);
			valorTotal= (jsonInfo.get("distance").get("value").asInt()/1000)*(jsonInfo.get("duration").get("value").asInt()/1000);
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
		return valorTotal;
	}
	

	/**
	 * @param arrStr
	 * @param totalPagar
	 * @param cuotas
	 * @return
	 * Method toDataOutArray
	 */
	private DataOutOneDTO toDataOutArray(String[] arrStr,float totalPagar,int cuotas){
		DataOutOneDTO out = new DataOutOneDTO();
		out.setPan(arrStr[0]+arrStr[1]);
		out.setEntidad(arrStr[2]);
		out.setCentro(arrStr[3]);
		out.setProducto(arrStr[4]);
		out.setContrato(arrStr[5]);
		out.setTitular(arrStr[6]);
		out.setDireccion(arrStr[7]);
		out.setNumCuotas(String.valueOf(cuotas));
		out.setTasaInteres(Float.parseFloat(arrStr[8].replace(',', '.').trim()));
		out.setTotalPagar(totalPagar);
		out.setArrayValorCuotas(calcularCuotas(out.getTasaInteres(),out.getTotalPagar(),cuotas));
		return out;
	}

	/**
	 * @param tasa
	 * @param deuda
	 * @param meses
	 * @return
	 * Method calcularCuotas
	 */
	private float[][] calcularCuotas(float tasa, float deuda,int meses){
		float[][] calculo = new float[meses][2];
		float deudaCl = deuda;
		for (int i = 0; i <= calculo.length - 1; i++) {
			
			calculo[i][0] = deuda / meses;
			switch (i) {
				case 0:	calculo[i][1] = 0;break;
				case 1: calculo[i][1] = (deuda *(tasa/100)) + (deuda - (deuda / meses)) * ((tasa/100)); break;
				default : calculo[i][1] = (deudaCl *(tasa/100));break;
			}
			deudaCl -= calculo[i][0];
			
		}
		return calculo;
	}


	/**
	 * @param out
	 * @param rutaBase
	 * Method writeDataOutCreDTOJson
	 */
	private void writeDataOutCreDTOJson(DataOutOneDTO out,String rutaBase){
		try {
			File file = new File(rutaBase+"DataOutOneDTO.json");
			if(file.exists())
				file.delete();
			
			file.createNewFile();
			
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(file, objectMapper.valueToTree(out));
			
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
	}
	
}
