package logicadenegocios;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvObserver extends FormatoBitacoraObserver{

	public CsvObserver(Bitacora pBitacora){
		subject = pBitacora;
		subject.attach(this);
	}
	
	@Override
	public void update() {
		
		try{
			try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\Gustavo\\OneDrive\\Documentos\\NetBeansProjects\\BancoApp\\bitacora.csv", true))) {
				String[] registro = subject.getRegistro();
				writer.writeNext(registro);
			}
			
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}