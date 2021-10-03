package com.sportyShoes.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.sportyShoes.model.Product;

public interface productRepository extends CrudRepository<Product, Integer> 
{
	
	List<Product> findByName(String name);
	
	List<Product> findAllByOrderByDateDesc();
	
	List<Product> findAllByOrderByDateAsc();
	
	List<Product> findBySeason(String season);
	
	List<Product> findByBrand(String brand);
	
	List<Product> findByCategory(String category);
	
	List<Product> findAllByOrderByPriceAsc();
	
	List<Product> findAllByOrderByCategoryAsc();
	
	List<Product> findAllByOrderByPriceDesc();
	
	List<Product> findByColor(String color);
	
	List<Product> findByDate(String date);
}
