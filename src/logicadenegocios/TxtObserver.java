package logicadenegocios;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebcor
 */
public class TxtObserver extends FormatoBitacoraObserver {

	public TxtObserver(Bitacora pBitacora) {
		subject = pBitacora;
		subject.attach(this);
	}

	@Override
	public void update() {
		String[] registro = subject.getRegistro();
		//String ID = fixedLengthString(registro[0], 6);
		String Ope = fixedLengthString(registro[2], 15);
		String Fecha = fixedLengthString(registro[0], 15);
		String Hora = fixedLengthString(registro[1], 15);
		String Vista = fixedLengthString(registro[3], 7);
		String PosFormat;

		PosFormat = Fecha + Hora + Ope + Vista;

		File file = new File("FormatoPosicional.txt");
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file, true);
		} catch (IOException ex) {
			Logger.getLogger(TxtObserver.class.getName()).log(Level.SEVERE, null, ex);
		}
		PrintWriter pw = new PrintWriter(fw);

		pw.println(PosFormat);
		pw.close();
	}

	private static String fixedLengthString(String string, int length) {
		return String.format("%1$" + length + "s", string);
	}
}