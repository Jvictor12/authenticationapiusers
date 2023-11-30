package io.github.jvictor12.AuthenticationAPIUsers.dto;

import io.github.jvictor12.AuthenticationAPIUsers.entity.Product;

import java.io.Serializable;


public record ProductDTO (
        Long codigo,
        String nome,
        Integer quantidade,
        String marca
) implements Serializable {

    public ProductDTO (Product product) {
        this(
                product.getCodigo(),
                product.getNome(),
                product.getQuantidade(),
                product.getMarca()
        );
    }
}

