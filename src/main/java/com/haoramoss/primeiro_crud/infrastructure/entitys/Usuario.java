package com.haoramoss.primeiro_crud.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa a entidade de Usuário no sistema.
 * Mapeada para a tabela "usuario" no banco de dados.
 * Utiliza o Lombok para reduzir a verbosidade do código (Getters, Setters,
 * Construtores, Builder).
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;
}
