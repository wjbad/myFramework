package testsTakeAlot;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;

public class ReadDataFromExcel {
	
	//instantiate the class object
	ReadExcel rExcel = new ReadExcel();
	
	@Test(dataProvider="Brand and Quantity")
	public void BrandQuantity(String brand, String quantity) {
		System.out.println(brand + " " + quantity);
		//int quantityInt = Integer.parseInt(quantity);
		//System.out.println("transformed to int " + quantityInt);
	}
	
//	@Test(dataProvider="Brand and Quantity")
//	public void BrandQuantityint(String brand, int quantity) {
//		System.out.println(brand + " " + quantity);
//	}

	@DataProvider(name = "Brand and Quantity")
	public Object[][] getDataFromExcel() throws IOException{
		String excelDIrectory = rExcel.getDataConfigProperties("excelDataDir");
		Object[][] errObj = rExcel.getExcelData(excelDIrectory +"BrandANDQuantity.xlsx", "Sheet1");
		return errObj;
	}
	
}
