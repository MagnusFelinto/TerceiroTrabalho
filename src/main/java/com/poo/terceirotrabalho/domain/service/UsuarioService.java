package com.poo.terceirotrabalho.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poo.terceirotrabalho.domain.excecoes.NegException;
import com.poo.terceirotrabalho.domain.models.Usuario;
import com.poo.terceirotrabalho.domain.repositorio.UsuarioRepositorio;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepositorio UserRepositorio;
    public Usuario buscar(Long userId){
        return UserRepositorio.findById(userId)
            .orElseThrow(() -> new NegException("Usuario não encontrado"));
    }

    @Transactional
    public Usuario salvar(Usuario usuario){
        boolean emailJatem = UserRepositorio.findByEmail(usuario.getEmail())
            .stream() .anyMatch(UserRepositorio -> !UserRepositorio.equals(usuario));
        if(emailJatem){
           throw new NegException("E-mail digitado já foi cadastrado");
        }
        return UserRepositorio.save(usuario);
    }

    @Transactional
    public void excluir(Long userId){
        UserRepositorio.deleteById(userId);
    }

}
