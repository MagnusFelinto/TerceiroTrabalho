package com.poo.terceirotrabalho.domain.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.terceirotrabalho.domain.models.Agendamento;

@Repository
public interface AgendamentoRepositorio extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByUsuarioId(Long userId);
}

