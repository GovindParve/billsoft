package com.bill_soft.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.entity.StockExcelReportDownloadCount;
import com.bill_soft.repository.ExcelPdfRepository;
@Service
public class ExcelDownoadService {

	@Autowired
	private ExcelPdfRepository excelpdfrepository;
	public void addDownlodingDetails(String fileType,Date date, String fkUserId, String role, long ldownloadcount) {
		StockExcelReportDownloadCount userdownload = new StockExcelReportDownloadCount();
		
		userdownload.setFileType(fileType);
		userdownload.setFkUserId(fkUserId);
		userdownload.setRole(role);
		
		userdownload.setTimeStamp(date);
		userdownload.setDwnldCount(ldownloadcount);
				
		excelpdfrepository.save(userdownload);
		
	}

}
