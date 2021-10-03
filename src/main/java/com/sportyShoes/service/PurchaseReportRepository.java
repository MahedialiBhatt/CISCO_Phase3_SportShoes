package com.sportyShoes.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sportyShoes.model.Product;
import com.sportyShoes.model.PurchaseReport;

public interface PurchaseReportRepository extends CrudRepository<PurchaseReport, Integer> 
{
	
	List<PurchaseReport> findAllByOrderByCategoryAsc();
	
	List<PurchaseReport> findAllByOrderByPurchasedateAsc();

}
