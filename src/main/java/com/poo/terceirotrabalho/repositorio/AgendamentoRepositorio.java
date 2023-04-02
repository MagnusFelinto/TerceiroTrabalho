package com.poo.terceirotrabalho.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.terceirotrabalho.entidade.Agendamento;

public interface AgendamentoRepositorio extends JpaRepository<Agendamento, Long>  {
    
}

