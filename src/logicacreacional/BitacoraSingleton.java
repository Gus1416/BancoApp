package logicacreacional;

import logicadenegocios.Bitacora;
import logicadenegocios.CsvObserver;
import logicadenegocios.FormatoBitacoraObserver;
import logicadenegocios.TxtObserver;
import logicadenegocios.XmlObserver;

public class BitacoraSingleton {
	
	private static Bitacora instance;

	private BitacoraSingleton() {
	}
	
	public static Bitacora getInstance(){
		if (instance == null){
			instance = new Bitacora();
			FormatoBitacoraObserver formatoBitacoraObserverCsv = new CsvObserver(instance);
			FormatoBitacoraObserver formatoBitacoraObserverTxt = new TxtObserver(instance);
			FormatoBitacoraObserver formatoBitacoraObserverXml = new XmlObserver(instance);
		}
		return instance;
	}
}