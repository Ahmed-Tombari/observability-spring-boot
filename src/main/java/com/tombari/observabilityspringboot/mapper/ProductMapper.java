package com.tombari.observabilityspringboot.mapper;

import com.tombari.observabilityspringboot.entities.Product;
import com.tombari.observabilityspringboot.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {
    private ModelMapper modelMapper=new ModelMapper();
    public ProductDTO fromProduct(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }
    public Product fromProductDTO(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }
    public List<ProductDTO> fromListProducts(List<Product> products){
        return products.stream().map(c->modelMapper.map(c, ProductDTO.class)).collect(Collectors.toList());
    }
}
