package com.bill_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.StockExcelReportDownloadCount;

@Repository
public interface ExcelPdfRepository extends JpaRepository<StockExcelReportDownloadCount,Long> {

}
