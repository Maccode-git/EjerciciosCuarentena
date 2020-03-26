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


public class DataFileOne {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataFileOne.class);
	private String numOrden;
	private String bin;
	private String iai;
	private String entidad;
	private String oficina;
	private String producto;
	private String contrato;
	private String nombre;
	private String dirreccion;
	private String tasa;
	private String deuda;
	
	public DataFileOne(){}
	/**
	 * @param numOrden
	 * @param bin
	 * @param iai
	 * @param entidad
	 * @param oficina
	 * @param producto
	 * @param contrato
	 * @param nombre
	 * @param dirreccion
	 * @param tasa
	 * @param deuda
	 */
	public DataFileOne(String numOrden, String bin, String iai, String entidad, String oficina, String producto,
			String contrato, String nombre, String dirreccion, String tasa, String deuda) {
		super();
		this.numOrden = numOrden;
		this.bin = bin;
		this.iai = iai;
		this.entidad = entidad;
		this.oficina = oficina;
		this.producto = producto;
		this.contrato = contrato;
		this.nombre = nombre;
		this.dirreccion = dirreccion;
		this.tasa = tasa;
		this.deuda = deuda;
	}
	
	public DataFileOne(String[] arrayDatos ) {
		super();
		this.bin 		= arrayDatos[0];
		this.iai 		= arrayDatos[1];
		this.entidad 	= arrayDatos[2];
		this.oficina 	= arrayDatos[3];
		this.producto 	= arrayDatos[4];
		this.contrato 	= arrayDatos[5];
		this.nombre 	= arrayDatos[6];
		this.dirreccion = arrayDatos[7];
		this.tasa 		= arrayDatos[8];
		this.deuda 		= arrayDatos[9];
		this.numOrden 	= this.entidad+this.oficina+this.producto+this.contrato;
	}
	
	public DataFileOne(String[] arrayDatos,int val ) {
		super();
		this.numOrden   = arrayDatos[0];
		this.bin 		= arrayDatos[1];
		this.iai 		= arrayDatos[2];
		this.entidad 	= arrayDatos[3];
		this.oficina 	= arrayDatos[4];
		this.producto 	= arrayDatos[5];
		this.contrato 	= arrayDatos[6];
		this.nombre 	= arrayDatos[7];
		this.dirreccion = arrayDatos[8];
		this.tasa 		= arrayDatos[9];
		this.deuda 		= arrayDatos[10];
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
	 * @return the bin
	 */
	public String getBin() {
		return bin;
	}
	/**
	 * @param bin the bin to set
	 */
	public void setBin(String bin) {
		this.bin = bin;
	}
	/**
	 * @return the iai
	 */
	public String getIai() {
		return iai;
	}
	/**
	 * @param iai the iai to set
	 */
	public void setIai(String iai) {
		this.iai = iai;
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
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the dirreccion
	 */
	public String getDirreccion() {
		return dirreccion;
	}
	/**
	 * @param dirreccion the dirreccion to set
	 */
	public void setDirreccion(String dirreccion) {
		this.dirreccion = dirreccion;
	}
	/**
	 * @return the tasa
	 */
	public String getTasa() {
		return tasa;
	}
	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}
	/**
	 * @return the deuda
	 */
	public String getDeuda() {
		return deuda;
	}
	/**
	 * @param deuda the deuda to set
	 */
	public void setDeuda(String deuda) {
		this.deuda = deuda;
	}
	
	@Override
	public String toString(){
		return this.numOrden +";"+ this.bin +";"+ this.iai  +";"+ this.entidad  +";"+this.oficina +";"+ this.producto  +";"+ this.contrato
				 +";"+ this.nombre  +";"+ this.dirreccion  +";"+ this.tasa +";"+ this.deuda;
	}
	
	public static void ordenarFile(String rutaBase, String nombreArcOne){
		LinkedList<DataFileOne> listaDatos = new LinkedList<DataFileOne>();
		
		try {
			String line = "";
		    BufferedReader bfr = new BufferedReader(new FileReader(new File(rutaBase+nombreArcOne)));
		    while((line = bfr.readLine()) != null){
		    	if(!line.split(";")[0].contains("BIN")){
		    		listaDatos.add(new DataFileOne(line.split(";")));
		    	}
		    }
		    Collections.sort(listaDatos,Comparator.comparing(DataFileOne::getNumOrden));
		    bfr.close();
		    
		    File file = new File(rutaBase+"DataFileOneOrder.txt");
			if(file.exists())
				file.delete();
				
			file.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (DataFileOne dataFileOne : listaDatos) {
		    	bw.write(dataFileOne.toString()+"\n");
			}
			bw.close();
					
		} catch (Exception e) {
			LOGGER.info("Error: " + e.getMessage());
		}
	}
	
	public static ArrayList<DataFileOne> toFileDataFile(String rutaArchivo){
		ArrayList<DataFileOne> listFileOne = new ArrayList<DataFileOne>();
		
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
			while((line = br.readLine()) != null ){
				listFileOne.add(new DataFileOne(line.split(";"),0));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listFileOne;
	}
	
	
}
