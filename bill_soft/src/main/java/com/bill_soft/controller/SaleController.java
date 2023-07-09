package com.bill_soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill_soft.bean.SaleQuotationGrid;
import com.bill_soft.bean.SalesBean;
import com.bill_soft.bean.UpdateSaleQuotationBean;
import com.bill_soft.dto.SaleQuotationDto;
import com.bill_soft.entity.SaleQuotation;
import com.bill_soft.service.SaleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SaleController implements ErrorController {

	@Autowired
	private SaleService saleservice;

	// To Save Sale Quotation Details
	@PostMapping("/saveSaleQuotation")
	public String savesalequotation(@RequestBody List<SaleQuotationDto> salequotatiodto, @RequestParam String role,
			@RequestParam String fkUserId) {
		//http://3.95.145.145:8181/getLastSINumber?role=admin&fkUserId=6
		saleservice.savesalequotation(salequotatiodto, role, fkUserId);
		return "Save Sale Quotation Successfully";
	}

	// To Get a Sale Quotation Grid Product Id Wise
	@GetMapping("/salequotationgrid")
	public List<SaleQuotationGrid> salequotationgrid(String productId, String role, String fkUserId) {
		return saleservice.getsalequotationgriddetail(productId, role, fkUserId);

	}

	// Get Sale Quotation Bill Number List For Sale Invoice
	@GetMapping("/getSaleQuotationNumberList")
	public List<String> getSaleQuotationNumberList(String role, String fkUserId) {
		return saleservice.getSaleQuotationNumberList(role, fkUserId);
	}

	@GetMapping("/getLastSQNumber")
	public String getLastEnteredSQNumber(String role, String fkUserId) {
		return saleservice.getLastEnteredSQNumber(role, fkUserId);
	}

	@GetMapping("/getsaleQuotaionByBarcodeNo")
	public List<SaleQuotationGrid> getSaleQuotationGridBarcodeNoWise(String role, String fkUserId, String barcodeNo) {
		return saleservice.getSaleQuotationGridBarcodeNoWise(role, fkUserId, barcodeNo);
	}

	  ///////////////////////////
	 // Update Sale Quotation///
	///////////////////////////

	@GetMapping("/getupdateSaleQuotationGrid")
	public List<SaleQuotation> getSaleQuotationGridForUpdate(String quotationNumber, String fkUserId) {
		return saleservice.getGridForSaleQuotationUpdate(quotationNumber, Long.parseLong(fkUserId));
	}
	
	@GetMapping("/getUpdateSaleQuotationGridByBarcodeNo")
	public List<SalesBean> getUpdateSaleQuotationGridByBarcode(String role, String fkUserId, String barcodeNo)
	{
		return saleservice.getSaleUpdateGridByBarcodeNo(role, fkUserId, barcodeNo);
	}
	
	// To Get a Update Sale Quotation Grid Product Id Wise
		@GetMapping("/getUpdateSaleQuotationByProduct")
		public List<SalesBean> getUpdatesalequotationgridProduct(String productId, String role, String fkUserId) {
			return saleservice.getUpdatesalequotationgriddetail(productId, role, fkUserId);

		}

	/**
	 * 
	 * @param updateSalequotatiodto
	 * @param role
	 * @param fkUserId
	 * @return
	 */
	
	@PutMapping("/updateSaleQuotation")
	public String SaleQuotationUpdate(@RequestBody List<UpdateSaleQuotationBean> updateSalequotatiodto, @RequestParam String role,
			@RequestParam String fkUserId) {

		saleservice.saleQuotationUpdate(updateSalequotatiodto, role, fkUserId);
		return "Sale Quotation Updated Successfully";
	}
	

	@GetMapping("/getSaleQuotationDetailsIdWise")
	public List<SaleQuotation> getSaleQuotationDetailsIdWise(@RequestParam String sqNumber,
			@RequestParam String fkUserId, @RequestParam String role) {
		return saleservice.getSaleQuotationDetailsIdWise(sqNumber, fkUserId, role);
	}

}
