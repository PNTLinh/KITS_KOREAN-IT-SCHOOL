package com.topcit.aims.aims.repository;

import com.topcit.aims.aims.entity.Product;
import com.topcit.aims.aims.entity.ProductType;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
   Optional<Product> findByTitle(String title);
   List<Product> findByProductType(ProductType productType);
   List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
   //Tìm theo gần đúng
   List<Product> findByTitleContainingIgnoreCase(String keyword);
   List<Product> findByPriceAsc();
   List<Product> findByPriceDesc();
   //Thống kê số lượng sản phẩm theo loại
    long countByProductType(ProductType type);
}
