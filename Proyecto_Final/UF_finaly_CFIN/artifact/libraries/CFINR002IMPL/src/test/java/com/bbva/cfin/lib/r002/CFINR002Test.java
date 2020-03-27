package com.bbva.cfin.lib.r002;

import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/CFINR002-app.xml",
		"classpath:/META-INF/spring/CFINR002-app-test.xml",
		"classpath:/META-INF/spring/CFINR002-arc.xml",
		"classpath:/META-INF/spring/CFINR002-arc-test.xml" })
public class CFINR002Test {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CFINR002.class);
	
	@Resource(name = "cfinR002")
	private CFINR002 cfinR002;
	
	@Before
	public void setUp() throws Exception {		
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.cfinR002;
		if(this.cfinR002 instanceof Advised){
			Advised advised = (Advised) this.cfinR002;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		LOGGER.info("Executing the test...");
		cfinR002.execute();
	}
	
}
