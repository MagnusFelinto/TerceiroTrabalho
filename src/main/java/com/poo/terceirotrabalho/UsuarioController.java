package com.poo.terceirotrabalho;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.terceirotrabalho.entidade.Usuario;
import com.poo.terceirotrabalho.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepositorio repositorio;
    @GetMapping
    public List<Usuario> listar(){
        // Lista de usuarios
        return repositorio.findAll();
    }
    @PostMapping
    public void salvar(@RequestBody Usuario usuario){
            repositorio.save(usuario);
    }

    @PutMapping
    public void alterar(@RequestBody Usuario usuario){
        if(usuario.getId() > 0)
            repositorio.save(usuario);
        
    }
    
    @DeleteMapping
    public void excluir(@RequestBody Usuario usuario){
        repositorio.delete(usuario);
    }

}
