package com.bill_soft.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.bill_soft.bean.PurchaseReturnBean;
import com.bill_soft.bean.SaleReportBean;
import com.bill_soft.bean.SaleReturnGridBean;
import com.bill_soft.bean.SingleDateWisePurchaseReportBean;
import com.bill_soft.bean.SupplierWisePurchaseReport;
import com.bill_soft.bean.SupplierWiseReportBean;
import com.bill_soft.entity.BarcodeNoWiseStock;
import com.bill_soft.entity.GoodReceive;
import com.bill_soft.entity.PurchaseReturn;
import com.bill_soft.entity.Stock;
import com.bill_soft.helper.ReportHelper;
import com.bill_soft.repository.BillingRepository;
import com.bill_soft.repository.GoodReceiveRepository;
import com.bill_soft.repository.PurchaseReturnRepository;
import com.bill_soft.repository.SaleReturnRepository;
import com.bill_soft.repository.StockRepository;

@Service
public class ReportService {

	@Autowired
	private StockRepository stockrepository;
	
	@Autowired
	private GoodReceiveRepository goodreceiverepository;
	
	@Autowired
	private PurchaseReturnRepository purchasereturnrepositoruy;
	
	@Autowired
	private BillingRepository billingrepository;
	@Autowired
	private SaleReturnRepository salereturnrepository;
	
	public List<Stock> getcurrentstockreport(String role, String fkUserId) {
		
		if(role.equals("super-admin"))
		{
			return stockrepository.getcurrentstockreportforsuperadmin();
		}
		
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
					
			return stockrepository.getcurrentstockreportfororagnization(fkOragnizationId);
		}
		
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			
			return stockrepository.getcurrentstockreportforadmin(fkAdminId);
		}
		return null;
	}
	
	
	public InputStream getcurrentstockdownloadexcel(String fkUserId, String role) {
		
		if(role.equals("super-admin"))
		{
			List<Stock> stock=stockrepository.downloadcurrentstockreportexcelforsuperadmin();
			if(stock.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CurrentStockReportForSuperAdmin(stock);
			return in;
			}
			return null;
		}
		
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<Stock> stock1=stockrepository.downloadcurrentstockreportexcelfororagnization(fkOragnizationId);
			if(stock1.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CurrentStockReportForOragnization(stock1);
			return in;
			}
			return null;
		}
		
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			
			List<Stock> stock2= stockrepository.downloadcurrentstockreportexcelforadmin(fkAdminId);
			if(stock2.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CurrentStockReportForAdmin(stock2);
			return in;
			}
			return null;
		}
		return null;
	}


	public InputStream getcurrentstockdownloadpdf(String fkUserId, String role) {
		if(role.equals("super-admin"))
		{
			List<Stock> stock=stockrepository.downloadcurrentstockreportexcelforsuperadmin();
			if(stock.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CurrentStockReportpdfForSuperAdmin(stock);
			return in;
			}
			return null;
		}
		
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<Stock> stock1=stockrepository.downloadcurrentstockreportexcelfororagnization(fkOragnizationId);
			if(stock1.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CurrentStockReportpdfForOragnization(stock1);
			return in;
			}
			return null;
		}
		
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			
			List<Stock> stock2= stockrepository.downloadcurrentstockreportexcelforadmin(fkAdminId);
			if(stock2.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CurrentStockReportpdfForAdmin(stock2);
			return in;
			}
			return null;
		}
		return null;
	}


	
	  public List<Stock> getcategorywisestockreport(String role, String fkUserId,String categoryId) {
		  
		if(role.equals("super-admin")) 
	  { 
			if(categoryId == null || categoryId == "")
			{
				
		          return stockrepository.getcategorywisestockreportforsuperadmin(fkUserId);
			}else {
				Long fkCategoryId = Long.parseLong(categoryId);
				 return stockrepository.getcategorywisestockreportforsuperadmin(fkUserId,fkCategoryId);
			}
	  }
	 
	  if(role.equals("organization")) 
	 {
		  Long fkOrganizationId=Long.parseLong(fkUserId);
		  if(categoryId == null || categoryId == "")
			{
	             return stockrepository.getcategorywisestockreportfororganization(fkOrganizationId);
			}else {
				Long fkCategoryId = Long.parseLong(categoryId);
				 return stockrepository.getcategorywisestockreportfororganization(fkOrganizationId,fkCategoryId);
			}
	  } 

	 if(role.equals("admin")) 
     { 
		 Long fkAdminId=Long.parseLong(fkUserId);
		 if(categoryId == null || categoryId == "")
			{
               return stockrepository.getcategorywisestockreportforadmin(fkAdminId);
			}else {
				Long fkCategoryId = Long.parseLong(categoryId);
				return stockrepository.getcategorywisestockreportforadmin(fkAdminId,fkCategoryId);
			}
	 } 
return null;
}


	public InputStream getcategorywisestockdownloadexcel(String fkUserId, String role, String categoryName) {
		if(role.equals("super-admin"))
		{
			List<Stock> stock=stockrepository.downloadcategorywisestockreportexcelforsuperadmin(categoryName);
			if(stock.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CategoryWiseStockReportExcelForsuperadmin(stock);
			return in;
			}
			return null;
		}
		
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<Stock> stock1=stockrepository.downloadcategorywisestockreportexcelfororagnization(fkOragnizationId,categoryName);
			if(stock1.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CategoryWiseStockReportExcelForsuperadmin(stock1);
			return in;
			}
			return null;
		}
		
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			
			List<Stock> stock2= stockrepository.downloadcategorywisestockreportexcelforadmin(fkAdminId,categoryName);
			if(stock2.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CategoryWiseStockReportExcelForsuperadmin(stock2);
			return in;
			}
			return null;
		}
		return null;
	}


	public InputStream getcategorywisestockdownloadpdf(String fkUserId, String role,String categoryName) {
		if(role.equals("super-admin"))
		{
			List<Stock> stock=stockrepository.downloadcategorywisestockreportpdfforsuperadmin(categoryName);
			if(stock.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CategoryWiseStockReportpdfForSuperAdmin(stock);
			return in;
			}
			return null;
		}
		
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<Stock> stock1=stockrepository.downloadcategorywisestockreportpdffororagnization(fkOragnizationId,categoryName);
			if(stock1.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CategoryWiseStockReportpdfForSuperAdmin(stock1);
			return in;
			}
			return null;
		}
		
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			
			List<Stock> stock2= stockrepository.downloadcategorywisestockreportpdfforadmin(fkAdminId,categoryName);
			if(stock2.size() > 0)
			{
			ByteArrayInputStream in =ReportHelper.CategoryWiseStockReportpdfForSuperAdmin(stock2);
			return in;
			}
			return null;
		}
		return null;
	}


	public List<GoodReceive> gettingsupplierwisereport(String role, String fkUserId, String fromDate, String toDate, String supplierId) {
		Long fksupplierId = Long.parseLong(supplierId);	
		Long UserId = Long.parseLong(fkUserId);
		if (role.equals("super-admin")) {

			return goodreceiverepository.getSupplierWiseStockReportForSuperadmin(fromDate, toDate, fksupplierId);
		}
		if (role.equals("oragnization")) {

			return goodreceiverepository.getSupplierWiseStockReportForOrganisation(UserId,fromDate, toDate, fksupplierId);
		}

		if (role.equals("admin")) {

			return goodreceiverepository.getSupplierWiseStockReportForAdmin(UserId,fromDate, toDate, fksupplierId);
			
		}
			
		return null;
	}
	
	public List<GoodReceive> getInvoiceStock(String role,String fkUserId,String billNumber){
		
		if(billNumber == null || billNumber == "") {
				if(role.equals("super-admin"))
				{
					return goodreceiverepository.getInvoicewisepurchasereportforsuperadmin();
				}
		
				if(role.equals("oragnization"))
				{
					Long fkOragnizationId=Long.parseLong(fkUserId);
					return goodreceiverepository.getInvoicewisepurchasereportfororganisation(fkOragnizationId);
				}
				if(role.equals("admin"))
				{
					Long fkAdminId=Long.parseLong(fkUserId);
					return goodreceiverepository.getInvoicewisepurchasereportforadmin(fkAdminId);
				}
		}else if(billNumber != null || billNumber != "") {
			Long InvoiceNumber = Long.parseLong(billNumber);
			if(role.equals("super-admin"))
			{
				return goodreceiverepository.getInvoicewisepurchasereportforsuperadmin(InvoiceNumber);
			}
	
			if(role.equals("oragnization"))
			{
				Long fkOragnizationId=Long.parseLong(fkUserId);
				return goodreceiverepository.getInvoicewisepurchasereportfororganisation(InvoiceNumber,fkOragnizationId);
			}
			if(role.equals("admin"))
			{
				Long fkAdminId=Long.parseLong(fkUserId);
				return goodreceiverepository.getInvoicewisepurchasereportforadmin(InvoiceNumber,fkAdminId);
			}
		}

			return null;
		
		
	}


public List<SupplierWisePurchaseReport> getsupplierwisepurchasereport(String role,String fkUserId,String supplierName)
{
if(role.equals("super-admin"))
{
	return goodreceiverepository.getsupplierwisepurchasereportforsuperadmin(supplierName);
}

if(role.equals("oragnization"))
{
	Long fkOragnizationId=Long.parseLong(fkUserId);
	return goodreceiverepository.getsupplierwisepurchasereportfororagnization(supplierName,fkOragnizationId);
}
if(role.equals("admin"))
{
	Long fkAdminId=Long.parseLong(fkUserId);
	return goodreceiverepository.getsupplierwisepurchasereportforadmin(supplierName,fkAdminId);
}

	return null;
	
}


public List<SingleDateWisePurchaseReportBean> getsingledatewisepurchasereport(String role, String fkUserId,
		String date) {
	
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	List<Object[]> report=goodreceiverepository.getsingledatewisepurchasereportforsuperadmin(date);
	System.out.println(report);
	for(Object[] report1 :report)
    {
		srNo++;
		SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
		 //bean.setSrNo(srNo);
		 //bean.setDate(report1[0].toString());
		 bean.setBillNo(report1[0].toString());
		 bean.setSupplierName(report1[1].toString());
		 bean.setCategoryName(report1[2].toString());
		 bean.setSubCategoryName(report1[3].toString());
		 bean.setProductName(report1[4].toString());
		
		 bean.setHsnsac(report1[5].toString());
		 bean.setQuantity(Double.parseDouble(report1[6].toString()));
		 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
		 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
		 
		 list.add(bean);
		 return list;
	}
	
	
	
	
	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	 List<Object[]> report=goodreceiverepository.getsingledatewisepurchasereportfororagnization(fkOragnizationId,date);
	 System.out.println(report);
		for(Object[] report1 :report)
	    {
			srNo++;
			SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
			 //bean.setSrNo(srNo);
			 //bean.setDate(report1[0].toString());
			 bean.setBillNo(report1[0].toString());
			 bean.setSupplierName(report1[1].toString());
			 bean.setCategoryName(report1[2].toString());
			 bean.setSubCategoryName(report1[3].toString());
			 bean.setProductName(report1[4].toString());
			
			 bean.setHsnsac(report1[5].toString());
			 bean.setQuantity(Double.parseDouble(report1[6].toString()));
			 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
			 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
			 
			 list.add(bean);
			 return list;
		}
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
		 List<Object[]> report=goodreceiverepository.getsingledatewisepurchasereportforadmin(fkAdminId,date);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
				 //bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
				 bean.setSupplierName(report1[1].toString());
				 bean.setCategoryName(report1[2].toString());
				 bean.setSubCategoryName(report1[3].toString());
				 bean.setProductName(report1[4].toString());
				
				 bean.setHsnsac(report1[5].toString());
				 bean.setQuantity(Double.parseDouble(report1[6].toString()));
				 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
				 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
				 
				 list.add(bean);
				 return list;
		// goodreceiverepository.getsingledatewisepurchasereportforadmin();
	}

}


return null;
}


public List<SingleDateWisePurchaseReportBean> getrangewisepurchasereport(String role, String fkUserId, String fromDate,
		String toDate) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	List<Object[]> report=goodreceiverepository.getrangewisepurchasereportforsuperadmin(fromDate,toDate);
	System.out.println(report);
	for(Object[] report1 :report)
    {
		srNo++;
		SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
		 //bean.setSrNo(srNo);
		 //bean.setDate(report1[0].toString());
		 bean.setBillNo(report1[0].toString());
		 bean.setSupplierName(report1[1].toString());
		 bean.setCategoryName(report1[2].toString());
		 bean.setSubCategoryName(report1[3].toString());
		 bean.setProductName(report1[4].toString());
		
		 bean.setHsnsac(report1[5].toString());
		 bean.setQuantity(Double.parseDouble(report1[6].toString()));
		 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
		 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
		 
		 list.add(bean);
		 return list;
	}
	
	
	
	
	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	 List<Object[]> report=goodreceiverepository.getrangewisepurchasereportfororagnization(fkOragnizationId,fromDate,toDate);
	 System.out.println(report);
		for(Object[] report1 :report)
	    {
			srNo++;
			SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
			 //bean.setSrNo(srNo);
			 //bean.setDate(report1[0].toString());
			 bean.setBillNo(report1[0].toString());
			 bean.setSupplierName(report1[1].toString());
			 bean.setCategoryName(report1[2].toString());
			 bean.setSubCategoryName(report1[3].toString());
			 bean.setProductName(report1[4].toString());
			
			 bean.setHsnsac(report1[5].toString());
			 bean.setQuantity(Double.parseDouble(report1[6].toString()));
			 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
			 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
			 
			 list.add(bean);
			 return list;
		}
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
		 List<Object[]> report=goodreceiverepository.getrangewisepurchasereportforadmin(fkAdminId,fromDate,toDate);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
				 //bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
				 bean.setSupplierName(report1[1].toString());
				 bean.setCategoryName(report1[2].toString());
				 bean.setSubCategoryName(report1[3].toString());
				 bean.setProductName(report1[4].toString());
				
				 bean.setHsnsac(report1[5].toString());
				 bean.setQuantity(Double.parseDouble(report1[6].toString()));
				 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
				 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
				 
				 list.add(bean);
				 return list;
		// goodreceiverepository.getsingledatewisepurchasereportforadmin();
	}

}
	
	return null;
}


public List<SingleDateWisePurchaseReportBean> getcategorywisepurchasereport(String role, String fkUserId,
		String category)
{
	Long srNo=0L;
if(role.equals("super-admin"))
{
	List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
List<Object[]> report=goodreceiverepository.getcategorywisepurchasereportforsuperadmin(category);
System.out.println(report);
for(Object[] report1 :report)
{
	srNo++;
	SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
	 //bean.setSrNo(srNo);
	 //bean.setDate(report1[0].toString());
	 bean.setBillNo(report1[0].toString());
	 bean.setSupplierName(report1[1].toString());
	 bean.setCategoryName(report1[2].toString());
	 bean.setSubCategoryName(report1[3].toString());
	 bean.setProductName(report1[4].toString());
	
	 bean.setHsnsac(report1[5].toString());
	 bean.setQuantity(Double.parseDouble(report1[6].toString()));
	 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
	 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
	 
	 list.add(bean);
	 return list;
}




}
if(role.equals("oragnization"))
{
	Long fkOragnizationId=Long.parseLong(fkUserId);
	List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
 List<Object[]> report=goodreceiverepository.getcategorywisepurchasereportfororagnization(fkOragnizationId,category);
 System.out.println(report);
	for(Object[] report1 :report)
    {
		srNo++;
		SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
		 //bean.setSrNo(srNo);
		 //bean.setDate(report1[0].toString());
		 bean.setBillNo(report1[0].toString());
		 bean.setSupplierName(report1[1].toString());
		 bean.setCategoryName(report1[2].toString());
		 bean.setSubCategoryName(report1[3].toString());
		 bean.setProductName(report1[4].toString());
		
		 bean.setHsnsac(report1[5].toString());
		 bean.setQuantity(Double.parseDouble(report1[6].toString()));
		 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
		 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
		 
		 list.add(bean);
		 return list;
	}
}
if(role.equals("admin"))
{
	Long fkAdminId=Long.parseLong(fkUserId);
	List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	 List<Object[]> report=goodreceiverepository.getcategorywisepurchasereportforadmin(fkAdminId,category);
	 System.out.println(report);
		for(Object[] report1 :report)
	    {
			srNo++;
			SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
			 //bean.setSrNo(srNo);
			 //bean.setDate(report1[0].toString());
			 bean.setBillNo(report1[0].toString());
			 bean.setSupplierName(report1[1].toString());
			 bean.setCategoryName(report1[2].toString());
			 bean.setSubCategoryName(report1[3].toString());
			 bean.setProductName(report1[4].toString());
			
			 bean.setHsnsac(report1[5].toString());
			 bean.setQuantity(Double.parseDouble(report1[6].toString()));
			 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
			 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
			 
			 list.add(bean);
			 return list;
	// goodreceiverepository.getsingledatewisepurchasereportforadmin();
}
	
	
}
return null;
}


public List<SingleDateWisePurchaseReportBean> getproductwisepurchasereport(String role, String fkUserId,
		String productName) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	List<Object[]> report=goodreceiverepository.getproductwisepurchasereportforsuperadmin(productName);
	System.out.println(report);
	for(Object[] report1 :report)
	{
		srNo++;
		SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
		 //bean.setSrNo(srNo);
		 //bean.setDate(report1[0].toString());
		 bean.setBillNo(report1[0].toString());
		 bean.setSupplierName(report1[1].toString());
		 bean.setCategoryName(report1[2].toString());
		 bean.setSubCategoryName(report1[3].toString());
		 bean.setProductName(report1[4].toString());
		
		 bean.setHsnsac(report1[5].toString());
		 bean.setQuantity(Double.parseDouble(report1[6].toString()));
		 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
		 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
		 
		 list.add(bean);
		 return list;
	}




	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	 List<Object[]> report=goodreceiverepository.getproductwisepurchasereportfororagnization(fkOragnizationId,productName);
	 System.out.println(report);
		for(Object[] report1 :report)
	    {
			srNo++;
			SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
			 //bean.setSrNo(srNo);
			 //bean.setDate(report1[0].toString());
			 bean.setBillNo(report1[0].toString());
			 bean.setSupplierName(report1[1].toString());
			 bean.setCategoryName(report1[2].toString());
			 bean.setSubCategoryName(report1[3].toString());
			 bean.setProductName(report1[4].toString());
			
			 bean.setHsnsac(report1[5].toString());
			 bean.setQuantity(Double.parseDouble(report1[6].toString()));
			 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
			 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
			 
			 list.add(bean);
			 return list;
		}
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
		 List<Object[]> report=goodreceiverepository.getproductwisepurchasereportforadmin(fkAdminId,productName);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
				 //bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
				 bean.setSupplierName(report1[1].toString());
				 bean.setCategoryName(report1[2].toString());
				 bean.setSubCategoryName(report1[3].toString());
				 bean.setProductName(report1[4].toString());
				
				 bean.setHsnsac(report1[5].toString());
				 bean.setQuantity(Double.parseDouble(report1[6].toString()));
				 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
				 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
				 
				 list.add(bean);
				 return list;
		// goodreceiverepository.getsingledatewisepurchasereportforadmin();
	}
		
	
	
}
	return null;
}


public List<SingleDateWisePurchaseReportBean> getbillnowisepurchasereport(String role, String fkUserId, String billNo)
{
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	List<Object[]> report=goodreceiverepository.getbillNowisepurchasereportforsuperadmin(billNo);
	System.out.println(report);
	for(Object[] report1 :report)
	{
		srNo++;
		SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
		 //bean.setSrNo(srNo);
		 //bean.setDate(report1[0].toString());
		 bean.setBillNo(report1[0].toString());
		 bean.setSupplierName(report1[1].toString());
		 bean.setCategoryName(report1[2].toString());
		 bean.setSubCategoryName(report1[3].toString());
		 bean.setProductName(report1[4].toString());
		
		 bean.setHsnsac(report1[5].toString());
		 bean.setQuantity(Double.parseDouble(report1[6].toString()));
		 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
		 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
		 
		 list.add(bean);
		 return list;
	}




	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	 List<Object[]> report=goodreceiverepository.getbillNowisepurchasereportfororagnization(fkOragnizationId,billNo);
	 System.out.println(report);
		for(Object[] report1 :report)
	    {
			srNo++;
			SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
			 //bean.setSrNo(srNo);
			 //bean.setDate(report1[0].toString());
			 bean.setBillNo(report1[0].toString());
			 bean.setSupplierName(report1[1].toString());
			 bean.setCategoryName(report1[2].toString());
			 bean.setSubCategoryName(report1[3].toString());
			 bean.setProductName(report1[4].toString());
			
			 bean.setHsnsac(report1[5].toString());
			 bean.setQuantity(Double.parseDouble(report1[6].toString()));
			 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
			 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
			 
			 list.add(bean);
			 return list;
		}
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
		 List<Object[]> report=goodreceiverepository.getbillNowisepurchasereportforadmin(fkAdminId,billNo);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
				 //bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
				 bean.setSupplierName(report1[1].toString());
				 bean.setCategoryName(report1[2].toString());
				 bean.setSubCategoryName(report1[3].toString());
				 bean.setProductName(report1[4].toString());
				
				 bean.setHsnsac(report1[5].toString());
				 bean.setQuantity(Double.parseDouble(report1[6].toString()));
				 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
				 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
				 
				 list.add(bean);
				 return list;
		// goodreceiverepository.getsingledatewisepurchasereportforadmin();
	}
		
	
}
	return null;

}


public List<SingleDateWisePurchaseReportBean> getbarcodenowisepurchasereport(String role, String fkUserId,
		String barcodeNo) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	List<Object[]> report=goodreceiverepository.getbarcodeNowisepurchasereportforsuperadmin(barcodeNo);
	System.out.println(report);
	for(Object[] report1 :report)
	{
		srNo++;
		SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
		 //bean.setSrNo(srNo);
		 //bean.setDate(report1[0].toString());
		 bean.setBillNo(report1[0].toString());
		 bean.setSupplierName(report1[1].toString());
		 bean.setCategoryName(report1[2].toString());
		 bean.setSubCategoryName(report1[3].toString());
		 bean.setProductName(report1[4].toString());
		
		 bean.setHsnsac(report1[5].toString());
		 bean.setQuantity(Double.parseDouble(report1[6].toString()));
		 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
		 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
		 
		 list.add(bean);
		 return list;
	}




	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	 List<Object[]> report=goodreceiverepository.getbarcodeNowisepurchasereportfororagnization(fkOragnizationId,barcodeNo);
	 System.out.println(report);
		for(Object[] report1 :report)
	    {
			srNo++;
			SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
			 //bean.setSrNo(srNo);
			 //bean.setDate(report1[0].toString());
			 bean.setBillNo(report1[0].toString());
			 bean.setSupplierName(report1[1].toString());
			 bean.setCategoryName(report1[2].toString());
			 bean.setSubCategoryName(report1[3].toString());
			 bean.setProductName(report1[4].toString());
			
			 bean.setHsnsac(report1[5].toString());
			 bean.setQuantity(Double.parseDouble(report1[6].toString()));
			 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
			 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
			 
			 list.add(bean);
			 return list;
		}
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
		 List<Object[]> report=goodreceiverepository.getbarcodeNowisepurchasereportforadmin(fkAdminId,barcodeNo);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
				 //bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
				 bean.setSupplierName(report1[1].toString());
				 bean.setCategoryName(report1[2].toString());
				 bean.setSubCategoryName(report1[3].toString());
				 bean.setProductName(report1[4].toString());
				
				 bean.setHsnsac(report1[5].toString());
				 bean.setQuantity(Double.parseDouble(report1[6].toString()));
				 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
				 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
				 
				 list.add(bean);
				 return list;
		// goodreceiverepository.getsingledatewisepurchasereportforadmin();
	}
		
	
}
	return null;
}


public List<SingleDateWisePurchaseReportBean> getexpensewisepurchasereport(String role, String fkUserId,String fromDate, String toDate) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	List<Object[]> report=goodreceiverepository.getexpensewisepurchasereportforsuperadmin(fromDate,toDate);
	System.out.println(report);
	for(Object[] report1 :report)
	{
		srNo++;
		SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
		 //bean.setSrNo(srNo);
		 //bean.setDate(report1[0].toString());
		 bean.setBillNo(report1[0].toString());
		 bean.setSupplierName(report1[1].toString());
		 bean.setCategoryName(report1[2].toString());
		 bean.setSubCategoryName(report1[3].toString());
		 bean.setProductName(report1[4].toString());
		
		 bean.setHsnsac(report1[5].toString());
		 bean.setQuantity(Double.parseDouble(report1[6].toString()));
		 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
		 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
		 
		 list.add(bean);
		 return list;
	}




	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
	 List<Object[]> report=goodreceiverepository.getexpensewisepurchasereportfororagnization(fkOragnizationId,fromDate,toDate);
	 System.out.println(report);
		for(Object[] report1 :report)
	    {
			srNo++;
			SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
			 bean.setSrNo(srNo);
			 //bean.setDate(report1[0].toString());
			 bean.setBillNo(report1[0].toString());
			 bean.setSupplierName(report1[1].toString());
			 bean.setCategoryName(report1[2].toString());
			 bean.setSubCategoryName(report1[3].toString());
			 bean.setProductName(report1[4].toString());
			
			 bean.setHsnsac(report1[5].toString());
			 bean.setQuantity(Double.parseDouble(report1[6].toString()));
			 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
			 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
			 
			 list.add(bean);
			 return list;
		}
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		List<SingleDateWisePurchaseReportBean> list=new ArrayList<>();
		 List<Object[]> report=goodreceiverepository.getexpensewisepurchasereportforadmin(fkAdminId,fromDate,toDate);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SingleDateWisePurchaseReportBean bean=new SingleDateWisePurchaseReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
				 bean.setSupplierName(report1[1].toString());
				 bean.setCategoryName(report1[2].toString());
				 bean.setSubCategoryName(report1[3].toString());
				 bean.setProductName(report1[4].toString());
				
				 bean.setHsnsac(report1[5].toString());
				 bean.setQuantity(Double.parseDouble(report1[6].toString()));
				 bean.setReturnQuantity(Double.parseDouble(report1[7].toString()));
				 bean.setSoldQuantity(Double.parseDouble(report1[8].toString()));
				 
				 list.add(bean);
				 return list;
		// goodreceiverepository.getsingledatewisepurchasereportforadmin();
	}
	

}
	return null;
}


public List<PurchaseReturnBean> getdatewisepurchasereturnreport(String role, String fkUserId, String date) 
{
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<PurchaseReturnBean> listbean = new ArrayList<>();
		List<Object[]> report=purchasereturnrepositoruy.getdatewisepurchasereturnreportforsuperadmin(date);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				PurchaseReturnBean bean=new PurchaseReturnBean();
				 bean.setSrNO(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setBuyPrice(Double.parseDouble(report1[5].toString()));
		         bean.setTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[7].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[8].toString()));
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
		 if(role.equals("oragnization"))
			{
				Long fkOragnizationId=Long.parseLong(fkUserId);
				List<PurchaseReturnBean> listbean = new ArrayList<>();
				List<Object[]> report=purchasereturnrepositoruy.getdatewisepurchasereturnreportfororagnization(fkOragnizationId,date);
				 System.out.println(report);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					PurchaseReturnBean bean=new PurchaseReturnBean();
					 bean.setSrNO(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setProductName(report1[3].toString());
			         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
			         bean.setBuyPrice(Double.parseDouble(report1[5].toString()));
			         bean.setTax(Double.parseDouble(report1[6].toString()));
			         bean.setTaxAmount(Double.parseDouble(report1[7].toString()));
			         bean.setReturnAmount(Double.parseDouble(report1[8].toString()));
			         listbean.add(bean);
			         return listbean;
				}
			}
		 
		 if(role.equals("admin"))
			{
				Long fkAdminId=Long.parseLong(fkUserId);
				List<PurchaseReturnBean> listbean = new ArrayList<>();
				List<Object[]> report=purchasereturnrepositoruy.getdatewisepurchasereturnreportforadmin(fkAdminId,date);
				 System.out.println(report);
					for(Object[] report1 :report)
				    {
						srNo++;
						PurchaseReturnBean bean=new PurchaseReturnBean();
						 bean.setSrNO(srNo);
						 //bean.setDate(report1[0].toString());
						 bean.setBillNo(report1[0].toString());
				         bean.setBarcodeNo(report1[1].toString());
				         bean.setCategoryName(report1[2].toString());
				         bean.setProductName(report1[3].toString());
				         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
				         bean.setBuyPrice(Double.parseDouble(report1[5].toString()));
				         bean.setTax(Double.parseDouble(report1[6].toString()));
				         bean.setTaxAmount(Double.parseDouble(report1[7].toString()));
				         bean.setReturnAmount(Double.parseDouble(report1[8].toString()));
				         listbean.add(bean);
				         return listbean;
					
				// goodreceiverepository.getsingledatewisepurchasereportforadmin();
			}
			}
	return null;
}


public List<PurchaseReturnBean> getrangewisepurchasereturnreport(String role, String fkUserId, String fromDate,
		String toDate) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<PurchaseReturnBean> listbean = new ArrayList<>();
		List<Object[]> report=purchasereturnrepositoruy.getrangewisepurchasereturnreportforsuperadmin(fromDate,toDate);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				PurchaseReturnBean bean=new PurchaseReturnBean();
				 bean.setSrNO(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setBuyPrice(Double.parseDouble(report1[5].toString()));
		         bean.setTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[7].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[8].toString()));
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
		 if(role.equals("oragnization"))
			{
				Long fkOragnizationId=Long.parseLong(fkUserId);
				List<PurchaseReturnBean> listbean = new ArrayList<>();
				List<Object[]> report=purchasereturnrepositoruy.getrangewisepurchasereturnreportfororagnization(fkOragnizationId,fromDate,toDate);
				 System.out.println(report);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					PurchaseReturnBean bean=new PurchaseReturnBean();
					 bean.setSrNO(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setProductName(report1[3].toString());
			         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
			         bean.setBuyPrice(Double.parseDouble(report1[5].toString()));
			         bean.setTax(Double.parseDouble(report1[6].toString()));
			         bean.setTaxAmount(Double.parseDouble(report1[7].toString()));
			         bean.setReturnAmount(Double.parseDouble(report1[8].toString()));
			         listbean.add(bean);
			         return listbean;
				}
			}
		 
		 if(role.equals("admin"))
			{
				Long fkAdminId=Long.parseLong(fkUserId);
				List<PurchaseReturnBean> listbean = new ArrayList<>();
				List<Object[]> report=purchasereturnrepositoruy.getrangewisepurchasereturnreportforadmin(fkAdminId,fromDate,toDate);
				 System.out.println(report);
					for(Object[] report1 :report)
				    {
						srNo++;
						PurchaseReturnBean bean=new PurchaseReturnBean();
						 bean.setSrNO(srNo);
						 //bean.setDate(report1[0].toString());
						 bean.setBillNo(report1[0].toString());
				         bean.setBarcodeNo(report1[1].toString());
				         bean.setCategoryName(report1[2].toString());
				         bean.setProductName(report1[3].toString());
				         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
				         bean.setBuyPrice(Double.parseDouble(report1[5].toString()));
				         bean.setTax(Double.parseDouble(report1[6].toString()));
				         bean.setTaxAmount(Double.parseDouble(report1[7].toString()));
				         bean.setReturnAmount(Double.parseDouble(report1[8].toString()));
				         listbean.add(bean);
				         return listbean;
					
				// goodreceiverepository.getsingledatewisepurchasereportforadmin();
			}
			}
	return null;
}


public List<PurchaseReturnBean> getbillnowisepurchasereturnreport(String role, String fkUserId, String supplierName,
		String billNo) 
{
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<PurchaseReturnBean> listbean = new ArrayList<>();
		List<Object[]> report=purchasereturnrepositoruy.getbillnowisepurchasereturnreportforsuperadmin(supplierName,billNo);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				PurchaseReturnBean bean=new PurchaseReturnBean();
				 bean.setSrNO(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setBuyPrice(Double.parseDouble(report1[5].toString()));
		         bean.setTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[7].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[8].toString()));
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
		 if(role.equals("oragnization"))
			{
				Long fkOragnizationId=Long.parseLong(fkUserId);
				List<PurchaseReturnBean> listbean = new ArrayList<>();
				List<Object[]> report=purchasereturnrepositoruy.getbillnowisepurchasereturnreportfororagnization(fkOragnizationId,supplierName,billNo);
				 System.out.println(report);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					PurchaseReturnBean bean=new PurchaseReturnBean();
					 bean.setSrNO(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setProductName(report1[3].toString());
			         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
			         bean.setBuyPrice(Double.parseDouble(report1[5].toString()));
			         bean.setTax(Double.parseDouble(report1[6].toString()));
			         bean.setTaxAmount(Double.parseDouble(report1[7].toString()));
			         bean.setReturnAmount(Double.parseDouble(report1[8].toString()));
			         listbean.add(bean);
			         return listbean;
				}
			}
		 
		 if(role.equals("admin"))
			{
				Long fkAdminId=Long.parseLong(fkUserId);
				List<PurchaseReturnBean> listbean = new ArrayList<>();
				List<Object[]> report=purchasereturnrepositoruy.getbillnowisepurchasereturnreportforadmin(fkAdminId,supplierName,billNo);
				 System.out.println(report);
					for(Object[] report1 :report)
				    {
						srNo++;
						PurchaseReturnBean bean=new PurchaseReturnBean();
						 bean.setSrNO(srNo);
						 //bean.setDate(report1[0].toString());
						 bean.setBillNo(report1[0].toString());
				         bean.setBarcodeNo(report1[1].toString());
				         bean.setCategoryName(report1[2].toString());
				         bean.setProductName(report1[3].toString());
				         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
				         bean.setBuyPrice(Double.parseDouble(report1[5].toString()));
				         bean.setTax(Double.parseDouble(report1[6].toString()));
				         bean.setTaxAmount(Double.parseDouble(report1[7].toString()));
				         bean.setReturnAmount(Double.parseDouble(report1[8].toString()));
				         listbean.add(bean);
				         return listbean;
					
				// goodreceiverepository.getsingledatewisepurchasereportforadmin();
			}
			}	
	return null;
}


public List<SaleReportBean> getcategorywisesalereport(String role, String fkUserId, String categoryName,
		String fromDate, String toDate) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReportBean> listbean = new ArrayList<>();
		List<Object[]> report=billingrepository.getcategorywisesalereportforsuperadmin(categoryName,fromDate,toDate);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getcategorywisesalereportfororagnization(fkOragnizationId,categoryName,fromDate,toDate);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getcategorywisesalereportforadmin(fkAdminId,categoryName,fromDate,toDate);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReportBean bean=new SaleReportBean();
					 bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setSubCategoryName(report1[3].toString());
			         bean.setProductName(report1[4].toString());
			         bean.setQuantity((Double.parseDouble(report1[5].toString())));
			         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
			         
			         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
			         bean.setDiscount(Double.parseDouble(report1[10].toString()));
			         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
			         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
			         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
			         bean.setDate(report1[14].toString());
			         listbean.add(bean);
			         return listbean;
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	
	return null;
}


public List<SaleReportBean> getproductwisesalereport(String role, String fkUserId, String productName) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReportBean> listbean = new ArrayList<>();
		List<Object[]> report=billingrepository.getproductwisesalereportforsuperadmin(productName);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getproductwisesalereportfororagnization(fkOragnizationId,productName);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getproductwisesalereportforadmin(fkAdminId,productName);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReportBean bean=new SaleReportBean();
					 bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setSubCategoryName(report1[3].toString());
			         bean.setProductName(report1[4].toString());
			         bean.setQuantity((Double.parseDouble(report1[5].toString())));
			         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
			         
			         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
			         bean.setDiscount(Double.parseDouble(report1[10].toString()));
			         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
			         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
			         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
			         bean.setDate(report1[14].toString());
			         listbean.add(bean);
			         return listbean;
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	return null;
}


public List<SaleReportBean> getsingledatewisesalereport(String role, String fkUserId, String date) {

	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReportBean> listbean = new ArrayList<>();
		List<Object[]> report=billingrepository.getsingledatewisesalereportforsuperadmin(date);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getsingledatewisesalereportfororagnization(fkOragnizationId,date);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getsingledatewisesalereportforadmin(fkAdminId,date);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReportBean bean=new SaleReportBean();
					 bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setSubCategoryName(report1[3].toString());
			         bean.setProductName(report1[4].toString());
			         bean.setQuantity((Double.parseDouble(report1[5].toString())));
			         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
			         
			         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
			         bean.setDiscount(Double.parseDouble(report1[10].toString()));
			         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
			         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
			         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
			         bean.setDate(report1[14].toString());
			         listbean.add(bean);
			         return listbean;
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	return null;
}


public List<SaleReportBean> getrangewisesalereport(String role, String fkUserId, String fromDate, String toDate) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReportBean> listbean = new ArrayList<>();
		List<Object[]> report=billingrepository.getrangewisesalereportforsuperadmin(fromDate,toDate);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getrangewisesalereportfororagnization(fkOragnizationId,fromDate,toDate);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getrangewisesalereportforadmin(fkAdminId,fromDate,toDate);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReportBean bean=new SaleReportBean();
					 bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setSubCategoryName(report1[3].toString());
			         bean.setProductName(report1[4].toString());
			         bean.setQuantity((Double.parseDouble(report1[5].toString())));
			         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
			         
			         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
			         bean.setDiscount(Double.parseDouble(report1[10].toString()));
			         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
			         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
			         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
			         bean.setDate(report1[14].toString());
			         listbean.add(bean);
			         return listbean;
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	
	return null;
}


public List<SaleReportBean> getuserwisesalereport(String role, String fkUserId, 
		String fromDate, String toDate) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReportBean> listbean = new ArrayList<>();
		List<Object[]> report=billingrepository.getuserwisesalereportforsuperadmin(fromDate,toDate);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getuserwisesalereportfororagnization(fkOragnizationId,fromDate,toDate);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getuserewisesalereportforadmin(fkAdminId,fromDate,toDate);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReportBean bean=new SaleReportBean();
					 bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setSubCategoryName(report1[3].toString());
			         bean.setProductName(report1[4].toString());
			         bean.setQuantity((Double.parseDouble(report1[5].toString())));
			         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
			         
			         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
			         bean.setDiscount(Double.parseDouble(report1[10].toString()));
			         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
			         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
			         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
			         bean.setDate(report1[14].toString());
			         listbean.add(bean);
			         return listbean;
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	return null;
}


public List<SaleReportBean> getbillwisesalereport(String role, String fkUserId, String fromDate, String toDate) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReportBean> listbean = new ArrayList<>();
		List<Object[]> report=billingrepository.getbillwisesalereportforsuperadmin(fromDate,toDate);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getbillwisesalereportfororagnization(fkOragnizationId,fromDate,toDate);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getbillwisesalereportforadmin(fkAdminId,fromDate,toDate);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReportBean bean=new SaleReportBean();
					 bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setSubCategoryName(report1[3].toString());
			         bean.setProductName(report1[4].toString());
			         bean.setQuantity((Double.parseDouble(report1[5].toString())));
			         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
			         
			         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
			         bean.setDiscount(Double.parseDouble(report1[10].toString()));
			         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
			         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
			         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
			         bean.setDate(report1[14].toString());
			         listbean.add(bean);
			         return listbean;
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	return null;
}


public List<SaleReportBean> getpaymentmodewisesalereport(String role, String fkUserId,	String paymentMode, String fromDate, String toDate
	) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReportBean> listbean = new ArrayList<>();
		List<Object[]> report=billingrepository.getpaymentmodewisesalereportforsuperadmin(paymentMode,fromDate,toDate);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getpaymentmodewisesalereportfororagnization(fkOragnizationId,paymentMode,fromDate,toDate);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReportBean bean=new SaleReportBean();
				 bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(report1[0].toString());
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		         bean.setSubCategoryName(report1[3].toString());
		         bean.setProductName(report1[4].toString());
		         bean.setQuantity((Double.parseDouble(report1[5].toString())));
		         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
		         
		         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
		         bean.setDiscount(Double.parseDouble(report1[10].toString()));
		         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
		         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
		         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
		         bean.setDate(report1[14].toString());
		         listbean.add(bean);
		         return listbean;
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReportBean> listbean = new ArrayList<>();
			List<Object[]> report=billingrepository.getpaymentmodewisesalereportforadmin(fkAdminId,paymentMode,fromDate,toDate);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReportBean bean=new SaleReportBean();
					 bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(report1[0].toString());
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			         bean.setSubCategoryName(report1[3].toString());
			         bean.setProductName(report1[4].toString());
			         bean.setQuantity((Double.parseDouble(report1[5].toString())));
			         bean.setBuyPriceExclusiveTax(Double.parseDouble(report1[6].toString()));
			         
			         bean.setSalePrice(Double.parseDouble(report1[7].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[8].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[9].toString()));
			         bean.setDiscount(Double.parseDouble(report1[10].toString()));
			         bean.setDiscountAmount(Double.parseDouble(report1[11].toString()));
			         bean.setTaxAmountAfterDiscount(Double.parseDouble(report1[12].toString()));
			         bean.setTotalAmount(Double.parseDouble(report1[13].toString()));
			         bean.setDate(report1[14].toString());
			         listbean.add(bean);
			         return listbean;
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	return null;
}


public List<SaleReturnGridBean> getdatewisesalereturnreport(String role, String fkUserId, String date) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReturnGridBean> listbean = new ArrayList<>();
		List<Object[]> report=salereturnrepository.getdatewisesalereturnreportforsuperadmin(date);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				 //bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getdatewisesalereturnreportfororagnization(fkOragnizationId,date);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				 //bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getdatewisesalereturnreportforadmin(fkAdminId,date);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReturnGridBean bean=new SaleReturnGridBean();
					//bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(Long.parseLong(report1[0].toString()));
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			        
			         bean.setProductName(report1[3].toString());
			         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
			         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
			         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
			         bean.setDiscount(Double.parseDouble(report1[9].toString()));
			         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
			         
			         
			         listbean.add(bean);
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	return null;
}


public List<SaleReturnGridBean> getrangewisesalereturnreport(String role, String fkUserId, String fromDate, String toDate) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReturnGridBean> listbean = new ArrayList<>();
		List<Object[]> report=salereturnrepository.getrangewisesalereturnreportforsuperadmin(fromDate,toDate);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				//bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getrangewisesalereturnreportfororagnization(fkOragnizationId,fromDate,toDate);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				//bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getrangewisesalereturnreportforadmin(fkAdminId,fromDate,toDate);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReturnGridBean bean=new SaleReturnGridBean();
					//bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(Long.parseLong(report1[0].toString()));
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			        
			         bean.setProductName(report1[3].toString());
			         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
			         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
			         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
			         bean.setDiscount(Double.parseDouble(report1[9].toString()));
			         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
			         
			         
			         listbean.add(bean);
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	return null;
}


public List<SaleReturnGridBean> getcategorywisesalereturnreport(String role, String fkUserId, String categoryName) 
{
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReturnGridBean> listbean = new ArrayList<>();
		List<Object[]> report=salereturnrepository.getcategorywisesalereturnreportforsuperadmin(categoryName);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				//bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getcategorywisesalereturnreportfororagnization(fkOragnizationId,categoryName);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				//bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getcategorywisesalereturnreportforadmin(fkAdminId,categoryName);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReturnGridBean bean=new SaleReturnGridBean();
					//bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(Long.parseLong(report1[0].toString()));
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			        
			         bean.setProductName(report1[3].toString());
			         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
			         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
			         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
			         bean.setDiscount(Double.parseDouble(report1[9].toString()));
			         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
			         
			         
			         listbean.add(bean);
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
   
	return null;
}


public List<SaleReturnGridBean> getbillnowisesalereturnreport(String role, String fkUserId, String billNo) {
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReturnGridBean> listbean = new ArrayList<>();
		List<Object[]> report=salereturnrepository.getbillnowisesalereturnreportforsuperadmin(billNo);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				//bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getbillnowisesalereturnreportfororagnization(fkOragnizationId,billNo);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				//bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getbillnowisesalereturnreportforadmin(fkAdminId,billNo);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReturnGridBean bean=new SaleReturnGridBean();
					//bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(Long.parseLong(report1[0].toString()));
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			        
			         bean.setProductName(report1[3].toString());
			         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
			         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
			         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
			         bean.setDiscount(Double.parseDouble(report1[9].toString()));
			         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
			         
			         
			         listbean.add(bean);
				
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
   
	return null;
}


public List<SaleReturnGridBean> getbarcodenowisesalereturnreport(String role, String fkUserId, String barcodeNo) {
	
	Long srNo=0L;
	if(role.equals("super-admin"))
	{
		List<SaleReturnGridBean> listbean = new ArrayList<>();
		List<Object[]> report=salereturnrepository.getbarcodenonowisesalereturnreportforsuperadmin(barcodeNo);
		 System.out.println(report);
		 for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				//bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
		         return listbean;
	
	}
	} 
	
	 if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getbarcodenowisesalereturnreportfororagnization(fkOragnizationId,barcodeNo);
			 System.out.println(report);
		 System.out.println(report);
			for(Object[] report1 :report)
		    {
				srNo++;
				SaleReturnGridBean bean=new SaleReturnGridBean();
				//bean.setSrNo(srNo);
				 //bean.setDate(report1[0].toString());
				 bean.setBillNo(Long.parseLong(report1[0].toString()));
		         bean.setBarcodeNo(report1[1].toString());
		         bean.setCategoryName(report1[2].toString());
		        
		         bean.setProductName(report1[3].toString());
		         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
		         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
		         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
		         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
		         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
		         bean.setDiscount(Double.parseDouble(report1[9].toString()));
		         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
		         
		         
		         listbean.add(bean);
		         return listbean;
			}
		}
	
	 if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			List<SaleReturnGridBean> listbean = new ArrayList<>();
			List<Object[]> report=salereturnrepository.getbarcodenowisesalereturnreportforadmin(fkAdminId,barcodeNo);
			 System.out.println(report);
				for(Object[] report1 :report)
			    {
					srNo++;
					SaleReturnGridBean bean=new SaleReturnGridBean();
					//bean.setSrNo(srNo);
					 //bean.setDate(report1[0].toString());
					 bean.setBillNo(Long.parseLong(report1[0].toString()));
			         bean.setBarcodeNo(report1[1].toString());
			         bean.setCategoryName(report1[2].toString());
			        
			         bean.setProductName(report1[3].toString());
			         bean.setReturnQuantity(Double.parseDouble(report1[4].toString()));
			         bean.setSalePriceIncludingtax(Double.parseDouble(report1[5].toString()));
			         bean.setSalePriceExcludingTax(Double.parseDouble(report1[6].toString()));
			         bean.setTaxPercentage(Double.parseDouble(report1[7].toString()));
			         bean.setTaxAmount(Double.parseDouble(report1[8].toString()));
			         bean.setDiscount(Double.parseDouble(report1[9].toString()));
			         bean.setReturnAmount(Double.parseDouble(report1[10].toString()));
			         
			         
			         listbean.add(bean);
				return listbean;
			// goodreceiverepository.getsingledatewisepurchasereportforadmin();
		}
		}
	return null;
}


public List<BarcodeNoWiseStock> getbarcodenowisestockreport(String role, String fkUserId, String barcodeNo) {
	if(role.equals("super-admin"))
	{
		if(barcodeNo == null || barcodeNo == "")
		{
		return stockrepository.getbarcodenowisestockreportforsuperadmin();
		}else
		{
		return stockrepository.getbarcodenowisestockreportforsuperadmin(barcodeNo);
		}
	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		if(barcodeNo == null || barcodeNo == "")
		{
		return stockrepository.getbarcodenowisestockreportfororagnization(fkOragnizationId);
		}else
		{
		return stockrepository.getbarcodenowisestockreportfororagnization(fkOragnizationId, barcodeNo);
		}
		
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		
		if(barcodeNo == null || barcodeNo == "")
		{
		return stockrepository.getbarcodenowisestockreportforadmin(fkAdminId);
		}else
		{
		return stockrepository.getbarcodenowisestockreportforadmin(fkAdminId, barcodeNo);
		}
	}
	return null;
}


public List<SaleReportBean> getdatewisecreditcustomersalereport(String role, String fkUserId, String date) {
	if(role.equals("super-admin"))
	{
		return billingrepository.getdatewisecreditcustomersalereportforsuperadmin(date);
	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		return billingrepository.getdatewisecreditcustomersalereportfororagnization(fkOragnizationId,date);
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		return billingrepository.getdatewisecreditcustomersalereportreportforadmin(fkAdminId,date);
	}
	return null;
} 


///// Get Low Stock Report ////

public List<Stock> getLowStockReport(String role, String fkUserId, String qty)
{
	Double quantity = Double.parseDouble(qty);
	if(role.equals("super-admin"))
	{
		return stockrepository.getLowStockReportForSuperAdmin(quantity);
	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		return stockrepository.getLowStockReportForOrganisation(quantity, fkOragnizationId);
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		return stockrepository.getLowStockReportForAdmin(quantity, fkAdminId);
	}
	return null;
}

public List<String> getSupplierList(String role, String fkUserId){
	if(role.equals("super-admin"))
	{
		return goodreceiverepository.getSupplierListForStockReportsSuperadmin();
	}
	if(role.equals("oragnization"))
	{
		Long fkOragnizationId=Long.parseLong(fkUserId);
		return goodreceiverepository.getSupplierListForStockReportsOrganisation(fkOragnizationId);
	}
	if(role.equals("admin"))
	{
		Long fkAdminId=Long.parseLong(fkUserId);
		return goodreceiverepository.getSupplierListForStockReportsAdmin(fkAdminId);
	}
	return null;
}

public List<String> getGoodReceiveNumber(String fkUserId) {
	Long fkAdminId = Long.parseLong(fkUserId);

	List<String> billNumbers = goodreceiverepository.getGoodReceiveNumberListForStock(fkAdminId);

	return billNumbers;
}

}


