package com.example.buoi_1.controller;

import com.example.buoi_1.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    // tạo danh sách book để test
    private List<Product> products = new ArrayList<>(List.of(
            new Product("1", "IPhone 12", "1T Màu Xanh Nước Biên", 1000, "Apple"),
            new Product("2", "IPhone 13", "1T Màu Cam Nhám", 2000, "Apple"),
            new Product("3", "IPhone 14", "1T Màu Đen Bóng", 3000, "Apple"),
            new Product("4", "IPhone 15", "1T Màu Đỏ Cam Nhạt", 4000, "Apple"),
            new Product("5", "IPhone 16", "1T Màu Tím TiTan", 5000, "Apple"),
            new Product("6", "Galaxy s22", "1T Màu Hồng Phấn", 4500, "SamSung"),
            new Product("7", "IPhone 11", "1T Màu xanh", 500, "Apple"),
            new Product("8", "Galaxy s21", "1T Màu Trắng nhạt", 7000, "SamSung"),
            new Product("9", "IPhone 17", "1T Màu Xám", 6000, "Apple"),
            new Product("10", "Galaxy s23", "1T Màu Xanh lá", 7500, "SamSung")
    ));

    // tất cả sản phẩm
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return products;
    }
    // lấy ra sản phẩm từ 5 đến 1o sản phẩm
     @GetMapping("/products/sublist")
    public List<Product> getListProductsBySubList(){
        return products.subList(4,10);
     }

     // lấy sản phẩm theo id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id){
        for (Product product: products){
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    // lấy ra sản phẩm giá lớn nhất
    @GetMapping("/products/max")
    public Product getProudctMax(){
      Product maxProduct = null;
      Integer maxPrice = Integer.MIN_VALUE;
      for (Product product: products){
          if (product.getPrice() > maxPrice){
              maxPrice = product.getPrice();
              maxProduct = product;
          }
      }
      return maxProduct;
    }

}
