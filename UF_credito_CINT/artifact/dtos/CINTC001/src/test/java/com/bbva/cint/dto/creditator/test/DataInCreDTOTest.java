package com.bbva.cint.dto.creditator.test;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cint.dto.creditator.DataInCreDTO;

import junit.framework.Assert;

public class DataInCreDTOTest {
	
	DataInCreDTO in = new DataInCreDTO();
	
	/**
	 * Method for test the sentence Starting()  - ended - OK
	 */
	@Before
	public void starting(){
		in.setPan("5865734442920128");
		in.setRutaBase("C:/Users/formacion/Desktop/IDE_APX_win64/IDE_APX_win64/workspace/UF_credito_CINT/ListadoTarjetas2.txt");
		
		Assert.assertEquals(in.getPan(), "5865734442920128");
		Assert.assertEquals(in.getRutaBase(), in.getRutaBase());
	}
	
	/**
	 *  Method for test the sentence toString() - ended - OK
	 */
	@Test
	public void testToString(){
		Assert.assertEquals(in.toString(), "DataInCreDTO [pan=" + in.getPan() + ", rutaBase=" + in.getRutaBase() + "]");
		Assert.assertFalse(in.toString().equals("1"));
	}
	
	/**
	 * Method for test the sentence HashCode() - ended - OK
	 */
	@Test
	public void testHashCode(){
		Assert.assertEquals(in.hashCode(), in.hashCode());
		Assert.assertFalse(((Integer)in.hashCode()).equals(1));
		Assert.assertFalse(((Integer)new DataInCreDTO().hashCode()).equals(1));
	}
	
	/**
	 * Method for test the sentence Equals() - ended - OK
	 */
	@Test
	public void testEquals(){
		DataInCreDTO in1 = new DataInCreDTO();
		DataInCreDTO in2 = new DataInCreDTO();
		
		Assert.assertEquals(in.equals(in), true);
		Assert.assertEquals(in1.equals(in2), true);
		Assert.assertEquals(in.equals(null), false);
		Assert.assertEquals(in.equals(new Integer(1)), false);
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setPan("123");
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setPan(in.getPan());
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setRutaBase("123");
		Assert.assertEquals(in1.equals(in), false);
		
		in2 = new DataInCreDTO(in.getPan(), in.getRutaBase());
		Assert.assertEquals(in2.equals(in), true);
		
	}
}
