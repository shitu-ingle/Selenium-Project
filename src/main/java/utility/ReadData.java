package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData
{
	public static String readPropertyFile(String value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\Dell\\Desktop\\SsquareIT\\vedios\\14March_Selenium_Framework\\src\\main\\java\\config\\config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}//config.prperties 
	public static String readExecl(int rownum,int colnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Dell\\Desktop\\SsquareIT\\vedios\\14March_Selenium_Framework\\TestData\\sheet1.xlsx");
		Sheet es = WorkbookFactory.create(file).getSheet("Sheet1"); 
		String value = es.getRow(rownum).getCell(colnum).getStringCellValue();
		return value;
	}
	

}
