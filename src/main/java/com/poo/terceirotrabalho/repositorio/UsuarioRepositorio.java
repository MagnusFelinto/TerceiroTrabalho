package com.poo.terceirotrabalho.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.terceirotrabalho.entidade.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    
}
