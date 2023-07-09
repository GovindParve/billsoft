package com.bill_soft.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.bean.SaleInvoiceGridBean;
import com.bill_soft.dto.BillDetailsDto;
import com.bill_soft.entity.BarcodeNoWiseStock;
import com.bill_soft.entity.BillDetails;
import com.bill_soft.entity.ProductDetails;
import com.bill_soft.entity.Stock;
import com.bill_soft.repository.BarcodeWiseStockRepository;
import com.bill_soft.repository.BillingRepository;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.ProductRepository;
import com.bill_soft.repository.SaleQuotationRepository;
import com.bill_soft.repository.StockRepository;

@Service
public class BillingService {

	@Autowired
	private StockRepository stockrepository;
	@Autowired
	private BillingRepository billingrepository;
	@Autowired
	private LoginRepository loginrepository;
	@Autowired
	private BarcodeWiseStockRepository barcodewisestockrepository;
	@Autowired
	private ProductRepository productrepository;
	@Autowired
	private SaleQuotationRepository saleQuotationRepository;

	public String addbill(List<BillDetailsDto> billdetailsdto, String role, String fkUserId) {
		Long pkid = Long.parseLong(fkUserId);
		String user = loginrepository.getusernameforcategory(role, pkid);
		if (user.equals(null)) {
			return "UserName Not Found";
		}
		LocalDate date = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		List<BillDetails> list = new ArrayList<BillDetails>();
		for (int i = 0; i < billdetailsdto.size(); i++) {
			BillDetails billdetails = new BillDetails();
			billdetails.setPkBillId(billdetailsdto.get(i).getPkBillId());
			billdetails.setCustomerType(billdetailsdto.get(i).getCustomerType());
			billdetails.setSaleQuotationNo(billdetailsdto.get(i).getSaleQuotationNo());
			billdetails.setCompanyName(billdetailsdto.get(i).getCompanyName());
			billdetails.setCustomerName(billdetailsdto.get(i).getCustomerName());
			billdetails.setContactNo(billdetailsdto.get(i).getContactNo());
			billdetails.setEmailId(billdetailsdto.get(i).getEmailId());
			billdetails.setAddress(billdetailsdto.get(i).getAddress());
			billdetails.setBillDate(billdetailsdto.get(i).getBillDate());
			billdetails.setBillNo(billdetailsdto.get(i).getBillNo());
			billdetails.setGstNo(billdetailsdto.get(i).getGstNo());
			billdetails.setPaymentMode(billdetailsdto.get(i).getPaymentMode());
			billdetails.setCashAmount(billdetailsdto.get(i).getCash());
			billdetails.setCardAmount(billdetailsdto.get(i).getCard());
			billdetails.setUpiAmount(billdetailsdto.get(i).getUpi());
			Long catId = billdetailsdto.get(i).getFkCatId();
			billdetails.setFkCatId(billdetailsdto.get(i).getFkCatId());
			billdetails.setCategoryName(billdetailsdto.get(i).getCategoryName());
			Long subcatId = billdetailsdto.get(i).getFkSubCatId();
			billdetails.setFkSubCatId(billdetailsdto.get(i).getFkSubCatId());
			billdetails.setSubCategoryName(billdetailsdto.get(i).getSubCategoryName());
			Long productId = billdetailsdto.get(i).getFkProductId();
			billdetails.setFkProductId(billdetailsdto.get(i).getFkProductId());
			billdetails.setProductName(billdetailsdto.get(i).getProductName());
			billdetails.setBarcodeNo(billdetailsdto.get(i).getBarcodeNo());
			Double quantity = billdetailsdto.get(i).getQuantity();
			billdetails.setQuantity(billdetailsdto.get(i).getQuantity());
			billdetails.setWeight(billdetailsdto.get(i).getWeight());
			billdetails.setUnit(billdetailsdto.get(i).getUnit());
			billdetails.setSalePriceIncludingtax(billdetailsdto.get(i).getSalePriceIncludingtax());
			billdetails.setSalePriceExcludingTax(billdetailsdto.get(i).getSalePriceExcludingTax());
			billdetails.setDiscount(billdetailsdto.get(i).getDiscount());
			billdetails.setDiscountAmount(billdetailsdto.get(i).getDiscountAmount());
			billdetails.setCgst(billdetailsdto.get(i).getCgst());
			billdetails.setSgst(billdetailsdto.get(i).getSgst());
			billdetails.setIgst(billdetailsdto.get(i).getIgst());
			billdetails.setTaxPercentage(billdetailsdto.get(i).getTaxPercentage());
			billdetails.setTaxAmount(billdetailsdto.get(i).getTaxAmount());
			billdetails.setTotalExcludingTax(billdetailsdto.get(i).getTotalExcludingTax());
			billdetails.setTotalAmount(billdetailsdto.get(i).getTotalAmount());
			billdetails.setBatchno(billdetailsdto.get(i).getBatchno());
			billdetails.setManufacturingDate(billdetailsdto.get(i).getManufacturingDate());
			billdetails.setExpiryDate(billdetailsdto.get(i).getExpiryDate());
			billdetails.setGrossTotal(billdetailsdto.get(i).getGrossTotal());
			billdetails.setLabourExpense(billdetailsdto.get(i).getLabourExpense());
			billdetails.setTransportExpense(billdetailsdto.get(i).getTransportExpense());
			billdetails.setGstExpense(billdetailsdto.get(i).getGstExpense());
			billdetails.setCreditAmount(billdetailsdto.get(i).getCreditAmount());
			billdetails.setFkShopId(billdetailsdto.get(i).getFkShopId());
			billdetails.setShopName(billdetailsdto.get(i).getShopName());
			billdetails.setBillDate(dateString);
			billdetails.setFkAdminId(billdetailsdto.get(i).getFkAdminId());
			billdetails.setAdminName(billdetailsdto.get(i).getAdminName());
			billdetails.setFkOragnizationId(billdetailsdto.get(i).getFkOragnizationId());
			billdetails.setOragnizationName(billdetailsdto.get(i).getOragnizationName());
			billdetails.setCreatedBy(user + "(" + role + ")");
			billdetails.setCreatedDate(dateString);

			list.add(billdetails);

			billingrepository.saveAll(list);

			List<Stock> stock = stockrepository.getAllStockentry();
			System.out.println("stock");
			for (int j = 0; j < stock.size(); j++) {
				Stock st = (Stock) stock.get(j);
				Long fkcatId = st.getFkcategoryId();
				Long fkproductId = st.getFkProductId();
				Long fksubcatId = st.getFkSubCategoryId();
				Long stockId = st.getPkStockId();

				System.out.println("\n ++++ if product name is already present in stock ++");

				if ((productId == fkproductId) && (catId == fkcatId) && (subcatId == fksubcatId)) {
					System.out.println("To update stock");
					// Long Stockid=stockrepository.getstockid(fkproductId);
					Double qty = st.getAvailableQuantity();
					Double updatedQuantity = qty - quantity;
					Stock updatestock = new Stock();

					updatestock.setPkStockId(stockId);
					updatestock.setFkcategoryId(billdetailsdto.get(i).getFkCatId());
					updatestock.setCategoryName(billdetailsdto.get(i).getCategoryName());
					updatestock.setFkSubCategoryId(billdetailsdto.get(i).getFkSubCatId());
					updatestock.setSubCategoryName(billdetailsdto.get(i).getSubCategoryName());
					updatestock.setFkProductId(billdetailsdto.get(i).getFkProductId());
					updatestock.setProductName(billdetailsdto.get(i).getProductName());
					updatestock.setQuantity(billdetailsdto.get(i).getQuantity());
					updatestock.setManufactureDate(billdetailsdto.get(i).getManufacturingDate());
					updatestock.setExpiryDate(billdetailsdto.get(i).getExpiryDate());
					// updatestock.setAvailableQuantity(goodreceivedto.get(i).getQuantity());
					updatestock.setAvailableQuantity(updatedQuantity);
					updatestock.setUpdateDate(dateString);
					updatestock.setPackingType("unpacked");
					if (billdetailsdto.get(i).getBatchno() != null) {
						updatestock.setBatchNumber(billdetailsdto.get(i).getBatchno());
					} else {
						updatestock.setBatchNumber("N/A");
					}
					if (billdetailsdto.get(i).getUnit() != null) {
						updatestock.setUnit(billdetailsdto.get(i).getUnit());
					} else {
						updatestock.setUnit("N/A");
					}
					if (billdetailsdto.get(i).getWeight() != null) {
						updatestock.setWeight(billdetailsdto.get(i).getWeight());
					} else {
						updatestock.setWeight(0d);
					}

					updatestock.setCompanyName(billdetailsdto.get(i).getCompanyName());
					updatestock.setFkShopId(billdetailsdto.get(i).getFkShopId());
					updatestock.setShopName(billdetailsdto.get(i).getShopName());
					updatestock.setFkAdminId(billdetailsdto.get(i).getFkAdminId());
					updatestock.setAdminName(billdetailsdto.get(i).getAdminName());
					updatestock.setFkoragnizationId(billdetailsdto.get(i).getFkOragnizationId());
					updatestock.setOragnizationName(billdetailsdto.get(i).getOragnizationName());
					updatestock.setCreatedBy(user + "(" + role + ")");
					updatestock.setCreatedDate(dateString);
					// stockrepository.updateavailablequantity(updatedQuantity,dateString,fkproductId);
					stockrepository.save(updatestock);

				}

				List<BarcodeNoWiseStock> barcodewisestock = barcodewisestockrepository.getallbarcodestock();
				System.out.println(barcodewisestock);
				System.out.println("size of barcode wise stock");
				System.out.println(barcodewisestock.size());
				BarcodeNoWiseStock barcodestock = new BarcodeNoWiseStock();
				barcodestock.setBarcodeNo(billdetailsdto.get(i).getBarcodeNo());
				barcodestock.setBatchNumber(billdetailsdto.get(i).getBatchno());
				barcodestock.setManufactureDate(billdetailsdto.get(i).getManufacturingDate());
				barcodestock.setExpiryDate(billdetailsdto.get(i).getExpiryDate());
				barcodestock.setCompanyName(billdetailsdto.get(i).getCompanyName());
				barcodestock.setColor(billdetailsdto.get(i).getColor());
				barcodestock.setWeight(billdetailsdto.get(i).getWeight());
				barcodestock.setUnit(billdetailsdto.get(i).getUnit());
				barcodestock.setSize(billdetailsdto.get(i).getSize());
				barcodestock.setAvailableQuantity(billdetailsdto.get(i).getQuantity());
				barcodestock.setPackingType(billdetailsdto.get(i).getPackingType());
				barcodestock.setFkAdminId(billdetailsdto.get(i).getFkAdminId());
				barcodestock.setAdminName(billdetailsdto.get(i).getAdminName());
				barcodestock.setFkoragnizationId(billdetailsdto.get(i).getFkOragnizationId());
				barcodestock.setOragnizationName(billdetailsdto.get(i).getOragnizationName());
				barcodestock.setFkcategoryId(billdetailsdto.get(i).getFkCatId());
				barcodestock.setCategoryName(billdetailsdto.get(i).getCategoryName());
				barcodestock.setFkSubCategoryId(billdetailsdto.get(i).getFkSubCatId());
				barcodestock.setSubCategoryName(billdetailsdto.get(i).getSubCategoryName());
				barcodestock.setFkProductId(billdetailsdto.get(i).getFkProductId());
				barcodestock.setProductName(billdetailsdto.get(i).getProductName());
				barcodestock.setCreatedBy(user + "(" + role + ")");
				barcodestock.setCreatedDate(dateString);
				barcodestock.setFkShopId(billdetailsdto.get(i).getFkShopId());
				barcodestock.setShopName(billdetailsdto.get(i).getShopName());
				barcodestock.setUpdateDate(dateString);
				barcodewisestockrepository.save(barcodestock);

			}
		}
		return "bill created successfully";
	}

	public Optional<BillDetails> getbill(Long id, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return billingrepository.findById(id);
		}
		if (role.equals("oragnization")) {
			return billingrepository.findById(id);

		}
		if (role.equals("admin")) {
			return billingrepository.findById(id);
		}
		return null;
	}

	public String updatebill(List<BillDetailsDto> billdetailsdto, String role, String fkUserId) {
		Long pkid = Long.parseLong(fkUserId);
		String user = loginrepository.getusernameforcategory(role, pkid);
		if (user.equals(null)) {
			return "UserName Not Found";
		}
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		List<BillDetails> list = new ArrayList<BillDetails>();
		for (int i = 0; i < billdetailsdto.size(); i++) {
			BillDetails billdetails = new BillDetails();
			billdetails.setPkBillId(billdetailsdto.get(i).getPkBillId());
			billdetails.setCustomerType(billdetailsdto.get(i).getCustomerType());
			billdetails.setSaleQuotationNo(billdetailsdto.get(i).getSaleQuotationNo());
			billdetails.setCompanyName(billdetailsdto.get(i).getCompanyName());
			billdetails.setCustomerName(billdetailsdto.get(i).getCustomerName());
			billdetails.setContactNo(billdetailsdto.get(i).getContactNo());
			billdetails.setEmailId(billdetailsdto.get(i).getEmailId());
			billdetails.setAddress(billdetailsdto.get(i).getAddress());
			billdetails.setBillDate(billdetailsdto.get(i).getBillDate());
			billdetails.setBillNo(billdetailsdto.get(i).getBillNo());
			billdetails.setGstNo(billdetailsdto.get(i).getGstNo());
			billdetails.setPaymentMode(billdetailsdto.get(i).getPaymentMode());
			Long catId = billdetailsdto.get(i).getFkCatId();
			billdetails.setFkCatId(billdetailsdto.get(i).getFkCatId());
			billdetails.setCategoryName(billdetailsdto.get(i).getCategoryName());
			Long subcatId = billdetailsdto.get(i).getFkSubCatId();
			billdetails.setFkSubCatId(billdetailsdto.get(i).getFkSubCatId());
			billdetails.setSubCategoryName(billdetailsdto.get(i).getSubCategoryName());
			Long productId = billdetailsdto.get(i).getFkProductId();
			billdetails.setFkProductId(billdetailsdto.get(i).getFkProductId());
			billdetails.setProductName(billdetailsdto.get(i).getProductName());
			billdetails.setBarcodeNo(billdetailsdto.get(i).getBarcodeNo());
			Double quantity = billdetailsdto.get(i).getQuantity();
			billdetails.setQuantity(billdetailsdto.get(i).getQuantity());
			billdetails.setWeight(billdetailsdto.get(i).getWeight());
			billdetails.setUnit(billdetailsdto.get(i).getUnit());
			billdetails.setSalePriceIncludingtax(billdetailsdto.get(i).getSalePriceIncludingtax());
			billdetails.setSalePriceExcludingTax(billdetailsdto.get(i).getSalePriceExcludingTax());
			billdetails.setDiscount(billdetailsdto.get(i).getDiscount());
			billdetails.setDiscountAmount(billdetailsdto.get(i).getDiscountAmount());
			billdetails.setCgst(billdetailsdto.get(i).getCgst());
			billdetails.setSgst(billdetailsdto.get(i).getSgst());
			billdetails.setIgst(billdetailsdto.get(i).getIgst());
			billdetails.setTaxPercentage(billdetailsdto.get(i).getTaxPercentage());
			billdetails.setTaxAmount(billdetailsdto.get(i).getTaxAmount());
			billdetails.setTotalExcludingTax(billdetailsdto.get(i).getTotalExcludingTax());
			billdetails.setTotalAmount(billdetailsdto.get(i).getTotalAmount());
			billdetails.setBatchno(billdetailsdto.get(i).getBatchno());
			billdetails.setManufacturingDate(billdetailsdto.get(i).getManufacturingDate());
			billdetails.setExpiryDate(billdetailsdto.get(i).getExpiryDate());
			billdetails.setGrossTotal(billdetailsdto.get(i).getGrossTotal());
			billdetails.setLabourExpense(billdetailsdto.get(i).getLabourExpense());
			billdetails.setTransportExpense(billdetailsdto.get(i).getTransportExpense());
			billdetails.setGstExpense(billdetailsdto.get(i).getGstExpense());
			billdetails.setCreditAmount(billdetailsdto.get(i).getCreditAmount());
			billdetails.setFkShopId(billdetailsdto.get(i).getFkShopId());
			billdetails.setShopName(billdetailsdto.get(i).getShopName());
			billdetails.setBillDate(dateString);
			billdetails.setFkAdminId(billdetailsdto.get(i).getFkAdminId());
			billdetails.setAdminName(billdetailsdto.get(i).getAdminName());
			billdetails.setFkOragnizationId(billdetailsdto.get(i).getFkOragnizationId());
			billdetails.setOragnizationName(billdetailsdto.get(i).getOragnizationName());
			billdetails.setCreatedBy(user + "(" + role + ")");
			billdetails.setCreatedDate(dateString);

			list.add(billdetails);

			billingrepository.saveAll(list);
			System.out.println("billing list");
			System.out.println(list);

			List<Stock> stock = stockrepository.getAllStockentry();
			System.out.println("stock");
			for (int j = 0; j < stock.size(); j++) {
				Stock st = (Stock) stock.get(j);
				Long fkcatId = st.getFkcategoryId();
				Long fkproductId = st.getFkProductId();
				Long fksubcatId = st.getFkSubCategoryId();
				Long stockId = st.getPkStockId();

				System.out.println("\n ++++ if product name is already present in stock ++");

				if ((productId == fkproductId) && (catId == fkcatId) && (subcatId == fksubcatId)) {
					System.out.println("To update stock");
					// Long Stockid=stockrepository.getstockid(fkproductId);
					Double qty = st.getAvailableQuantity();
					Double updatedQuantity = qty - quantity;
					Stock updatestock = new Stock();

					updatestock.setPkStockId(stockId);
					updatestock.setFkcategoryId(billdetailsdto.get(i).getFkCatId());
					updatestock.setCategoryName(billdetailsdto.get(i).getCategoryName());
					updatestock.setFkSubCategoryId(billdetailsdto.get(i).getFkSubCatId());
					updatestock.setSubCategoryName(billdetailsdto.get(i).getSubCategoryName());
					updatestock.setFkProductId(billdetailsdto.get(i).getFkProductId());
					updatestock.setProductName(billdetailsdto.get(i).getProductName());
					updatestock.setQuantity(billdetailsdto.get(i).getQuantity());
					updatestock.setManufactureDate(billdetailsdto.get(i).getManufacturingDate());
					updatestock.setExpiryDate(billdetailsdto.get(i).getExpiryDate());
					// updatestock.setAvailableQuantity(goodreceivedto.get(i).getQuantity());
					updatestock.setAvailableQuantity(updatedQuantity);
					updatestock.setUpdateDate(dateString);
					updatestock.setPackingType("unpacked");
					if (billdetailsdto.get(i).getBatchno() != null) {
						updatestock.setBatchNumber(billdetailsdto.get(i).getBatchno());
					} else {
						updatestock.setBatchNumber("N/A");
					}
					if (billdetailsdto.get(i).getUnit() != null) {
						updatestock.setUnit(billdetailsdto.get(i).getUnit());
					} else {
						updatestock.setUnit("N/A");
					}
					if (billdetailsdto.get(i).getWeight() != null) {
						updatestock.setWeight(billdetailsdto.get(i).getWeight());
					} else {
						updatestock.setWeight(0d);
					}

					updatestock.setCompanyName(billdetailsdto.get(i).getCompanyName());
					updatestock.setFkShopId(billdetailsdto.get(i).getFkShopId());
					updatestock.setShopName(billdetailsdto.get(i).getShopName());
					updatestock.setFkAdminId(billdetailsdto.get(i).getFkAdminId());
					updatestock.setAdminName(billdetailsdto.get(i).getAdminName());
					updatestock.setFkoragnizationId(billdetailsdto.get(i).getFkOragnizationId());
					updatestock.setOragnizationName(billdetailsdto.get(i).getOragnizationName());
					updatestock.setCreatedBy(user + "(" + role + ")");
					updatestock.setCreatedDate(dateString);
					// stockrepository.updateavailablequantity(updatedQuantity,dateString,fkproductId);
					stockrepository.save(updatestock);

				}

				List<BarcodeNoWiseStock> barcodewisestock = barcodewisestockrepository.getallbarcodestock();
				System.out.println(barcodewisestock);
				System.out.println("size of barcode wise stock");
				System.out.println(barcodewisestock.size());
				BarcodeNoWiseStock barcodestock = new BarcodeNoWiseStock();
				barcodestock.setBarcodeNo(billdetailsdto.get(i).getBarcodeNo());
				barcodestock.setBatchNumber(billdetailsdto.get(i).getBatchno());
				barcodestock.setManufactureDate(billdetailsdto.get(i).getManufacturingDate());
				barcodestock.setExpiryDate(billdetailsdto.get(i).getExpiryDate());
				barcodestock.setCompanyName(billdetailsdto.get(i).getCompanyName());
				barcodestock.setColor(billdetailsdto.get(i).getColor());
				barcodestock.setWeight(billdetailsdto.get(i).getWeight());
				barcodestock.setUnit(billdetailsdto.get(i).getUnit());
				barcodestock.setSize(billdetailsdto.get(i).getSize());
				barcodestock.setAvailableQuantity(billdetailsdto.get(i).getQuantity());
				barcodestock.setPackingType(billdetailsdto.get(i).getPackingType());
				barcodestock.setFkAdminId(billdetailsdto.get(i).getFkAdminId());
				barcodestock.setAdminName(billdetailsdto.get(i).getAdminName());
				barcodestock.setFkoragnizationId(billdetailsdto.get(i).getFkOragnizationId());
				barcodestock.setOragnizationName(billdetailsdto.get(i).getOragnizationName());
				barcodestock.setFkcategoryId(billdetailsdto.get(i).getFkCatId());
				barcodestock.setCategoryName(billdetailsdto.get(i).getCategoryName());
				barcodestock.setFkSubCategoryId(billdetailsdto.get(i).getFkSubCatId());
				barcodestock.setSubCategoryName(billdetailsdto.get(i).getSubCategoryName());
				barcodestock.setFkProductId(billdetailsdto.get(i).getFkProductId());
				barcodestock.setProductName(billdetailsdto.get(i).getProductName());
				barcodestock.setCreatedBy(user + "(" + role + ")");
				barcodestock.setCreatedDate(dateString);
				barcodestock.setFkShopId(billdetailsdto.get(i).getFkShopId());
				barcodestock.setShopName(billdetailsdto.get(i).getShopName());
				barcodestock.setUpdateDate(dateString);
				barcodewisestockrepository.save(barcodestock);

			}
		}
		return "bill update successfully";

	}

//	public List<String> getbillinggriddetail(String productId, String role, String fkUserId) {
//		Long fkProductId = Long.parseLong(productId);
//		List<SaleInvoiceGridBean> gridList = new ArrayList<>();
//		List<String> productList = new ArrayList<>();
//		if (role.equals("super-admin")) {
//			productList= goodReceiveRepository.getProductsInBillingGridbyProductIdForSuperAdmin(fkProductId);
//		}
//		if (role.equals("admin")) {
//			Long fkAdminId = Long.parseLong(fkUserId);
//			productList= goodReceiveRepository.getProductsInBillingGridbyProductIdForAdmin(fkProductId, fkAdminId);
//		}
//		if (role.equals("oragnization")) {
//			Long fkoragnizationId = Long.parseLong(fkUserId);
//			productList= goodReceiveRepository.getProductsInBillingGridbyProductIdForOrganization(fkProductId, fkoragnizationId);
//		}
//		if(productList != null)
//		{
//			for(int i=0;i<=productList.size();i++)
//			{
//				gridList. productList.get(i).get
//			}
//		}
//		else
//		{
//			return null;
//		}
		
//	}

	public List<ProductDetails> getbillineditggriddetail(String productname, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return productrepository.getbillingeditgridforsuperadmin(productname);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return productrepository.getbillingeditgridforadmin(productname, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return productrepository.getbillingeditgridfororagnization(productname, fkoragnizationId);
		}
		return null;
	}

	public List<BillDetails> getbillingdetails(String role, String fkUserId) {

		if (role.equals("super-admin")) {
			return billingrepository.getbillingeditgridforsuperadmin();
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return billingrepository.getbillingeditgridforadmin(fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return billingrepository.getbillingeditgridfororagnization(fkoragnizationId);
		}
		return null;
	}

	public BillDetails getlastbillNo() {

		BillDetails bill = billingrepository.findlastbillnoforpdf();

		return bill;
	}

	public List<BillDetails> findbybillNo(Long billNo) {

		return billingrepository.findbybillNo(billNo);
	}
	
	/*
	 * public String getLastEnteredSINumber(String role, String fkUserId) { if
	 * (role.equals("admin")) { Long fkAdminId = Long.parseLong(fkUserId);
	 * List<String> list = billingrepository.getLastSINumber(fkAdminId); String[]
	 * value = list.get(0).split(","); return value[1]; } return null; }
	 */
	
	public String getLastEnteredSINumber(String role, String fkUserId)
	{
		if (role.equals("admin")) {
		Long fkAdminId = Long.parseLong(fkUserId);
			
		List<String> billNumbers = billingrepository.getLastSINumber(fkAdminId);
		
		String OrderNumber;
		if( billNumbers.isEmpty())
		{
			OrderNumber = "0";
		}
		else {
			OrderNumber = billNumbers.get(billNumbers.size() - 1);
		}
		
		return OrderNumber;
		}
		return null;
		
	}
	
	public List<SaleInvoiceGridBean> getsaleinvoicegriddetail(String ProductID, String role, String fkUserId) {
		Long productId = Long.parseLong(ProductID);

		if (role.equals("super-admin")) {
			List<SaleInvoiceGridBean> product = billingrepository.getsaleInvoicegridforsuperadmin(productId);

			return product;

		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);

			List<SaleInvoiceGridBean> product = billingrepository.getsaleInvoicegridforadmin(productId, fkAdminId);

			return product;

		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			List<SaleInvoiceGridBean> product = billingrepository.getsaleInvoicegridfororagnization(productId,
					fkoragnizationId);
			
			return product;
		}

		return null;
	}
	
	public List<SaleInvoiceGridBean> getSQNumberWiseSaleInvoiceGrid(String sqNumber, String fkUserId, String role)
	{
		if (role.equals("super-admin")) {
			List<SaleInvoiceGridBean> product = saleQuotationRepository.getsaleInvoicegridforsuperadmin(sqNumber);

			return product;

		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);

			List<SaleInvoiceGridBean> product = saleQuotationRepository.getsaleInvoicegridforadmin(sqNumber, fkAdminId);

			return product;

		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			List<SaleInvoiceGridBean> product = saleQuotationRepository.getsaleInvoicegridfororagnization(sqNumber, fkoragnizationId);
			
			return product;
		}

		return null;
		
	}
	
	public List<SaleInvoiceGridBean> getSaleInvoiceGridBarcodeNoWise(String role, String fkUserId, String barcodeNo)
	{
		if (role.equals("super-admin")) {
			return billingrepository.getsaleinvoicegridforsuperadmin(barcodeNo);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return billingrepository.getsaleinvoicegridforadmin(barcodeNo, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return billingrepository.getsaleinvoicegridfororagnization(barcodeNo, fkoragnizationId);
		}
		return null;
	}
	
	
	public List<String> getSaleInvoiceNumberList(String role, String fkUserId)
	{
		
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return billingrepository.getSaleInoviceListName(fkAdminId);
		}
     return null;
		
	}
	
	
	//////////////Get Credit Customer method for Cashbook/////////////
	
	public List<String> getCreditCustomerList(String role, String fkUserId)
	{
		
		if (role.equals("super-admin")) {
			return billingrepository.getCreditCustomerListForSuperadmin();
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return billingrepository.getCreditCustomerListForadmin(fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return billingrepository.getCreditCustomerListForOrganization(fkoragnizationId);
		}
		
		
		return null;
	}
	
	
	
	public List<String> getCreditCustomerBillNo(String contactNo)
	{
		return billingrepository.getCreditCustomerBillNo(contactNo);
	}
	
	public List<String> getCreditDetailsByBillNo(Long billNo, String fkUserId, String role)
	{
		if (role.equals("super-admin")) {
			return billingrepository.getCreditDetailsForSuperadmin(billNo);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return billingrepository.getCreditDetailsForAdmin(fkAdminId,billNo);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return billingrepository.getCreditDetailsForOrganization(fkoragnizationId,billNo);
		}
		return null;
	}
	
	

}
