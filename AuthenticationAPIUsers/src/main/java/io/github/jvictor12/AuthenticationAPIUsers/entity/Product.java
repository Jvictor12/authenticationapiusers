package io.github.jvictor12.AuthenticationAPIUsers.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_products")
public class Product extends AbstractEntity {


    @NotEmpty
    private String nome;

    private String tipo;

    private Long codigo;

    private String marca;

    @NotNull
    private Integer quantidade;
}
