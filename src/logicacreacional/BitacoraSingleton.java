package logicacreacional;

import logicadenegocios.Bitacora;
import logicadenegocios.CsvObserver;
import logicadenegocios.FormatoBitacoraObserver;
import logicadenegocios.TxtObserver;

public class BitacoraSingleton {
	
	private static Bitacora instance;

	private BitacoraSingleton() {
	}
	
	public static Bitacora getInstance(){
		if (instance == null){
			instance = new Bitacora();
			FormatoBitacoraObserver formatoBitacoraObserverCsv = new CsvObserver(instance);
			FormatoBitacoraObserver formatoBitacoraObserverTxt = new TxtObserver(instance);
		}
		return instance;
	}
}
