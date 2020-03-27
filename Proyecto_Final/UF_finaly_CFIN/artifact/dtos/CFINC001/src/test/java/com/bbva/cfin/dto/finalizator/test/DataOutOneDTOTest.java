package com.bbva.cfin.dto.finalizator.test;
import org.junit.Before;
import org.junit.Test;

import com.bbva.cfin.dto.finalizator.DataOutOneDTO;

import junit.framework.Assert;
public class DataOutOneDTOTest {
	DataOutOneDTO out = new DataOutOneDTO();
	
	/**
	 * Method for test the sentence Starting()  - ended - OK
	 */
	@Before
	public void starting(){
		
		float[][] arrayCalCuotas = new float[3][2];
		arrayCalCuotas[0][0] = 1;arrayCalCuotas[0][1] = 2;
		
		out.setPan("9929392");
		out.setEntidad("0013");
		out.setCentro("5120");
		out.setProducto("50");
		out.setContrato("50568162");
		out.setTitular("ADRIANA HERNANDEZ BRAVO");
		out.setDireccion("Carrera 79 # 18-20 Bogotá");
		out.setTasaInteres(2.21F);
		out.setTotalPagar(6181844F);
		out.setNumCuotas("36");
		out.setArrayValorCuotas(arrayCalCuotas);
	}
	
	/**
	 *  Method for test the sentence toString() - ended - OK
	 */
	@Test
	public void testToString(){
		Assert.assertEquals(out.toString(), out.toString());
		Assert.assertFalse(out.toString().equals(""));
	}
	
	/**
	 * Method for test the sentence HashCode() - ended - OK
	 */
	@Test
	public void testHashCode(){
		Assert.assertEquals(out.hashCode(), out.hashCode());
		Assert.assertFalse(((Integer)out.hashCode()).equals(1));
		Assert.assertFalse(((Integer)new DataOutOneDTO().hashCode()).equals(1));
	}
	
	/**
	 * Method for test the sentence Equals() - ended - OK
	 */
	@Test
	public void testEquals(){
		DataOutOneDTO out1 = new DataOutOneDTO();
		DataOutOneDTO out2 = new DataOutOneDTO();
		
		Assert.assertEquals(out.equals(out), true);
		Assert.assertEquals(out.equals(null), false);
		Assert.assertEquals(out.equals(new Integer(1)), false);
		Assert.assertEquals(out1.equals(out2), true);
		Assert.assertEquals(out.equals(out1), false);
		
		
		out1.setArrayValorCuotas(out.getArrayValorCuotas());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setCentro("001");
		Assert.assertEquals(out1.equals(out), false);
		out1.setCentro(out.getCentro());
		Assert.assertEquals(out1.equals(out), false);

		out1.setContrato("001");
		Assert.assertEquals(out1.equals(out), false);
		out1.setContrato(out.getContrato());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setDireccion("Carrera");
		Assert.assertEquals(out1.equals(out), false);
		out1.setDireccion(out.getDireccion());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setEntidad("001");
		Assert.assertEquals(out1.equals(out), false);
		out1.setEntidad(out.getEntidad());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setNumCuotas("1");
		Assert.assertEquals(out1.equals(out), false);
		out1.setNumCuotas(out.getNumCuotas());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setPan("1232321");
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setPan(out.getPan());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setProducto("001");
		Assert.assertEquals(out1.equals(out), false);
		out1.setProducto(out.getProducto());
		Assert.assertEquals(out1.equals(out), false);
		
		
		out1.setTasaInteres(out.getTasaInteres());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setTitular("001");
		Assert.assertEquals(out1.equals(out), false);
		out1.setTitular(out.getTitular());
		Assert.assertEquals(out1.equals(out), false);
		
		out1.setTotalPagar(122);
		Assert.assertEquals(out1.equals(out), false);
		out1.setTotalPagar(out.getTotalPagar());
		Assert.assertEquals(out1.equals(out), true);
		
		out1 = new DataOutOneDTO(
				out.getPan(),
				out.getEntidad(),
				out.getCentro(),
				out.getProducto(),
				out.getContrato(),
				out.getTitular(),
				out.getDireccion(),
				out.getNumCuotas(),
				out.getTasaInteres(),
				out.getTotalPagar(),
				out.getArrayValorCuotas());
		Assert.assertEquals(out1.equals(out), true);
		
	} 
	
	
	
}
