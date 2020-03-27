package com.bbva.cfin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.cfin.dto.finalizator.DataInOneDTO;
import com.bbva.cfin.dto.finalizator.DataOutOneDTO;
import com.bbva.cfin.lib.r001.CFINR001;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;



/**
 * Proy_Transacion_One
 * Implementacion de logica de negocio.
 * @author formacion
 *
 */
public class CFINT00101COTransaction extends AbstractCFINT00101COTransaction {
	private static Logger LOGGER = LoggerFactory.getLogger(CFINT00101COTransaction.class);
	/* (non-Javadoc)
	 * @see com.bbva.elara.domain.transaction.Transaction#execute()
	 */
	@Override
	public void execute() {
		try {
			LOGGER.debug("Start search");
			CFINR001 lib = (CFINR001)getServiceLibrary(CFINR001.class); 
			DataInOneDTO in = this.getDatainonedto();
			DataOutOneDTO out = lib.execute(in.getOrigen(), in.getDestino(), in.getPan(), in.getNumCuotas());
			this.setDataoutonedto(out);
			setContentLocation(getURIPath());
			setHttpResponseCode(HttpResponseCode.HTTP_CODE_200, Severity.OK);
			LOGGER.debug("Successful search");
		} catch (Exception e) {
			LOGGER.debug("Error: " +e.getMessage());
		}
	}

}
