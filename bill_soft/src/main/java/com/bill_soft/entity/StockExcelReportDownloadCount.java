package com.bill_soft.entity;

import java.util.Date;

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
@Table(name="")
public class StockExcelReportDownloadCount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_download_id")
	private Long pkDownloadId;
	
	@Column(name="file_type")
	private String fileType;
	
	@Column(name="fk_user_id")
	private String fkUserId;	
	
	@Column(name="role")
	private String role;
	
	@Column(name="time_stamp")
	private Date timeStamp;
	
	@Column(name="download_count")
	private Long dwnldCount;

	
}
