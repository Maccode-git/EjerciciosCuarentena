package com.bbva.cint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.cint.dto.creditator.DataInCreDTO;
import com.bbva.cint.dto.creditator.DataOutCreDTO;
import com.bbva.cint.lib.r001.CINTR001;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;


/**
 * Descripcion
 * Implementacion de logica de negocio.
 * @author formacion
 *
 */
public class CINTT00101COTransaction extends AbstractCINTT00101COTransaction {
	private static Logger LOGGER = LoggerFactory.getLogger(CINTT00101COTransaction.class);
	/* (non-Javadoc)
	 * @see com.bbva.elara.domain.transaction.Transaction#execute()
	 */
	@Override
	public void execute() {
		try {
			LOGGER.debug("Start search");
			CINTR001 ci = (CINTR001)getServiceLibrary(CINTR001.class);
			DataInCreDTO in = this.getDataincredto();
			DataOutCreDTO out = ci.execute(in.getPan(), in.getRutaBase());
			this.setDataoutcredto(out);
			LOGGER.debug("Successful search");
			setContentLocation(getURIPath());
			setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
