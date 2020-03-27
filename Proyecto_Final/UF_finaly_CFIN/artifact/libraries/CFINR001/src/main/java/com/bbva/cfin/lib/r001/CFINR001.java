package com.bbva.cfin.lib.r001;

import com.bbva.cfin.dto.finalizator.DataOutOneDTO;

public interface CFINR001 {

	/**
	 * @param origen
	 * @param destino
	 * @param pan
	 * @param numCuotas
	 * @return
	 * Method execute CFINR001
	 */
	DataOutOneDTO execute(String origen, String destino, String pan, int numCuotas);

}
