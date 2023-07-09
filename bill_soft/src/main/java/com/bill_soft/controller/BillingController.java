package com.bill_soft.controller;

import java.io.ByteArrayInputStream;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill_soft.bean.SaleInvoiceGridBean;
import com.bill_soft.bean.SaleReturnGridBean;
import com.bill_soft.dto.BillDetailsDto;
import com.bill_soft.dto.SaleReturnDto;
import com.bill_soft.entity.BillDetails;
import com.bill_soft.entity.ProductDetails;
import com.bill_soft.service.BillingService;
import com.bill_soft.service.GenerateBillPDF;
import com.bill_soft.service.SaleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BillingController implements ErrorController {

	@Autowired
	private BillingService billingservice;
	@Autowired
	private SaleService saleReturnService;

	@PostMapping("/savebilldetails")
	public String savebilldeatils(@RequestBody List<BillDetailsDto> billdetailsdto,
			@RequestParam String role, @RequestParam String fkUserId) {
		billingservice.addbill(billdetailsdto, role, fkUserId);

//		BillDetails bill = billingservice.getlastbillNo();
//
//		System.out.println("bill no" + bill);
//		List<BillDetails> listbill = billingservice.findbybillNo(bill.getBillNo());
//		ByteArrayInputStream bis = GenerateBillPDF.billPDF(bill, listbill);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Disposition", "inline; filename=BillReport.pdf");
//		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
//				.body(new InputStreamResource(bis));
		return "bill_done";

	}

	@GetMapping("/getbilltoedit/{pk_bill_id}")
	public Optional<BillDetails> getbilltoedit(@PathVariable(value = "pk_bill_id") Long id, @RequestParam String role,
			@RequestParam String fkUserId) {

		return billingservice.getbill(id, role, fkUserId);
	}

	@PutMapping("/updatebilldetails")
	public String updatebilldetails(@RequestBody List<BillDetailsDto> billdetailsdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		billingservice.updatebill(billdetailsdto, role, fkUserId);
		return "Billing update successfully";
	}

	@GetMapping("/getbillingeditgrid")
	public List<ProductDetails> getbillingeditgrid(@RequestParam String productname, @RequestParam String role,
			@RequestParam String fkUserId) {
		return billingservice.getbillineditggriddetail(productname, role, fkUserId);

	}

	// To Get a Sale Invoice Grid Product Id Wise
	@GetMapping("/saleinvoicegrid")
	public List<SaleInvoiceGridBean> salequotationgrid(String productId, String role, String fkUserId) {
		return billingservice.getsaleinvoicegriddetail(productId, role, fkUserId);

	}
	
	@GetMapping("/getsaleInvoicByBarcodeNo")
	public List<SaleInvoiceGridBean> getSaleQuotationGridBarcodeNoWise(String role, String fkUserId, String barcodeNo)
	{
		return billingservice.getSaleInvoiceGridBarcodeNoWise(role, fkUserId, barcodeNo);
	}

	// To get Last Entered Sales Quotation number from that table respective with

	@GetMapping("/getLastSINumber")
	public String getLastEnteredSINumber(String role, String fkUserId) {
		return billingservice.getLastEnteredSINumber(role, fkUserId);
	}

	@GetMapping("/getSaleInvoiceBySaleQuotation")
	public List<SaleInvoiceGridBean> saleInvoiceGridDetailsBySaleQuotationNo(String sqNumber, String fkUserId,
			String role) {
		return billingservice.getSQNumberWiseSaleInvoiceGrid(sqNumber, fkUserId, role);
	}
	
	@GetMapping("/getSalInvoiceNumberList")
	public List<String> getSaleInvoiceNumberList(String role, String fkUserId)
	{
		return billingservice.getSaleInvoiceNumberList(role, fkUserId);
	}
	

	// To Save a Data of Sale Return
	@PostMapping("/saveSaleReturn")
	public String savesalereturn(@RequestBody List<SaleReturnDto> salereturndto, @RequestParam String role,
			@RequestParam String fkUserId) {
		saleReturnService.savesalereturnsetails(salereturndto, role, fkUserId);
		return "sale return successfully";
	}

	// To generate a data of Sale return grid Invoice Number wise
	@GetMapping("/getsalereturngrid")
	public List<SaleReturnGridBean> getsalereturnngrid(String invoiceNumber,String fkUserId) {
		return saleReturnService.getsalereturngriddetail(Long.parseLong(invoiceNumber),Long.parseLong(fkUserId));

	}

}
