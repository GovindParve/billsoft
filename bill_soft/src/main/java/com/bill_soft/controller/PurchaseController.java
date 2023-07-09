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

import com.bill_soft.bean.PurchaseQuotationBean;
import com.bill_soft.dto.PurchaseOrderDto;
import com.bill_soft.dto.PurchaseQuotationDto;
import com.bill_soft.entity.ProductDetails;
import com.bill_soft.entity.PurchaseOrder;
import com.bill_soft.entity.PurchaseQuotation;
import com.bill_soft.service.PurchaseService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class PurchaseController implements ErrorController {
	@Autowired
	private PurchaseService purchaseservice;

///////////////////////////////////
	// Purchase Quotation//      /
/////////////////////////////////

	@PostMapping("/savePurchaseQuotation")
	public String addpurchaseQuotation(@RequestBody List<PurchaseQuotationDto> PurchaseQuotationDto, String role,
			String fkUserId) {
		return purchaseservice.addpurchsequotation(PurchaseQuotationDto, role, fkUserId);
		// return "Quotation send Successfully";
	}
    
	
	// Last Purchase Quotation Number for Purchase Quotation API
	@GetMapping("/getPurchaseQuotationNumber")
	public String getPurchaseQuotationNumber(@RequestParam String fkUserId) {
		return purchaseservice.getPurchaseQuotationNumber(fkUserId);
	}

	@GetMapping("/getpurchasequotationgrid")
	public List<PurchaseQuotationBean> getpurchasequotationgrid(String productId, String role, String fkUserId) {
		return purchaseservice.getpurchasequotationgrid(productId, role, fkUserId);

	}

/////////////////////////////////
	// Purchase Order//
/////////////////////////////////
	
	// Last Purchase Order Number For Purchase order
	@GetMapping("/getPurchaseOrderNumber")
	public String getPurchaseOrderNumber(String fkUserId) {
		return purchaseservice.getPurchaseOrderNumber(fkUserId);
	}

	// To get a Purchase Quotation Numbers Supplier Name Wise
	@GetMapping("/getPQNumberSupplierWise")
	public List<String> getPQNumberSupplierWise(String supplierId, String role, String fkUserId) {
		return purchaseservice.getPurchaseQuotationSuplierNamewise(Long.parseLong(supplierId), role, fkUserId);
	}

	// All Purchase Quotation Number List for Purchase Order Dropdown
	@GetMapping("/getPurchaseQuotationNumberDropDown")
	public List<String> getpurchasequotationnuberdropdown(String role, String fkUserId) {
		return purchaseservice.getpurchasequotationnodropdown(role, fkUserId);
	}

	// get Purchase Quotation Details of Previously done Purchase Quotation by
	// Quotation number to get Purchase Order Grid
	@GetMapping("/getPurchaseQuotationDetailsByQuotationNumber")
	public List<PurchaseQuotation> getpurchasequotationdetailsByQuotationNumber(String role, String fkUserId,
			String quotationNumber) {
		return purchaseservice.getpurchasequotationnodetailsbyquotationumber(role, fkUserId, quotationNumber);
	}

	@PostMapping("/savePurchaseOrder")
	public String addpurchseorder(@RequestBody List<PurchaseOrderDto> purchseorderDto, String role, String fkUserId) {
		return purchaseservice.addpurchseorder(purchseorderDto, role, fkUserId);

	}

	@GetMapping("/getPurchaseOrderListForEdit")
	public List<PurchaseOrder> getPurchaseOrderDetails(@RequestParam String role, @RequestParam String fkUserId) {
		return purchaseservice.getpurchaseOrderList(role, fkUserId);
	}

	@PutMapping("/updatePurchaseOrder")
	public String updatepurchseorder(@RequestBody List<PurchaseOrderDto> purchseorderDto, @RequestParam String role,
			@RequestParam String fkUserId) {
		purchaseservice.updatedpurchseorder(purchseorderDto, role, fkUserId);
		return "Order Updated Successfully";
	}

	@GetMapping("/getpurchaseordergrid")
	public List<ProductDetails> getpurchaseorderrid(@RequestParam String productname, @RequestParam String role,
			@RequestParam String fkUserId) {
		return purchaseservice.getpurchaseordergrid(productname, role, fkUserId);

	}

	@GetMapping("/getpurchaseordereditgrid")
	public List<ProductDetails> getpurchaseordereditgrid(@RequestParam String productname, @RequestParam String role,
			@RequestParam String fkUserId) {
		return purchaseservice.getpurchaseordereditgrid(productname, role, fkUserId);

	}

	@GetMapping("/getPurchaseOrderGridbyPurchaseQuotationNumber")
	public List<PurchaseQuotationBean> getPurchaseOrderGridByPurchaseQuotation(String role, String fkUserId,
			String pqNumber) {
		return purchaseservice.getPurchaseOrderGridByPurchaseQuotation(role, fkUserId, pqNumber);
	}
	
	@GetMapping("/getPurchaseOrderNumberList")
	public List<String> getPurchaseOrderNumberList(String fkAdminId, String supplierId) {
		return purchaseservice.getPurchaseOrderNumberList(fkAdminId, supplierId);
	}
	
	
/////////////////////////////////
      // Stock Transfer//
////////////////////////////////

	@GetMapping("/getCategoryListForGodown")
	public List<String> getCategoryListForGodown(String role, String fkUserId, String fkGodownId)
	{
		return purchaseservice.getCategoryListForStock(role, fkUserId, fkGodownId);
	}
	
	@GetMapping("/getProductListForGodown")
	public List<String> getProductListForGodown(String role, String fkUserId, String fkGodownId, String fkCategoryId)
	{
		return purchaseservice.getProductListForStock(role, fkUserId, fkGodownId, fkCategoryId);
	}

/////////////////////////////////
	    // Extras//
////////////////////////////////
	
	@GetMapping("/supplierDetailsidWisePurchaseOrder")
	public List<String> getSupplierDetailsForPurchaseOrder(String purchaseOrderId, String fkUserId) {
		return purchaseservice.getSupplierDetailsForPurchaseOrder(purchaseOrderId, fkUserId);
	}

	@GetMapping("/getcategorywisesubcategorydropdownIdWise")
	public List<String> getcategorywisesubcategorydropdownIdWise(String categoryId, String role, String fkUserId) {
		return purchaseservice.getcategorywisesubcategorydropdrownIdWise(Long.parseLong(categoryId), role, fkUserId);
	}

	@GetMapping("/getcategorywisesubcategorydropdown")
	public List<String> getcategorywisesubcategorydropdown(String categoryName, String role, String fkUserId) {
		return purchaseservice.getcategorywisesubcategorydropdrown(categoryName, role, fkUserId);
	}

	@GetMapping("/getsubcategorywiseproductdropdown")
	public List<String> getsubcategorywiseproductdropdown(String subCategoryName, String role, String fkUserId) {
		return purchaseservice.getsubcategorywiseproductdropdown(subCategoryName, role, fkUserId);
	}

}
