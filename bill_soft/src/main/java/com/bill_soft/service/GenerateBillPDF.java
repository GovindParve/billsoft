package com.bill_soft.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.bill_soft.entity.BillDetails;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateBillPDF {

	
	
	public static ByteArrayInputStream billPDF(BillDetails bill, List<BillDetails> listbill) {

		System.out.println("billing details.........." + bill);
// String billno=bill.getBillNo();
		Document document = new Document(PageSize.A4);

		ByteArrayOutputStream arrayoutputstream = new ByteArrayOutputStream();

		try {

			document.setMargins(2, 2, 5, 5);

			Font font14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
			Font font17 = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD, BaseColor.BLACK);
			Font font11 = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD, BaseColor.BLACK);
			Font Normalfont11 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);

			PdfPTable table = new PdfPTable(1);

			table.setWidthPercentage(100);

			float[] columnWidths = {10f};
			table.setWidths(columnWidths);

			PdfPCell table_cell;
			/*
			 * table_cell = new PdfPCell(new Phrase());
			 * table_cell.setBorder(table_cell.NO_BORDER); table.addCell(table_cell);
			 */
			table_cell = new PdfPCell(new Phrase(bill.getShopName(), font17));
			table_cell.setBorder(table_cell.NO_BORDER);
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(table_cell);

			table_cell = new PdfPCell(new Phrase("karvenagar", font14));
			table_cell.setBorder(table_cell.NO_BORDER);
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(table_cell);
			
			
		      table_cell = new PdfPCell(new Phrase("\n", Normalfont11));
			  table_cell.setBorder(table_cell.NO_BORDER);
			  table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			  table.addCell(table_cell);
			 

			PdfPTable table1 = new PdfPTable(2);
			table1.setWidthPercentage(90);
			float[] columnWidths1 = { 4.3f, 5.3f };
			table1.setWidths(columnWidths1);

			PdfPCell hcell;

			hcell = new PdfPCell(new Phrase("Customer Name :" +  bill.getCustomerName(), font14));
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(Rectangle.NO_BORDER);
			table1.addCell(hcell);

			hcell = new PdfPCell();
			hcell = new PdfPCell(new Phrase("Contact No :" +  bill.getContactNo(), font14));
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setBorder(Rectangle.NO_BORDER);
			table1.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Bill No :" + bill.getBillNo(), font14));
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(Rectangle.NO_BORDER);
			table1.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Date :" +  bill.getBillDate(), font14));
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setBorder(Rectangle.NO_BORDER);
			table1.addCell(hcell);

			hcell = new PdfPCell(new Phrase("\n", Normalfont11));
			hcell.setBorder(hcell.NO_BORDER);
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			  table1.addCell(hcell);
			  hcell = new PdfPCell(new Phrase("\n", Normalfont11));
				hcell.setBorder(hcell.NO_BORDER);
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  table1.addCell(hcell);
			  
			PdfPTable table2 = new PdfPTable(5);
			table2.setWidthPercentage(80);
			float[] columnWidths2 = {0.3f, 0.5f, 0.3f, 0.4f, 0.4f};
			table2.setWidths(columnWidths2);
			
			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			PdfPCell hcell1;
			hcell1 = new PdfPCell(new Phrase("Sr no", headFont));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell1);

			hcell1 = new PdfPCell(new Phrase("Particular", headFont));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell1);

			hcell1 = new PdfPCell(new Phrase("Quantity", headFont));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell1);

			hcell1 = new PdfPCell(new Phrase("Rate", headFont));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell1);

			hcell1 = new PdfPCell(new Phrase("Total Amount", headFont));
			hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(hcell1);
			
			///List<BillDetails>=billingrepository.getbillnowiseproduct(billno);
		//int rowcount=0;
			
			// for(int i=1;i<rowcount;i++) { 
				Integer i = 1;
				PdfPCell cell;
			 for(BillDetails bills : listbill)
			 {
					
				// Integer i = 1;
				 cell = new PdfPCell(new Phrase((String.valueOf(i++))));
				// cell.setPaddingLeft(5);
				// cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 cell .setHorizontalAlignment(Element.ALIGN_RIGHT); 
				 cell.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			 table2.addCell(cell); 
			 
			 cell = new PdfPCell(new Phrase((bills.getProductName().toString())));
			 //String productname=bill.getProductName();
			// System.out.println("product name :"+productname);
			// cell.setPaddingLeft(5);
			 //cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			 cell.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			 table2.addCell(cell); 
			 
			 cell= new PdfPCell(new Phrase((bills.getQuantity().toString())));
			// cell.setPaddingLeft(5); 
			// cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 cell.setHorizontalAlignment(Element.ALIGN_RIGHT); 
			 cell.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			 table2.addCell(cell);
			 
			 cell = new PdfPCell(new Phrase((String.valueOf(bills.getSalePriceExcludingTax()))));
			 //cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 cell.setHorizontalAlignment(Element.ALIGN_RIGHT); 
			 cell.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			// cell.setPaddingLeft(5);
			 table2.addCell(cell); 
			 
			 cell = new PdfPCell(new Phrase(String.valueOf((bills.getTotalAmount()))));
			 //cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 cell.setHorizontalAlignment(Element.ALIGN_RIGHT); 
			 cell.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			// cell.setPaddingLeft(5);
			 table2.addCell(cell);
			 //System.out.println("i :"+i); 

		  }
			 
			 PdfPTable table3 = new PdfPTable(2);
				table3.setWidthPercentage(80);
				float[] columnWidths3 = { 2.3f, 0.6f };
				table3.setWidths(columnWidths3);

				PdfPCell tablecell1;
		
		
				tablecell1=new PdfPCell(new Phrase("Gross total",font11));
				tablecell1.setHorizontalAlignment(Element.ALIGN_LEFT); 
				tablecell1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
				//tablecell1.setColspan(4);
				table3.addCell(tablecell1);
			 
				tablecell1=new PdfPCell(new Phrase((String.valueOf(bill.getGrossTotal()))));
				tablecell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
				tablecell1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
				//tablecell1.setColspan(4);
				table3.addCell(tablecell1);
				
				 PdfPTable table4 = new PdfPTable(2);
					table4.setWidthPercentage(80);
					float[] columnWidths4 = { 2.3f, 0.6f };
					table4.setWidths(columnWidths4);

					PdfPCell tablecell2;
			
			
					tablecell2=new PdfPCell(new Phrase("Discount",font11));
					tablecell2.setHorizontalAlignment(Element.ALIGN_LEFT); 
					tablecell2.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
					//tablecell1.setColspan(4);
					table4.addCell(tablecell2);
				 
					tablecell2=new PdfPCell(new Phrase((String.valueOf(bill.getDiscount()))));
					tablecell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
					tablecell2.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
					//tablecell1.setColspan(4);
					table4.addCell(tablecell2);
					
					 PdfPTable table5 = new PdfPTable(1);
						table5.setWidthPercentage(80);
						float[] columnWidths5 = { 2.3f, 0.6f };
						table4.setWidths(columnWidths5);

						PdfPCell tablecell3;
				
				
						tablecell3=new PdfPCell(new Phrase("Thank you for visiting ",Normalfont11));
						tablecell3.setHorizontalAlignment(Element.ALIGN_LEFT); 
						tablecell3.setBorder(tablecell3.NO_BORDER);
						//tablecell1.setColspan(4);
						table5.addCell(tablecell3);
					 
						/*tablecell3=new PdfPCell(new Phrase((String.valueOf(bill.getDiscount()))));
						tablecell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
						tablecell3.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
						//tablecell1.setColspan(4);
						table5.addCell(tablecell3);*/
				
//				  cell=new PdfPCell(new Phrase("total",font11));
//				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				 cell.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
//				 
//				  cell.setColspan(1); table2.addCell(cell);
				 
			
			
			PdfWriter.getInstance(document, arrayoutputstream);
			document.open();
			document.add(table);
			document.add(table1);
			document.add(table2);
            document.add(table3);
            document.add(table4);
            document.add(table5);
			document.close();
			

		} catch (DocumentException ex) {

			ex.printStackTrace();
		}
		return new ByteArrayInputStream(arrayoutputstream.toByteArray());
	}

}
