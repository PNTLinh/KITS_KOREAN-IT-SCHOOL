package com.topcit.aims.aims.service;

import com.topcit.aims.aims.entity.Product;
import com.topcit.aims.aims.entity.ProductType;
import com.topcit.aims.aims.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // Create
    public Product createProduct(Product product) {
        if (product.getTitle() == null || product.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Product title cannot be empty");
        }
        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (product.getProductType() == null) {
            throw new IllegalArgumentException("Product type must be provided");
        }
        return productRepository.save(product);
    }

    // Read
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id){
        return productRepository.findById(id);
    }

    public Optional<Product> getProductByTitle(String title){
        return productRepository.findByTitle(title);
    }

    public List<Product> getProductsByProductType(ProductType productType){
        return productRepository.findByProductType(productType);
    }

    public List<Product> getProductsByPriceBetween(BigDecimal min, BigDecimal max){
        return productRepository.findByPriceBetween(min, max);
    }

    // Update
    public Product updateProduct(Integer id, Product updatedProduct){
        return productRepository.findById(id)
                .map(product -> {
                    product.setTitle(updatedProduct.getTitle());
                    product.setPrice(updatedProduct.getPrice());
                    product.setProductType(updatedProduct.getProductType());
                    product.setAddedDate(updatedProduct.getAddedDate());
                    product.setQuantity(updatedProduct.getQuantity());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Cannot find product to update"));
    }

    // Delete
    public void deleteProduct(Integer id){
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    public List<Product> getByPriceAsc() {
        return productRepository.findByPriceAsc();
    }

    public List<Product> getByPriceDesc() {
        return productRepository.findByPriceDesc();
    }

    public long countByProductType(ProductType type) {
        return productRepository.countByProductType(type);
    }

    public List<Product> getByTitleContainingIgnoreCase(String keyword) {
        return productRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
