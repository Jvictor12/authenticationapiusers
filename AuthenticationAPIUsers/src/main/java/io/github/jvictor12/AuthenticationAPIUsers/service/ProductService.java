package io.github.jvictor12.AuthenticationAPIUsers.service;

import io.github.jvictor12.AuthenticationAPIUsers.entity.Product;
import io.github.jvictor12.AuthenticationAPIUsers.exception.ObjectNotFoundException;
import io.github.jvictor12.AuthenticationAPIUsers.exception.ValidationException;
import io.github.jvictor12.AuthenticationAPIUsers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Produto não encontrado");
        });
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        if (product == null) {
            throw new ValidationException("Produto Invalido");
        }

        productRepository.save(product);

        return product;
    }
}
