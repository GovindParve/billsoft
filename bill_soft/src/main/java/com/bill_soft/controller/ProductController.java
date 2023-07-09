package com.bill_soft.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import org.springframework.web.multipart.MultipartFile;

import com.bill_soft.dto.ProductDto;
import com.bill_soft.entity.ProductDetails;
import com.bill_soft.service.ProductService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController implements ErrorController {

	@Autowired
	private ProductService productservice;

	/**
	 * Adds product details
	 * 
	 * @param productdto List of ProductDto objects containing product details
	 * @param role       User role
	 * @param fkUserId   User ID
	 * @return String indicating success or failure
	 */
	@PostMapping("/addProductDetails")
	public String addproductdetails(@RequestBody List<ProductDto> productdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		return productservice.addproductdetails(productdto, role, fkUserId);
	}

	/**
	 * Retrieves a list of all products
	 * 
	 * @param role     User role
	 * @param fkUserId User ID
	 * @return List of ProductDetails objects containing product details
	 */
	@GetMapping("/getProductDetails")
	public List<ProductDetails> getproductlist(String role, String fkUserId) {
		return productservice.getproductlist(role, fkUserId);
	}

	/**
	 * Retrieves a list of all products for dropdown
	 * 
	 * @param role     User role
	 * @param fkUserId User ID
	 * @return List of product names as String
	 */
	@GetMapping("/getProduct-drop-down-list")
	public List<String> getproductdropdownlist(String role, String fkUserId) {
		return productservice.getproducdropdowntlist(role, fkUserId);
	}

	/**
	 * Retrieves a list of products for dropdown based on purchase filter
	 * 
	 * @param role          User role
	 * @param fkUserId      User ID
	 * @param categoryId    Category ID for filtering
	 * @param subCategoryId Subcategory ID for filtering
	 * @return List of product names as String
	 */
	@GetMapping("/getProduct-drop-down-list-purchase-filter")
	public List<String> getproductdropdownlistforpurchasefilter(String role, String fkUserId,
			@RequestParam(required = false) String categoryId, @RequestParam(required = false) String subCategoryId) {
		return productservice.getproductdropdowntlistforpurchasefilter(role, fkUserId, categoryId, subCategoryId);
	}

	/**
	 * Retrieves a list of products for dropdown based on sales
	 * 
	 * @param role     User role
	 * @param fkUserId User ID
	 * @return List of product names as String
	 */
	@GetMapping("/getProduct-drop-down-list-sale")
	public List<String> getproductdropdownlistForSales(String role, String fkUserId) {
		return productservice.getproducdropdowntlistForSales(role, fkUserId);
	}

	/**
	 * Retrieves a product by ID for editing
	 * 
	 * @param id       Product ID
	 * @param role     User role
	 * @param fkUserId User ID
	 * @return Optional of ProductDetails object containing product details
	 */
	@GetMapping("/getProductToEdit/{pk_product_id}")
	public Optional<ProductDetails> getproducttoedit(@PathVariable(value = "pk_product_id") Long id,
			@RequestParam String role, @RequestParam String fkUserId) {
		return productservice.getproducttoedit(id, role, fkUserId);
	}

	/**
	 * Updates product details
	 * 
	 * @param productdto ProductDto object containing product details
	 * @param role       User role
	 * @param fkUserId   User ID
	 * @return String indicating success or failure
	 */
	@PutMapping("/updatePproduct")
	public String updateproductdetails(@RequestBody ProductDto productdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		productservice.updateproduct(productdto, role, fkUserId);
		return "Customer updated successfully";
	}

	/**
	 * 
	 * POST endpoint to bulk upload product details from a file.
	 * 
	 * @param files    The MultipartFile representing the file to be uploaded.
	 * @param role     The role of the user performing the upload.
	 * @param fkUserId The ID of the user performing the upload.
	 * @return A String message indicating the status of the upload.
	 * @throws IOException                If there is an error with the input or
	 *                                    output.
	 * @throws EncryptedDocumentException If the document is encrypted and cannot be
	 *                                    read.
	 * @throws InvalidFormatException     If the format of the document is invalid.
	 * @throws ParseException             If there is an error parsing the document.
	 */
	@PostMapping("/bulkuploadproductdetails")
	public String bulkupload(@RequestParam("file") MultipartFile files, @RequestParam String role,
			@RequestParam String fkUserId)
			throws IOException, EncryptedDocumentException, InvalidFormatException, ParseException {
		String str = productservice.bulkuploadproductdetails(files, role, fkUserId);
		return str;
	}
}
