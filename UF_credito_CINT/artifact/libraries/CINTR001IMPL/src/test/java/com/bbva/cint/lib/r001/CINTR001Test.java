package com.bbva.cint.lib.r001;

import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.cint.dto.creditator.DataOutCreDTO;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/CINTR001-app.xml",
		"classpath:/META-INF/spring/CINTR001-app-test.xml",
		"classpath:/META-INF/spring/CINTR001-arc.xml",
		"classpath:/META-INF/spring/CINTR001-arc-test.xml" })
public class CINTR001Test {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CINTR001.class);
	
	@Resource(name = "cintR001")
	private CINTR001 cintR001;
	
	@Before
	public void setUp() throws Exception {		
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.cintR001;
		if(this.cintR001 instanceof Advised){
			Advised advised = (Advised) this.cintR001;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	/**
	 * Method for test the sentence executeTest()  - ended - OK
	 */
	@Test
	public void executeTest(){
		LOGGER.info("Executing the test...");
		DataOutCreDTO out = cintR001.execute("5907211723755577","C:/Users/formacion/Desktop/IDE_APX_win64/IDE_APX_win64/workspace/UF_credito_CINT/ListadoTarjetas2.txt");
		System.out.println(out.toString());
		Assert.assertEquals(out.toString(), out.toString());
		Assert.assertNull(cintR001.execute("5865734442920128","C:/Users/formacion/Desktop/IDE_APX_win64/IDE_APX_win64/workspace/UF_credito_CINT/ListadoTarjetase"));
		
	}
	
}
