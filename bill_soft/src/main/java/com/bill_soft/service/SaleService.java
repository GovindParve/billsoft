package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.bean.SaleQuotationGrid;
import com.bill_soft.bean.SaleReturnGridBean;
import com.bill_soft.bean.SalesBean;
import com.bill_soft.bean.UpdateSaleQuotationBean;
import com.bill_soft.dto.SaleQuotationDto;
import com.bill_soft.dto.SaleReturnDto;
import com.bill_soft.entity.BarcodeNoWiseStock;
import com.bill_soft.entity.SaleQuotation;
import com.bill_soft.entity.SaleReturn;
import com.bill_soft.entity.Stock;
import com.bill_soft.repository.BarcodeWiseStockRepository;
import com.bill_soft.repository.GoodReceiveRepository;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.SaleQuotationRepository;
import com.bill_soft.repository.SaleReturnRepository;
import com.bill_soft.repository.StockRepository;

@Service
public class SaleService {

	@Autowired
	private SaleQuotationRepository salequotationrepository;
	@Autowired
	private LoginRepository loginrepository;
	@Autowired
	private BarcodeWiseStockRepository barcodewisestockrepository;
	@Autowired
	private StockRepository stockrepository;
	@Autowired
	private SaleReturnRepository salereturnrepository;
	@Autowired
	private GoodReceiveRepository goodReceiveRepository;
	

	public List<String> getSaleQuotationNumberList(String role, String fkUserId) {
		return salequotationrepository.getSaleQuotationNumberList(Long.parseLong(fkUserId));
	}

	public String savesalequotation(List<SaleQuotationDto> salequotatiodto, String role, String fkUserId) {
		Long pkid = Long.parseLong(fkUserId);
		String user = loginrepository.getusernameforcategory(role, pkid);

		if (user.equals(null)) {

			return "UserName Not Found";

		}

		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		List<SaleQuotation> list = new ArrayList<SaleQuotation>();
		for (int i = 0; i<salequotatiodto.size(); i++) {
			SaleQuotation salequotation = new SaleQuotation();

			salequotation.setPkSaleQuatationId(salequotatiodto.get(i).getPkSaleQuatationId());
			salequotation.setSaleQuotationNo(salequotatiodto.get(i).getSaleQuotationNo());
			salequotation.setFkCatId(salequotatiodto.get(i).getFkCatId());
			salequotation.setCategoryName(salequotatiodto.get(i).getCategoryName());
			salequotation.setFksubcatId(salequotatiodto.get(i).getFksubcatId());
			salequotation.setSubCategoryName(salequotatiodto.get(i).getSubCategoryName());
			salequotation.setFkProductId(salequotatiodto.get(i).getFkProductId());
			salequotation.setFkShopId(salequotatiodto.get(i).getFkShopId());
			salequotation.setFkCustomerId(salequotatiodto.get(i).getFkCustomerId());
			salequotation.setProductName(salequotatiodto.get(i).getProductName());
			salequotation.setCustomerName(salequotatiodto.get(i).getCustomerName());
			salequotation.setShopName(salequotatiodto.get(i).getShopName());
			salequotation.setAddress(salequotatiodto.get(i).getAddress());
			salequotation.setEmailId(salequotatiodto.get(i).getEmailId());
			salequotation.setContactNo(salequotatiodto.get(i).getContactNo());
			salequotation.setCompany(salequotatiodto.get(i).getCompany());
			salequotation.setHsnorsac(salequotatiodto.get(i).getHsnorsac());
			salequotation.setWeight(salequotatiodto.get(i).getWeight());
			salequotation.setSalePriceIncludingTax(salequotatiodto.get(i).getSalePriceInclusiveTax());
			salequotation.setSalePriceExcludingTax(salequotatiodto.get(i).getSalePriceExclusiveTax());
			salequotation.setQuantity(salequotatiodto.get(i).getQuantity());
			salequotation.setUnit(salequotatiodto.get(i).getUnit());
			salequotation.setDiscount(salequotatiodto.get(i).getDiscount());
			salequotation.setDiscountAmount(salequotatiodto.get(i).getDiscountAmount());
			salequotation.setCgst(salequotatiodto.get(i).getCgst());
			salequotation.setSgst(salequotatiodto.get(i).getSgst());
			salequotation.setIgst(salequotatiodto.get(i).getIgst());
			salequotation.setTaxPercentage(salequotatiodto.get(i).getTaxPercentage());
			salequotation.setLabourTaxAmount(salequotatiodto.get(i).getLabourTaxAmount());
			salequotation.setTaxAmount(salequotatiodto.get(i).getTaxAmount());
			salequotation.setBarcodeNo(salequotatiodto.get(i).getBarcodeNo());
			salequotation.setTotalExcludingTax(salequotatiodto.get(i).getTotalExcludingTax());
			salequotation.setTotalAmount(salequotatiodto.get(i).getTotalAmount());

			salequotation.setGrossTotal(salequotatiodto.get(i).getGrossTotal());
			salequotation.setGstExpense(salequotatiodto.get(i).getGstExpense());
			salequotation.setGstNo(salequotatiodto.get(i).getGstNo());
			salequotation.setLabourExpense(salequotatiodto.get(i).getLabourExpense());
			salequotation.setPaymentMode(salequotatiodto.get(i).getPaymentMode());
			salequotation.setQuotationDate(dateString);
			salequotation.setTransportExpense(salequotatiodto.get(i).getTransportExpense());
			salequotation.setFkAdminId(salequotatiodto.get(i).getFkAdminId());
			salequotation.setAdminName(salequotatiodto.get(i).getAdminName());
			salequotation.setFkoragnizationId(salequotatiodto.get(i).getFkoragnizationId());
			salequotation.setOragnizationName(salequotatiodto.get(i).getOragnizationName());
			salequotation.setStatus("Active");
			salequotation.setCreatedBy(user + "(" + role + ")");
			salequotation.setCreatedDate(dateString);
			list.add(salequotation);
			//salequotationrepository.saveAll(list);
		}
		salequotationrepository.saveAll(list);
		return "saved";
	}

	public String saleQuotationUpdate(List<UpdateSaleQuotationBean> salequotatioGriddto, String role, String fkUserId) {
		Long pkid = Long.parseLong(fkUserId);
		// List<Long> Quotations = new ArrayList<>();
		String user = loginrepository.getusernameforcategory(role, pkid);

		if (user.equals(null)) {

			return "UserName Not Found";

		}

		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < salequotatioGriddto.size(); i++) {

			SaleQuotation salequotation = new SaleQuotation();

			salequotation.setPkSaleQuatationId(salequotatioGriddto.get(i).getPkSaleQuatationId());

			salequotation.setSaleQuotationNo(salequotatioGriddto.get(i).getQuotationNumber());
			salequotation.setFkCatId(salequotatioGriddto.get(i).getFkCatId());
			salequotation.setCategoryName(salequotatioGriddto.get(i).getCategoryName());
			salequotation.setFksubcatId(salequotatioGriddto.get(i).getFksubcatId());
			salequotation.setSubCategoryName(salequotatioGriddto.get(i).getSubCategoryName());
			salequotation.setFkProductId(salequotatioGriddto.get(i).getFkProductId());
			salequotation.setFkShopId(salequotatioGriddto.get(i).getFkShopId());
			salequotation.setFkCustomerId(salequotatioGriddto.get(i).getFkCustomerId());
			salequotation.setProductName(salequotatioGriddto.get(i).getProductName());
			salequotation.setCustomerName(salequotatioGriddto.get(i).getCustomerName());
			salequotation.setShopName(salequotatioGriddto.get(i).getShopName());
			salequotation.setAddress(salequotatioGriddto.get(i).getAddress());
			salequotation.setEmailId(salequotatioGriddto.get(i).getEmailId());
			salequotation.setCompany(salequotatioGriddto.get(i).getCompany());
			salequotation.setHsnorsac(salequotatioGriddto.get(i).getHsnsac());
			salequotation.setWeight(salequotatioGriddto.get(i).getWeight());
			salequotation.setSalePriceIncludingTax(salequotatioGriddto.get(i).getSalePriceInclusiveTax());
			salequotation.setSalePriceExcludingTax(salequotatioGriddto.get(i).getSalePriceExclusiveTax());
			salequotation.setQuantity(salequotatioGriddto.get(i).getQuantity());
			salequotation.setUnit(salequotatioGriddto.get(i).getUnit());
			salequotation.setDiscount(salequotatioGriddto.get(i).getDiscount());
			salequotation.setDiscountAmount(salequotatioGriddto.get(i).getDiscountAmount());
			salequotation.setCgst(salequotatioGriddto.get(i).getCgst());
			salequotation.setSgst(salequotatioGriddto.get(i).getSgst());
			salequotation.setIgst(salequotatioGriddto.get(i).getIgst());
			salequotation.setTaxPercentage(salequotatioGriddto.get(i).getTaxPercentage());
			salequotation.setLabourTaxAmount(salequotatioGriddto.get(i).getLabourTaxAmount());
			salequotation.setTaxAmount(salequotatioGriddto.get(i).getTaxAmount());
			salequotation.setBarcodeNo(salequotatioGriddto.get(i).getBarcodeNo());
			salequotation.setTotalExcludingTax(salequotatioGriddto.get(i).getTotalExcludingTax());
			salequotation.setTotalAmount(salequotatioGriddto.get(i).getTotalAmount());
			salequotation.setContactNo(salequotatioGriddto.get(i).getContactNo());
			salequotation.setGrossTotal(salequotatioGriddto.get(i).getGrossTotal());
			salequotation.setGstExpense(salequotatioGriddto.get(i).getGstExpense());
			salequotation.setGstNo(salequotatioGriddto.get(i).getGstNo());
			salequotation.setLabourExpense(salequotatioGriddto.get(i).getLabourExpenses());
			salequotation.setPaymentMode(salequotatioGriddto.get(i).getPaymentMode());
			salequotation.setQuotationDate(dateString);
			salequotation.setTransportExpense(salequotatioGriddto.get(i).getTransportExpenses());
			salequotation.setLabourTaxAmount(salequotatioGriddto.get(i).getLabourTaxAmount());
			salequotation.setFkAdminId(salequotatioGriddto.get(i).getFkAdminId());
			salequotation.setAdminName(salequotatioGriddto.get(i).getAdminName());
			salequotation.setFkoragnizationId(salequotatioGriddto.get(i).getFkoragnizationId());
			salequotation.setOragnizationName(salequotatioGriddto.get(i).getOragnizationName());
			salequotation.setStatus(salequotatioGriddto.get(i).getStatus());
			salequotation.setCreatedBy(user + "(" + role + ")");
			salequotation.setCreatedDate(dateString);
			salequotation.setStatus("Active");
			  
			  SaleQuotation salequotation2 = salequotationrepository.save(salequotation);
			  list.add(salequotation2.getPkSaleQuatationId());

		}
		
		List<Long> list2= salequotationrepository.getAllPkSaleQuotationId(salequotatioGriddto.get(0).getQuotationNumber());
		
		list2.removeAll(list);
		for(int i=0;i<list2.size();i++) {
			salequotationrepository.getSaleQuotatationDeactiveForUpdate(list2.get(i));
		}

		return "saved";
	}

	public String savesalereturnsetails(List<SaleReturnDto> salereturndto, String role, String fkUserId) {
		Long pkid = Long.parseLong(fkUserId);
		String user = loginrepository.getusernameforcategory(role, pkid);

//		if (user.equals(null)) {
//
//			return "UserName Not Found";
//
//		}

		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		List<SaleReturn> list = new ArrayList<SaleReturn>();
		for (int i = 0; i < salereturndto.size(); i++) {
			SaleReturn salereturn = new SaleReturn();
			salereturn.setCustomerName(salereturndto.get(i).getCustomerName());
			salereturn.setContactNo(salereturndto.get(i).getContactNo());
			salereturn.setBillNo(salereturndto.get(i).getBillNo());
			Long catId = salereturndto.get(i).getFkcategoryId();
			salereturn.setFkcategoryId(salereturndto.get(i).getFkcategoryId());
			salereturn.setCategoryName(salereturndto.get(i).getCategoryName());
			Long subcatId = salereturndto.get(i).getFkSubCategoryId();
			salereturn.setFkSubCategoryId(salereturndto.get(i).getFkSubCategoryId());
			salereturn.setSubCategoryName(salereturndto.get(i).getSubCategoryName());
			Long productId = salereturndto.get(i).getFkProductId();
			salereturn.setFkProductId(salereturndto.get(i).getFkProductId());
			salereturn.setProductName(salereturndto.get(i).getProductName());
			salereturn.setCompany(salereturndto.get(i).getCompany());
			salereturn.setColor(salereturndto.get(i).getColor());
			salereturn.setBarcodeNo(salereturndto.get(i).getBarcodeNo());
			salereturn.setAvailableQuantity(salereturndto.get(i).getAvailableQuantity());
			Double quantity = salereturndto.get(i).getReturnQuantity();
			salereturn.setReturnQuantity(salereturndto.get(i).getReturnQuantity());
			salereturn.setHsnsac(salereturndto.get(i).getHsnsac());
			salereturn.setWeight(salereturndto.get(i).getWeight());
			salereturn.setUnit(salereturndto.get(i).getUnit());

			salereturn.setCgst(salereturndto.get(i).getCgst());
			salereturn.setSgst(salereturndto.get(i).getSgst());
			salereturn.setIgst(salereturndto.get(i).getIgst());
			salereturn.setTaxPercentage(salereturndto.get(i).getTaxPercentage());
			salereturn.setTaxAmount(salereturndto.get(i).getTaxAmount());
			salereturn.setTotalExcludingTax(salereturndto.get(i).getTotalExcludingTax());
			salereturn.setTotalAmount(salereturndto.get(i).getTotalAmount());
			salereturn.setBatchNo(salereturndto.get(i).getBatchNo());
			salereturn.setManufacture_date(salereturndto.get(i).getManufactureDate());

			salereturn.setExpiryDate(salereturndto.get(i).getExpiryDate());
			salereturn.setDiscount(salereturndto.get(i).getDiscount());
			salereturn.setDiscountAmount(salereturndto.get(i).getDiscountAmount());
			salereturn.setSalePriceExcludingTax(salereturndto.get(i).getSalePriceExcludingTax());
			salereturn.setSalePriceIncludingTax(salereturndto.get(i).getSalePriceIncludingTax());
			salereturn.setCreatedBy(user + "(" + role + ")");
			salereturn.setCreatedDate(dateString);
			salereturn.setFkShopId(salereturndto.get(i).getFkShopId());
			salereturn.setShopName(salereturndto.get(i).getShopName());
			salereturn.setFkAdminId(salereturndto.get(i).getFkAdminId());
			salereturn.setAdminName(salereturndto.get(i).getAdminName());
			salereturn.setFkOragnizationId(salereturndto.get(i).getFkOragnizationId());
			salereturn.setOragnizationName(salereturndto.get(i).getOragnizationName());
			salereturn.setGrossTotal(salereturndto.get(i).getGrossTotal());
			salereturn.setMrp(salereturndto.get(i).getMrp());
			salereturn.setPackingType(salereturndto.get(i).getPackingType());
			salereturn.setReturnDate(dateString);
			salereturn.setReturnTotal(salereturndto.get(i).getReturnTotal());
			salereturn.setSize(salereturndto.get(i).getSize());
			list.add(salereturn);
			salereturnrepository.saveAll(list);

			System.out.println("sale return list" + list);
			System.out.println("\nstock update start");
			List<Stock> stock2 = stockrepository.getAllStockentry();
			if (stock2.size() == 0) {
				System.out.println("if stock list is 0 " + stock2.size());
				Stock stock = new Stock();
				stock.setFkcategoryId(salereturndto.get(i).getFkcategoryId());
				stock.setCategoryName(salereturndto.get(i).getCategoryName());
				stock.setFkSubCategoryId(salereturndto.get(i).getFkSubCategoryId());
				stock.setSubCategoryName(salereturndto.get(i).getSubCategoryName());
				stock.setFkProductId(salereturndto.get(i).getFkProductId());
				stock.setProductName(salereturndto.get(i).getProductName());
				stock.setQuantity(salereturndto.get(i).getReturnQuantity());
				stock.setManufactureDate(salereturndto.get(i).getManufactureDate());
				stock.setExpiryDate(salereturndto.get(i).getExpiryDate());
				stock.setAvailableQuantity(salereturndto.get(i).getAvailableQuantity());
				stock.setPackingType("unpacked");
				if (salereturndto.get(i).getBatchNo() != null) {
					stock.setBatchNumber(salereturndto.get(i).getBatchNo());
				} else {
					stock.setBatchNumber("N/A");
				}
				if (salereturndto.get(i).getUnit() != null) {
					stock.setUnit(salereturndto.get(i).getUnit());
				} else {
					stock.setUnit("N/A");
				}
				if (salereturndto.get(i).getWeight() != null) {
					stock.setWeight(salereturndto.get(i).getWeight());
				} else {
					stock.setWeight(0d);
				}
				stock.setUpdateDate(dateString);
				stock.setCompanyName(salereturndto.get(i).getCompany());
				stock.setFkShopId(salereturndto.get(i).getFkShopId());
				stock.setShopName(salereturndto.get(i).getShopName());
				stock.setFkAdminId(salereturndto.get(i).getFkAdminId());
				stock.setAdminName(salereturndto.get(i).getAdminName());
				stock.setFkoragnizationId(salereturndto.get(i).getFkOragnizationId());
				stock.setOragnizationName(salereturndto.get(i).getOragnizationName());
				stock.setCreatedBy(user + "(" + role + ")");
				stock.setCreatedDate(dateString);
				stockrepository.save(stock);
			} else {
				for (int j = 0; j < stock2.size(); j++) {
					Stock st = (Stock) stock2.get(j);
					Long fkcatId = st.getFkcategoryId();
					Long fkproductId = st.getFkProductId();
					Long fksubcatId = st.getFkSubCategoryId();
					Long stockId = st.getPkStockId();

					System.out.println("\n ++++ if product name is already present in stock ++");

					if ((productId == fkproductId) && (catId == fkcatId) && (subcatId == fksubcatId)) {
						System.out.println("To update stock");
						// Long Stockid=stockrepository.getstockid(fkproductId);
						Double qty = st.getAvailableQuantity();
						Double updatedQuantity = qty + quantity;
						Stock updatestock = new Stock();

						updatestock.setPkStockId(stockId);
						updatestock.setFkcategoryId(salereturndto.get(i).getFkcategoryId());
						updatestock.setCategoryName(salereturndto.get(i).getCategoryName());
						updatestock.setFkSubCategoryId(salereturndto.get(i).getFkSubCategoryId());
						updatestock.setSubCategoryName(salereturndto.get(i).getSubCategoryName());
						updatestock.setFkProductId(salereturndto.get(i).getFkProductId());
						updatestock.setProductName(salereturndto.get(i).getProductName());
						updatestock.setQuantity(salereturndto.get(i).getAvailableQuantity());
						updatestock.setManufactureDate(salereturndto.get(i).getManufactureDate());
						updatestock.setExpiryDate(salereturndto.get(i).getExpiryDate());
						// updatestock.setAvailableQuantity(goodreceivedto.get(i).getQuantity());
						updatestock.setAvailableQuantity(updatedQuantity);
						updatestock.setUpdateDate(dateString);
						updatestock.setPackingType("unpacked");
						if (salereturndto.get(i).getBatchNo() != null) {
							updatestock.setBatchNumber(salereturndto.get(i).getBatchNo());
						} else {
							updatestock.setBatchNumber("N/A");
						}
						if (salereturndto.get(i).getUnit() != null) {
							updatestock.setUnit(salereturndto.get(i).getUnit());
						} else {
							updatestock.setUnit("N/A");
						}
						if (salereturndto.get(i).getWeight() != null) {
							updatestock.setWeight(salereturndto.get(i).getWeight());
						} else {
							updatestock.setWeight(0d);
						}

						updatestock.setCompanyName(salereturndto.get(i).getCompany());
						updatestock.setFkShopId(salereturndto.get(i).getFkShopId());
						updatestock.setShopName(salereturndto.get(i).getShopName());
						updatestock.setFkAdminId(salereturndto.get(i).getFkAdminId());
						updatestock.setAdminName(salereturndto.get(i).getAdminName());
						updatestock.setFkoragnizationId(salereturndto.get(i).getFkOragnizationId());
						updatestock.setOragnizationName(salereturndto.get(i).getOragnizationName());
						updatestock.setCreatedBy(user + "(" + role + ")");
						updatestock.setCreatedDate(dateString);
						// stockrepository.updateavailablequantity(updatedQuantity,dateString,fkproductId);
						stockrepository.save(updatestock);

					} else {
						if (j + 1 == stock2.size()) {
							System.out.println(" if product is not present in stock");
							Stock newentry = new Stock();
							newentry.setFkcategoryId(salereturndto.get(i).getFkcategoryId());
							newentry.setCategoryName(salereturndto.get(i).getCategoryName());
							newentry.setFkSubCategoryId(salereturndto.get(i).getFkSubCategoryId());
							newentry.setSubCategoryName(salereturndto.get(i).getSubCategoryName());
							newentry.setFkProductId(salereturndto.get(i).getFkProductId());
							newentry.setProductName(salereturndto.get(i).getProductName());
							newentry.setQuantity(salereturndto.get(i).getReturnQuantity());
							newentry.setManufactureDate(salereturndto.get(i).getManufactureDate());
							newentry.setExpiryDate(salereturndto.get(i).getExpiryDate());
							newentry.setAvailableQuantity(salereturndto.get(i).getReturnQuantity());
							newentry.setPackingType("unpacked");
							if (salereturndto.get(i).getBatchNo() != null) {
								newentry.setBatchNumber(salereturndto.get(i).getBatchNo());
							} else {
								newentry.setBatchNumber("N/A");
							}
							if (salereturndto.get(i).getUnit() != null) {
								newentry.setUnit(salereturndto.get(i).getUnit());
							} else {
								newentry.setUnit("N/A");
							}
							if (salereturndto.get(i).getWeight() != null) {
								newentry.setWeight(salereturndto.get(i).getWeight());
							} else {
								newentry.setWeight(0d);
							}
							newentry.setUpdateDate(dateString);
							newentry.setCompanyName(salereturndto.get(i).getCompany());
							newentry.setFkShopId(salereturndto.get(i).getFkShopId());
							newentry.setShopName(salereturndto.get(i).getShopName());
							newentry.setFkAdminId(salereturndto.get(i).getFkAdminId());
							newentry.setAdminName(salereturndto.get(i).getAdminName());
							newentry.setFkoragnizationId(salereturndto.get(i).getFkOragnizationId());
							newentry.setOragnizationName(salereturndto.get(i).getOragnizationName());
							newentry.setCreatedBy(user + "(" + role + ")");
							newentry.setCreatedDate(dateString);
							stockrepository.save(newentry);

						}

					}
				}
			}
			List<BarcodeNoWiseStock> barcodewisestock = barcodewisestockrepository.getallbarcodestock();
			System.out.println(barcodewisestock);
			System.out.println("size of barcode wise stock");
			System.out.println(barcodewisestock.size());
			BarcodeNoWiseStock barcodestock = new BarcodeNoWiseStock();
			barcodestock.setBarcodeNo(salereturndto.get(i).getBarcodeNo());
			barcodestock.setBatchNumber(salereturndto.get(i).getBatchNo());
			barcodestock.setManufactureDate(salereturndto.get(i).getManufactureDate());
			barcodestock.setExpiryDate(salereturndto.get(i).getExpiryDate());
			barcodestock.setCompanyName(salereturndto.get(i).getCompany());
			barcodestock.setColor(salereturndto.get(i).getColor());
			barcodestock.setWeight(salereturndto.get(i).getWeight());
			barcodestock.setUnit(salereturndto.get(i).getUnit());
			barcodestock.setSize(salereturndto.get(i).getSize());
			barcodestock.setAvailableQuantity(salereturndto.get(i).getReturnQuantity());
			barcodestock.setPackingType(salereturndto.get(i).getPackingType());
			barcodestock.setFkAdminId(salereturndto.get(i).getFkAdminId());
			barcodestock.setAdminName(salereturndto.get(i).getAdminName());
			barcodestock.setFkoragnizationId(salereturndto.get(i).getFkOragnizationId());
			barcodestock.setOragnizationName(salereturndto.get(i).getOragnizationName());
			barcodestock.setFkcategoryId(salereturndto.get(i).getFkcategoryId());
			barcodestock.setCategoryName(salereturndto.get(i).getCategoryName());
			barcodestock.setFkSubCategoryId(salereturndto.get(i).getFkSubCategoryId());
			barcodestock.setSubCategoryName(salereturndto.get(i).getSubCategoryName());
			barcodestock.setFkProductId(salereturndto.get(i).getFkProductId());
			barcodestock.setProductName(salereturndto.get(i).getProductName());
			barcodestock.setCreatedBy(user + "(" + role + ")");
			barcodestock.setCreatedDate(dateString);
			barcodestock.setFkShopId(salereturndto.get(i).getFkShopId());
			barcodestock.setShopName(salereturndto.get(i).getShopName());
			barcodestock.setUpdateDate(dateString);
			barcodewisestockrepository.save(barcodestock);

		}
		return "sale return successfully";
	}

	public List<SaleQuotationGrid> getsalequotationgriddetail(String ProductID, String role, String fkUserId) {
		Long productId = Long.parseLong(ProductID);

		if (role.equals("super-admin")) {
			List<SaleQuotationGrid> product = goodReceiveRepository.getsalequotationgridforsuperadmin(productId);

			return product;

		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);

			List<SaleQuotationGrid> product = goodReceiveRepository.getsalequotationgridforadmin(productId, fkAdminId);

			return product;

		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			List<SaleQuotationGrid> product = goodReceiveRepository.getsalequotationgridfororagnization(productId,
					fkoragnizationId);

			return product;
		}

		return null;
	}

	public List<SaleReturnGridBean> getsalereturngriddetail(Long invoiceNumber, Long fkUserId) {

		return salereturnrepository.getsalereturngrid(invoiceNumber, fkUserId);
	}

	public String getLastEnteredSQNumber(String role, String fkUserId) {

		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			List<String> SqNumber = salequotationrepository.getLastEnteredSQNumberForAdmin(fkAdminId);
			//System.out.println(SqNumber.get(0)); 
			String saleQuotationNumber;
			if(SqNumber.isEmpty()) {
				saleQuotationNumber = "0";
			}else 
			{
				
				saleQuotationNumber = SqNumber.get(0);
			}
			return saleQuotationNumber;

		}

		return null;
	}

	public List<SaleQuotationGrid> getSaleQuotationGridBarcodeNoWise(String role, String fkUserId, String barcodeNo) {
		if (role.equals("super-admin")) {
			return salequotationrepository.getsalequotationgridforsuperadmin(barcodeNo);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return salequotationrepository.getsalequotationgridforadmin(barcodeNo, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return salequotationrepository.getsalequotationgridfororagnization(barcodeNo, fkoragnizationId);
		}
		return null;
	}

	////////////////////////////
	/// Update Sale Quoataion////
	////////////////////////////

	public List<SaleQuotation> getSaleQuotationDetailsIdWise(String sqNumber, String fkUserId, String role) {
		if (role.equals("super-admin")) {
			return salequotationrepository.getSaleQuotationDetailsIdWiseForSuperadmin(sqNumber);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return salequotationrepository.getSaleQuotationDetailsIdWiseForAdmin(fkAdminId, sqNumber);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return salequotationrepository.getSaleQuotationDetailsIdWiseForOrganisation(fkoragnizationId, sqNumber);
		}
		return null;
	}
	
	public List<SalesBean> getSaleUpdateGridByBarcodeNo(String role, String fkUserId, String barcodeNo) {
		if (role.equals("super-admin")) {
			return salequotationrepository.getsalequotationUpdategridforsuperadmin(barcodeNo);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return salequotationrepository.getsalequotationUpdategridforadmin(barcodeNo, fkAdminId);
		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return salequotationrepository.getsalequotationUpdategridfororagnization(barcodeNo, fkoragnizationId);
		}
		return null;
	}

	public List<SaleQuotation> getGridForSaleQuotationUpdate(String quotationNumber, Long fkUserId) {
		return salequotationrepository.getGridForSaleQuotationRepository(quotationNumber, fkUserId);
	}
	
	public List<SalesBean> getUpdatesalequotationgriddetail(String ProductID, String role, String fkUserId) {
		Long productId = Long.parseLong(ProductID);

		if (role.equals("super-admin")) {
			List<SalesBean> product = goodReceiveRepository.getupdatesalequotationgridforsuperadmin(productId);

			return product;
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);

			List<SalesBean> product = goodReceiveRepository.getupdatesalequotationgridforadmin(productId, fkAdminId);

			return product;

		}

		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			List<SalesBean> product = goodReceiveRepository.getsaleupdatequotationgridfororagnization(productId,
					fkoragnizationId);

			return product;
		}

		return null;
	}
	

}
