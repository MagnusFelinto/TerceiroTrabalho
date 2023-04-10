package com.poo.terceirotrabalho.domain.repositorio;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.terceirotrabalho.domain.models.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findBySenha(String senha);
    Optional<Usuario> findByEmailAndSenha(String email, String senha);

}
