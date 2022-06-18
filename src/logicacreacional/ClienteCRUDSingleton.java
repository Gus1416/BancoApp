package logicacreacional;

import logicadeaccesodedatos.ClienteCRUD;

/**
 *
 * @author sebcor
 */
public class ClienteCRUDSingleton {

	//Lazy version
	private static ClienteCRUD instance;

	private ClienteCRUDSingleton() {
	}

	public static ClienteCRUD getInstance() {
		if (instance == null) {
			instance = new ClienteCRUD();
		}
		return instance;
	}

}
