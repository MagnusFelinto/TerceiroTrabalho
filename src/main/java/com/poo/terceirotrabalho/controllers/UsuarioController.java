package com.poo.terceirotrabalho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.terceirotrabalho.domain.models.Usuario;
import com.poo.terceirotrabalho.domain.repositorio.UsuarioRepositorio;
import com.poo.terceirotrabalho.domain.service.AgendamentoService;
import com.poo.terceirotrabalho.domain.service.UsuarioService;
import com.poo.terceirotrabalho.model.input.LoginInput;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {
    @Autowired
    private UsuarioRepositorio usuarioRepository;
    private AgendamentoService agendamentoService;
    private UsuarioService usuarioService;

    
    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    //Listar Usuario por ID
    @GetMapping("/{userId}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long userId){
        return usuarioRepository.findById(userId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //Criar um novo usuario
    @PostMapping
    public Usuario criar(@Valid @RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    //Edita um usuario existente
    @PutMapping("/{userId}")
    public ResponseEntity<Usuario> atualizar(@Valid @PathVariable Long userId,@RequestBody Usuario usuario){
        if(!usuarioRepository.existsById(userId)){
            return ResponseEntity.notFound().build();
        }
        usuario.setId(userId);
        usuario = usuarioService.salvar(usuario);
        return ResponseEntity.ok(usuario);
    }

    //Deleta usuario pelo ID de usuario
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletar(@PathVariable Long userId){
        if(usuarioRepository.existsById(userId)){
            usuarioRepository.deleteById(userId);
            agendamentoService.deletarTodosAgendamentoDoUsuario(userId);
            // usuarioService.excluir(userId);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    
    }
    @PostMapping("/login")
    public Usuario criar(@Valid @RequestBody LoginInput loginInput){
        return usuarioService.login(loginInput);
    }
}
