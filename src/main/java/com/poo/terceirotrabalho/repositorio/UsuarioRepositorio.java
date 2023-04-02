package com.poo.terceirotrabalho.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poo.terceirotrabalho.entidade.Usuario;
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    
}
