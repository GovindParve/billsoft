package com.bill_soft.service;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bill_soft.dto.ProductDto;
import com.bill_soft.entity.ProductDetails;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private LoginRepository  loginrepository;

	public String addproductdetails(List<ProductDto> productdto,String role,String fkUserId) 
	{
		if(role.equals("super-admin") || role.equals("oragnization") || role.equals("admin") )
		{
			 Long pkid=Long.parseLong(fkUserId);
			String user=loginrepository.getusernameforcategory(role,pkid);
			 if(user.equals(null))
				{
					return "UserName Not Found";
				}
			 List<ProductDetails> listbean=new ArrayList<ProductDetails>();
			 int count=0;
			 for(int i=0; i< productdto.size(); i++)
			 {
						 
				 String productName=productdto.get(i).getProductName();
					ProductDetails productNameexist=productrepository.findbyproductname(productName);

					if(productNameexist==null)
					{
						
					LocalDate date=LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String dateString = date.format(formatter);
				ProductDetails product=new ProductDetails();
				product.setPkProductId(productdto.get(i).getPkProductId());
				product.setProductName(productdto.get(i).getProductName());
				product.setFkShopId(productdto.get(i).getFkShopId());
				product.setShopName(productdto.get(i).getShopName());
				product.setFkAdminId(productdto.get(i).getFkAdminId());
				product.setAdminName(productdto.get(i).getAdminName());
				product.setFkoragnizationId(productdto.get(i).getFkoragnizationId());
				product.setOragnizationName(productdto.get(i).getOragnizationName());
				product.setFkCategoryId(productdto.get(i).getFkCategoryId());
				product.setCategoryName(productdto.get(i).getCategoryName());
				product.setFkSubCategoryId(productdto.get(i).getFkSubCategoryId());
				product.setSubcategoryName(productdto.get(i).getSubcategoryName());
				if(productdto.get(i).getFkTaxId()!=null)
				{
					product.setFkTaxId(productdto.get(i).getFkTaxId());
				}
				else
				{
					product.setFkTaxId(0l);
				}
				product.setFkUnitId(productdto.get(i).getFkUnitId());
			if(productdto.get(i).getWeight() !=null)
			{
				product.setWeight(productdto.get(i).getWeight());
			}
			else
			{
				product.setWeight(0d);
			}
				
				
				if(productdto.get(i).getRollSize()!=null)
				{
					product.setRollSize(productdto.get(i).getRollSize());
				}
				else
				{
					product.setRollSize(0d);
				}
				
				if(productdto.get(i).getSize()!=null)
				{
					
			product.setSize(productdto.get(i).getSize());
				}
				else
				{
					product.setSize("N/A");
				}
				if(productdto.get(i).getColor()!=null)
				{
					product.setColor(productdto.get(i).getColor());
				}

				else
				{
					product.setColor("N/A");
				}
				
				product.setDiscription(productdto.get(i).getDiscription());
				product.setBuyPriceIncludingTax(productdto.get(i).getBuyPriceIncludingTax());
				
				if(productdto.get(i).getPurchaseDiscount()!=null)
				{
				product.setPurchaseDiscount(productdto.get(i).getPurchaseDiscount());
				}
				else
				{
					product.setPurchaseDiscount(0d);
				}
				if(productdto.get(i).getSaleDiscount() != null)
				{
				product.setSaleDiscount(productdto.get(i).getSaleDiscount());
				}
				else
				{
					product.setSaleDiscount(0d);
				}
				product.setHsnCode(productdto.get(i).getHsnCode());
				product.setImagePath(productdto.get(i).getImagePath());
				product.setManufactureCompany(productdto.get(i).getManufactureCompany());
				product.setIsBarcodeProduct(productdto.get(i).getIsBarcodeProduct());
				if(productdto.get(i).getStyle()!=null)
				{
					product.setStyle(productdto.get(i).getStyle());
				}
				else
				{
					product.setStyle("N/A");
				}
				if(productdto.get(i).getModelName()!=null)
				{
				product.setModelName(productdto.get(i).getModelName());
				}
				
				else
				{
					product.setModelName("N/A");
				}
				product.setMrp(productdto.get(i).getMrp());
				product.setSalePriceIncludingTax(productdto.get(i).getSalePriceIncludingTax());
				if(productdto.get(i).getUnit()!=null)
				{
					product.setUnit(productdto.get(i).getUnit());
				}
				else
				{
					product.setUnit("N/A");
				}
				product.setUnitQuantity(1d);
				if(productdto.get(i).getTax() !=null)
				{
				product.setTax(productdto.get(i).getTax());
				}
				else
				{
					product.setTax(0d);
				}
				if(productdto.get(i).getCgst()!=null)
				{
					product.setCgst(productdto.get(i).getCgst());
				}
				else
				{
					product.setCgst(0d);
				}
				
				if(productdto.get(i).getSgst()!=null)
				{
					product.setSgst(productdto.get(i).getSgst());
				}
				else
				{
					product.setSgst(0d);
				}
				if(productdto.get(i).getIgst()!=null)
				{
					product.setIgst(productdto.get(i).getIgst());
				}
				else
				{
					product.setIgst(0d);
				}
				product.setCreatedDate(dateString);
				product.setCreatedBy(user+"(" + role +")");
				listbean.add(product);
				   count++;
					}
  
			 }
					productrepository.saveAll(listbean);
			   
			     
		
		int count1=productdto.size();
		if(count==count1)	 
		{
			return "product successfully added"+" "+ count +" "+" product added";
		}
		else
		{
			return "only" +" "+ count+" "+"product  are saved OR product already exist...!..";
		}
		}
		return "You Don't have access to add product deatils";
		
	}
    
					
		
					
				
			
			
			
			
	

public List<ProductDetails> getproductlist(String role,String fkUserId) {
	if(role.equals("super-admin"))
			{
		return productrepository.getproductlistforsuperadmin();
			}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
     return productrepository.getproductlistfororagnization(fkOragnizationId);
	}	
	
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
	    return productrepository.getproductlistforadmin(fkAdminId);
		}	
	return null;
	}

public Optional<ProductDetails> getproducttoedit(Long id,String role,String fkUserId) {
	
	if (role.equals("super-admin")) {
		return productrepository.getproducteditforsuperadmin(id);
	}
	if (role.equals("oragnization")) {
		Long fkOragnizationId=Long.parseLong(fkUserId);
		return productrepository.getproducteditfororagnization(id,fkOragnizationId);
	}

	if (role.equals("admin")) {
		Long fkAdminId=Long.parseLong(fkUserId);
		return productrepository.getproducteditforadmin(id,fkAdminId);
	}
	return null;

	//return productrepository.findById(id);
}

public String updateproduct(ProductDto productdto,String role,String fkUserId) {
	if(role.equals("super-admin") || role.equals("oragnization") || role.equals("admin") )
	{
		 Long pkid=Long.parseLong(fkUserId);
		String user=loginrepository.getusernameforcategory(role,pkid);
		 if(user.equals(null))
			{
				return "UserName Not Found";
			}
		LocalDate date=LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
	ProductDetails product=new ProductDetails();
	product.setPkProductId(productdto.getPkProductId());
	product.setProductName(productdto.getProductName());
	product.setFkShopId(productdto.getFkShopId());
	product.setShopName(productdto.getShopName());
	product.setFkAdminId(productdto.getFkAdminId());
	product.setAdminName(productdto.getAdminName());
	product.setFkoragnizationId(productdto.getFkoragnizationId());
	product.setOragnizationName(productdto.getOragnizationName());
	product.setFkCategoryId(productdto.getFkCategoryId());
	product.setCategoryName(productdto.getCategoryName());
	product.setFkSubCategoryId(productdto.getFkSubCategoryId());
	product.setSubcategoryName(productdto.getSubcategoryName());
	product.setWeight(productdto.getWeight());
	product.setRollSize(productdto.getRollSize());
	product.setSize(productdto.getSize());
	product.setColor(productdto.getColor());
	product.setDiscription(productdto.getDiscription());
	product.setBuyPriceIncludingTax(productdto.getBuyPriceIncludingTax());
	product.setPurchaseDiscount(0d);
	product.setSaleDiscount(null);
	product.setHsnCode(productdto.getHsnCode());
	product.setImagePath(productdto.getImagePath());
	product.setManufactureCompany(productdto.getManufactureCompany());
	product.setModelName(productdto.getModelName());
	product.setMrp(productdto.getMrp());
	product.setSalePriceIncludingTax(productdto.getSalePriceIncludingTax());
	product.setUnit(productdto.getUnit());
	product.setUnitQuantity(productdto.getUnitQuantity());
	product.setTax(productdto.getTax());
	product.setCgst(productdto.getCgst());
	product.setSgst(productdto.getSgst());
	product.setIgst(productdto.getIgst());
	product.setCreatedDate(dateString);
	product.setCreatedBy(user+"(" + role +")");
	
    productrepository.save(product);
}
	
return "You Don't have access to update product deatils";
	
}

public List<String> getproducdropdowntlist(String role,String fkUserId) {
	if(role.equals("super-admin"))
	{
		return productrepository.getproductdropdownlistforsuperadmin();
		}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		return productrepository.getproductdropdownlistfororagnization(fkOragnizationId);
	}	
	
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		return productrepository.getproductdropdownlistforadmin(fkAdminId);
	}	
	return null;
}

public List<String> getproducdropdowntlistForSales(String role,String fkUserId) {
	
	
	if(role.equals("super-admin"))
	{
		return productrepository.getproductdropdownlistforsuperadmin();
		}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		return productrepository.getproductdropdownlistfororagnization(fkOragnizationId);
	}	
	
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		return productrepository.getproductdropdownlistforadmin(fkAdminId);
	}	
		return null;
}



public String bulkuploadproductdetails(MultipartFile files, String role, String fkUserId) throws IOException,EncryptedDocumentException,InvalidFormatException,ParseException
{

	XSSFWorkbook workbook=new XSSFWorkbook(files.getInputStream());
	XSSFSheet sheet=workbook.getSheetAt(0);

	int count=0;
	for(int i=1; i< sheet.getPhysicalNumberOfRows(); i++)
	{
		if(i > 0)
		{
		Long fkCategoryId=null;
			ProductDetails productdetails=new ProductDetails();
			XSSFRow row=sheet.getRow(i);
			try {
			 fkCategoryId=(long) row.getCell(0,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
			 if(fkCategoryId==null)
				{
					break;
				}
			
			
			String categoryName=row.getCell(1,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			Long fkSubCategoryId=(long) row.getCell(2,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			String subcategoryName=row.getCell(3,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			Long fkShopId=(long) row.getCell(4,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			String shopName=row.getCell(5,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			Long fkAdminId=(long) row.getCell(6,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			String adminName=row.getCell(7,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			Long fkTaxId=(long) row.getCell(8,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Long fkoragnizationId=(long) row.getCell(9,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			String oragnizationName=row.getCell(10,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			Long fkUnitId=(long) row.getCell(11,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			String manufactureCompany=row.getCell(12,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String productName=row.getCell(13,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			
			Long packing=(long) row.getCell(14,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double rollSize= row.getCell(15,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Long size=(long) row.getCell(16,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			String modelName=row.getCell(17,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String colour=row.getCell(18,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String discription=row.getCell(19,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String imagePath=row.getCell(20,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String unit=row.getCell(21,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String unitType=row.getCell(22,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			Long hsnCode= (long) row.getCell(23,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double weight=row.getCell(24,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double tax=row.getCell(25,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double buyPrice=row.getCell(26,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double buyPriceIncludingTax=row.getCell(27,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double salePrice=row.getCell(28,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double salePriceIncludingTax=row.getCell(29,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double mrp=row.getCell(30,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double discount=row.getCell(31,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double cgst=row.getCell(32,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double sgst=row.getCell(33,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			Double igst=row.getCell(34,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
	//Double unitQuantity=row.getCell(35,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			
			Long pkid=Long.parseLong(fkUserId);
			String user=loginrepository.getusernameforcategory(role,pkid);
			 if(user.equals(null))
				{
					return "UserName Not Found";
				}
			LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
			ProductDetails product=productrepository.findbyproductname(productName);
			if(product==null)
			{
			productdetails.setFkCategoryId(fkCategoryId);
			productdetails.setCategoryName(categoryName);
			productdetails.setFkSubCategoryId(fkSubCategoryId);
			productdetails.setSubcategoryName(subcategoryName);
			productdetails.setFkAdminId(fkAdminId);
			productdetails.setAdminName(adminName);
			productdetails.setFkoragnizationId(fkoragnizationId);
			productdetails.setOragnizationName(oragnizationName);
			productdetails.setFkShopId(fkShopId);
			productdetails.setShopName(shopName);
			productdetails.setProductName(productName);
			productdetails.setFkTaxId(fkTaxId);
			productdetails.setFkUnitId(fkUnitId);
			productdetails.setColor(colour);
			productdetails.setWeight(weight);
			//productdetails.setBuyPrice(buyPrice);
			//productdetails.setSalePrice(salePrice);
			//productdetails.setDiscount(discount);
			productdetails.setDiscription(discription);
			productdetails.setHsnCode(hsnCode.toString());
			productdetails.setCgst(cgst);
			productdetails.setSgst(sgst);
			productdetails.setIgst(igst);
			productdetails.setImagePath(imagePath);
			productdetails.setManufactureCompany(manufactureCompany);
			productdetails.setModelName(modelName);
			productdetails.setMrp(mrp);
			//productdetails.setPacking(packing.toString());
			productdetails.setRollSize(rollSize);
			productdetails.setSize(size.toString());
			//productdetails.setSalePrice(salePrice);
			productdetails.setSalePriceIncludingTax(salePriceIncludingTax);
			//productdetails.setBuyPrice(buyPrice);
			productdetails.setBuyPriceIncludingTax(buyPriceIncludingTax);
			productdetails.setDiscription(discription);
			productdetails.setTax(tax);
			productdetails.setUnitQuantity(1d);
			//productdetails.setUnitType(unitType);
			productdetails.setUnit(unit);
			productdetails.setWeight(weight);
			productdetails.setCreatedBy(user+"(" + role +")");
			productdetails.setCreatedDate(dateString);
			productrepository.save(productdetails);
			count++;
			System.out.println("+++++++ product details +++++"+productdetails);
            }
			}
	
}

	int lastrow=sheet.getPhysicalNumberOfRows();
	if(count == lastrow-1)
	{
		return " product sucessfully added:"+count+"Record are saved";
	}
	else
	{
		
		return "only" + count+"product are saved OR product already exist...!..";
	}
}


public List<String>getproductdropdowntlistforpurchasefilter(String role, String fkUserId, String categoryId, String subCategoryId)
{

	if(role.equals("super-admin"))
	{
		if(categoryId != null && subCategoryId == null)
		{
			return productrepository.getproductdropdownlistforsuperadmincategory(Long.parseLong(categoryId));
			
		}
		else if(subCategoryId != null && categoryId == null)
		{
			return productrepository.getproductdropdownlistforsuperadminsubcategory(Long.parseLong(subCategoryId));
		}
		else if(categoryId != null && subCategoryId != null)
		{
			return productrepository.getproductdropdownlistforsuperadminboth(Long.parseLong(subCategoryId), Long.parseLong(subCategoryId));
		}
		else
		{
			return productrepository.getproductdropdownlistforsuperadminnofilter();
		}
		
	}
	
	if(role.equals("oragnization"))
	{
		if(categoryId != null && subCategoryId == null)
		{
			return productrepository.getproductdropdownlistfororganizationcategory(Long.parseLong(categoryId), Long.parseLong(fkUserId));
		}
		else if(subCategoryId != null && categoryId == null)
		{
			return productrepository.getproductdropdownlistfororganizationsubcategory(Long.parseLong(subCategoryId), Long.parseLong(fkUserId));
		}
		else if(categoryId != null && subCategoryId != null)
		{
			return productrepository.getproductdropdownlistfororganizationboth(Long.parseLong(categoryId), Long.parseLong(subCategoryId), Long.parseLong(fkUserId));
			
		}
		else
		{
			return productrepository.getproductdropdownlistfororganizationnofilter(Long.parseLong(fkUserId));
		}
	}	
	
	if(role.equals("admin"))
	{
		if(categoryId != null && subCategoryId == null)
		{
			return productrepository.getproductdropdownlistforadmincategory(Long.parseLong(categoryId), Long.parseLong(fkUserId));
		}
		else if(subCategoryId != null && categoryId == null)
		{
			return productrepository.getproductdropdownlistforadminsubcategory(Long.parseLong(subCategoryId), Long.parseLong(fkUserId));
		}
		else if(categoryId != null && subCategoryId != null)
		{
			return productrepository.getproductdropdownlistforadminboth(Long.parseLong(categoryId), Long.parseLong(subCategoryId), Long.parseLong(fkUserId));
		}
		else
		{
			return productrepository.getproductdropdownlistforadminnofilter(Long.parseLong(fkUserId));
		}
	}	
	return null;
	
}
}



