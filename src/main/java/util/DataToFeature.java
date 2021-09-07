/**
 * @since 27/11/2017
 */
package util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Ingresa los datos obtenidos del archivo de Excel al archivo feature del cual se está llamando
 * @since 27/11/2017
 * @author bgaona
 *
 */
public class DataToFeature {
	
	/**
	 * Ingresa los datos obtenidos de un excel al archivo .feature del cual se está llamando, hace que se genere la tabla en el escenario 
	 * Outline como Data Table
	 * @since 27/11/2017
	 * @author bgaona
	 * @param featureFile Nombre del archivo .feature el cual se modificará, debe tener la ruta del archivo y la hoja ser usada
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	 private static List<String> setExcelDataToFeature(File featureFile)
	 
	            throws InvalidFormatException, IOException {
		 //System.out.println("ENTRO setExcelDataToFeature");
	        List<String> fileData = new ArrayList<String>();
	        try (BufferedReader buffReader = new BufferedReader(
	                new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), "UTF-8"))) {
	            String data;
	            List<Map<String, String>> excelData = null;
	            boolean foundHashTag = false;
	            boolean featureData = false;
	            while ((data = buffReader.readLine()) != null) {
	                String sheetName = null;
	                String excelFilePath = null;
	                if (data.trim().contains("##@externaldata")) {
	                    excelFilePath = data.substring(StringUtils.ordinalIndexOf(data, "@", 2)+1, data.lastIndexOf("@"));
	                    sheetName = data.substring(data.lastIndexOf("@")+1, data.length());
	                    System.out.println("Hoja: "+sheetName);
	                    
	                    foundHashTag = true;
	                    fileData.add(data);
	                } if (foundHashTag) {
	                	/*System.out.println("ruta del archivo: "+excelFilePath+"\n");
	                	System.out.println("Hoja del archivo: "+sheetName+"\n");*/
	                    excelData = new LectorExcel().getData(excelFilePath, sheetName);
//	                    String columnHeader = "";

//	                    for (Entry<String, String> map : excelData.get(0).entrySet()) {
//	                        columnHeader = columnHeader + "|" + map.getKey();
//	                    }
//	                   
//	                    fileData.add(columnHeader + "|");

	                    for (int rowNumber = 0; rowNumber < excelData.size()-1; rowNumber++) {
	                        String cellData = "";
	                        for (Entry<String, String> mapData : excelData.get(rowNumber).entrySet()) {
	                            cellData = cellData + "|" + mapData.getValue();
	                        }
	                        fileData.add(cellData + "|");
	                    }
	                    foundHashTag = false;
	                    featureData = true;
	                    continue;
	                }
	                if(data.startsWith("|")||data.endsWith("|")){
	                    if(featureData){
	                        continue;
	                    } else{
	                        fileData.add(data);
	                        continue;
	                    }
	                } else {
	                    featureData = false;
	                }
	                fileData.add(data);
	            }
	        }
	        return fileData;
	    }
	 
	 /**
	  * Lista de todos los features con sus respectivos archivo de excel que se usarán en la prueba
	  * @since 27/11/2017
	  * @author bgaona
	  * @param folder Carpeta donde estarán los archivo .feature
	  * @return
	  */
	 private static List<File> listOfFeatureFiles(File folder) {
	        List<File> featureFiles = new ArrayList<File>();
	        for (File fileEntry : folder.listFiles()) {
	            if (fileEntry.isDirectory()) {
	                featureFiles.addAll(listOfFeatureFiles(fileEntry));
	            } else {
	                if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
	                    featureFiles.add(fileEntry);
	                }
	            }
	        }
	        return featureFiles;
	    }
	 
	 /**
	  * Hace una lista con todos los features dependiendo de la ruta asignada
	  * @since 27/11/2017
	  * @author bgaona
	  * @param featuresDirectoryPath Ruta donde se encuentran los features que tendrán las tablas
	  * @throws IOException
	  * @throws InvalidFormatException
	  */
	public static void overrideFeatureFiles(String featuresDirectoryPath)
			// public void overrideFeatureFiles(String featuresDirectoryPath)
			throws IOException, InvalidFormatException {
		List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));
		
			for (File featureFile : listOfFeatureFiles) {
				
				List<String> featureWithExcelData = setExcelDataToFeature(featureFile);
				try (BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(featureFile), "UTF-8"));) {
					for (String string : featureWithExcelData) {
						writer.write(string);
						writer.write("\n");
					}
				}
				
			}
		
	}
	        
}
