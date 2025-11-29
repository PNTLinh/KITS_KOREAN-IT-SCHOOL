package com.topcit.aims.aims.controller;

import com.topcit.aims.aims.entity.Product;
import com.topcit.aims.aims.entity.ProductType;
import com.topcit.aims.aims.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.updateProduct(id, product));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productService.getByTitleContainingIgnoreCase(keyword);
    }

    @GetMapping("/type/{type}")
    public List<Product> getProductsByType(@PathVariable ProductType type) {
        return productService.getProductsByProductType(type);
    }

    @GetMapping("/price-range")
    public List<Product> getProductsByPriceRange(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return productService.getProductsByPriceBetween(min, max);
    }
    @GetMapping("/sort/price/asc")
    public List<Product> getProductsSortedByPriceAsc() {
        return productService.getByPriceAsc();
    }

    @GetMapping("/sort/price/desc")
    public List<Product> getProductsSortedByPriceDesc() {
        return productService.getByPriceDesc();
    }

    @GetMapping("/count/{type}")
    public long countProductsByType(@PathVariable ProductType type) {
        return productService.countByProductType(type);
    }
}
