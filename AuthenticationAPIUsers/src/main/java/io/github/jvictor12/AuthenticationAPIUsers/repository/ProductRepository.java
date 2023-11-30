package io.github.jvictor12.AuthenticationAPIUsers.repository;

import io.github.jvictor12.AuthenticationAPIUsers.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
