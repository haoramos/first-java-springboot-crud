package com.haoramoss.primeiro_crud.controller;

import com.haoramoss.primeiro_crud.business.UsuarioService;
import com.haoramoss.primeiro_crud.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller REST para gerenciar operações de Usuário.
 * Expõe endpoints para criar, buscar, atualizar e deletar usuários.
 */
@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    /**
     * Endpoint para salvar um novo usuário.
     *
     * @param usuario O corpo da requisição contendo os dados do usuário.
     * @return ResponseEntity com status 200 OK se bem-sucedido.
     */
    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint para buscar um usuário por e-mail.
     *
     * @param email O parâmetro de requisição com o e-mail do usuário.
     * @return ResponseEntity contendo o objeto Usuario e status 200 OK.
     */
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    /**
     * Endpoint para deletar um usuário por e-mail.
     *
     * @param email O parâmetro de requisição com o e-mail do usuário a ser
     *              deletado.
     * @return ResponseEntity com status 200 OK se bem-sucedido.
     */
    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint para atualizar um usuário existente.
     *
     * @param id      O parâmetro de requisição com o ID do usuário a ser
     *                atualizado.
     * @param usuario O corpo da requisição com os novos dados do usuário.
     * @return ResponseEntity com status 200 OK se bem-sucedido.
     */
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Long id, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}