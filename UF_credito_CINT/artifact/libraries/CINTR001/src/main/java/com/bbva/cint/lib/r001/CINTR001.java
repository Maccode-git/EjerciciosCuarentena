package com.bbva.cint.lib.r001;

import com.bbva.cint.dto.creditator.DataOutCreDTO;

public interface CINTR001 {

	/**
	 * @param pan
	 * @param rutaBase
	 * @return
	 */
	DataOutCreDTO execute(String pan, String rutaBase);

}
