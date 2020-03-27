package com.bbva.cfin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.cfin.lib.r002.CFINR002;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;

/**
 * Transaccion 2
 * Implementacion de logica de negocio.
 * @author formacion
 *
 */
public class CFINT00201COTransaction extends AbstractCFINT00201COTransaction {
	private static Logger LOGGER = LoggerFactory.getLogger(CFINT00201COTransaction.class);
	/* (non-Javadoc)
	 * @see com.bbva.elara.domain.transaction.Transaction#execute()
	 */
	@Override
	public void execute() {
		try {
			LOGGER.debug("Start search");
			CFINR002 lib = (CFINR002)getServiceLibrary(CFINR002.class); 
			lib.execute();
			setContentLocation(getURIPath());
			setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);
			LOGGER.debug("Successful search");
		} catch (Exception e) {
			LOGGER.debug("Error: " +e.getMessage());
		}
	}

}
