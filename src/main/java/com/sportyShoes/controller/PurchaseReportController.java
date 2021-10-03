package com.sportyShoes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sportyShoes.model.PurchaseReport;
import com.sportyShoes.service.PurchaseReportRepository;

@RestController
@RequestMapping("/PurchaseReport")
public class PurchaseReportController 
{
	
	@Autowired
	PurchaseReportRepository reportRepo;
	
	@RequestMapping(method = RequestMethod.POST, value="/addPurchaseReport")
	public String addProduct(@RequestBody PurchaseReport report)
	{
		// Date date = new Date();
	    // report.setPurchasedate(date);      
		 reportRepo.save(report);
		 return "PurchaseReport is added";
	}
	
	@RequestMapping("/getAllReportByCategory")
	public List<PurchaseReport> getAllReport() 
	{
		return reportRepo.findAllByOrderByCategoryAsc();
	}
	
	@RequestMapping("/getAllReportByDate")
	public List<PurchaseReport> getAllReport2() 
	{
		return reportRepo.findAllByOrderByPurchasedateAsc();
	}
}
