package com.bill_soft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill_soft.dto.ShopDto;
import com.bill_soft.entity.Shop;
import com.bill_soft.service.ShopService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController

public class ShopController implements ErrorController {

	@Autowired
	private ShopService shopservice;

	/**
	 * This method is used to add a new shop to the database
	 * @param shopdto The ShopDto object containing the details of the shop to be added
	 * @param role The role of the user making the request
	 * @param fkUserId The user id of the user making the request
	 * @return A String indicating whether the shop was added successfully or not
	 */
	@PostMapping("/addShopDetails")
	public String addshop(@RequestBody ShopDto shopdto, @RequestParam String role, @RequestParam String fkUserId) {
		return shopservice.addshopDetails(shopdto, role, fkUserId);
	}

	/**
	 * This method is used to retrieve the list of all shops present in the database
	 * @param role The role of the user making the request
	 * @param fkUserId The user id of the user making the request
	 * @return A List of Shop objects containing the details of all the shops
	 */
	@GetMapping("/getShopList")
	public List<Shop> getshop(String role, String fkUserId) {
		return shopservice.getshoplist(role, fkUserId);
	}

	/**
	 * This method is used to retrieve the details of a specific shop
	 * @param id The id of the shop to be retrieved
	 * @param role The role of the user making the request
	 * @param fkUserId The user id of the user making the request
	 * @return An Optional object of type Shop containing the details of the shop if found, else empty
	 */
	@GetMapping("/editShopDetails/{pk_shop_id}")
	public Optional<Shop> editShop(@PathVariable(value = "pk_shop_id") Long id, @RequestParam String role,
			@RequestParam String fkUserId) {
		return shopservice.editShopDetails(id, role, fkUserId);
	}

	/**
	 * This method is used to retrieve a list of all shops to be used for dropdowns
	 * @param role The role of the user making the request
	 * @param fkUserId The user id of the user making the request
	 * @return A List of Strings containing the names of all the shops
	 */
	@GetMapping("/getShop-DropDown-List")
	public List<String> getshopdropdown(@RequestParam String  role,@RequestParam String fkUserId) {
		return shopservice.getshopdropdown(role, fkUserId);
	}

	/**
	 * This method is used to update the details of a specific shop
	 * @param shopdto The ShopDto object containing the updated details of the shop
	 * @param role The role of the user making the request
	 * @param fkUserId The user id of the user making the request
	 * @return A String indicating whether the shop details were updated successfully or not
	 */
	@PutMapping("/updateShopDetails")
	public String updateShop(@RequestBody ShopDto shopdto, @RequestParam String role, @RequestParam String fkUserId) {
		shopservice.updateShopDetails(shopdto, role, fkUserId);
		return "Shop Details updated successfully";
	}


}
