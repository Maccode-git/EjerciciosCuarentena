package com.bbva.cint.dto.creditator.test;

import com.bbva.cint.dto.creditator.DataInCreDTO;
import com.bbva.cint.dto.creditator.DataOutCreDTO;

import junit.framework.Assert;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class DataOutCreDTOTest {
	
	DataOutCreDTO out = new DataOutCreDTO();
	
	/**
	 * Method for test the sentence Starting()  - ended - OK
	 */
	@Before
	public void starting(){
		
		float[][] arrayCalCuotas = new float[3][2];
		arrayCalCuotas[0][0] = 1;arrayCalCuotas[0][1] = 2;
		
		out.setEntBancaria("0013");
		out.setCentro("5120");
		out.setProducto("50");
		out.setNumContrato("50568162");
		out.setTitular("ADRIANA HERNANDEZ BRAVO");
		out.setDireccion("Carrera 79 # 18-20 Bogotá");
		out.setTasaInteres(2.21F);
		out.setDeuda(6181844F);
		out.setCalCuotas(arrayCalCuotas);
		
	}
	
	/**
	 * Method for test the sentence toString() - ended - OK
	 */
	@Test
	public void testToString(){
		Assert.assertEquals(out.toString(), "DataOutCreDTO [entBancaria=0013, centro=5120, producto=50, numContrato=50568162, titular=ADRIANA HERNANDEZ BRAVO, direccion=Carrera 79 # 18-20 Bogotá, tasaInteres=2.21, deuda=6181844.0, calCuotas=[Cuota #1: Abono Capital: $1.0 ,Valor Interes: 2.0][Cuota #2: Abono Capital: $0.0 ,Valor Interes: 0.0][Cuota #3: Abono Capital: $0.0 ,Valor Interes: 0.0]]");
		Assert.assertFalse(out.toString().equals("1"));
	}
	
	/**
	 * Method for test the sentence HashCode() - ended - OK
	 */
	@Test
	public void testHashCode(){
		Assert.assertEquals(out.hashCode(), out.hashCode());
		Assert.assertFalse(((Integer)out.hashCode()).equals(1));
		Assert.assertFalse(((Integer)new DataOutCreDTO().hashCode()).equals(1));
	}
	
	/**
	 * Method for test the sentence Equals() - ended - OK
	 */
	@Test
	public void testEquals(){
		DataOutCreDTO out1 = new DataOutCreDTO();
		DataOutCreDTO out2 = new DataOutCreDTO();
		
		Assert.assertEquals(out.equals(out), true);
		Assert.assertEquals(out.equals(null), false);
		Assert.assertEquals(out.equals(new Integer(1)), false);
		Assert.assertEquals(out1.equals(out2), true);
		Assert.assertEquals(out.equals(out1), false);
		
		out1.setCalCuotas(out.getCalCuotas());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setCentro("001");
		Assert.assertEquals(out.equals(out1), false);
		
		out1.setCentro(out.getCentro());
		out1.setDeuda(122);
		Assert.assertEquals(out.equals(out1), false);
		
		out1.setDeuda(out.getDeuda());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setDireccion("Carrera");
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setDireccion(out.getDireccion());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setEntBancaria("001");
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setEntBancaria(out.getEntBancaria());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setNumContrato("001");
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setNumContrato(out.getNumContrato());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setProducto("001");
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setProducto(out.getProducto());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setTasaInteres(out.getTasaInteres());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setTitular("001");
		Assert.assertEquals(out1.equals(out), false);
		
		out1 = new DataOutCreDTO(out.getEntBancaria(),out.getCentro(),out.getProducto(),out.getNumContrato(),out.getTitular(),out.getDireccion(),out.getTasaInteres(),out.getDeuda(),out.getCalCuotas());
		Assert.assertEquals(out1.equals(out), true);
		
	} 

}
