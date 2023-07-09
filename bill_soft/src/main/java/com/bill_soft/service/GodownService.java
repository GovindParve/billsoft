package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.dto.GodownDto;
import com.bill_soft.entity.GodownEntry;
import com.bill_soft.repository.GodownRepository;
import com.bill_soft.repository.LoginRepository;

@Service
public class GodownService {

	@Autowired
	private LoginRepository loginrepository;
	@Autowired
	private GodownRepository godownrepository;

	public String addgodown(GodownDto godowndto, String role, String fkUserId) {
		if (role.equals("super-admin") || role.equals("oragnization") || role.equals("admin")) {
			Long pkid = Long.parseLong(fkUserId);
			String user = loginrepository.getusernameforcategory(role, pkid);

			if (user.equals(null)) // filter
			{
				return "UserName Not  Found";
			}

			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);

			GodownEntry godownentry = new GodownEntry();
			godownentry.setPkGodownId(godowndto.getPkGodownId());
			godownentry.setGodownName(godowndto.getGodownName());
			godownentry.setFkShopId(godowndto.getFkShopId());
			godownentry.setShopName(godowndto.getShopName());
			godownentry.setFkAdminId(godowndto.getFkAdminId());
			godownentry.setFkOrganizationId(godowndto.getFkOrganizationId());
			godownentry.setCreatedBy(user + "(" + role + ")");
			godownentry.setCreatedDate(dateString);
			godownrepository.save(godownentry);

		}
		return "you don't have access";

	}

	public List<GodownEntry> getgodownlist(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return godownrepository.getgodownlistforsuperadmin();
		}
		if (role.equals("oragnization")) {
			Long fkOragnizationId = Long.parseLong(fkUserId);
			return godownrepository.getgodownlistfororagnization(fkOragnizationId);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return godownrepository.getgodownlistforadmin(fkAdminId);
		}

		return null;

		// return godownrepository.findAll();
	}

	public Optional<GodownEntry> editgodown(Long id, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return godownrepository.getgodowneditforsuperadmin(id);

		}

		if (role.equals("oragnization")) {
			Long fkOragnizationId = Long.parseLong(fkUserId);
			return godownrepository.getgodowneditfororagnization(id, fkOragnizationId);
		}

		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return godownrepository.getgodowneditforadmin(id, fkAdminId);
		}
		return null;
		// return godownrepository.findById(id);
	}

	public String updategodown(GodownDto godowndto, String role, String fkUserId) {
		if (role.equals("super-admin") || role.equals("oragnization") || role.equals("admin")) {
			Long pkid = Long.parseLong(fkUserId);
			String user = loginrepository.getusernameforcategory(role, pkid);

			if (user.equals(null)) // filter
			{
				return "UserName Not  Found";
			}

			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
			GodownEntry godownentry = new GodownEntry();
			godownentry.setPkGodownId(godowndto.getPkGodownId());
			godownentry.setGodownName(godowndto.getGodownName());
			godownentry.setFkShopId(godowndto.getFkShopId());
			godownentry.setShopName(godowndto.getShopName());
			godownentry.setFkAdminId(godowndto.getFkAdminId());
			godownentry.setFkOrganizationId(godowndto.getFkOrganizationId());
			godownentry.setCreatedBy(user + "(" + role + ")");
			godownentry.setCreatedDate(dateString);

			godownrepository.save(godownentry);
		}

		return "you don't have access";

	}

	public List<String> getgodowndropdownlist(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return godownrepository.getgodowndropdownforsuperadmin();

		}

		if (role.equals("oragnization")) {
			Long fkOragnizationId = Long.parseLong(fkUserId);
			return godownrepository.getgodowndropdownfororagnization(fkOragnizationId);
		}

		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return godownrepository.getgodowndropdownforadmin(fkAdminId);
		}

		return null;
	}

}
