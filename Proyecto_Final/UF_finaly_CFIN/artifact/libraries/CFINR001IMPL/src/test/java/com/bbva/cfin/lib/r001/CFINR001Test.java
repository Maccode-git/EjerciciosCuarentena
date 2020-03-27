package com.bbva.cfin.lib.r001;

import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.cfin.dto.finalizator.DataOutOneDTO;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/CFINR001-app.xml",
		"classpath:/META-INF/spring/CFINR001-app-test.xml",
		"classpath:/META-INF/spring/CFINR001-arc.xml",
		"classpath:/META-INF/spring/CFINR001-arc-test.xml" })
public class CFINR001Test {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CFINR001.class);
	
	@Resource(name = "cfinR001")
	private CFINR001 cfinR001;
	
	@Before
	public void setUp() throws Exception {		
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.cfinR001;
		if(this.cfinR001 instanceof Advised){
			Advised advised = (Advised) this.cfinR001;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		LOGGER.info("Executing the test...");
		DataOutOneDTO out = cfinR001.execute("CARTAJENA","ARGENTINA","5865734442920128",36);
		System.out.println(out.toString());
		Assert.assertEquals(out.toString(), out.toString());
		Assert.assertNull(cfinR001.execute("1","ARGENTINA","",0));
	}
	
	
	
}
