package com.bill_soft.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bill_soft.entity.Stock;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ReportHelper {

	private static String[] HEADERs = {"SR.NO","Item Name","Category","Quantity"};
	private static final String SHEET = "current stock";
	
	private static String[] HEADERs1 = {"SR.NO","Category Name","Item Name","Available Quantity","Update Date"};
	private static final String SHEET1 = "category Wise stock";
	public static ByteArrayInputStream CurrentStockReportForSuperAdmin(List<Stock> stock) {
		try
		(Workbook workbook = new XSSFWorkbook(); 
		ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	    Sheet sheet = workbook.createSheet(SHEET);
	    Row headerRow = sheet.createRow(0);
	    for (int col = 0; col < HEADERs.length; col++)
					{
						Cell cell = headerRow.createCell(col);
						cell.setCellValue(HEADERs[col]);
						
					}
	    int rowIdx = 1;
		for (Stock stockexcel : stock) {
			Row row = sheet.createRow(rowIdx++);

			//System.out.println(track);
			row.createCell(0).setCellValue(stockexcel.getPkStockId());
			row.createCell(1).setCellValue(stockexcel.getProductName());
			row.createCell(2).setCellValue(stockexcel.getCategoryName());
			row.createCell(3).setCellValue(stockexcel.getAvailableQuantity());
		}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());	
		}
		catch (IOException e) 
		{
		      throw new RuntimeException("fail to Export data to Excel file: " + e.getMessage());
		    }
		
	}



	public static ByteArrayInputStream CurrentStockReportForOragnization(List<Stock> stock1) {
		try
		(Workbook workbook = new XSSFWorkbook(); 
		ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	    Sheet sheet = workbook.createSheet(SHEET);
	    Row headerRow = sheet.createRow(0);
	    for (int col = 0; col < HEADERs.length; col++)
					{
						Cell cell = headerRow.createCell(col);
						cell.setCellValue(HEADERs[col]);
						
					}
	    int rowIdx = 1;
		for (Stock stockexcel : stock1) {
			Row row = sheet.createRow(rowIdx++);

			//System.out.println(track);
			row.createCell(0).setCellValue(stockexcel.getPkStockId());
			row.createCell(1).setCellValue(stockexcel.getProductName());
			row.createCell(2).setCellValue(stockexcel.getCategoryName());
			row.createCell(3).setCellValue(stockexcel.getAvailableQuantity());
		}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());	
		}
		catch (IOException e) 
		{
		      throw new RuntimeException("fail to export data to Excel file: " + e.getMessage());
		    }
		
		
	}

	public static ByteArrayInputStream CurrentStockReportForAdmin(List<Stock> stock2) {
	
		try
		(Workbook workbook = new XSSFWorkbook(); 
		ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	    Sheet sheet = workbook.createSheet(SHEET);
	    Row headerRow = sheet.createRow(0);
	    for (int col = 0; col < HEADERs.length; col++)
					{
						Cell cell = headerRow.createCell(col);
						cell.setCellValue(HEADERs[col]);
						
					}
	    int rowIdx = 1;
		for (Stock stockexcel : stock2) {
			Row row = sheet.createRow(rowIdx++);

			//System.out.println(track);
			row.createCell(0).setCellValue(stockexcel.getPkStockId());
			row.createCell(1).setCellValue(stockexcel.getProductName());
			row.createCell(2).setCellValue(stockexcel.getCategoryName());
			row.createCell(3).setCellValue(stockexcel.getAvailableQuantity());
		}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());	
		}
		catch (IOException e) 
		{
		      throw new RuntimeException("fail to export data to Excel file: " + e.getMessage());
		    }
		
	}



	public static ByteArrayInputStream CurrentStockReportpdfForSuperAdmin(List<Stock> stock) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			Font font17 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(100);
			float[] columnWidths = {10f};
			table.setWidths(columnWidths);

			PdfPCell table_cell;
			
			table_cell = new PdfPCell(new Phrase("Current Stock Report" , font17));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(table_cell);

			table_cell = new PdfPCell(new Phrase("\n" , font17));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(table_cell);

			
			PdfPTable table1 = new PdfPTable(4);
			table1.setWidthPercentage(100);
			table1.setWidths(new int[]{3, 3, 3,3});

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("SR NO", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			hcell = new PdfPCell(new Phrase("Item Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Category", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			hcell = new PdfPCell(new Phrase("Quantity", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			Integer i=1;
			for(Stock stock1 :stock)
			{
				PdfPCell cell;
			    cell = new PdfPCell(new Phrase((String.valueOf(i++))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(stock1.getProductName().toString()));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(stock1.getCategoryName().toString()));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(String.valueOf(stock1.getAvailableQuantity())));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
			}
		
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);
		document.add(table1);
			
			document.close();
			

		} catch (DocumentException ex) {

			ex.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	
	}



	public static ByteArrayInputStream CurrentStockReportpdfForOragnization(List<Stock> stock1) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			Font font17 = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD, BaseColor.BLACK);
			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(100);
			float[] columnWidths = {10f};
			table.setWidths(columnWidths);

			PdfPCell table_cell;
			
			table_cell = new PdfPCell(new Phrase("Current Stock Report" , font17));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(table_cell);
			
			table_cell = new PdfPCell(new Phrase("\n" , font17));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(table_cell);

			PdfPTable table1 = new PdfPTable(4);
			table1.setWidthPercentage(100);
			table1.setWidths(new int[]{3, 3, 3,3});

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("SR NO", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			hcell = new PdfPCell(new Phrase("Item Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Category", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			hcell = new PdfPCell(new Phrase("Quantity", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			Integer i=1;
			for(Stock stock2 :stock1)
			{
				PdfPCell cell;
			    cell = new PdfPCell(new Phrase((String.valueOf(i++))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(stock2.getProductName().toString()));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(stock2.getCategoryName().toString()));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(String.valueOf(stock2.getAvailableQuantity())));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
			}
		
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);
			document.add(table1);
		
			
			document.close();
			

		} catch (DocumentException ex) {

			ex.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	
	}



	public static ByteArrayInputStream CurrentStockReportpdfForAdmin(List<Stock> stock2) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			Font font17 = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD, BaseColor.BLACK);
			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(100);
			float[] columnWidths = {10f};
			table.setWidths(columnWidths);

			PdfPCell table_cell;
			
			table_cell = new PdfPCell(new Phrase("Current Stock Report" , font17));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(table_cell);

			table_cell = new PdfPCell(new Phrase("\n" , font17));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(table_cell);
			
			PdfPTable table1 = new PdfPTable(4);
			table1.setWidthPercentage(100);
			table1.setWidths(new int[]{3, 3, 3,3});

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("SR NO", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			hcell = new PdfPCell(new Phrase("Item Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Category", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			hcell = new PdfPCell(new Phrase("Quantity", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			Integer i=1;
			for(Stock stock3 :stock2)
			{
				PdfPCell cell;
			    cell = new PdfPCell(new Phrase((String.valueOf(i++))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(stock3.getProductName().toString()));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(stock3.getCategoryName().toString()));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(String.valueOf(stock3.getAvailableQuantity())));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
			}
		
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);
			document.add(table1);
		
			
			document.close();
			

		} catch (DocumentException ex) {

			ex.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	
	}



	public static ByteArrayInputStream CategoryWiseStockReportExcelForsuperadmin(List<Stock> stock4) {
		try
		(Workbook workbook = new XSSFWorkbook(); 
		ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	    Sheet sheet = workbook.createSheet(SHEET1);
	    Row headerRow = sheet.createRow(0);
	    for (int col = 0; col < HEADERs1.length; col++)
					{
						Cell cell = headerRow.createCell(col);
						cell.setCellValue(HEADERs1[col]);
						
					}
	    int rowIdx = 1;
	    int i=1;
		for (Stock stockexcel : stock4) {
			Row row = sheet.createRow(rowIdx++);

			//System.out.println(track);
			row.createCell(0).setCellValue(i++);
			
			row.createCell(2).setCellValue(stockexcel.getCategoryName());
			row.createCell(1).setCellValue(stockexcel.getProductName());
			row.createCell(3).setCellValue(stockexcel.getAvailableQuantity());
			row.createCell(4).setCellValue(stockexcel.getUpdateDate());
		}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());	
		}
		catch (IOException e) 
		{
		      throw new RuntimeException("fail to Export data to Excel file: " + e.getMessage());
		    }
	
	}



	public static ByteArrayInputStream CategoryWiseStockReportpdfForSuperAdmin(List<Stock> stock) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			Font font17 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(100);
			float[] columnWidths = {10f};
			table.setWidths(columnWidths);

			PdfPCell table_cell;
			
			table_cell = new PdfPCell(new Phrase("Category Wise Stock Report" , font17));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(table_cell);

			table_cell = new PdfPCell(new Phrase("\n" , font17));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(table_cell);

			
			PdfPTable table1 = new PdfPTable(5);
			table1.setWidthPercentage(100);
			table1.setWidths(new int[]{3, 3, 3,3,3});

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("SR NO", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			hcell = new PdfPCell(new Phrase("Category Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Item Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			hcell = new PdfPCell(new Phrase("Available Quantity", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Upadate Date", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			table1.addCell(hcell);
		
			Integer i=1;
			for(Stock stock1 :stock)
			{
				PdfPCell cell;
			    cell = new PdfPCell(new Phrase((String.valueOf(i++))));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(stock1.getCategoryName().toString()));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(stock1.getProductName().toString()));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(String.valueOf(stock1.getAvailableQuantity())));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
				 cell = new PdfPCell(new Phrase(stock1.getUpdateDate().toString()));
				 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				 table1.addCell(cell);
				 
			}
		
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);
		document.add(table1);
			
			document.close();
			

		} catch (DocumentException ex) {

			ex.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	
	}

	}



	







	

	
