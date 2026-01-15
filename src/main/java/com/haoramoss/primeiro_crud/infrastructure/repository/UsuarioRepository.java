package com.haoramoss.primeiro_crud.infrastructure.repository;

import com.haoramoss.primeiro_crud.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interface Repository para a entidade Usuario.
 * Estende JpaRepository para fornecer operações de CRUD padrão.
 * O Spring Data JPA implementa automaticamente esta interface em tempo de
 * execução.
 */
// table / id type
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca um usuário pelo seu endereço de e-mail.
     *
     * @param email O e-mail do usuário a ser buscado.
     * @return Um Optional contendo o usuário se encontrado, ou vazio caso
     *         contrário.
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Deleta um usuário pelo seu endereço de e-mail.
     * A anotação @Transactional garante que a operação seja executada dentro de uma
     * transação.
     *
     * @param email O e-mail do usuário a ser deletado.
     */
    @Transactional
    void deleteByEmail(String email);
}
