package com.bbva.cbat.batch;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.bbva.cbat.batch.lib.DataContractOut;
import com.bbva.elara.batch.contextutils.ContextUtils;

public class Step1 implements Tasklet {

	private ContextUtils contextUtils;
	
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
	
		Logger log = contextUtils.getLOGGER(chunkContext, getClass());

		String rutaArchivo = "C:/Users/formacion/Desktop/IDE_APX_win64/IDE_APX_win64/workspace/UF_finaly_CFIN/";
		ArrayList<DataContractOut> listData = DataContractOut.OrderToBatch(rutaArchivo);
		DataContractOut.createFile(rutaArchivo,listData);  
		DataContractOut.validateFileResult(rutaArchivo,listData);
		// TODO Auto-generated method stub
		return null;
	}

	public void setContextUtils(ContextUtils contextUtils) {
		this.contextUtils = contextUtils;
	}

}
