package com.bill_soft.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill_soft.bean.PurchaseReturnBean;
import com.bill_soft.bean.SaleReportBean;
import com.bill_soft.bean.SaleReturnGridBean;
import com.bill_soft.bean.SingleDateWisePurchaseReportBean;
import com.bill_soft.bean.SupplierWisePurchaseReport;
import com.bill_soft.bean.SupplierWiseReportBean;
import com.bill_soft.entity.BarcodeNoWiseStock;
import com.bill_soft.entity.GoodReceive;
import com.bill_soft.entity.Stock;
import com.bill_soft.service.BarcodeService;
import com.bill_soft.service.ExcelDownoadService;
import com.bill_soft.service.ReportService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ReportController implements ErrorController {

	/**
	 * 
	 * This controller is responsible for handling requests related to reports.
	 */
	@Autowired
	private ExcelDownoadService exceldownloadservice;

	@Autowired
	private ReportService reportservice;

	@Autowired
	private BarcodeService barcodeService;

	//////////////// Purchase Reports////////////////////

	/**
	 * 
	 * Returns a list of supplier-wise purchase reports based on the given
	 * parameters.
	 * 
	 * @param role         the role of the user making the request
	 * @param fkUserId     the user ID of the user making the request
	 * @param supplierName the name of the supplier
	 * @return a list of SupplierWisePurchaseReport objects
	 */
	@GetMapping("/suppliernmaewisepurchasereport")
	public List<SupplierWisePurchaseReport> supplierwisepurchasereport(String role, String fkUserId,
			String supplierName) {
		return reportservice.getsupplierwisepurchasereport(role, fkUserId, supplierName);
	}

	/**
	 * 
	 * Returns a list of single date-wise purchase reports based on the given
	 * parameters.
	 * 
	 * @param role     the role of the user making the request
	 * @param fkUserId the user ID of the user making the request
	 * @param date     the date for which the report is requested
	 * @return a list of SingleDateWisePurchaseReportBean objects
	 */
	@GetMapping("/singledatewisepurchasereport")
	public List<SingleDateWisePurchaseReportBean> singledatewisepurchasereport(String role, String fkUserId,
			String date) {
		return reportservice.getsingledatewisepurchasereport(role, fkUserId, date);
	}

	/**
	 * 
	 * Returns a list of range-wise purchase reports based on the given parameters.
	 * 
	 * @param role     the role of the user making the request
	 * @param fkUserId the user ID of the user making the request
	 * @param fromDate the start date of the report
	 * @param toDate   the end date of the report
	 * @return a list of SingleDateWisePurchaseReportBean objects
	 */
	@GetMapping("/rangewisepurchasereport")
	public List<SingleDateWisePurchaseReportBean> rangewisepurchasereport(String role, String fkUserId, String fromDate,
			String toDate) {
		return reportservice.getrangewisepurchasereport(role, fkUserId, fromDate, toDate);
	}

	/**
	 * 
	 * Returns a list of category-wise purchase reports based on the given
	 * parameters.
	 * 
	 * @param role     the role of the user making the request
	 * @param fkUserId the user ID of the user making the request
	 * @param category the category for which the report is requested
	 * @return a list of SingleDateWisePurchaseReportBean objects
	 */
	@GetMapping("/categorywisepurchasereport")
	public List<SingleDateWisePurchaseReportBean> categorywisepurchasereport(String role, String fkUserId,
			String category) {
		return reportservice.getcategorywisepurchasereport(role, fkUserId, category);
	}

	/**
	 * 
	 * Returns a list of product-wise purchase reports based on the given
	 * parameters.
	 * 
	 * @param role        the role of the user making the request
	 * @param fkUserId    the user ID of the user making the request
	 * @param productName the name of the product for which the report is requested
	 * @return a list of SingleDateWisePurchaseReportBean objects
	 */
	@GetMapping("/productwisepurchasereport")
	public List<SingleDateWisePurchaseReportBean> productwisepurchasereport(String role, String fkUserId,
			String productName) {
		return reportservice.getproductwisepurchasereport(role, fkUserId, productName);
	}

	/**
	 * 
	 * Returns a list of SingleDateWisePurchaseReportBean for a given bill number.
	 * 
	 * @param role     the user's role
	 * @param fkUserId the user's id
	 * @param billNo   the bill number
	 * @return a list of SingleDateWisePurchaseReportBean for the given bill number
	 */
	@GetMapping("/billnowisepurchasereport")
	public List<SingleDateWisePurchaseReportBean> billnowisepurchasereport(String role, String fkUserId,
			String billNo) {
		return reportservice.getbillnowisepurchasereport(role, fkUserId, billNo);
	}

	/**
	 * 
	 * Returns a list of SingleDateWisePurchaseReportBean for a given barcode
	 * number.
	 * 
	 * @param role      the user's role
	 * @param fkUserId  the user's id
	 * @param barcodeNo the barcode number
	 * @return a list of SingleDateWisePurchaseReportBean for the given barcode
	 *         number
	 */
	@GetMapping("/barcodenowisepurchasereport")
	public List<SingleDateWisePurchaseReportBean> barcodenowisepurchasereport(String role, String fkUserId,
			String barcodeNo) {
		return reportservice.getbarcodenowisepurchasereport(role, fkUserId, barcodeNo);
	}

	/**
	 * 
	 * Returns a list of SingleDateWisePurchaseReportBean for a given date range of
	 * expenses.
	 * 
	 * @param role     the user's role
	 * @param fkUserId the user's id
	 * @param fromDate the start date of the date range
	 * @param toDate   the end date of the date range
	 * @return a list of SingleDateWisePurchaseReportBean for the given date range
	 *         of expenses
	 */
	@GetMapping("/expensewisepurchasereport")
	public List<SingleDateWisePurchaseReportBean> expensewisepurchasereport(String role, String fkUserId,
			String fromDate, String toDate) {
		return reportservice.getexpensewisepurchasereport(role, fkUserId, fromDate, toDate);
	}

	/**
	 * 
	 * Returns a list of PurchaseReturnBean for a given date of purchase returns.
	 * 
	 * @param role     the user's role
	 * @param fkUserId the user's id
	 * @param date     the date of purchase returns
	 * @return a list of PurchaseReturnBean for the given date of purchase returns
	 */
	@GetMapping("/datewisepurchasereturnreport")
	public List<PurchaseReturnBean> datewisepurchasereturnreport(String role, String fkUserId, String date) {
		return reportservice.getdatewisepurchasereturnreport(role, fkUserId, date);
	}

	/**
	 * 
	 * Returns a list of PurchaseReturnBean for a given date range of purchase
	 * returns.
	 * 
	 * @param role     the user's role
	 * @param fkUserId the user's id
	 * @param fromDate the start date of the date range
	 * @param toDate   the end date of the date range
	 * @return a list of PurchaseReturnBean for the given date range of purchase
	 *         returns
	 */

	@GetMapping("/rangewisepurchasereturnreport")
	public List<PurchaseReturnBean> rangeewisepurchasereturnreport(String role, String fkUserId, String fromDate,
			String toDate) {
		return reportservice.getrangewisepurchasereturnreport(role, fkUserId, fromDate, toDate);
	}

	@GetMapping("/billnowisepurchasereturnreport")
	public List<PurchaseReturnBean> billnowisepurchasereturnreport(String role, String fkUserId, String supplierName,
			String billNo) {
		return reportservice.getbillnowisepurchasereturnreport(role, fkUserId, supplierName, billNo);
	}

////////////////Sale Reports////////////////////////

	@GetMapping("/categorywisesalereport")
	public List<SaleReportBean> categorywisesalereport(String role, String fkUserId, String categoryName,
			String fromDate, String toDate) {
		return reportservice.getcategorywisesalereport(role, fkUserId, categoryName, fromDate, toDate);
	}

	@GetMapping("/productwisesalereport")
	public List<SaleReportBean> productwisesalereport(String role, String fkUserId, String productName) {
		return reportservice.getproductwisesalereport(role, fkUserId, productName);
	}

	@GetMapping("/singledatewisesalereport")
	public List<SaleReportBean> datewisesalereport(String role, String fkUserId, String date) {
		return reportservice.getsingledatewisesalereport(role, fkUserId, date);
	}

	@GetMapping("/rangewisesalereport")
	public List<SaleReportBean> rangewisesalereport(String role, String fkUserId, String fromDate, String toDate) {
		return reportservice.getrangewisesalereport(role, fkUserId, fromDate, toDate);
	}

	@GetMapping("/userwisesalereport")
	public List<SaleReportBean> userwisesalereport(String role, String fkUserId, String fromDate, String toDate) {
		return reportservice.getuserwisesalereport(role, fkUserId, fromDate, toDate);
	}

	@GetMapping("/billnowisalereport")
	public List<SaleReportBean> billnowisesalereport(String role, String fkUserId, String fromDate, String toDate) {
		return reportservice.getbillwisesalereport(role, fkUserId, fromDate, toDate);

	}

	@GetMapping("/paymentmodewisesalereport")
	public List<SaleReportBean> paymentmodewisesalereport(String role, String fkUserId, String fromDate, String toDate,
			String paymentMode) {
		return reportservice.getpaymentmodewisesalereport(role, fkUserId, paymentMode, fromDate, toDate);
	}

	@GetMapping("/datewisesalereturnreport")
	public List<SaleReturnGridBean> datewisesalereturnreport(String role, String fkUserId, String date) {
		return reportservice.getdatewisesalereturnreport(role, fkUserId, date);
	}

	@GetMapping("/rangewisesalereturnreport")
	public List<SaleReturnGridBean> rangewisesalereturnreport(String role, String fkUserId, String fromDate,
			String toDate) {
		return reportservice.getrangewisesalereturnreport(role, fkUserId, fromDate, toDate);
	}

	@GetMapping("/categorywisesalereturnreport")
	public List<SaleReturnGridBean> categorywisesalereturnreport(String role, String fkUserId, String categoryName) {
		return reportservice.getcategorywisesalereturnreport(role, fkUserId, categoryName);
	}

	@GetMapping("/billnowisesalereturnreport")
	public List<SaleReturnGridBean> billnowisesalereturnreport(String role, String fkUserId, String billNo) {
		return reportservice.getbillnowisesalereturnreport(role, fkUserId, billNo);
	}

	@GetMapping("/barcodenowisesalereturnreport")
	public List<SaleReturnGridBean> barcodenowisesalereturnreport(String role, String fkUserId, String barcodeNo) {
		return reportservice.getbarcodenowisesalereturnreport(role, fkUserId, barcodeNo);
	}

	@GetMapping("/getcurrentstockreport-csv-excel-pdf")
	public ResponseEntity<Resource> getPayloadReportBetweenTwoDateForAdminExportDownload(String fileType,
			String fkUserId, String role) throws ParseException {
		if (fileType.equals("excel")) {
			String filename = "currentstockreport.xls";
			InputStreamResource file = new InputStreamResource(
					reportservice.getcurrentstockdownloadexcel(fkUserId, role));

			// current download count
			long ldownloadcount = 1;
			// current date
			Date date = new Date();

			exceldownloadservice.addDownlodingDetails(fileType, date, fkUserId, role, ldownloadcount);

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
		}
		if (fileType.equals("Pdf")) {
			String filename = "currentstockreport.pdf";
			InputStreamResource file = new InputStreamResource(
					reportservice.getcurrentstockdownloadpdf(fkUserId, role));

			// current download count
			long ldownloadcount = 1;
			// current date
			Date date = new Date();

			exceldownloadservice.addDownlodingDetails(fileType, date, fkUserId, role, ldownloadcount);

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/pdf")).body(file);
		}

		if (fileType.equals("csv")) {
			String filename = "currentstockreport.csv";
			InputStreamResource file = new InputStreamResource(
					reportservice.getcurrentstockdownloadexcel(fkUserId, role));

			// current download count
			long ldownloadcount = 1;
			// current date
			Date date = new Date();

			exceldownloadservice.addDownlodingDetails(fileType, date, fkUserId, role, ldownloadcount);

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
		}
		return null;
	}

	@GetMapping("/getcategorywisestockreport-csv-excel-pdf")
	public ResponseEntity<Resource> getPayloadReportBetweenTwoDateForAdminExportDownload(String fileType,
			String categoryName, String fkUserId, String role) throws ParseException {
		if (fileType.equals("excel")) {
			String filename = "categorywisestockreport.xls";
			InputStreamResource file = new InputStreamResource(
					reportservice.getcategorywisestockdownloadexcel(fkUserId, role, categoryName));

			// current download count
			long ldownloadcount = 1;
			// current date
			Date date = new Date();

			exceldownloadservice.addDownlodingDetails(fileType, date, fkUserId, role, ldownloadcount);

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
		}
		if (fileType.equals("pdf")) {
			String filename = "categorywisestockreport.pdf";
			InputStreamResource file = new InputStreamResource(
					reportservice.getcategorywisestockdownloadpdf(fkUserId, role, categoryName));

			// current download count
			long ldownloadcount = 1;
			// current date
			Date date = new Date();

			exceldownloadservice.addDownlodingDetails(fileType, date, fkUserId, role, ldownloadcount);

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/pdf")).body(file);
		}
		if (fileType.equals("csv")) {
			String filename = "categorywisestockreport.csv";
			InputStreamResource file = new InputStreamResource(
					reportservice.getcategorywisestockdownloadexcel(fkUserId, role, categoryName));

			// current download count
			long ldownloadcount = 1;
			// current date
			Date date = new Date();

			exceldownloadservice.addDownlodingDetails(fileType, date, fkUserId, role, ldownloadcount);

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
		}
		return null;
	}

	@GetMapping("/datewisecreditcustomersalereport")
	public List<SaleReportBean> getdatewisecreditcustomersalereport(@RequestParam String role,
			@RequestParam String fkUserId, @RequestParam String date) {
		return reportservice.getdatewisecreditcustomersalereport(role, fkUserId, date);
	}

	////////////////// Stock Related Api's//////////////////

	/////// Reports///////
	@GetMapping("/getBarcodeNoDropDown")
	public List<String> getBarcodeNumberList(String fkUserId, String role) {
		return barcodeService.getbarcodeNumberList(fkUserId, role);
	}

	@GetMapping("/getsuppplierListForStock")
	public List<String> getsupplierListForStock(@RequestParam String role,@RequestParam String fkUserId){
		return reportservice.getSupplierList(role, fkUserId);
	}
	
	
	@GetMapping("/supplierWiseStockReport")
	public List<GoodReceive> getsupplierwisereport(@RequestParam String role, @RequestParam String fkUserId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String supplierId) {
		return reportservice.gettingsupplierwisereport(role, fkUserId, fromDate, toDate, supplierId);
	}

	@GetMapping("/barcodeNoWiseStockReport")
	public List<BarcodeNoWiseStock> getbarcodenowisestockreport(@RequestParam String role,
			@RequestParam String fkUserId, @RequestParam(required = false) String barcodeNo) {
		return reportservice.getbarcodenowisestockreport(role, fkUserId, barcodeNo);
	}

	@GetMapping("/categorywisestockreport")
	public List<Stock> getcategorywisestockreport(@RequestParam String role, @RequestParam String fkUserId,
			@RequestParam(required = false) String categoryId) {

		return reportservice.getcategorywisestockreport(role, fkUserId, categoryId);

	}

	@GetMapping("/getcurrentstockreport")
	public List<Stock> getcurrentstock(@RequestParam String role, @RequestParam String fkUserId) {
		return reportservice.getcurrentstockreport(role, fkUserId);

	}
	
	@GetMapping("/getGoodReceiveNumberForStock")
	public List<String> getGoodReceiveNumber(String fkUserId) {
		return reportservice.getGoodReceiveNumber(fkUserId);
	}
	
	@GetMapping("/getInvoiceStockReport")
	public List<GoodReceive> getInvoiceStock(@RequestParam String role, @RequestParam String fkUserId, @RequestParam(required = false) String InvoiceNumber){
		
		return reportservice.getInvoiceStock(role, fkUserId, InvoiceNumber);
	}
	
	@GetMapping("/getLowStockReport")
	public List<Stock> getLowStockReport(@RequestParam String role, @RequestParam String fkUserId, @RequestParam String quantity){
		 
		return reportservice.getLowStockReport(role, fkUserId, quantity);
	}

}
