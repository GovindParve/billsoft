package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.bean.ProductDetailsBean;
import com.bill_soft.bean.PurchaseQuotationBean;
import com.bill_soft.bean.PurchaseReturnGridBean;
import com.bill_soft.dto.PurchaseOrderDto;
import com.bill_soft.dto.PurchaseQuotationDto;
import com.bill_soft.dto.PurchaseReturnDto;
import com.bill_soft.entity.GoodReceive;
import com.bill_soft.entity.ProductDetails;
import com.bill_soft.entity.PurchaseOrder;
import com.bill_soft.entity.PurchaseQuotation;
import com.bill_soft.entity.PurchaseReturn;
import com.bill_soft.entity.Stock;
import com.bill_soft.repository.BarcodeWiseStockRepository;
import com.bill_soft.repository.GoodReceiveRepository;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.ProductRepository;
import com.bill_soft.repository.PurchaseOrderRepository;
import com.bill_soft.repository.PurchaseQuotationRepository;
import com.bill_soft.repository.PurchaseReturnRepository;
import com.bill_soft.repository.StockRepository;
import com.bill_soft.repository.SubCategoryRepository;

@Service
public class PurchaseService {
	@Autowired
	private PurchaseOrderRepository purchaseorderrepository;
	@Autowired
	private PurchaseReturnRepository purchasereturnrepository;
	@Autowired
	private PurchaseQuotationRepository purchasequotationrepository;
	@Autowired
	private StockRepository stockrepository;
	@Autowired
	private LoginRepository loginrepository;
	@Autowired
	private SubCategoryRepository subcategoryrepository;
	@Autowired
	private ProductRepository productrepository;
	@Autowired
	private GoodReceiveRepository goodReceiveRepository;
	@Autowired
	private BarcodeWiseStockRepository barcodeWiseStock;

	public String getPurchaseQuotationNumber(String fkUserId) {
		Long fkAdminId = Long.parseLong(fkUserId);

		List<String> billNumbers = purchasequotationrepository.getQuotationNumber(fkAdminId);

		String QuotationNumber = null;
		if (billNumbers.size() == 0) {
			
			QuotationNumber = "0";
		}
		else {
			QuotationNumber =  billNumbers.get(billNumbers.size() - 1);
		}

		return QuotationNumber;

	}

	public String getPurchaseOrderNumber(String fkUserId) {
		Long fkAdminId = Long.parseLong(fkUserId);

		List<String> billNumbers = purchaseorderrepository.getOrderNumber(fkAdminId);

		String OrderNumber = null;
		if (billNumbers.size() == 0) {
			OrderNumber = "0";
		}else {
			OrderNumber = billNumbers.get(billNumbers.size() - 1);
		}

		return OrderNumber;

	}

	public List<String> getGoodReceiveNumber(String fkUserId) {
		Long fkAdminId = Long.parseLong(fkUserId);

		List<String> billNumbers = goodReceiveRepository.getGoodReceiveNumberList(fkAdminId);

		return billNumbers;
	}

	public String addpurchseorder(List<PurchaseOrderDto> purchseorderDto, String role, String fkUserId) {
//		if(role.equals("super-admin") || role.equals("organization") || role.equals("admin") )
//		{
		Long pkid = Long.parseLong(fkUserId);
		String user = loginrepository.getusernameforcategory(role, pkid);
		if (user.equals(null)) {
			return "UserName Not Found";
		}
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		List<PurchaseOrder> list = new ArrayList<PurchaseOrder>();
		// purchaseorder.setPkPurchaseOrderId(purchseorderDto.getPkPurchaseOrderId());
//	    if(purchseorderDto.getFkPurchaseQuotationId()!=null)
//	    {
//	    	 purchaseorder.setFkPurchaseQuotationId(purchseorderDto.getFkPurchaseQuotationId());
//	    }
//	    else
//	    {
//	    	 purchaseorder.setFkPurchaseQuotationId(0l);
//	    }
//	   
//	    

		for (int i = 0; i < purchseorderDto.size(); i++) {
			PurchaseOrder purchaseorder = new PurchaseOrder();
			purchaseorder.setPurchaseOrderNumber(purchseorderDto.get(i).getPurchaseOrderNumber());

			purchaseorder.setFkSupplierId(purchseorderDto.get(i).getFkSupplierId());
			purchaseorder.setSupplierName(purchseorderDto.get(i).getSupplierName());
			if (purchseorderDto.get(i).getFkPurchaseQuotationId() != null) {
				purchaseorder.setFkPurchaseQuotationId(purchseorderDto.get(i).getFkPurchaseQuotationId());
			} else {
				purchaseorder.setFkPurchaseQuotationId(0l);
			}
			if (purchseorderDto.get(i).getQuotationNumber() != null) {
				purchaseorder.setQuotationNumber(purchseorderDto.get(i).getQuotationNumber());
			} else {
				purchaseorder.setQuotationNumber(0l);
			}
			purchaseorder.setEmailId(purchseorderDto.get(i).getEmailId());
			purchaseorder.setCity(purchseorderDto.get(i).getCity());
			purchaseorder.setAddress(purchseorderDto.get(i).getAddress());
			purchaseorder.setContactNo(purchseorderDto.get(i).getContactNo());
			purchaseorder.setGstNo(purchseorderDto.get(i).getGstNo());
			purchaseorder.setBarcodeNo(purchseorderDto.get(i).getBarcodeNo());
			purchaseorder.setFkCategoryId(purchseorderDto.get(i).getFkProductId());
			purchaseorder.setCategoryName(purchseorderDto.get(i).getCategoryName());
			purchaseorder.setFkSubCategoryId(purchseorderDto.get(i).getFkSubCategoryId());
			purchaseorder.setSubCategoryName(purchseorderDto.get(i).getSubCategoryName());
			purchaseorder.setFkProductId(purchseorderDto.get(i).getFkProductId());
			purchaseorder.setProductName(purchseorderDto.get(i).getProductName());
			purchaseorder.setPurchaseOrderDate(dateString);
			purchaseorder.setColor(purchseorderDto.get(i).getColor());
			if (purchseorderDto.get(i).getStyle() != null) {
				purchaseorder.setStyle(purchseorderDto.get(i).getStyle());
			} else {
				purchaseorder.setStyle("N/A");
			}

			if (purchseorderDto.get(i).getRollSize() != null) {
				purchaseorder.setRollSize(purchseorderDto.get(i).getRollSize());
			} else {
				purchaseorder.setRollSize(0d);
			}

			if (purchseorderDto.get(i).getSize() != null) {
				purchaseorder.setSize(purchseorderDto.get(i).getSize());
			} else {
				purchaseorder.setSize("N/A");
			}
			purchaseorder.setPayDuedate(purchseorderDto.get(i).getPayDuedate());
			purchaseorder.setBuyPriceIncludingTax(purchseorderDto.get(i).getBuyPriceIncludingTax());
			purchaseorder.setBuyPriceExcludingTax(purchseorderDto.get(i).getBuyPriceExcludingTax());

			purchaseorder.setQuantity(purchseorderDto.get(i).getQuantity());
			purchaseorder.setWeight(purchseorderDto.get(i).getWeight());
			purchaseorder.setUnit(purchseorderDto.get(i).getUnit());
			purchaseorder.setCompany(purchseorderDto.get(i).getCompany());
			purchaseorder.setHsnsacc(purchseorderDto.get(i).getHsnsacc());

			purchaseorder.setDiscount(purchseorderDto.get(i).getDiscount());
			purchaseorder.setDiscountAmount(purchseorderDto.get(i).getDiscountAmount());
			purchaseorder.setSalePrice(purchseorderDto.get(i).getSalePrice());
			purchaseorder.setMrp(purchseorderDto.get(i).getMrp());
			purchaseorder.setCgst(purchseorderDto.get(i).getCgst());
			purchaseorder.setSgst(purchseorderDto.get(i).getSgst());
			purchaseorder.setIgst(purchseorderDto.get(i).getIgst());
			purchaseorder.setTaxpercentage(purchseorderDto.get(i).getTaxpercentage());
			purchaseorder.setTaxAmount(purchseorderDto.get(i).getTaxAmount());
			purchaseorder.setTotalExcludingTax(purchseorderDto.get(i).getTotalExcludingTax());
			purchaseorder.setTotalAmount(purchseorderDto.get(i).getTotalAmount());
			purchaseorder.setPaymentMode(purchseorderDto.get(i).getPaymentMode());
//			purchaseorder.setBatchNumber(purchseorderDto.get(i).getBatchNumber());
//			purchaseorder.setManufacturingDate(purchseorderDto.get(i).getManufacturingDate());
//			purchaseorder.setExpiryDate(purchseorderDto.get(i).getExpiryDate());
			// purchaseorder.setMrp(purchseorderDto.get(i).getMrp());

			purchaseorder.setLabourExpense(purchseorderDto.get(i).getLabourExpense());
			purchaseorder.setTransportExpense(purchseorderDto.get(i).getTransportExpense());
			purchaseorder.setTotalQuantity(purchseorderDto.get(i).getTotalQuantity());
			purchaseorder.setTotalTaxAmount(purchseorderDto.get(i).getTotalTaxAmount());
			purchaseorder.setGrossTotal(purchseorderDto.get(i).getGrossTotal());
			purchaseorder.setFkShopId(purchseorderDto.get(i).getFkShopId());
			purchaseorder.setShopName(purchseorderDto.get(i).getShopName());
			purchaseorder.setFkAdminId(purchseorderDto.get(i).getFkAdminId());
			purchaseorder.setAdminName(purchseorderDto.get(i).getAdminName());
			purchaseorder.setFkoragnizationId(purchseorderDto.get(i).getFkoragnizationId());
			purchaseorder.setOragnizationName(purchseorderDto.get(i).getOragnizationName());
			purchaseorder.setCreatedDate(dateString);
			purchaseorder.setCreatedBy(user + "(" + role + ")");

			list.add(purchaseorder);
		}

		purchaseorderrepository.saveAll(list);
		// }
		return "saved";
	}

	public String addpurchsequotation(List<PurchaseQuotationDto> purchaseQuotationDto, String role, String fkUserId) {
//		if(role.equals("super-admin") || role.equals("organization") || role.equals("admin") )
//		{
//		
		Long pkid = Long.parseLong(fkUserId);
		String user = loginrepository.getusernameforcategory(role, pkid);

		if (user.equals(null)) {

			return "UserName Not Found";

		}

		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		List<PurchaseQuotation> list = new ArrayList<PurchaseQuotation>();
		for (int i = 0; i < purchaseQuotationDto.size(); i++) {
			PurchaseQuotation quotation = new PurchaseQuotation();
			quotation.setPkPurchaseQuotationId(purchaseQuotationDto.get(i).getPkPurchaseQuotationId());
			quotation.setFkSupplierId(purchaseQuotationDto.get(i).getFkSupplierId());
			quotation.setSupplierName(purchaseQuotationDto.get(i).getSupplierName());
			quotation.setEmailId(purchaseQuotationDto.get(i).getEmailId());
			quotation.setContactNo(purchaseQuotationDto.get(i).getContactNo());
			quotation.setAddress(purchaseQuotationDto.get(i).getAddress());
			quotation.setCity(purchaseQuotationDto.get(i).getCity());
			if (purchaseQuotationDto.get(i).getBarcodeNo() != null) {
				quotation.setBarcodeNo(purchaseQuotationDto.get(i).getBarcodeNo());
			} else {
				quotation.setBarcodeNo("N/A");
			}
			quotation.setQuotationDate(dateString);
			quotation.setQuotationNumber(purchaseQuotationDto.get(i).getQuotationNumber());
			quotation.setFkCategoryId(purchaseQuotationDto.get(i).getFkCategoryId());
			quotation.setCategoryName(purchaseQuotationDto.get(i).getCategoryName());
			quotation.setFkSubCategoryId(purchaseQuotationDto.get(i).getFkSubCategoryId());
			quotation.setSubCategoryName(purchaseQuotationDto.get(i).getSubcategoryName());
			quotation.setFkProductId(purchaseQuotationDto.get(i).getFkProductId());
			quotation.setProductName(purchaseQuotationDto.get(i).getProductName());
			quotation.setCompany(purchaseQuotationDto.get(i).getCompany());
			quotation.setBuyPriceIncludingTax(purchaseQuotationDto.get(i).getBuyPriceIncludingTax());
			quotation.setBuyPriceExcludingTax(purchaseQuotationDto.get(i).getBuyPriceExcludingTax());
			quotation.setQuantity(purchaseQuotationDto.get(i).getQuantity());
			quotation.setWeight(purchaseQuotationDto.get(i).getWeight());
			quotation.setRollSize(purchaseQuotationDto.get(i).getRollSize());
			quotation.setSize(purchaseQuotationDto.get(i).getSize());
			quotation.setColor(purchaseQuotationDto.get(i).getColor());
			quotation.setStyle(purchaseQuotationDto.get(i).getStyle());
			quotation.setUnit(purchaseQuotationDto.get(i).getUnit());
			quotation.setDiscount(purchaseQuotationDto.get(i).getDiscount());
			quotation.setDiscountAmount(purchaseQuotationDto.get(i).getDiscountAmount());
			quotation.setDiscountPercentage(purchaseQuotationDto.get(i).getDiscountPercentage());
			quotation.setSalePrice(purchaseQuotationDto.get(i).getSalePrice());
			quotation.setMrp(purchaseQuotationDto.get(i).getMrp());
			quotation.setCgst(purchaseQuotationDto.get(i).getCgst());
			quotation.setSgst(purchaseQuotationDto.get(i).getSgst());
			quotation.setIgst(purchaseQuotationDto.get(i).getIgst());
			quotation.setTaxpercentage(purchaseQuotationDto.get(i).getTaxpercentage());
			quotation.setTaxAmount(purchaseQuotationDto.get(i).getTaxAmount());
			quotation.setTotalExcludingTax(purchaseQuotationDto.get(i).getTotalExcludingTax());
			quotation.setTotalAmount(purchaseQuotationDto.get(i).getTotalAmount());
			quotation.setGrossTotal(purchaseQuotationDto.get(i).getGrossTotal());
			quotation.setTotalQuantity(purchaseQuotationDto.get(i).getTotalQuantity());
			quotation.setTotalTaxAmount(purchaseQuotationDto.get(i).getTotalTaxAmount());
			quotation.setGstNo(purchaseQuotationDto.get(i).getGstNo());
			// quotation.setMrp(purchaseQuotationDto.get(i).getMrp());
			quotation.setHsnsacc(purchaseQuotationDto.get(i).getHsnsacc());
			quotation.setPaymentMode(purchaseQuotationDto.get(i).getPaymentMode());
			quotation.setTransportExpence(purchaseQuotationDto.get(i).getTransportExpence());
			quotation.setLabourExpence(purchaseQuotationDto.get(i).getLabourExpence());
			quotation.setFkShopId(purchaseQuotationDto.get(i).getFkShopId());
			quotation.setShopName(purchaseQuotationDto.get(i).getShopName());
			quotation.setFkAdminId(purchaseQuotationDto.get(i).getFkAdminId());
			quotation.setAdminName(purchaseQuotationDto.get(i).getAdminName());
			quotation.setFkoragnizationId(purchaseQuotationDto.get(i).getFkoragnizationId());
			quotation.setOragnizationName(purchaseQuotationDto.get(i).getOragnizationName());
			quotation.setCreatedBy(user + "(" + role + ")");
			quotation.setCreatedDate(dateString);
			list.add(quotation);

		}

		purchasequotationrepository.saveAll(list);
		return "purchase quotation added successfully";
	}

	public Optional<PurchaseOrder> getpurchaseorder(String role, Long id) {
		if (role.equals("super-admin") || role.equals("oragnization") || role.equals("admin")) {
			return purchaseorderrepository.findById(id);
		}
		return null;
	}

	public String updatedpurchseorder(List<PurchaseOrderDto> purchseorderDto, String role, String fkUserId) {
		/*
		 * if(role.equals("super-admin") || role.equals("organization") ||
		 * role.equals("admin") ) {
		 */
		Long pkid = Long.parseLong(fkUserId);
		String user = loginrepository.getusernameforcategory(role, pkid);
		if (user.equals(null)) {
			return "UserName Not Found";
		}
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		List<PurchaseOrder> list = new ArrayList<PurchaseOrder>();
		for (int i = 0; i < purchseorderDto.size(); i++) {
			PurchaseOrder purchaseorder = new PurchaseOrder();
			purchaseorder.setPkPurchaseOrderId(purchseorderDto.get(i).getPkPurchaseOrderId());
			if (purchseorderDto.get(i).getFkPurchaseQuotationId() != null) {
				purchaseorder.setFkPurchaseQuotationId(purchseorderDto.get(i).getFkPurchaseQuotationId());
			} else {
				purchaseorder.setFkPurchaseQuotationId(0l);
			}

			if (purchseorderDto.get(i).getQuotationNumber() != null) {
				purchaseorder.setQuotationNumber(purchseorderDto.get(i).getQuotationNumber());
			} else {
				purchaseorder.setQuotationNumber(0l);
			}
			purchaseorder.setPurchaseOrderNumber(purchseorderDto.get(i).getPurchaseOrderNumber());

			purchaseorder.setFkSupplierId(purchseorderDto.get(i).getFkSupplierId());
			purchaseorder.setSupplierName(purchseorderDto.get(i).getSupplierName());

			purchaseorder.setEmailId(purchseorderDto.get(i).getEmailId());
			purchaseorder.setCity(purchseorderDto.get(i).getCity());
			purchaseorder.setAddress(purchseorderDto.get(i).getAddress());
			purchaseorder.setContactNo(purchseorderDto.get(i).getContactNo());
			purchaseorder.setGstNo(purchseorderDto.get(i).getGstNo());
			purchaseorder.setBarcodeNo(purchseorderDto.get(i).getBarcodeNo());
			purchaseorder.setFkCategoryId(purchseorderDto.get(i).getFkProductId());
			purchaseorder.setCategoryName(purchseorderDto.get(i).getCategoryName());
			purchaseorder.setFkSubCategoryId(purchseorderDto.get(i).getFkSubCategoryId());
			purchaseorder.setSubCategoryName(purchseorderDto.get(i).getSubCategoryName());
			purchaseorder.setFkProductId(purchseorderDto.get(i).getFkProductId());
			purchaseorder.setProductName(purchseorderDto.get(i).getProductName());
			purchaseorder.setPurchaseOrderDate(dateString);
			purchaseorder.setPayDuedate(purchseorderDto.get(i).getPayDuedate());
			purchaseorder.setColor(purchseorderDto.get(i).getColor());
			purchaseorder.setStyle(purchseorderDto.get(i).getStyle());
			purchaseorder.setRollSize(purchseorderDto.get(i).getRollSize());
			purchaseorder.setSize(purchseorderDto.get(i).getSize());
			purchaseorder.setBuyPriceIncludingTax(purchseorderDto.get(i).getBuyPriceIncludingTax());
			purchaseorder.setBuyPriceExcludingTax(purchseorderDto.get(i).getBuyPriceExcludingTax());

			purchaseorder.setQuantity(purchseorderDto.get(i).getQuantity());
			purchaseorder.setWeight(purchseorderDto.get(i).getWeight());
			purchaseorder.setUnit(purchseorderDto.get(i).getUnit());
			purchaseorder.setCompany(purchseorderDto.get(i).getCompany());
			purchaseorder.setHsnsacc(purchseorderDto.get(i).getHsnsacc());

			purchaseorder.setDiscount(purchseorderDto.get(i).getDiscount());
			purchaseorder.setDiscountAmount(purchseorderDto.get(i).getDiscountAmount());
			purchaseorder.setSalePrice(purchseorderDto.get(i).getSalePrice());
			purchaseorder.setMrp(purchseorderDto.get(i).getMrp());
			purchaseorder.setCgst(purchseorderDto.get(i).getCgst());
			purchaseorder.setSgst(purchseorderDto.get(i).getSgst());
			purchaseorder.setIgst(purchseorderDto.get(i).getIgst());
			purchaseorder.setTaxpercentage(purchseorderDto.get(i).getTaxpercentage());
			purchaseorder.setTaxAmount(purchseorderDto.get(i).getTaxAmount());
			purchaseorder.setTotalExcludingTax(purchseorderDto.get(i).getTotalExcludingTax());
			purchaseorder.setTotalAmount(purchseorderDto.get(i).getTotalAmount());
			purchaseorder.setPaymentMode(purchseorderDto.get(i).getPaymentMode());
//			purchaseorder.setBatchNumber(purchseorderDto.get(i).getBatchNumber());
//			purchaseorder.setManufacturingDate(purchseorderDto.get(i).getManufacturingDate());
//			purchaseorder.setExpiryDate(purchseorderDto.get(i).getExpiryDate());
			// purchaseorder.setMrp(purchseorderDto.get(i).getMrp());

			purchaseorder.setLabourExpense(purchseorderDto.get(i).getLabourExpense());
			purchaseorder.setTransportExpense(purchseorderDto.get(i).getTransportExpense());
			purchaseorder.setTotalQuantity(purchseorderDto.get(i).getTotalQuantity());
			purchaseorder.setTotalTaxAmount(purchseorderDto.get(i).getTotalTaxAmount());
			purchaseorder.setGrossTotal(purchseorderDto.get(i).getGrossTotal());
			purchaseorder.setFkShopId(purchseorderDto.get(i).getFkShopId());
			purchaseorder.setShopName(purchseorderDto.get(i).getShopName());
			purchaseorder.setFkAdminId(purchseorderDto.get(i).getFkAdminId());
			purchaseorder.setAdminName(purchseorderDto.get(i).getAdminName());
			purchaseorder.setFkoragnizationId(purchseorderDto.get(i).getFkoragnizationId());
			purchaseorder.setOragnizationName(purchseorderDto.get(i).getOragnizationName());
			purchaseorder.setCreatedDate(dateString);
			purchaseorder.setCreatedBy(user + "(" + role + ")");
			list.add(purchaseorder);
		}
		purchaseorderrepository.saveAll(list);
		return "saved";
	}

	public String savepurchasereturn(List<PurchaseReturnDto> purchasereturndto, String role, String fkUserId) {
		

		Long pkid = Long.parseLong(fkUserId);
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		List<PurchaseReturn> list = new ArrayList<PurchaseReturn>();
		for (int i = 0; i < purchasereturndto.size(); i++) {

			PurchaseReturn purchasereturn = new PurchaseReturn();
			purchasereturn.setPurchaseReturnId(purchasereturndto.get(i).getPurchaseReturnId());
			purchasereturn.setFkCatId(purchasereturndto.get(i).getFkCatId());
			purchasereturn.setCategoryName(purchasereturndto.get(i).getCategoryName());
			purchasereturn.setFkSubCatId(purchasereturndto.get(i).getFkSubCatId());
			purchasereturn.setSubCategoryName(purchasereturndto.get(i).getSubCategoryName());
			Long productId = purchasereturndto.get(i).getFkProductId();
			purchasereturn.setFkProductId(purchasereturndto.get(i).getFkProductId());

			purchasereturn.setFkSupplierId(purchasereturndto.get(i).getFkSupplierId());
			purchasereturn.setSupplierName(purchasereturndto.get(i).getSupplierName());
			purchasereturn.setProductName(purchasereturndto.get(i).getProductName());
			purchasereturn.setBillNo(purchasereturndto.get(i).getBillNo());
			purchasereturn.setPurchaseReturnNo(purchasereturndto.get(i).getPurchaseReturnNo());
			purchasereturn.setBarcodeNo(purchasereturndto.get(i).getBarcodeNo());
			purchasereturn.setBatchNo(purchasereturndto.get(i).getBatchNo());
			purchasereturn.setCompany(purchasereturndto.get(i).getCompany());
			purchasereturn.setBuyPriceIncludingTax(purchasereturndto.get(i).getBuyPriceIncludingTax());
			purchasereturn.setBuyPriceExcludingTax(purchasereturndto.get(i).getBuyPriceExcludingTax());
			purchasereturn.setCgst(purchasereturndto.get(i).getCgst());
			purchasereturn.setSgst(purchasereturndto.get(i).getSgst());
			purchasereturn.setIgst(purchasereturndto.get(i).getIgst());
			purchasereturn.setTaxPercentage(purchasereturndto.get(i).getTaxPercentage());
			purchasereturn.setTaxAmount(purchasereturndto.get(i).getTaxAmount());
			purchasereturn.setQuantity(purchasereturndto.get(i).getQuantity());
			purchasereturn.setReturnQuantity(purchasereturndto.get(i).getReturnQuantity());
			purchasereturn.setReturnTotal(purchasereturndto.get(i).getReturnTotal());
			purchasereturn.setReturnAmount(purchasereturndto.get(i).getReturnAmount());
			purchasereturn.setWeight(purchasereturndto.get(i).getWeight());
			purchasereturn.setUnit(purchasereturndto.get(i).getUnit());
			purchasereturn.setMrp(purchasereturndto.get(i).getMrp());
			purchasereturn.setManufactureDate(purchasereturndto.get(i).getManufactureDate());
			purchasereturn.setTotalAmount(purchasereturndto.get(i).getTotalAmount());
			purchasereturn.setReturnAmount(purchasereturndto.get(i).getReturnAmount());
			purchasereturn.setExpiryDate(purchasereturndto.get(i).getExpiryDate());
			purchasereturn.setFkShopId(purchasereturndto.get(i).getFkShopId());
			purchasereturn.setShopName(purchasereturndto.get(i).getShopName());
			purchasereturn.setFkAdminId(purchasereturndto.get(i).getFkAdminId());
			purchasereturn.setAdminName(purchasereturndto.get(i).getAdminName());
			purchasereturn.setFkoragnizationId(purchasereturndto.get(i).getFkoragnizationId());
			purchasereturn.setOragnizationName(purchasereturndto.get(i).getOragnizationName());
			purchasereturn.setCreatedDate(dateString);
			// purchasereturn.setCreatedBy(user + "(" + role + ")");
			if (purchasereturndto.get(i).getReturnQuantity() > 0) {
				list.add(purchasereturn);

				purchasereturnrepository.saveAll(list);

				Double availableQuantity = stockrepository.getstockquantity(productId);
				System.out.println("get available quantity from stock");
				System.out.println(availableQuantity);
				Long stockid = stockrepository.getstockid(productId);
				System.out.println("get stock id from stock");
				System.out.println(stockid);

				Double newreturnquantity = purchasereturndto.get(i).getReturnQuantity();
				Double newquantity = availableQuantity - newreturnquantity;
				System.out.println(newquantity);

				Stock stock = new Stock();

				stock.setPkStockId(stockid);
				stock.setFkcategoryId(purchasereturndto.get(i).getFkCatId());
				stock.setCategoryName(purchasereturndto.get(i).getCategoryName());
				stock.setFkSubCategoryId(purchasereturndto.get(i).getFkSubCatId());
				stock.setSubCategoryName(purchasereturndto.get(i).getSubCategoryName());
				stock.setFkProductId(purchasereturndto.get(i).getFkProductId());
				purchasereturn.setProductName(purchasereturndto.get(i).getProductName());
				stock.setQuantity(purchasereturndto.get(i).getQuantity());
				stock.setManufactureDate(purchasereturndto.get(i).getManufactureDate());
				stock.setExpiryDate(purchasereturndto.get(i).getExpiryDate());

				// stock.setAvailableQuantity(purchasereturndto.get(i).getQuantity());

				stock.setPackingType("unpacked");
				if (purchasereturndto.get(i).getBatchNo() != null) {
					stock.setBatchNumber(purchasereturndto.get(i).getBatchNo());
				} else {
					stock.setBatchNumber("N/A");
				}
				if (purchasereturndto.get(i).getUnit() != null) {
					stock.setUnit(purchasereturndto.get(i).getUnit());
				} else {
					stock.setUnit("N/A");
				}
				if (purchasereturndto.get(i).getWeight() != null) {
					stock.setWeight(purchasereturndto.get(i).getWeight());
				} else {
					stock.setWeight(0d);
				}
				stock.setUpdateDate(dateString);
				stock.setCompanyName(purchasereturndto.get(i).getCompany());
				stock.setFkShopId(purchasereturndto.get(i).getFkShopId());
				stock.setShopName(purchasereturndto.get(i).getShopName());
				stock.setFkAdminId(purchasereturndto.get(i).getFkAdminId());
				stock.setAdminName(purchasereturndto.get(i).getAdminName());
				stock.setFkoragnizationId(purchasereturndto.get(i).getFkoragnizationId());
				stock.setOragnizationName(purchasereturndto.get(i).getOragnizationName());
				stock.setCreatedDate(dateString);

				stock.setAvailableQuantity(newquantity);

				stockrepository.save(stock);
				
				barcodeWiseStock.updatebarcodeWiseStock(newquantity,purchasereturndto.get(i).getBarcodeNo());

			}
		}
		return "saved";
	}

	public List<ProductDetailsBean> getpurchasequotationgrid(Long fkCatId, Long fkSubCatId, Long fkProductId,
			String role, String fkUserId) {
		if (role.equals("super-admin")) {

			return productrepository.getpurchasequotationgridforsuperadmin(fkCatId, fkSubCatId, fkProductId);

		}

		if (role.equals("oragnization")) {
			Long fkOragnizationId = Long.parseLong(fkUserId);
			return productrepository.getpurchasequotationgridfororagnization(fkCatId, fkSubCatId, fkProductId,
					fkOragnizationId);

		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return productrepository.getpurchasequotationgridforadmin(fkCatId, fkSubCatId, fkProductId, fkAdminId);

		}

		return null;
	}

	public List<PurchaseQuotationBean> getpurchasequotationgrid(String productId, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			List<PurchaseQuotationBean> listbean = new ArrayList<>();
			List<ProductDetails> getproductdetails = productrepository
					.getproductdeatilsforpurchasequotationgridforsuperadmin(Long.parseLong(productId));
			for (int i = 0; i < getproductdetails.size(); i++) {

				PurchaseQuotationBean grid = new PurchaseQuotationBean();

				grid.setBarcodeNo("N/A");
				grid.setFkProductId(getproductdetails.get(i).getPkProductId());
				grid.setProductName(getproductdetails.get(i).getProductName());
				grid.setFkCategoryId(getproductdetails.get(i).getFkCategoryId());
				grid.setCategoryName(getproductdetails.get(i).getCategoryName());
				grid.setSubcategoryName(getproductdetails.get(i).getSubcategoryName());
				grid.setFkSubCategoryId(getproductdetails.get(i).getFkSubCategoryId());
				grid.setFkShopId(getproductdetails.get(i).getFkShopId());
				grid.setShopName(getproductdetails.get(i).getShopName());
				grid.setFkAdminId(getproductdetails.get(i).getFkAdminId());
				grid.setAdminName(getproductdetails.get(i).getAdminName());
				grid.setFkoragnizationId(getproductdetails.get(i).getFkoragnizationId());
				grid.setOragnizationName(getproductdetails.get(i).getOragnizationName());
				grid.setGst(getproductdetails.get(i).getCgst() + getproductdetails.get(i).getSgst());
				grid.setIgst(getproductdetails.get(i).getIgst());
				grid.setCompany(getproductdetails.get(i).getManufactureCompany());
				grid.setWeight(getproductdetails.get(i).getWeight());
				grid.setUnit(getproductdetails.get(i).getUnit());
				grid.setRollSize(getproductdetails.get(i).getRollSize());
				grid.setSize(getproductdetails.get(i).getSize());
				grid.setColor(getproductdetails.get(i).getColor());
				grid.setStyle(getproductdetails.get(i).getStyle());
				grid.setBuyPriceIncludingTax(getproductdetails.get(i).getBuyPriceIncludingTax());
				grid.setBuyPriceExcludingTax(0d);
				grid.setDiscountPercentage(getproductdetails.get(i).getPurchaseDiscount());
				grid.setDiscountAmount(0d);
				grid.setSalePrice(getproductdetails.get(i).getSalePriceIncludingTax());
				grid.setMrp(getproductdetails.get(i).getMrp());
				grid.setTaxpercentage(getproductdetails.get(i).getTax());
				grid.setHsnsacc(getproductdetails.get(i).getHsnCode());
				grid.setQuantity(1d);

				grid.setTotalExcludingTax(0d);
				grid.setTaxAmount(0d);
				grid.setTotalAmount(0d);

				listbean.add(grid);

			}
			return listbean;

		}
		if (role.equals("admin")) {

			Long fkAdminId = Long.parseLong(fkUserId);
			List<PurchaseQuotationBean> listbean = new ArrayList<>();
			List<ProductDetails> getproductdetails = productrepository
					.getproductdeatilsforpurchasequotationgridforadmin(Long.parseLong(productId), fkAdminId);
			for (int i = 0; i < getproductdetails.size(); i++) {
				PurchaseQuotationBean grid = new PurchaseQuotationBean();

				grid.setBarcodeNo("N/A");
				grid.setFkProductId(getproductdetails.get(i).getPkProductId());
				grid.setProductName(getproductdetails.get(i).getProductName());
				grid.setFkCategoryId(getproductdetails.get(i).getFkCategoryId());
				grid.setCategoryName(getproductdetails.get(i).getCategoryName());
				grid.setSubcategoryName(getproductdetails.get(i).getSubcategoryName());
				grid.setFkSubCategoryId(getproductdetails.get(i).getFkSubCategoryId());
				grid.setFkShopId(getproductdetails.get(i).getFkShopId());
				grid.setShopName(getproductdetails.get(i).getShopName());
				grid.setFkAdminId(getproductdetails.get(i).getFkAdminId());
				grid.setAdminName(getproductdetails.get(i).getAdminName());
				grid.setFkoragnizationId(getproductdetails.get(i).getFkoragnizationId());
				grid.setOragnizationName(getproductdetails.get(i).getOragnizationName());
				grid.setGst(getproductdetails.get(i).getCgst() + getproductdetails.get(i).getSgst());
				grid.setIgst(getproductdetails.get(i).getIgst());
				grid.setCompany(getproductdetails.get(i).getManufactureCompany());
				grid.setWeight(getproductdetails.get(i).getWeight());
				grid.setUnit(getproductdetails.get(i).getUnit());
				grid.setRollSize(getproductdetails.get(i).getRollSize());
				grid.setSize(getproductdetails.get(i).getSize());
				grid.setColor(getproductdetails.get(i).getColor());
				grid.setStyle(getproductdetails.get(i).getStyle());
				grid.setBuyPriceIncludingTax(getproductdetails.get(i).getBuyPriceIncludingTax());
				grid.setBuyPriceExcludingTax(0d);
				grid.setDiscountPercentage(getproductdetails.get(i).getPurchaseDiscount());
				grid.setDiscountAmount(0d);
				grid.setSalePrice(getproductdetails.get(i).getSalePriceIncludingTax());
				grid.setMrp(getproductdetails.get(i).getMrp());
				grid.setTaxpercentage(getproductdetails.get(i).getTax());
				grid.setHsnsacc(getproductdetails.get(i).getHsnCode());
				grid.setQuantity(1d);

				grid.setTotalExcludingTax(0d);
				grid.setTaxAmount(0d);
				grid.setTotalAmount(0d);
				listbean.add(grid);

			}
			return listbean;
		}
		if (role.equals("oragnization")) {

			Long fkOragnizationId = Long.parseLong(fkUserId);
			List<PurchaseQuotationBean> listbean = new ArrayList<>();
			List<ProductDetails> getproductdetails = productrepository
					.getproductdeatilsforpurchasequotationgridfororagnization(Long.parseLong(productId),
							fkOragnizationId);
			for (int i = 0; i < getproductdetails.size(); i++) {
				PurchaseQuotationBean grid = new PurchaseQuotationBean();

				grid.setBarcodeNo("N/A");
				grid.setFkProductId(getproductdetails.get(i).getPkProductId());
				grid.setProductName(getproductdetails.get(i).getProductName());
				grid.setFkCategoryId(getproductdetails.get(i).getFkCategoryId());
				grid.setCategoryName(getproductdetails.get(i).getCategoryName());
				grid.setSubcategoryName(getproductdetails.get(i).getSubcategoryName());
				grid.setFkShopId(getproductdetails.get(i).getFkShopId());
				grid.setShopName(getproductdetails.get(i).getShopName());
				grid.setFkAdminId(getproductdetails.get(i).getFkAdminId());
				grid.setAdminName(getproductdetails.get(i).getAdminName());
				grid.setFkoragnizationId(getproductdetails.get(i).getFkoragnizationId());
				grid.setOragnizationName(getproductdetails.get(i).getOragnizationName());
				grid.setGst(getproductdetails.get(i).getCgst() + getproductdetails.get(i).getSgst());
				grid.setIgst(getproductdetails.get(i).getIgst());
				grid.setCompany(getproductdetails.get(i).getManufactureCompany());
				grid.setWeight(getproductdetails.get(i).getWeight());
				grid.setUnit(getproductdetails.get(i).getUnit());
				grid.setRollSize(getproductdetails.get(i).getRollSize());
				grid.setSize(getproductdetails.get(i).getSize());
				grid.setColor(getproductdetails.get(i).getColor());
				grid.setStyle(getproductdetails.get(i).getStyle());
				grid.setBuyPriceIncludingTax(getproductdetails.get(i).getBuyPriceIncludingTax());
				grid.setBuyPriceExcludingTax(0d);
				grid.setDiscountPercentage(getproductdetails.get(i).getPurchaseDiscount());
				grid.setDiscountAmount(0d);
				grid.setSalePrice(getproductdetails.get(i).getSalePriceIncludingTax());
				grid.setMrp(getproductdetails.get(i).getMrp());
				grid.setTaxpercentage(getproductdetails.get(i).getTax());
				grid.setHsnsacc(getproductdetails.get(i).getHsnCode());
				grid.setQuantity(1d);

				grid.setTotalExcludingTax(0d);
				grid.setTaxAmount(0d);
				grid.setTotalAmount(0d);

				listbean.add(grid);

			}
			return listbean;
		}
		return null;
	}

	public List<ProductDetails> getpurchaseordergrid(String productname, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return productrepository.gerpurchaseordergridforsuperadmin(productname);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return productrepository.gerpurchaseordergridforadmin(productname, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return productrepository.gerpurchaseordergridfororagnization(productname, fkoragnizationId);
		}
		return null;
	}

	public List<ProductDetails> getpurchaseordereditgrid(String productname, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return productrepository.gerpurchaseordereditgridforsuperadmin(productname);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return productrepository.gerpurchaseordereditgridforadmin(productname, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return productrepository.gerpurchaseordereditgridfororagnization(productname, fkoragnizationId);
		}
		return null;
	}

	public List<String> getcategorywisesubcategorydropdrown(String categoryName, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return subcategoryrepository.getcategorywisesubcategorydropdownforsuperadmin(categoryName);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return subcategoryrepository.getcategorywisesubcategorydropdownforadmin(categoryName, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return subcategoryrepository.getcategorywisesubcategorydropdownfororagnization(categoryName,
					fkoragnizationId);
		}
		return null;
	}

	public List<String> getcategorywisesubcategorydropdrownIdWise(Long categoryId, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return subcategoryrepository.getcategorywisesubcategorydropdownforsuperadminIdWise(categoryId);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return subcategoryrepository.getcategorywisesubcategorydropdownforadminIdWise(categoryId, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return subcategoryrepository.getcategorywisesubcategorydropdownfororagnizationIdWise(categoryId,
					fkoragnizationId);
		}
		return null;
	}

	public List<String> getsubcategorywiseproductdropdown(String subCategoryName, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return productrepository.getsubcategorywiseproductdropdownforsuperadmin(subCategoryName);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return productrepository.getsubcategorywiseproductdropdownforadmin(subCategoryName, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return productrepository.getsubcategorywiseproductdropdownfororagnization(subCategoryName,
					fkoragnizationId);
		}
		return null;
	}

	public List<String> getpurchasequotationnodropdown(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return purchasequotationrepository.getpurchasequotationnumberdropdownforsuperadmin();
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return purchasequotationrepository.getpurchasequotationnumberdropdownforadmin(fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return purchasequotationrepository.getpurchasequotationnumberdropdownforOragnization(fkoragnizationId);
		}

		return null;

	}

	public List<PurchaseQuotation> getpurchasequotationnodetailsbyquotationumber(String role, String fkUserId,
			String quotationNumber) {
		Long quotationnumber = Long.parseLong(quotationNumber);
		if (role.equals("super-admin")) {

			return purchasequotationrepository
					.getpurchasequotationnumberdetailsbyquotationnumberforsuperadmin(quotationnumber);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return purchasequotationrepository
					.getpurchasequotationnumberdetailsbyquotationnumberforadmin(quotationnumber, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return purchasequotationrepository.getpurchasequotationnumberdetailsbyquotationnumberforOragnization(
					quotationnumber, fkoragnizationId);
		}

		return null;
	}

	public List<String> getpurchaseordernoodropdown(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return purchaseorderrepository.getpurchaseordernumberdropdownforsuperadmin();
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return purchaseorderrepository.getpurchaseordernumberdropdownforadmin(fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return purchaseorderrepository.getpurchaseordernumberdropdownforOragnization(fkoragnizationId);
		}
		return null;
	}

	public List<PurchaseOrder> getpurchaseordernodetailsbyordernumber(String role, String fkUserId,
			String orderNumber) {
		Long ordernumber = Long.parseLong(orderNumber);
		if (role.equals("super-admin")) {

			return purchaseorderrepository.getpurchaseorderNumberdetailsbyquotationnumberforsuperadmin(ordernumber);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return purchaseorderrepository.getpurchaseorderNumberdetailsbyquotationnumberforadmin(ordernumber,
					fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return purchaseorderrepository.getpurchaseorderNumberdetailsbyquotationnumberforOragnization(ordernumber,
					fkoragnizationId);
		}
		return null;
	}

	public List<PurchaseOrder> getpurchaseOrderList(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return purchaseorderrepository.getPurchaseOrderListForSuperAdmin();
		}
		if (role.equals("admin")) {

			Long fkAdminId = Long.parseLong(fkUserId);
			return purchaseorderrepository.getPurchaseOrderListForAdmin(fkAdminId);
		}
		if (role.equals("oragnization")) {
			Long fkOrganizationId = Long.parseLong(fkUserId);
			return purchaseorderrepository.getPurchaseOrderListForOrganization(fkOrganizationId);
		}
		return null;
	}

	public List<PurchaseReturnGridBean> getPurchaseReturnGrid(String billId, String role, String fkUserId) {
		List<GoodReceive> goodReceiveList = null;
		List<PurchaseReturnGridBean> purchaseReturnList = new ArrayList<>();
		if (role.equals("super-admin")) {
			goodReceiveList = purchasereturnrepository.getPurchaseReturnListForSuperAdmin(billId);
		}
		if (role.equals("admin")) {

			Long fkAdminId = Long.parseLong(fkUserId);
			goodReceiveList = purchasereturnrepository.getPurchaseReturnListForAdmin(billId, fkAdminId);
		}
		if (role.equals("oragnization")) {
			Long fkOrganizationId = Long.parseLong(fkUserId);
			goodReceiveList = purchasereturnrepository.getPurchaseReturnListForOrganization(billId, fkOrganizationId);
		}

		for (int i = 0; i < goodReceiveList.size(); i++) {

			PurchaseReturnGridBean purchaseReturn = new PurchaseReturnGridBean();

			purchaseReturn.setAdminName(goodReceiveList.get(i).getAdminName());
			purchaseReturn.setBarcodeNo(goodReceiveList.get(i).getBarcodeNo());
			purchaseReturn.setBatchNo(goodReceiveList.get(i).getBatchNo());
			purchaseReturn.setBillNo(goodReceiveList.get(i).getBillNo());
			purchaseReturn.setBuyPriceIncludingTax(goodReceiveList.get(i).getBuyPriceIncludingTax());
			purchaseReturn.setBuyPriceExcludingTax(goodReceiveList.get(i).getBuyPriceExcludingTax());
			purchaseReturn.setCategoryName(goodReceiveList.get(i).getCategoryName());
			Double gst = goodReceiveList.get(i).getCgst() + goodReceiveList.get(i).getSgst();
			purchaseReturn.setGst(gst);
			purchaseReturn.setIgst(goodReceiveList.get(i).getIgst());
			purchaseReturn.setColor(goodReceiveList.get(i).getColor());
			purchaseReturn.setCompany(goodReceiveList.get(i).getCompany());
			purchaseReturn.setContactNo(goodReceiveList.get(i).getContactNo());
			purchaseReturn.setCreatedBy(goodReceiveList.get(i).getCreatedBy());
			purchaseReturn.setCreatedDate(goodReceiveList.get(i).getCreatedDate());
			purchaseReturn.setDiscount(goodReceiveList.get(i).getDiscount());
			purchaseReturn.setDiscountAmount(goodReceiveList.get(i).getDiscountAmount());
			purchaseReturn.setExpiryDate(goodReceiveList.get(i).getExpiryDate());
			purchaseReturn.setFkAdminId(goodReceiveList.get(i).getFkAdminId());
			purchaseReturn.setFkCatId(goodReceiveList.get(i).getFkCategoryId());
			purchaseReturn.setFkGoodReceiveId(goodReceiveList.get(i).getPkGoodReceiveId());
			purchaseReturn.setFkoragnizationId(goodReceiveList.get(i).getFkoragnizationId());
			purchaseReturn.setFkProductId(goodReceiveList.get(i).getFkProductId());
			purchaseReturn.setFkShopId(goodReceiveList.get(i).getFkShopId());
			purchaseReturn.setFkSubCatId(goodReceiveList.get(i).getFkSubCategoryId());
			purchaseReturn.setFkSupplierId(goodReceiveList.get(i).getFkSupplierId());
			purchaseReturn.setGoodReceiveDate(goodReceiveList.get(i).getGoodReceiveDate());
			purchaseReturn.setGrossTotal(goodReceiveList.get(i).getGrossTotal());
			purchaseReturn.setGstForExpense(goodReceiveList.get(i).getGstForExpense());
			purchaseReturn.setHsnsac(goodReceiveList.get(i).getHsnsac());
			purchaseReturn.setLabourExpense(goodReceiveList.get(i).getLabourExpense());
			purchaseReturn.setManufactureDate(goodReceiveList.get(i).getManufactureDate());
			purchaseReturn.setMrp(goodReceiveList.get(i).getMrp());
			purchaseReturn.setOragnizationName(goodReceiveList.get(i).getOragnizationName());
			purchaseReturn.setProductName(goodReceiveList.get(i).getProductName());
			purchaseReturn.setQuantity(goodReceiveList.get(i).getQuantity());
			purchaseReturn.setReturnAmount(0d);
			purchaseReturn.setReturnQuantity(0d);
			purchaseReturn.setReturnTotal(0d);
			purchaseReturn.setRollSize(goodReceiveList.get(i).getRollSize());
			purchaseReturn.setShopName(goodReceiveList.get(i).getShopName());
			purchaseReturn.setSize(goodReceiveList.get(i).getSize());
			purchaseReturn.setStyle(goodReceiveList.get(i).getStyle());
			purchaseReturn.setSubCategoryName(goodReceiveList.get(i).getSubCategoryName());
			purchaseReturn.setSupplierName(goodReceiveList.get(i).getSupplierName());
			purchaseReturn.setTaxAmount(goodReceiveList.get(i).getTaxAmount());
			purchaseReturn.setTaxPercentage(goodReceiveList.get(i).getTaxPercentage());
			purchaseReturn.setTotalAmount(goodReceiveList.get(i).getTotalAmount());
			purchaseReturn.setTotalExcludingTax(goodReceiveList.get(i).getTotalExcludingTax());
			purchaseReturn.setTotalQuantity(goodReceiveList.get(i).getTotalQuantity());
			purchaseReturn.setTotalTaxAmount(goodReceiveList.get(i).getTotalTaxAmount());
			purchaseReturn.setTransportExpense(goodReceiveList.get(i).getTransportExpense());
			purchaseReturn.setUnit(goodReceiveList.get(i).getUnit());
			purchaseReturn.setWeight(goodReceiveList.get(i).getWeight());

			purchaseReturnList.add(purchaseReturn);
		}
		return purchaseReturnList;
	}

	public List<String> getPurchaseQuotationSuplierNamewise(Long supplierId, String role, String fkUserId) {

		if (role.equals("super-admin")) {
			return purchasequotationrepository.getPurchaseQuotationNumberForSuperAdmin(supplierId);

		}
		if (role.equals("admin")) {

			Long fkAdminId = Long.parseLong(fkUserId);
			return purchasequotationrepository.getPurchaseQuotationNumberForAdmin(supplierId, fkAdminId);

		}
		if (role.equals("oragnization")) {
			Long fkOrganizationId = Long.parseLong(fkUserId);
			return purchasequotationrepository.getPurchaseQuotationNumberForOrganization(supplierId, fkOrganizationId);
		}
		return null;
	}

	public List<PurchaseQuotationBean> getPurchaseOrderGridByPurchaseQuotation(String role, String fkUserId,
			String pqNumber) {
		List<PurchaseQuotation> purchaseQuotationList = purchasequotationrepository
				.getPurchaseOrderGrid(Long.parseLong(pqNumber), Long.parseLong(fkUserId));
		List<PurchaseQuotationBean> grid = new ArrayList<>();

		for (int i = 0; i < purchaseQuotationList.size(); i++) {
			PurchaseQuotationBean bean = new PurchaseQuotationBean();

			bean.setPkPurchaseQuotationId(purchaseQuotationList.get(i).getPkPurchaseQuotationId());
			bean.setFkSupplierId(purchaseQuotationList.get(i).getFkSupplierId());
			bean.setSupplierName(purchaseQuotationList.get(i).getSupplierName());
			bean.setEmailId(purchaseQuotationList.get(i).getEmailId());
			bean.setCity(purchaseQuotationList.get(i).getCity());
			bean.setAddress(purchaseQuotationList.get(i).getAddress());
			bean.setContactNo(purchaseQuotationList.get(i).getContactNo());
			bean.setGstNo(purchaseQuotationList.get(i).getGstNo());
			bean.setQuotationDate(purchaseQuotationList.get(i).getQuotationDate());
			bean.setFkCategoryId(purchaseQuotationList.get(i).getFkCategoryId());
			bean.setCategoryName(purchaseQuotationList.get(i).getCategoryName());
			bean.setSubcategoryName(purchaseQuotationList.get(i).getSubCategoryName());
			bean.setFkSubCategoryId(purchaseQuotationList.get(i).getFkSubCategoryId());
			bean.setFkProductId(purchaseQuotationList.get(i).getFkProductId());
			bean.setProductName(purchaseQuotationList.get(i).getProductName());
			bean.setBarcodeNo(purchaseQuotationList.get(i).getBarcodeNo());
			bean.setBuyPriceIncludingTax(purchaseQuotationList.get(i).getBuyPriceIncludingTax());
			bean.setBuyPriceExcludingTax(purchaseQuotationList.get(i).getBuyPriceExcludingTax());
			bean.setQuantity(purchaseQuotationList.get(i).getQuantity());
			bean.setRollSize(purchaseQuotationList.get(i).getRollSize());
			bean.setSize(purchaseQuotationList.get(i).getSize());
			bean.setStyle(purchaseQuotationList.get(i).getStyle());
			bean.setColor(purchaseQuotationList.get(i).getColor());
			bean.setWeight(purchaseQuotationList.get(i).getWeight());
			bean.setUnit(purchaseQuotationList.get(i).getUnit());
			bean.setCompany(purchaseQuotationList.get(i).getCompany());
			bean.setHsnsacc(purchaseQuotationList.get(i).getHsnsacc());
			bean.setDiscountPercentage(purchaseQuotationList.get(i).getDiscount());
			bean.setDiscountAmount(purchaseQuotationList.get(i).getDiscountAmount());
			bean.setDiscountPercentage(purchaseQuotationList.get(i).getDiscountPercentage());
			bean.setSalePrice(purchaseQuotationList.get(i).getSalePrice());
			bean.setMrp(purchaseQuotationList.get(i).getMrp());
			Double gst = purchaseQuotationList.get(i).getSgst() + purchaseQuotationList.get(i).getCgst();
			bean.setGst(gst);
			bean.setIgst(purchaseQuotationList.get(i).getIgst());
			bean.setTaxpercentage(purchaseQuotationList.get(i).getTaxpercentage());
			bean.setTaxAmount(purchaseQuotationList.get(i).getTaxAmount());
			bean.setTotalExcludingTax(purchaseQuotationList.get(i).getTotalExcludingTax());
			bean.setTotalAmount(purchaseQuotationList.get(i).getTotalAmount());
			bean.setPaymentMode(purchaseQuotationList.get(i).getPaymentMode());
			bean.setLabourExpence(purchaseQuotationList.get(i).getLabourExpence());
			bean.setGrossTotal(purchaseQuotationList.get(i).getGrossTotal());
			bean.setTransportExpence(purchaseQuotationList.get(i).getTransportExpence());
			bean.setQuotationNumber(purchaseQuotationList.get(i).getQuotationNumber());
			bean.setFkShopId(purchaseQuotationList.get(i).getFkShopId());
			bean.setShopName(purchaseQuotationList.get(i).getShopName());
			bean.setFkAdminId(purchaseQuotationList.get(i).getFkAdminId());
			bean.setAdminName(purchaseQuotationList.get(i).getAdminName());
			bean.setFkoragnizationId(purchaseQuotationList.get(i).getFkoragnizationId());
			bean.setOragnizationName(purchaseQuotationList.get(i).getOragnizationName());
			bean.setTotalQuantity(purchaseQuotationList.get(i).getTotalQuantity());
			bean.setTotalTaxAmount(purchaseQuotationList.get(i).getTotalTaxAmount());
			bean.setCreatedDate(purchaseQuotationList.get(i).getCreatedDate());
			bean.setCreatedBy(purchaseQuotationList.get(i).getCreatedBy());

			grid.add(bean);
		}

		return grid;

	}

	public List<String> getGoodReceiveSupplierList(String role, Long fkAdminId) {
		return purchasereturnrepository.getGoodReceivePurchaseReturn(fkAdminId);

	}

	public List<String> getGoodReceiveBillNoList(String role, Long fkAdminId, Long fksupplierId) {
		return purchasereturnrepository.getgoodReceiveBillNoForPurchaseReturn(fkAdminId, fksupplierId);

	}

	public List<String> getSupplierDetailsIdWise(Long supplierId, Long fkAdminId) {
		return purchasereturnrepository.getSupplierDetailsIdWise(supplierId, fkAdminId);
	}

	public List<String> getSupplierDetailsForPurchaseOrder(String purchaseOrderId, String fkUserId) {

		return purchasequotationrepository.getSupplierDetailsForPurchaseOrderForAdmin(Long.parseLong(purchaseOrderId));

	}

	public List<String> getPurchaseOrderNumberList(String fkAdmin, String supplierId) {
		Long fkAdminId = Long.parseLong(fkAdmin);

		return purchaseorderrepository.getPurchaseOrderNumberList(fkAdminId, Long.parseLong(supplierId));
	}

	public List<String> getCategoryListForStock(String role, String fkUserId, String fkGodownId) {
		Long fkGodownID = Long.parseLong(fkGodownId);
		if (role.equals("super-admin")) {
			return stockrepository.getCategoryListForStockForSuperAdmin(fkGodownID);

		}
		if (role.equals("admin")) {

			Long fkAdminId = Long.parseLong(fkUserId);
			return stockrepository.getCategoryListForStockAdmin(fkGodownID, fkAdminId);

		}
		if (role.equals("oragnization")) {
			Long fkOrganizationId = Long.parseLong(fkUserId);
			return stockrepository.getCategoryListForStockOrganization(fkGodownID, fkOrganizationId);
		}
		return null;
	}

	public List<String> getProductListForStock(String role, String fkUserId, String fkGodownId, String fkCategoryID) {
		Long fkCategoryId = Long.parseLong(fkCategoryID);
		Long fkGodownID = Long.parseLong(fkGodownId);
		if (role.equals("super-admin")) {
			return stockrepository.getProductListForStockForSuperAdmin(fkGodownID, fkCategoryId);

		}
		if (role.equals("admin")) {

			Long fkAdminId = Long.parseLong(fkUserId);
			return stockrepository.getProductListForStockAdmin(fkGodownID, fkAdminId, fkCategoryId);

		}
		if (role.equals("oragnization")) {
			Long fkOrganizationId = Long.parseLong(fkUserId);
			return stockrepository.getProductListForStockOrganization(fkGodownID, fkOrganizationId, fkCategoryId);
		}
		return null;
	}

}
