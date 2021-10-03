package com.sportyShoes.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sportyShoes.model.Product;
import com.sportyShoes.service.productRepository;

@RestController
@RequestMapping("/Product")
public class ProductController 
{
	@Autowired
    productRepository productRepo;
	
	@RequestMapping("/getAll")
	public List<Product> getAllProduct() 
	{
		List<Product> product = new ArrayList<Product>();
		productRepo.findAll().forEach(product::add);
		return product;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addProduct")
	public String addProduct(@RequestBody Product product)
	{
		 Date date = new Date();
	     product.setDate(date);      
		 productRepo.save(product);
		 return "Product is added";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) 
	{
		productRepo.deleteById(id);
		return "Product is Deleted";
	}
    
	@RequestMapping(method = RequestMethod.PUT, value="/updateProduct/{id}")
	public String updateProduct(@PathVariable int id,@RequestBody Product product) 
	{
        Date date = new Date();
        product.setDate(date);
        product.setProductId(id);
		productRepo.save(product);
		return "Product is updated";
	}
	
	@RequestMapping("/getById/{id}")
	public Optional<Product> allProduct(@PathVariable int id) 
	{
		return productRepo.findById(id);
	}
	
	@RequestMapping("/getBySeason/{season}")
	public List<Product> allProductBySeason(@PathVariable String season) 
	{
		return productRepo.findBySeason(season);
	}
	
	@RequestMapping("/getByBrand/{brand}")
	public List<Product> allProductByBrand(@PathVariable String brand) 
	{
		return productRepo.findByBrand(brand); 
	}
	
	@RequestMapping("/getByCategory/{category}")
	public List<Product> allProductByCategory(@PathVariable String category) 
	{
		return productRepo.findByCategory(category);
	}
	
	@RequestMapping("/getByPrice/{order}")
	public List<Product> allProductByPrice(@PathVariable String order) 
	{
		if(order.equals("Asc"))
		   return productRepo.findAllByOrderByPriceAsc();
		else
		   return productRepo.findAllByOrderByPriceDesc();		
	}
	
	@RequestMapping("/getByColor/{color}")
	public List<Product> allProductByColor(@PathVariable String color) 
	{
		return productRepo.findByColor(color);
	}
	
	@RequestMapping("/getLatestProductByDate")
	public List<Product> latestProductByDate() 
	{
		return productRepo.findAllByOrderByDateDesc();
	}
}
