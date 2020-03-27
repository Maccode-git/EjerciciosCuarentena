package com.bbva.cfin.dto.finalizator.test;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cfin.dto.finalizator.DataInOneDTO;

import junit.framework.Assert;

public class DataInOneDTOTest {
	DataInOneDTO in = new DataInOneDTO();
	
	/**
	 * Method for test the sentence Starting()  - ended - OK
	 */
	@Before
	public void starting(){
		in.setOrigen("BOGOTA");
		in.setDestino("SOACHA");
		in.setPan("");
		in.setNumCuotas(36);
	}
	
	/**
	 *  Method for test the sentence toString() - ended - OK
	 */
	@Test
	public void testToString(){
		Assert.assertEquals(in.toString(), "DataInOneDTO [Origen=" + in.getOrigen() + ", Destino=" + in.getDestino() + ", Pan=" + in.getPan() + ", NumCuotas=" + in.getNumCuotas()+ "]");
		Assert.assertFalse(in.toString().equals("1"));
	}
	
	/**
	 * Method for test the sentence HashCode() - ended - OK
	 */
	@Test
	public void testHashCode(){
		Assert.assertEquals(in.hashCode(), in.hashCode());
		Assert.assertFalse(((Integer)in.hashCode()).equals(1));
		Assert.assertFalse(((Integer)new DataInOneDTO().hashCode()).equals(1));
	}
	
	/**
	 * Method for test the sentence Equals() - ended - OK
	 */
	@Test
	public void testEquals(){
		DataInOneDTO in1 = new DataInOneDTO();
		DataInOneDTO in2 = new DataInOneDTO();
		
		Assert.assertEquals(in.equals(in), true);
		Assert.assertEquals(in1.equals(in2), true);
		Assert.assertEquals(in.equals(null), false);
		Assert.assertEquals(in.equals(new Integer(1)), false);
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setDestino("SUBA");
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setDestino(in.getDestino());
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setNumCuotas(1);
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setNumCuotas(in.getNumCuotas());
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setOrigen("USME");
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setOrigen(in.getOrigen());
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setPan("123");
		Assert.assertEquals(in1.equals(in), false);
		
		in1.setPan(in.getPan());
		Assert.assertEquals(in1.equals(in), true);

		in2 = new DataInOneDTO(in.getOrigen(),in.getDestino(), in.getPan(), in.getNumCuotas());
		Assert.assertEquals(in2.equals(in), true);
	}
	
	
}
