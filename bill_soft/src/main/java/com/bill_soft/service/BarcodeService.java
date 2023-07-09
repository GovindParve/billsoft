package com.bill_soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.repository.BarcodeWiseStockRepository;

@Service
public class BarcodeService {
	
	@Autowired
	private BarcodeWiseStockRepository barcodeWiseRepository;
	
/////Get Barcode Number DropDown //////////
	
	public List<String> getbarcodeNumberList(String fkUserId, String role)
	{
		if (role.equals("super-admin")) {
			return barcodeWiseRepository.getBarcodeListForSuperadmin();
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return barcodeWiseRepository.getBarcodeListForAdmin(fkAdminId);
		}
		if (role.equals("oragnization")) {
			Long fkoragnizationId = Long.parseLong(fkUserId);
			return barcodeWiseRepository.getBarcodeListForOrganisation(fkoragnizationId);

		}
		return null;
	}

}
