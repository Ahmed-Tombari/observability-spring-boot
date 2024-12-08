package com.tombari.observabilityspringboot.web;

import com.tombari.observabilityspringboot.dto.ProductDTO;
import com.tombari.observabilityspringboot.model.Users;
import com.tombari.observabilityspringboot.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private ProductService productService;
    RestClient restClient;

    public ProductRestController(ProductService productService, RestClient.Builder restClient) {
        this.productService = productService;
        this.restClient = restClient.baseUrl("https://json-placeholder.mock.beeceptor.com").build();
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable String id){
        return productService.findProductById(id);
    }
    @GetMapping("/products/search")
    public List<ProductDTO> searchProducts(@RequestParam String keyword){
        return productService.searchProducts(keyword);
    }
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO saveProduct(@RequestBody @Valid ProductDTO productDTO){
        return productService.saveNewProduct(productDTO);
    }
    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);
    }
    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }

    @GetMapping("/users")
    public List<Users> allPosts(){
        return restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Users>>() {});
    }
}

