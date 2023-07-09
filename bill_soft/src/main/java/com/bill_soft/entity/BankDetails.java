package com.bill_soft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "bank_details")
public class BankDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_bank_id")
	private Long pkBankId;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "branch_name")
	private String branchName;

	@Column(name = "ifsc_code")
	private String ifscCode;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "account_holder_name")
	private String accountHolderName;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name="bank_email")
	private String bankEmail;
	
	@Column(name = "address")
	private String address;

	@Column(name = "fk_oragnization_id")
	private Long fkOragnizationId;

	@Column(name = "fk_admin_id")
	private Long fkAdminId;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	
}
