package com.bill_soft.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.bean.GoodReceiveGridBean;
import com.bill_soft.dto.GoodReceiveDto;
import com.bill_soft.entity.BarcodeNoWiseStock;
import com.bill_soft.entity.GoodReceive;
import com.bill_soft.entity.ProductDetails;
import com.bill_soft.entity.PurchaseOrder;
import com.bill_soft.entity.PurchaseQuotation;
import com.bill_soft.entity.Stock;
import com.bill_soft.repository.BarcodeWiseStockRepository;
import com.bill_soft.repository.GoodReceiveRepository;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.ProductRepository;
import com.bill_soft.repository.PurchaseOrderRepository;
import com.bill_soft.repository.PurchaseQuotationRepository;
import com.bill_soft.repository.StockRepository;

@Service
public class GoodReceiveService {

	@Autowired
	private GoodReceiveRepository goodreceiverepository;
	@Autowired
	private LoginRepository loginrepository;
	@Autowired
	private BarcodeWiseStockRepository barcodewisestockrepository;
	@Autowired
	private StockRepository stockrepository;
	@Autowired
	private ProductRepository productrepository;
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	@Autowired
	private PurchaseQuotationRepository purchaseQuotationRepository;

	public String savegoodreceive(List<GoodReceiveDto> goodreceivedto, String role, String fkUserId) {

		Long pkid = Long.parseLong(fkUserId);
		String user = loginrepository.getusernameforcategory(role, pkid);
		
		
		LocalDate date = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		Long lastbarcode = null;
		List<GoodReceive> list1 = new ArrayList<GoodReceive>();
		for (int i = 0; i < goodreceivedto.size(); i++) {
			
			GoodReceive goodreceive = new GoodReceive();

			
			if (goodreceivedto.get(i).getFkPurchaseOrderId() != null) {
				goodreceive.setFkPurchaseOrderId(goodreceivedto.get(i).getFkPurchaseOrderId());
			} else {
				goodreceive.setFkPurchaseOrderId(0l);
			}
			if (goodreceivedto.get(i).getPurchaseOrderNumber() != null) {
				goodreceive.setPurchaseOrderNumber(goodreceivedto.get(i).getPurchaseOrderNumber());
			} else {
				goodreceive.setPurchaseOrderNumber(0l);
			}
			if (goodreceivedto.get(i).getFkPurchaseQuotationId() != null) {
				goodreceive.setFkPurchaseQuotationId(goodreceivedto.get(i).getFkPurchaseQuotationId());
			} else {
				goodreceive.setFkPurchaseQuotationId(0l);
			}
			if (goodreceivedto.get(i).getQuotationNumber() != null) {
				goodreceive.setQuotationNumber(goodreceivedto.get(i).getQuotationNumber());
			}
			else {
				goodreceive.setQuotationNumber(0l);
			}
			if (goodreceivedto.get(i).getTotalExcludingTax() != null) {
				goodreceive.setTotalExcludingTax(goodreceivedto.get(i).getTotalExcludingTax());
			} else {
				goodreceive.setTotalExcludingTax(0d);
			}
			if(goodreceivedto.get(i).getContactNo() != null)
			{
				goodreceive.setContactNo(goodreceivedto.get(i).getContactNo());
			}else
			{
				goodreceive.setContactNo("N/A");
			}
			
			if(goodreceivedto.get(i).getGoodReceiveNumber() != null)
			{
				goodreceive.setGoodReceiveNumber(goodreceivedto.get(i).getGoodReceiveNumber());
			}else
			{
				goodreceive.setGoodReceiveNumber(0l);
			}
			Long catId = goodreceivedto.get(i).getFkCategoryId();
			goodreceive.setFkCategoryId(goodreceivedto.get(i).getFkCategoryId());
			goodreceive.setCategoryName(goodreceivedto.get(i).getCategoryName());
			Long subcatId = goodreceivedto.get(i).getFkSubCategoryId();
			goodreceive.setFkSubCategoryId(goodreceivedto.get(i).getFkSubCategoryId());
			goodreceive.setSubCategoryName(goodreceivedto.get(i).getSubCategoryName());
			goodreceive.setFkSupplierId(goodreceivedto.get(i).getFkSupplierId());
			goodreceive.setSupplierName(goodreceivedto.get(i).getSupplierName());
			Long productId = goodreceivedto.get(i).getFkProductId();
			goodreceive.setFkProductId(goodreceivedto.get(i).getFkProductId());
			goodreceive.setProductName(goodreceivedto.get(i).getProductName());
			goodreceive.setBillNo(goodreceivedto.get(i).getBillNo());
			if (goodreceivedto.get(i).getBuyPriceExcludingTax() != null) {
				goodreceive.setBuyPriceExcludingTax(goodreceivedto.get(i).getBuyPriceExcludingTax());
			} else {
				goodreceive.setBuyPriceExcludingTax(0d);
			}
			if (goodreceivedto.get(i).getBuyPriceIncludingTax() != null) {
				goodreceive.setBuyPriceIncludingTax(goodreceivedto.get(i).getBuyPriceIncludingTax());
			} else {
				goodreceive.setBuyPriceIncludingTax(0d);
			}
			if (goodreceivedto.get(i).getDiscount() != null) {
				goodreceive.setDiscount(goodreceivedto.get(i).getDiscount());
			} else {
				goodreceive.setDiscount(0d);
			}
			if (goodreceivedto.get(i).getDiscountAmount() != null) {
				goodreceive.setDiscountAmount(goodreceivedto.get(i).getDiscountAmount());
			} else {
				goodreceive.setDiscountAmount(0d);
			}

			if (goodreceivedto.get(i).getSalePrice() != null) {
				goodreceive.setSalePrice(goodreceivedto.get(i).getSalePrice());
			} else {
				goodreceive.setSalePrice(0d);
			}

			if (goodreceivedto.get(i).getMrp() != null) {
				goodreceive.setMrp(goodreceivedto.get(i).getMrp());
			} else {
				goodreceive.setSalePrice(0d);
			}
			Double quantity = goodreceivedto.get(i).getQuantity();
			if (goodreceivedto.get(i).getQuantity() != null) {
				goodreceive.setQuantity(goodreceivedto.get(i).getQuantity());
			} else {
				goodreceive.setQuantity(0d);
			}
			if (goodreceivedto.get(i).getHsnsac() != null) {
				goodreceive.setHsnsac(goodreceivedto.get(i).getHsnsac());
			} else {
				goodreceive.setHsnsac("0");
			}
			
			  // If the Product is Barcode Based then Increment the Barcode Number by 1 and if the Product
			 // is not barcode based then it will not apply above logic of increment one
			
			ProductDetails product = productrepository.getproductForBarcode(goodreceivedto.get(i).getFkProductId());
			
			String IBP2 = product.getIsBarcodeProduct();
			
			if(IBP2.contains("Y"))
			{
				Long fkAdminId = Long.parseLong(goodreceivedto.get(i).getFkAdminId().toString());
				
					try {
						if( i ==0) {
						    String barcode = barcodewisestockrepository.getLastEnteredBarcode(fkAdminId);
						    if (barcode != null || barcode != "")
						    {
							  lastbarcode = Long.parseLong(barcode);
							 // lastbarcode++;
							  System.out.println("Barcode Number on Server is"+lastbarcode );
						    }
						}
						}catch(Exception e)
						{
							System.out.println("No Barcode Number in database");
							lastbarcode = 999l;
						}
				
				 
				if(lastbarcode != null)
				{ 
					lastbarcode++;
					goodreceive.setBarcodeNo(lastbarcode.toString());
				}
			
			}else if(IBP2.contains("N")) {
				goodreceive.setBarcodeNo("N/A");
			}
			
			
			if (goodreceivedto.get(i).getBatchNo() != null) {
				goodreceive.setBatchNo(goodreceivedto.get(i).getBatchNo());
			} else {
				goodreceive.setBatchNo("N/A");
			}
			if (goodreceivedto.get(i).getWeight() != null) {
				goodreceive.setWeight(goodreceivedto.get(i).getWeight());
			} else {
				goodreceive.setWeight(0d);
			}
			if (goodreceivedto.get(i).getRollSize() != null) {
				goodreceive.setRollSize(goodreceivedto.get(i).getRollSize());
			} else {
				goodreceive.setRollSize(0d);
			}
			if (goodreceivedto.get(i).getStyle() != null) {
				goodreceive.setStyle(goodreceivedto.get(i).getStyle());
			} else {
				goodreceive.setStyle("N/A");
			}
			if (goodreceivedto.get(i).getTotalQuantity() != null) {
				goodreceive.setTotalQuantity(goodreceivedto.get(i).getTotalQuantity());
			} else {
				goodreceive.setTotalQuantity(0d);
			}

			if (goodreceivedto.get(i).getUnit() != null) {
				goodreceive.setUnit(goodreceivedto.get(i).getUnit());
			} else {
				goodreceive.setUnit("N/A");
			}

			if (goodreceivedto.get(i).getSgst() != null) {
				goodreceive.setSgst(goodreceivedto.get(i).getSgst());
			} else {
				goodreceive.setSgst(0d);
			}
			if (goodreceivedto.get(i).getCgst() != null) {
				goodreceive.setCgst(goodreceivedto.get(i).getCgst());
			} else {
				goodreceive.setCgst(0d);
			}
			goodreceive.setManufactureDate(goodreceivedto.get(i).getManufactureDate());
			goodreceive.setExpiryDate(goodreceivedto.get(i).getExpiryDate());

			if (goodreceivedto.get(i).getIgst() != null) {
				goodreceive.setIgst(goodreceivedto.get(i).getIgst());
			} else {
				goodreceive.setIgst(0d);
			}
			if (goodreceivedto.get(i).getTaxPercentage() != null) {
				goodreceive.setTaxPercentage(goodreceivedto.get(i).getTaxPercentage());
			} else {
				goodreceive.setTaxPercentage(0d);
			}
			if (goodreceivedto.get(i).getTaxAmount() != null) {
				goodreceive.setTaxAmount(goodreceivedto.get(i).getTaxAmount());
			} else {
				goodreceive.setTaxAmount(0d);
			}
			if (goodreceivedto.get(i).getTotalAmount() != null) {
				goodreceive.setTotalAmount(goodreceivedto.get(i).getTotalAmount());
			}

			else {
				goodreceive.setTotalAmount(0d);
			}
			if (goodreceivedto.get(i).getGrossTotal() != null) {
				goodreceive.setGrossTotal(goodreceivedto.get(i).getGrossTotal());

			} else {
				goodreceive.setGrossTotal(0d);
			}
			if (goodreceivedto.get(i).getLabourExpense() != null) {
				goodreceive.setLabourExpense(goodreceivedto.get(i).getLabourExpense());
			} else {
				goodreceive.setLabourExpense(0d);
			}
			if (goodreceivedto.get(i).getTransportExpense() != null) {
				goodreceive.setTransportExpense(goodreceivedto.get(i).getTransportExpense());
			} else {
				goodreceive.setTransportExpense(0d);
			}
			if (goodreceivedto.get(i).getGstForExpense() != null) {
				goodreceive.setGstForExpense(goodreceivedto.get(i).getGstForExpense());
			} else {
				goodreceive.setGstForExpense(0d);
			}

			if (goodreceivedto.get(i).getTotalTaxAmount() != null) {
				goodreceive.setTotalTaxAmount(goodreceivedto.get(i).getTotalTaxAmount());
			} else {
				goodreceive.setTotalTaxAmount(0d);
			}
			
			if (goodreceivedto.get(i).getSupplierUnPaidAmt() != null) {
				goodreceive.setSupplierUnPaidAmt(goodreceivedto.get(i).getSupplierUnPaidAmt());
			} else {
				goodreceive.setSupplierUnPaidAmt(0d);
			}
			

			goodreceive.setCompany(goodreceivedto.get(i).getCompany());
			goodreceive.setFkShopId(goodreceivedto.get(i).getFkShopId());
			goodreceive.setShopName(goodreceivedto.get(i).getShopName());
			goodreceive.setFkAdminId(goodreceivedto.get(i).getFkAdminId());
			goodreceive.setAdminName(goodreceivedto.get(i).getAdminName());
			goodreceive.setFkoragnizationId(goodreceivedto.get(i).getFkoragnizationId());
			goodreceive.setOragnizationName(goodreceivedto.get(i).getOragnizationName());
			goodreceive.setCreatedBy(user + "(" + role + ")");
			goodreceive.setCreatedDate(dateString);
			list1.add(goodreceive);
			goodreceiverepository.saveAll(list1);

			System.out.println("good receive list" + list1);
			System.out.println("\nstock update start");
			List<Stock> stock2 = stockrepository.getAllStockentry();
			System.out.println("stock :-" + stock2);
			if (stock2.size() == 0) {
				System.out.println("if stock list is 0 " + stock2.size());
				Stock stock = new Stock();
				stock.setFkcategoryId(goodreceivedto.get(i).getFkCategoryId());
				stock.setCategoryName(goodreceivedto.get(i).getCategoryName());
				stock.setFkSubCategoryId(goodreceivedto.get(i).getFkSubCategoryId());
				stock.setSubCategoryName(goodreceivedto.get(i).getSubCategoryName());
				stock.setFkProductId(goodreceivedto.get(i).getFkProductId());
				stock.setProductName(goodreceivedto.get(i).getProductName());
				stock.setQuantity(goodreceivedto.get(i).getQuantity());
				stock.setManufactureDate(goodreceivedto.get(i).getManufactureDate());
				stock.setExpiryDate(goodreceivedto.get(i).getExpiryDate());
				stock.setAvailableQuantity(goodreceivedto.get(i).getQuantity());
				stock.setPackingType("unpacked");
				if (goodreceivedto.get(i).getBatchNo() != null) {
					stock.setBatchNumber(goodreceivedto.get(i).getBatchNo());
				} else {
					stock.setBatchNumber("N/A");
				}
				if (goodreceivedto.get(i).getUnit() != null) {
					stock.setUnit(goodreceivedto.get(i).getUnit());
				} else {
					stock.setUnit("N/A");
				}
				if (goodreceivedto.get(i).getWeight() != null) {
					stock.setWeight(goodreceivedto.get(i).getWeight());
				} else {
					stock.setWeight(0d);
				}
				stock.setUpdateDate(dateString);
				stock.setCompanyName(goodreceivedto.get(i).getCompany());
				stock.setFkShopId(goodreceivedto.get(i).getFkShopId());
				stock.setShopName(goodreceivedto.get(i).getShopName());
				stock.setFkAdminId(goodreceivedto.get(i).getFkAdminId());
				stock.setAdminName(goodreceivedto.get(i).getAdminName());
				stock.setFkoragnizationId(goodreceivedto.get(i).getFkoragnizationId());
				stock.setOragnizationName(goodreceivedto.get(i).getOragnizationName());
				stock.setCreatedBy(user + "(" + role + ")");
				stock.setCreatedDate(dateString);
				stockrepository.save(stock);
			}

			else {
				System.out.println("if stock is not empty");
				for (int j = 0; j < stock2.size(); j++) {
					Stock st = (Stock) stock2.get(j);
					Long fkcatId = st.getFkcategoryId();
					Long fkproductId = st.getFkProductId();
					Long fksubcatId = st.getFkSubCategoryId();
					Long stockId = st.getPkStockId();

					System.out.println("\n ++++ if product name is already present in stock ++");

				//	List<String> pList = stockrepository.getproductDetails();
					if ((productId == fkproductId) && (catId == fkcatId) && (subcatId == fksubcatId)) {
						System.out.println("To update stock");
						Double qty = st.getAvailableQuantity();
						Double updatedQuantity = qty + quantity;
						Stock updatestock = new Stock();

						updatestock.setPkStockId(stockId);
						updatestock.setFkcategoryId(goodreceivedto.get(i).getFkCategoryId());
						updatestock.setCategoryName(goodreceivedto.get(i).getCategoryName());
						updatestock.setFkSubCategoryId(goodreceivedto.get(i).getFkSubCategoryId());
						updatestock.setSubCategoryName(goodreceivedto.get(i).getSubCategoryName());
						updatestock.setFkProductId(goodreceivedto.get(i).getFkProductId());
						updatestock.setProductName(goodreceivedto.get(i).getProductName());
						updatestock.setQuantity(goodreceivedto.get(i).getQuantity());
						updatestock.setManufactureDate(goodreceivedto.get(i).getManufactureDate());
						updatestock.setExpiryDate(goodreceivedto.get(i).getExpiryDate());
						updatestock.setAvailableQuantity(updatedQuantity);
						updatestock.setUpdateDate(dateString);
						updatestock.setPackingType("unpacked");
						if (goodreceivedto.get(i).getBatchNo() != null) {
							updatestock.setBatchNumber(goodreceivedto.get(i).getBatchNo());
						} else {
							updatestock.setBatchNumber("N/A");
						}
						if (goodreceivedto.get(i).getUnit() != null) {
							updatestock.setUnit(goodreceivedto.get(i).getUnit());
						} else {
							updatestock.setUnit("N/A");
						}
						if (goodreceivedto.get(i).getWeight() != null) {
							updatestock.setWeight(goodreceivedto.get(i).getWeight());
						} else {
							updatestock.setWeight(0d);
						}

						updatestock.setCompanyName(goodreceivedto.get(i).getCompany());
						updatestock.setFkShopId(goodreceivedto.get(i).getFkShopId());
						updatestock.setShopName(goodreceivedto.get(i).getShopName());
						updatestock.setFkAdminId(goodreceivedto.get(i).getFkAdminId());
						updatestock.setAdminName(goodreceivedto.get(i).getAdminName());
						updatestock.setFkoragnizationId(goodreceivedto.get(i).getFkoragnizationId());
						updatestock.setOragnizationName(goodreceivedto.get(i).getOragnizationName());
						updatestock.setCreatedBy(user + "(" + role + ")");
						updatestock.setCreatedDate(dateString);
						stockrepository.save(updatestock);

					} else {
						if (j + 1 == stock2.size()) {
							System.out.println(" if product is not present in stock");
							Stock newentry = new Stock();
							newentry.setFkcategoryId(goodreceivedto.get(i).getFkCategoryId());
							newentry.setCategoryName(goodreceivedto.get(i).getCategoryName());
							newentry.setFkSubCategoryId(goodreceivedto.get(i).getFkSubCategoryId());
							newentry.setSubCategoryName(goodreceivedto.get(i).getSubCategoryName());
							newentry.setFkProductId(goodreceivedto.get(i).getFkProductId());
							newentry.setProductName(goodreceivedto.get(i).getProductName());
							newentry.setQuantity(goodreceivedto.get(i).getQuantity());
							newentry.setManufactureDate(goodreceivedto.get(i).getManufactureDate());
							newentry.setExpiryDate(goodreceivedto.get(i).getExpiryDate());
							newentry.setAvailableQuantity(goodreceivedto.get(i).getQuantity());
							newentry.setPackingType("unpacked");
							if (goodreceivedto.get(i).getBatchNo() != null) {
								newentry.setBatchNumber(goodreceivedto.get(i).getBatchNo());
							} else {
								newentry.setBatchNumber("N/A");
							}
							if (goodreceivedto.get(i).getUnit() != null) {
								newentry.setUnit(goodreceivedto.get(i).getUnit());
							} else {
								newentry.setUnit("N/A");
							}
							if (goodreceivedto.get(i).getWeight() != null) {
								newentry.setWeight(goodreceivedto.get(i).getWeight());
							} else {
								newentry.setWeight(0d);
							}
							newentry.setUpdateDate(dateString);
							newentry.setCompanyName(goodreceivedto.get(i).getCompany());
							newentry.setFkShopId(goodreceivedto.get(i).getFkShopId());
							newentry.setShopName(goodreceivedto.get(i).getShopName());
							newentry.setFkAdminId(goodreceivedto.get(i).getFkAdminId());
							newentry.setAdminName(goodreceivedto.get(i).getAdminName());
							newentry.setFkoragnizationId(goodreceivedto.get(i).getFkoragnizationId());
							newentry.setOragnizationName(goodreceivedto.get(i).getOragnizationName());
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
			if(lastbarcode != null )
			{
				
			barcodestock.setBarcodeNo((lastbarcode).toString());
			}
			barcodestock.setBatchNumber(goodreceivedto.get(i).getBatchNo());
			barcodestock.setManufactureDate(goodreceivedto.get(i).getManufactureDate());
			barcodestock.setExpiryDate(goodreceivedto.get(i).getExpiryDate());
			barcodestock.setCompanyName(goodreceivedto.get(i).getCompany());
			barcodestock.setColor(goodreceivedto.get(i).getColor());
			barcodestock.setWeight(goodreceivedto.get(i).getWeight());
			barcodestock.setUnit(goodreceivedto.get(i).getUnit());
			barcodestock.setSize(goodreceivedto.get(i).getSize());
			barcodestock.setAvailableQuantity(goodreceivedto.get(i).getQuantity());
			barcodestock.setFkAdminId(goodreceivedto.get(i).getFkAdminId());
			barcodestock.setAdminName(goodreceivedto.get(i).getAdminName());
			barcodestock.setFkoragnizationId(goodreceivedto.get(i).getFkoragnizationId());
			barcodestock.setOragnizationName(goodreceivedto.get(i).getOragnizationName());
			barcodestock.setFkcategoryId(goodreceivedto.get(i).getFkCategoryId());
			barcodestock.setCategoryName(goodreceivedto.get(i).getCategoryName());
			barcodestock.setFkSubCategoryId(goodreceivedto.get(i).getFkSubCategoryId());
			barcodestock.setSubCategoryName(goodreceivedto.get(i).getSubCategoryName());
			barcodestock.setFkProductId(goodreceivedto.get(i).getFkProductId());
			barcodestock.setProductName(goodreceivedto.get(i).getProductName());
			barcodestock.setCreatedBy(user + "(" + role + ")");
			barcodestock.setCreatedDate(dateString);
			barcodestock.setFkShopId(goodreceivedto.get(i).getFkShopId());
			barcodestock.setShopName(goodreceivedto.get(i).getShopName());
			barcodestock.setUpdateDate(dateString);
			barcodewisestockrepository.save(barcodestock);

		}

		return "saved";

	}

	public List<GoodReceiveGridBean> getgoodreceivegrid(String productId, String role, String fkUserId) {
		List<ProductDetails> products = new ArrayList<>();
		List<GoodReceiveGridBean> grid = new ArrayList<>();
		if (role.equals("super-admin")) {
			products = productrepository.getgoodreceivegridforsuperadmin(Long.parseLong(productId));
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			products = productrepository.getgoodreceivegridforadmin(Long.parseLong(productId), fkAdminId);
		}
		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			products = productrepository.getgoodreceivegridfororagnization(Long.parseLong(productId), fkoragnizationId);

		}

		for (int i = 0; i < products.size(); i++) {
			GoodReceiveGridBean bean = new GoodReceiveGridBean();

			bean.setPkProductId(products.get(i).getPkProductId());
			bean.setProductName(products.get(i).getProductName());
			bean.setFkCategoryId(products.get(i).getFkCategoryId());
			bean.setCategoryName(products.get(i).getCategoryName());
			bean.setFkSubCategoryId(products.get(i).getFkSubCategoryId());
			bean.setSubcategoryName(products.get(i).getSubcategoryName());
			bean.setFkShopId(products.get(i).getFkShopId());
			bean.setShopName(products.get(i).getShopName());
			bean.setFkAdminId(products.get(i).getFkAdminId());
			bean.setAdminName(products.get(i).getAdminName());
			bean.setFkTaxId(products.get(i).getFkTaxId());
			bean.setFkUnitId(products.get(i).getFkUnitId());
			bean.setFkoragnizationId(products.get(i).getFkoragnizationId());
			bean.setOragnizationName(products.get(i).getOragnizationName());
			Double gst = products.get(i).getCgst() + products.get(i).getSgst();
			bean.setGst(gst);
			bean.setIgst(products.get(i).getIgst());
			bean.setManufactureCompany(products.get(i).getManufactureCompany());
			bean.setWeight(products.get(i).getWeight());
			bean.setUnit(products.get(i).getUnit());
			bean.setRollSize(products.get(i).getRollSize());
			bean.setSize(products.get(i).getSize());
			bean.setModelName(products.get(i).getModelName());
			bean.setColor(products.get(i).getColor());
			bean.setStyle(products.get(i).getStyle());
			bean.setBuyPriceIncludingTax(products.get(i).getBuyPriceIncludingTax());
			bean.setBuyPriceExcludingTax(0d);
			bean.setPurchaseDiscount(products.get(i).getPurchaseDiscount());
			bean.setSalePriceIncludingTax(products.get(i).getSalePriceIncludingTax());
			bean.setSaleDiscount(products.get(i).getSaleDiscount());
			bean.setMrp(products.get(i).getMrp());
			bean.setTax(products.get(i).getTax());
			bean.setHsnCode(products.get(i).getHsnCode());
			bean.setIsBarcodeProduct(products.get(i).getIsBarcodeProduct());
			bean.setDiscription(products.get(i).getDiscription());
			bean.setUnitQuantity(products.get(i).getUnitQuantity());
			bean.setCreatedDate(products.get(i).getCreatedDate());
			bean.setCreatedBy(products.get(i).getCreatedBy());
			

			grid.add(bean);
		}

		return grid;
	}
	
	public List<String> getGoodReceiveNumber(Long fkAdminId)
	{
		return goodreceiverepository.getGoodReceiveNumber(fkAdminId);
	}
	
	public List<GoodReceiveGridBean> getgoodreceivegridByPONumber(Long poNumber, String role, Long fkUserId) {
		List<PurchaseOrder> pqDetails = new ArrayList<>();
		List<GoodReceiveGridBean> grid = new ArrayList<>();

		if (role.equals("super-admin")) {
			pqDetails = purchaseOrderRepository.getpurchaseorderNumberdetailsbyquotationnumberforsuperadmin(poNumber);
		}
		if (role.equals("admin")) {
			Long fkAdminId = fkUserId;
			pqDetails = purchaseOrderRepository.getpurchaseorderNumberdetailsbyquotationnumberforadmin(poNumber,
					fkAdminId);
		}
		if (role.equals("oragnization")) {
			Long fkoragnizationId = fkUserId;
			pqDetails = purchaseOrderRepository.getpurchaseorderNumberdetailsbyquotationnumberforOragnization(poNumber,
					fkoragnizationId);

		}

		for (int i = 0; i < pqDetails.size(); i++) {
			GoodReceiveGridBean bean = new GoodReceiveGridBean();

			bean.setPkPurchaseOrderId(pqDetails.get(i).getPkPurchaseOrderId());
			bean.setQuotationNumber(pqDetails.get(i).getQuotationNumber());
			bean.setPkPurchaseQuotationId(pqDetails.get(i).getFkPurchaseQuotationId());

			bean.setFkSupplierId(pqDetails.get(i).getFkSupplierId());
			bean.setSupplierName(pqDetails.get(i).getSupplierName());
			bean.setEmailId(pqDetails.get(i).getEmailId());
			bean.setCity(pqDetails.get(i).getCity());
			bean.setAddress(pqDetails.get(i).getAddress());
			bean.setContactNo(pqDetails.get(i).getContactNo());
			bean.setGstNo(pqDetails.get(i).getGstNo());
			bean.setPkProductId(pqDetails.get(i).getFkProductId());
			bean.setProductName(pqDetails.get(i).getProductName());
			bean.setFkCategoryId(pqDetails.get(i).getFkCategoryId());
			bean.setCategoryName(pqDetails.get(i).getCategoryName());
			bean.setFkSubCategoryId(pqDetails.get(i).getFkSubCategoryId());
			bean.setSubcategoryName(pqDetails.get(i).getSubCategoryName());
			bean.setFkShopId(pqDetails.get(i).getFkShopId());
			bean.setShopName(pqDetails.get(i).getShopName());
			bean.setFkAdminId(pqDetails.get(i).getFkAdminId());
			bean.setAdminName(pqDetails.get(i).getAdminName());
			bean.setFkoragnizationId(pqDetails.get(i).getFkoragnizationId());
			bean.setOragnizationName(pqDetails.get(i).getOragnizationName());
			
			Double gst = 0d;
			if(pqDetails.get(i).getCgst() != null || pqDetails.get(i).getSgst() != null )
			{
			gst= pqDetails.get(i).getCgst() + pqDetails.get(i).getSgst();
			}
			bean.setGst(gst);
			
			
			bean.setIgst(pqDetails.get(i).getIgst());
			bean.setWeight(pqDetails.get(i).getWeight());
			bean.setUnit(pqDetails.get(i).getUnit());
			bean.setRollSize(pqDetails.get(i).getRollSize());
			bean.setSize(pqDetails.get(i).getSize());
			bean.setColor(pqDetails.get(i).getColor());
			bean.setStyle(pqDetails.get(i).getStyle());
			bean.setBuyPriceIncludingTax(pqDetails.get(i).getBuyPriceIncludingTax());
			bean.setBuyPriceExcludingTax(pqDetails.get(i).getBuyPriceExcludingTax());
			bean.setPurchaseDiscount(0d);
			bean.setSalePriceIncludingTax(pqDetails.get(i).getSalePrice());
			bean.setBarcodeNo(pqDetails.get(i).getBarcodeNo());
			bean.setSaleDiscount(0d);
			bean.setMrp(pqDetails.get(i).getMrp());
			bean.setTaxpercentage(pqDetails.get(i).getTaxpercentage());
			bean.setHsnCode(pqDetails.get(i).getHsnsacc());
			bean.setUnitQuantity(pqDetails.get(i).getQuantity());
			bean.setCreatedDate(pqDetails.get(i).getCreatedDate());
			bean.setCreatedBy(pqDetails.get(i).getCreatedBy());
			bean.setQuantity(pqDetails.get(i).getQuantity());
			bean.setTaxAmount(pqDetails.get(i).getTaxAmount());
			bean.setTotalExcludingTax(pqDetails.get(i).getTotalExcludingTax());
			bean.setTotalAmount(pqDetails.get(i).getTotalAmount());
			bean.setPaymentMode(pqDetails.get(i).getPaymentMode());
			bean.setLabourExpence(pqDetails.get(i).getLabourExpense());
			bean.setGrossTotal(pqDetails.get(i).getGrossTotal());
			bean.setTransportExpence(pqDetails.get(i).getTransportExpense());

			grid.add(bean);
		}

		return grid;
	}
	
	public List<GoodReceiveGridBean> getgoodreceivegridByPQNumber(Long pqNumber, String role, Long fkUserId) {
		List<PurchaseQuotation> pqDetails = new ArrayList<>();
		List<GoodReceiveGridBean> grid = new ArrayList<>();

		if (role.equals("super-admin")) {
			pqDetails = purchaseQuotationRepository
					.getpurchasequotationnumberdetailsbyquotationnumberforsuperadmin(pqNumber);
		}
		if (role.equals("admin")) {
			Long fkAdminId = fkUserId;
			pqDetails = purchaseQuotationRepository.getpurchasequotationnumberdetailsbyquotationnumberforadmin(pqNumber,
					fkAdminId);
		}
		if (role.equals("oragnization")) {
			Long fkoragnizationId = fkUserId;
			pqDetails = purchaseQuotationRepository
					.getpurchasequotationnumberdetailsbyquotationnumberforOragnization(pqNumber, fkoragnizationId);

		}

		for (int i = 0; i < pqDetails.size(); i++) {
			GoodReceiveGridBean bean = new GoodReceiveGridBean();

			bean.setQuotationNumber(pqDetails.get(i).getQuotationNumber());
			bean.setPkPurchaseQuotationId(pqDetails.get(i).getPkPurchaseQuotationId());
			bean.setFkSupplierId(pqDetails.get(i).getFkSupplierId());
			bean.setSupplierName(pqDetails.get(i).getSupplierName());
			bean.setEmailId(pqDetails.get(i).getEmailId());
			bean.setCity(pqDetails.get(i).getCity());
			bean.setAddress(pqDetails.get(i).getAddress());
			bean.setContactNo(pqDetails.get(i).getContactNo());
			bean.setGstNo(pqDetails.get(i).getGstNo());
			bean.setQuotationDate(pqDetails.get(i).getQuotationDate());
			bean.setPkProductId(pqDetails.get(i).getFkProductId());
			bean.setProductName(pqDetails.get(i).getProductName());
			bean.setFkCategoryId(pqDetails.get(i).getFkCategoryId());
			bean.setCategoryName(pqDetails.get(i).getCategoryName());
			bean.setFkSubCategoryId(pqDetails.get(i).getFkSubCategoryId());
			bean.setSubcategoryName(pqDetails.get(i).getSubCategoryName());
			bean.setFkShopId(pqDetails.get(i).getFkShopId());
			bean.setShopName(pqDetails.get(i).getShopName());
			bean.setFkAdminId(pqDetails.get(i).getFkAdminId());
			bean.setAdminName(pqDetails.get(i).getAdminName());
			bean.setFkoragnizationId(pqDetails.get(i).getFkoragnizationId());
			bean.setOragnizationName(pqDetails.get(i).getOragnizationName());
			Double gst = pqDetails.get(i).getCgst() + pqDetails.get(i).getSgst();
			bean.setGst(gst);
			bean.setIgst(pqDetails.get(i).getIgst());
			bean.setWeight(pqDetails.get(i).getWeight());
			bean.setUnit(pqDetails.get(i).getUnit());
			bean.setRollSize(pqDetails.get(i).getRollSize());
			bean.setSize(pqDetails.get(i).getSize());
			bean.setColor(pqDetails.get(i).getColor());
			bean.setStyle(pqDetails.get(i).getStyle());
			bean.setBuyPriceIncludingTax(pqDetails.get(i).getBuyPriceIncludingTax());
			bean.setBuyPriceExcludingTax(pqDetails.get(i).getBuyPriceExcludingTax());
			bean.setPurchaseDiscount(0d);
			bean.setSalePriceIncludingTax(pqDetails.get(i).getSalePrice());
			bean.setBarcodeNo(pqDetails.get(i).getBarcodeNo());
			bean.setSaleDiscount(0d);
			bean.setMrp(pqDetails.get(i).getMrp());
			bean.setTaxpercentage(pqDetails.get(i).getTaxpercentage());
			bean.setHsnCode(pqDetails.get(i).getHsnsacc());
			bean.setUnitQuantity(pqDetails.get(i).getQuantity());
			bean.setCreatedDate(pqDetails.get(i).getCreatedDate());
			bean.setCreatedBy(pqDetails.get(i).getCreatedBy());
			bean.setQuantity(pqDetails.get(i).getQuantity());
			bean.setTaxAmount(pqDetails.get(i).getTaxAmount());
			bean.setTotalExcludingTax(pqDetails.get(i).getTotalExcludingTax());
			bean.setTotalAmount(pqDetails.get(i).getTotalAmount());
			bean.setPaymentMode(pqDetails.get(i).getPaymentMode());
			bean.setLabourExpence(pqDetails.get(i).getLabourExpence());
			bean.setGrossTotal(pqDetails.get(i).getGrossTotal());
			bean.setTransportExpence(pqDetails.get(i).getTransportExpence());

			grid.add(bean);
		}

		return grid;
	}

	
	public List<String> getSupplierListForCashBook(String role, String fkUserId)
	{
		List<String> supplierList = new ArrayList<>();
		if (role.equals("super-admin")) {
			supplierList = goodreceiverepository.getSupplierListForCashBookSuperAdmin();
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			supplierList = goodreceiverepository.getSupplierListForCashBookAdmin(fkAdminId);
		}
		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			supplierList = goodreceiverepository.getSupplierListForCashBookOrganization(fkoragnizationId);

		}
		
		return supplierList;
	}
	
	public List<String> getbillNoListForCashBook(String role, String fkUserId, Long fkSupplierId)
	{
		List<String> supplierList = new ArrayList<>();
		if (role.equals("super-admin")) {
			supplierList = goodreceiverepository.getbillNoListForCashBookSuperAdmin(fkSupplierId);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			supplierList = goodreceiverepository.getbillNoListForCashBookAdmin(fkAdminId,fkSupplierId);
		}
		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			supplierList = goodreceiverepository.getbillNoListForCashBookOrganization(fkoragnizationId, fkSupplierId);

		}
		
		return supplierList;
	}
	
	

}
