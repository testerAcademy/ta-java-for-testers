package cap03;

import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Permite gestionar datos de un archivo CSV, utilizando OPENCSV
 * @author DavidChavezAvila
 *
 */
public class Ej10_HashMapListFromCSV {

    public static final char SEPARATOR=',';
    public static final char QUOTE='"';
    
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

        String file = "data/csv/personas.csv";
		
		List<HashMap<String, String>> dataList = getCsvData(file);	        
		System.out.println(dataList);

        String nombrePersona1 = dataList.get(0).get("NOMBRE");
        System.out.println("Nombre de la persona #1: " + nombrePersona1);

        //Intenta realizar lo siguiente:
        //  1. Modifica un dato a una persona existente
        //  2. Elimina a una persona existente
        //  3. Agrega una nueva persona


	}
	
	
	/**	
	 * Metodo para obtener la data de un csv data pool. 
	 * @param fileName
	 * 			el nombre del archivo csv, puede contener la exteci�n o no.
	 * @return lista de tipo hashmap por cada registro del csv
	 * @throws Exception 
	 */
	public static List<HashMap<String, String>> getCsvData(String fileName) throws Exception {
		CSVReader dt = null;
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> data;
	   	String dataFile;
		List<String[]> filas;
		
	   	dataFile = fileName.contains(".csv") ? fileName.toLowerCase().trim() : fileName.toLowerCase().trim() + ".csv";
	   	
		try {						
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(dataFile), "UTF-8");
            //datos = new CSVReader(new FileReader(ruta), SEPARATOR, QUOTE);
            dt = new CSVReader(inputStreamReader, SEPARATOR, QUOTE);
			filas = dt.readAll();

			//ITERAR FILAS
            for(int i = 1; i < filas.size(); i++) {
    			data = new LinkedHashMap<>();
    			
            	//ITERAR COLUMNAS
            	for(int j = 0; j < filas.get(i).length; j++) {
                	//AGERGAR COLUMNA Y VALOR DE COLUMANA A LA FILA CORRESPONDIENTE				   	
                	data.put(filas.get(0)[j].trim(), filas.get(i)[j].trim());

            	}

		        dataList.add(data);
            }

			dt.close();

		} catch (FileNotFoundException e) {
			throw new Exception("No se pudo leer la data del archivo: " + fileName + " \n" + e.getMessage());
		}
		
		return dataList;
	}

	/**
	 * Setea un Valor a una Columna de X Fila
	 * @param row Map<String, String> fila que se esta leyendo
	 * @param column String nombre de la columna tal cual esta en el archivo CSV
	 * @param value String valor que se le va asignar a la columna
	 */
	public static void setValueToColumn(HashMap<String, String> row, String column, String value) {
		row.replace(column.trim(), value.trim());
	}

}
