package br.com.aguiar.spring_boot_essencials.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.aguiar.spring_boot_essencials.database.model.ProductEntity;
import br.com.aguiar.spring_boot_essencials.dto.ProductDto;
import br.com.aguiar.spring_boot_essencials.exception.NotFoundException;

@Service
public class ProductService {
    private static final List<ProductEntity> PRODUTOS = new ArrayList<>();

    static{
        ProductEntity.builder()
            .id(1)
            .name("Notebook")
            .price(new BigDecimal("5000"))
            .quantity(10)
            .build();
            
        ProductEntity.builder()
            .id(2)
            .name("Iphone")
            .price(new BigDecimal("7000"))
            .quantity(10)
            .build();

        ProductEntity.builder()
            .id(3)
            .name("Mouse")
            .price(new BigDecimal("500"))
            .quantity(10)
            .build();
    }

    public List<ProductEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    public ProductEntity createProduct(ProductDto productDto) {

        Integer identifier = PRODUTOS.stream()
            .mapToInt(ProductEntity::getId)
            .max()
            .orElse(0) + 1;

        ProductEntity newProduct = ProductEntity.builder()
            .id(identifier)
            .name(productDto.getName())
            .price(productDto.getPrice())
            .quantity(productDto.getQuantity())
            .build();

        PRODUTOS.add(newProduct);
        
        return newProduct;
    }

    public ProductEntity updateProduct(ProductDto productDto, Integer id) throws NotFoundException {
        ProductEntity product = PRODUTOS.stream()
            .filter(p -> p.getId().equals(id))
            .findAny()
            .orElseThrow(() -> new NotFoundException("Product not found"));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        return product;
    }

    public void deleteProduct(Integer id) {
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }
}
