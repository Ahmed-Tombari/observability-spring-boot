package com.tombari.observabilityspringboot.service;

import com.tombari.observabilityspringboot.dto.ProductDTO;
import com.tombari.observabilityspringboot.exceptions.ProductAlreadyExistException;
import com.tombari.observabilityspringboot.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    ProductDTO saveNewProduct(ProductDTO productDTO) throws ProductAlreadyExistException;
    List<ProductDTO> getAllProducts();
    ProductDTO findProductById(String id) throws ProductNotFoundException;
    List<ProductDTO> searchProducts(String keyword);
    ProductDTO updateProduct(String id, ProductDTO productDTO)throws ProductNotFoundException;
    void deleteProduct(String id)throws ProductNotFoundException;
}
