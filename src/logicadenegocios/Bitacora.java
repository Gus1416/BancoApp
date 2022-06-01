package logicadenegocios;

import java.util.ArrayList;

public class Bitacora {
	
	private String[] registro;
	private ArrayList<FormatoBitacoraObserver> observers;
	
	public Bitacora(){
		registro = new String[4];
		observers = new ArrayList<>();
	}

	public String[] getRegistro() {
		return registro;
	}

	public void setRegistro(String[] registro) {
		this.registro = registro;
		notifyAllObservers();
	}

	public void attach(FormatoBitacoraObserver pObserver){
		observers.add(pObserver);
	}
	
	public void notifyAllObservers(){
		for (FormatoBitacoraObserver observer : observers){
			observer.update();
		}
	}
}