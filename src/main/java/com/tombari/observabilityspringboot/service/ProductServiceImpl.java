package com.tombari.observabilityspringboot.service;

import com.tombari.observabilityspringboot.dto.ProductDTO;
import com.tombari.observabilityspringboot.entities.Product;
import com.tombari.observabilityspringboot.exceptions.ProductAlreadyExistException;
import com.tombari.observabilityspringboot.exceptions.ProductNotFoundException;
import com.tombari.observabilityspringboot.mapper.ProductMapper;
import com.tombari.observabilityspringboot.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveNewProduct(ProductDTO productDTO) throws ProductAlreadyExistException {
        log.info(String.format("Saving new Product => %s ", productDTO.toString()));
        Optional<Product> byEmail = productRepository.findByName(productDTO.getName());
        if(byEmail.isPresent()) {
            log.error(String.format("This product %s already exist", productDTO.getName()));
            throw new ProductAlreadyExistException();
        }
        Product productToSave = productMapper.fromProductDTO(productDTO);
        Product savedProduct = productRepository.save(productToSave);
        ProductDTO result = productMapper.fromProduct(savedProduct);
        return result;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return productMapper.fromListProducts(allProducts);
    }

    @Override
    public ProductDTO findProductById(String id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) throw new ProductNotFoundException();
        return productMapper.fromProduct(product.get());
    }

    @Override
    public List<ProductDTO> searchProducts(String keyword) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(keyword);
        return productMapper.fromListProducts(products);
    }

    @Override
    public ProductDTO updateProduct(String id, ProductDTO productDTO) throws ProductNotFoundException {
        Optional<Product> product=productRepository.findById(id);
        if(product.isEmpty()) throw new ProductNotFoundException();
        productDTO.setId(id);
        Product productToUpdate = productMapper.fromProductDTO(productDTO);
        Product updatedProduct = productRepository.save(productToUpdate);
        return productMapper.fromProduct(updatedProduct);
    }

    @Override
    public void deleteProduct(String id) throws ProductNotFoundException {
        Optional<Product> product=productRepository.findById(id);
        if(product.isEmpty()) throw new ProductNotFoundException();
        productRepository.deleteById(id);
    }
}
