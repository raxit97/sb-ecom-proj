package com.raxit.ecom_proj.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.raxit.ecom_proj.model.Product;
import com.raxit.ecom_proj.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProduct(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        try {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImage(imageFile.getBytes());
            return productRepo.save(product);
        } catch (Exception e) {
            throw e;
        }
    }

    public Product updateProduct(Product product, MultipartFile imageFile) throws IOException {
        try {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImage(imageFile.getBytes());
            return productRepo.save(product);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }

}
