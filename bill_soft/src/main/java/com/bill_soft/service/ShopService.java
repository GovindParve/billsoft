package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.dto.GodownDto;
import com.bill_soft.dto.ShopDto;
import com.bill_soft.entity.Shop;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.ShopRepository;

@Service
public class ShopService {

	@Autowired
	private ShopRepository ShopRepository;

	@Autowired
	private GodownService godownservice;

	@Autowired
	private LoginRepository loginrepository;

	// Add Shop Details
	public String addshopDetails(ShopDto shopdto, String role, String fkUserId) {

		if (role.equals("super-admin") || role.equals("oragnization") || role.equals("admin")) {
			Long pkid = Long.parseLong(fkUserId);
			String user = loginrepository.getusernameforcategory(role, pkid);

			if (user.equals(null)) // filter
			{
				return "UserName Not Found";
			}

			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);

			Shop shop = new Shop();
			shop.setFkAdminId(shopdto.getFkAdminId());
			shop.setCity(shopdto.getCity());
			shop.setFkAdminId(shopdto.getFkAdminId());
			shop.setFkOrganizationId(shopdto.getFkOrganizationId());
			shop.setOrganizationName(shopdto.getOrganizationName());
			shop.setAdminName(shopdto.getAdminName());
			shop.setContactNo(shopdto.getContactNo());
			shop.setShopName(shopdto.getShopName());
			shop.setShopAddress(shopdto.getShopAddress());
			shop.setShopRegistrationDate(dateString);
			shop.setGstNo(shopdto.getGstNo());
			shop.setShopLogo(shopdto.getShopLogo());
			shop.setBusinessType(shopdto.getBusinessType());
			Shop SavedShop = ShopRepository.save(shop);

			// Default Godown Creation Process Starts:

			GodownDto godowndto = new GodownDto();
			godowndto.setGodownName(SavedShop.getShopName() + "-default");
			godowndto.setFkShopId(SavedShop.getPkShopId());
			godowndto.setShopName(SavedShop.getShopName());
			godowndto.setFkAdminId(SavedShop.getFkAdminId());
			godowndto.setFkOrganizationId(SavedShop.getFkOrganizationId());
			godowndto.setCreatedBy(fkUserId);
			godowndto.setCreatedDate(dateString);
			godownservice.addgodown(godowndto, role, fkUserId);

			return "Shop Created Successfully";

		}
		return null;
	}

	public List<Shop> getshoplist(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return ShopRepository.getshoplistforsuperadmin();
		}
		if (role.equals("oragnization")) {
			Long fkOrganizationId = Long.parseLong(fkUserId);
			return ShopRepository.getshoplistfororganization(fkOrganizationId);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return ShopRepository.getshoplistforadmin(fkAdminId);
		}
		return null;
	}

	public Optional<Shop> editShopDetails(Long id, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return ShopRepository.editshopdetailsforsuperadmin(id);
		}
		if (role.equals("oragnization")) {
			Long fkOrganizationId = Long.parseLong(fkUserId);
			return ShopRepository.editshopdetailsfororganization(id, fkOrganizationId);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return ShopRepository.editshopdetailsforadmin(id, fkAdminId);
		}
		return null;
	}

	public String updateShopDetails(ShopDto shopdto, String role, String fkUserId) {
		if (role.equals("super-admin") || role.equals("oragnization") || role.equals("admin")) {
			Long pkid = Long.parseLong(fkUserId);
			String user = loginrepository.getusernameforcategory(role, pkid);

			if (user.equals(null)) // filter
			{
				return "UserName Not  Found";
			}

			Shop shop = new Shop();

			shop.setPkShopId(shopdto.getPkShopId());
			shop.setShopName(shopdto.getShopName());
			shop.setFkAdminId(shopdto.getFkAdminId());
			shop.setAdminName(shopdto.getAdminName());
			shop.setContactNo(shopdto.getContactNo());
			// shop.setFkUserId(shopdto.getFkUserId());
			// shop.setUser(shopdto.getUser());
			shop.setFkOrganizationId(shopdto.getFkOrganizationId());
			shop.setOrganizationName(shopdto.getOrganizationName());
			shop.setShopRegistrationDate(shopdto.getShopRegistrationDate());
			shop.setGstNo(shopdto.getGstNo());
			shop.setShopAddress(shopdto.getShopAddress());
			shop.setCity(shopdto.getCity());
			shop.setBusinessType(shopdto.getBusinessType());
			ShopRepository.save(shop);

		}
		return "shop updated successfully";
	}

	public List<String> getshopdropdown(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return ShopRepository.getshopdropdownforsuperadmin();
		}

		if (role.equals("oragnization")) {
			Long fkOrganizationId = Long.parseLong(fkUserId);
			return ShopRepository.getshopdropdownfororganization(fkOrganizationId);
		}

		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return ShopRepository.getshopdropdownforadmin(fkAdminId);
		}

		return null;
	}

}
