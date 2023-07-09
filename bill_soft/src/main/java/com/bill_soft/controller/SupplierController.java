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

import com.bill_soft.dto.SupplierDto;
import com.bill_soft.entity.SupplierDetails;
import com.bill_soft.service.SupplierService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class SupplierController implements ErrorController {

	/**
	 * 
	 * This class is a controller for managing supplier related operations.
	 */

	@Autowired
	private SupplierService supplierservice;

	/**
	 * 
	 * Adds a new supplier to the system.
	 * 
	 * @param supplierdto the DTO object for supplier details
	 * @param role        the user role
	 * @param fkUserId    the foreign key for user id
	 * @return a string indicating whether the operation was successful or not
	 */
	@PostMapping("/addSupplierDetails")
	public String addsupplierdetails(@RequestBody SupplierDto supplierdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		supplierservice.addsupplier(supplierdto, role, fkUserId);
		return "Supplier Added Successfully";
	}

	/**
	 * 
	 * Retrieves a list of all suppliers based on the user role and foreign key user
	 * id.
	 * 
	 * @param role     the user role
	 * @param fkUserId the foreign key for user id
	 * @return a list of SupplierDetails objects
	 */
	@GetMapping("/getSupplierList")
	public List<SupplierDetails> getsupplierlist(@RequestParam String role, @RequestParam String fkUserId) {
		return supplierservice.getsupplier(role, fkUserId);
	}

	/**
	 * 
	 * Retrieves a supplier details based on the supplier id, user role and foreign
	 * key user id.
	 * 
	 * @param id       the supplier id
	 * @param role     the user role
	 * @param fkUserId the foreign key for user id
	 * @return an Optional containing a SupplierDetails object if it exists, else an
	 *         empty Optional
	 */
	@GetMapping("/getSupplierToEdit/{pk_supplier_id}")
	public Optional<SupplierDetails> editsupplier(@PathVariable(value = "pk_supplier_id") Long id,
			@RequestParam String role, @RequestParam String fkUserId) {
		return supplierservice.editsupplier(id, role, fkUserId);
	}

	/**
	 * 
	 * Updates the details of an existing supplier.
	 * 
	 * @param supplierdto the DTO object for supplier details
	 * @param role        the user role
	 * @param fkUserId    the foreign key for user id
	 * @return a string indicating whether the operation was successful or not
	 */
	@PutMapping("/updateSupplierDetails")
	public String updatesupplier(@RequestBody SupplierDto supplierdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		supplierservice.updatesupplier(supplierdto, role, fkUserId);
		return "supplier details updated Successfully";
	}

	/**
	 * 
	 * Retrieves a list of suppliers for populating a drop-down list based on the
	 * user role and foreign key user id.
	 * 
	 * @param role     the user role
	 * @param fkUserId the foreign key for user id
	 * @return a list of supplier names
	 */
	@GetMapping("/getSupplier-Drop-Down-List")
	public List<String> getsupplierdropdown(@RequestParam String role, @RequestParam String fkUserId) {
		return supplierservice.getsupplierdropdownlist(role, fkUserId);
	}

	/**
	 * 
	 * This method is used to upload multiple supplier details using a CSV file.
	 * 
	 * @param files    the CSV file containing supplier details to be uploaded
	 * @param role     the role of the user performing the upload
	 * @param fkUserId the ID of the user performing the upload
	 * @return a message indicating whether the upload was successful or not
	 * @throws IOException                if an I/O exception occurs while reading
	 *                                    the file
	 * @throws EncryptedDocumentException if the file is encrypted and cannot be
	 *                                    read
	 * @throws InvalidFormatException     if the file format is invalid
	 * @throws ParseException             if there is an error while parsing the
	 *                                    file
	 */
	@PostMapping("/bulkuploadsupplierdetails")
	public String uploadsupplier(@RequestParam("file") MultipartFile files, @RequestParam String role,
			@RequestParam String fkUserId)
			throws IOException, EncryptedDocumentException, InvalidFormatException, ParseException {
		String str = supplierservice.bulkuploadsupplierdetails(files, role, fkUserId);
		return str;
	}
}
