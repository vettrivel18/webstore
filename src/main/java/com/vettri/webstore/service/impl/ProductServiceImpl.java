/**
 * 
 */
package com.vettri.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vettri.webstore.domain.Product;
import com.vettri.webstore.domain.repository.ProductRepository;
import com.vettri.webstore.service.ProductService;

/**
 * @author vettrivel
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	/*
	 * (non-Javadoc)
	 * @see com.vettri.webstore.service.ProductService#updateAllStock()
	 */
	@Override
	public void updateAllStock() {
		List<Product> allProducts = productRepository.getAllProducts();

		for (Product product : allProducts) {
			if (product.getUnitsInStock() < 500) {
				productRepository.updateStock(product.getProductId(), product.getUnitsInStock() + 1000);
			}
		}

	}
	
	/*
	 * (non-Javadoc)
	 * @see com.vettri.webstore.service.ProductService#getProductsByCategory()
	 */
	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
}
