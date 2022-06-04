package logicadevalidacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sebco
 */
public class ValidacionFecha {

	public static boolean validarFormatoFecha(String strDate) {
		/* Check if date is 'null' */
		if (strDate.trim().equals("")) {
			return true;
		} /* Date is not 'null' */ else {
			/*
	     * Set preferred date format,
	     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
			sdfrmt.setLenient(false);
			/* Create Date object
	     * parse the string into date 
			 */
			try {
				Date javaDate = sdfrmt.parse(strDate);
				System.out.println(strDate + " is valid date format");
			} /* Date format is invalid */ catch (ParseException e) {
				System.out.println(strDate + " is Invalid Date format");
				return false;
			}
			/* Return true if date format is valid */
			return true;
		}

	}
}