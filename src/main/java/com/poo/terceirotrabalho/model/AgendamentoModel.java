package com.poo.terceirotrabalho.model;

import java.time.OffsetDateTime;

import com.poo.terceirotrabalho.domain.models.Reserva;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoModel {
    private Long id;
    // private UsuarioModel usuario;
    private String descricao;
    private String horarioentrada;
    private Reserva status;
}
