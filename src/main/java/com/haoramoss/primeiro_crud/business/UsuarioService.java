package com.haoramoss.primeiro_crud.business;

import com.haoramoss.primeiro_crud.infrastructure.entitys.Usuario;
import com.haoramoss.primeiro_crud.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela lógica de negócios relacionada a Usuários.
 * Intermedia a comunicação entre o Controller e o Repository.
 */
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    /**
     * Salva um novo usuário no banco de dados.
     *
     * @param usuario O objeto Usuario a ser salvo.
     */
    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    /**
     * Busca um usuário pelo e-mail.
     * Lança uma exceção caso o usuário não seja encontrado.
     *
     * @param email O e-mail do usuário.
     * @return O objeto Usuario encontrado.
     * @throws RuntimeException Se o e-mail não for encontrado.
     */
    public Usuario buscarUsuarioPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("E-mail não encontrado"));
    }

    /**
     * Deleta um usuário do banco de dados utilizando o e-mail.
     *
     * @param email O e-mail do usuário a ser deletado.
     */
    public void deletarUsuarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    /**
     * Atualiza os dados de um usuário existente.
     * Apenas os campos não nulos no objeto recebido serão atualizados.
     *
     * @param id      O ID do usuário a ser atualizado.
     * @param usuario O objeto Usuario com os novos dados.
     * @throws RuntimeException Se o usuário com o ID fornecido não for encontrado.
     */
    public void atualizarUsuarioPorId(Long id, Usuario usuario) {
        Usuario usuarioEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);

    }

}
