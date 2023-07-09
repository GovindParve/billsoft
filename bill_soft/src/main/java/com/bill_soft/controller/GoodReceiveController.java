package com.bill_soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill_soft.bean.GoodReceiveGridBean;
import com.bill_soft.bean.PurchaseReturnGridBean;
import com.bill_soft.dto.GoodReceiveDto;
import com.bill_soft.dto.PurchaseReturnDto;
import com.bill_soft.entity.PurchaseOrder;
import com.bill_soft.service.GoodReceiveService;
import com.bill_soft.service.PurchaseService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class GoodReceiveController implements ErrorController {
	@Autowired
	private GoodReceiveService goodreceiveservice;
	@Autowired
	private PurchaseService purchaseReturnService;

	@PostMapping("/saveGoodReceive")
	public String addgoodreceive(@RequestBody List<GoodReceiveDto> goodreceivedto, @RequestParam String role,
			@RequestParam String fkUserId) {

		goodreceiveservice.savegoodreceive(goodreceivedto, role, fkUserId);
		return "good receive successfully";
	}

	@GetMapping("/getPurchaseOrderDetailsByOrderNumber")
	public List<PurchaseOrder> getpurchaseorderdetailsByordernNumber(String role, String fkUserId, String orderNumber) {
		return purchaseReturnService.getpurchaseordernodetailsbyordernumber(role, fkUserId, orderNumber);
	}

	@GetMapping("/getPurchaseOrderNumberDropDown")
	public List<String> getpurchaseordernuberdropdown(String role, String fkUserId) {
		return purchaseReturnService.getpurchaseordernoodropdown(role, fkUserId);

	}

	@GetMapping("/getgridforgoodreceive")
	public List<GoodReceiveGridBean> getgoodreceivegrid(@RequestParam String productId, @RequestParam String role,
			@RequestParam String fkUserId) {
		return goodreceiveservice.getgoodreceivegrid(productId, role, fkUserId);
	}

	@GetMapping("/getLastGoodReceiveNumber")
	public List<String> getLastGoodReceiveNumber(String fkAdminId) {
		return goodreceiveservice.getGoodReceiveNumber(Long.parseLong(fkAdminId));
	}
	
	@GetMapping("/getgridforgoodreceivebyPONumber")
	public List<GoodReceiveGridBean> getgoodreceivegridbyPONumber(@RequestParam String poNumber,
			@RequestParam String role, @RequestParam String fkUserId) {
		return goodreceiveservice.getgoodreceivegridByPONumber(Long.parseLong(poNumber), role,
				Long.parseLong(fkUserId));
	}
	
	@GetMapping("/getgridforgoodreceivebyPQNumber")
	public List<GoodReceiveGridBean> getgoodreceivegridbyPQNumber(@RequestParam String pqNumber,
			@RequestParam String role, @RequestParam String fkUserId) {
		return goodreceiveservice.getgoodreceivegridByPQNumber(Long.parseLong(pqNumber), role,
				Long.parseLong(fkUserId));
	}

/////////////////////////////////
    // Purchase Return//
////////////////////////////////

// All Good Receive number List for Purchase Return
	@GetMapping("/getGoodReceiveNumber")
	public List<String> getGoodReceiveNumber(String fkUserId) {
		return purchaseReturnService.getGoodReceiveNumber(fkUserId);
	}

	@GetMapping("/getSupplierNameListForPurchaseReturn")
	public List<String> getSupplierNamesPurchaseReturn(String role, String fkAdminId) {
		return purchaseReturnService.getGoodReceiveSupplierList(role, Long.parseLong(fkAdminId));
	}

	@GetMapping("/getBillNumberForPurchaseReturn")
	public List<String> getBillNumberForPurchaseReturn(String role, String fkAdminId, String fksupplierId) {
		return purchaseReturnService.getGoodReceiveBillNoList(role, Long.parseLong(fkAdminId),
				Long.parseLong(fksupplierId));
	}

	@GetMapping("/getPurchaseReturnGrid")
	public List<PurchaseReturnGridBean> getPurchaseReturnGrid(@RequestParam String billId, @RequestParam String role,
			String fkUserId) {
		return purchaseReturnService.getPurchaseReturnGrid(billId, role, fkUserId);
	}
	
	@PostMapping("/savePurchaseReturn")
	public String savepurchasereturn(@RequestBody List<PurchaseReturnDto> purchasereturndto, @RequestParam String role,
			@RequestParam String fkUserId) {
		purchaseReturnService.savepurchasereturn(purchasereturndto, role, fkUserId);
		return "purchase return successfully";
	}

	@GetMapping("/getSupplierDetailsIdWise")
	public List<String> getSupplierDetailsIdWise(String supplierId, String fkAdminId) {
		return purchaseReturnService.getSupplierDetailsIdWise(Long.parseLong(supplierId), Long.parseLong(fkAdminId));
	}
	
	
	
}
