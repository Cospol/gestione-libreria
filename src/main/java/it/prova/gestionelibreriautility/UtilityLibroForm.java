package it.prova.gestionelibreriautility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

 public class UtilityLibroForm {

	public static boolean validateInput(String titoloInputParam, String genereInputParam,
			String pagineInputStringParam, String dataPubblicazioneStringParam) {
		// prima controlliamo che non siano vuoti
		if (StringUtils.isBlank(titoloInputParam) || StringUtils.isBlank(genereInputParam)
				|| !NumberUtils.isCreatable(pagineInputStringParam) || StringUtils.isBlank(dataPubblicazioneStringParam)) {
			return false;
		}
		return true;
	}
	
	public static boolean validateIdInput(String idInputParam ) {
 		if (StringUtils.isBlank(idInputParam) ) {
			return false;
		}
		return true;
	}

	public static Date parseDateArrivoFromString(String dataPubblicazioneStringParam) {
		if (StringUtils.isBlank(dataPubblicazioneStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataPubblicazioneStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
