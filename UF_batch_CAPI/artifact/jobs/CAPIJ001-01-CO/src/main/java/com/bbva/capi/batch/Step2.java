package com.bbva.capi.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.bbva.capi.data.DataFileThree;
import com.bbva.elara.batch.contextutils.ContextUtils;

public class Step2 implements Tasklet {

	private ContextUtils contextUtils;
	
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
	
		Logger log = contextUtils.getLOGGER(chunkContext, getClass());
		String rutaBase1 = "C:/Users/formacion/Desktop/IDE_APX_win64/IDE_APX_win64/workspace/UF_batch_CAPI/";
		DataFileThree.lineaBalance(rutaBase1, "DataFileOneOrder.txt", "DataFileTwoOrder.txt");
		// TODO Auto-generated method stub
		return null;
	}

	public void setContextUtils(ContextUtils contextUtils) {
		this.contextUtils = contextUtils;
	}

}
