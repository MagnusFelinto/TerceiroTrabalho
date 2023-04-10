package com.poo.terceirotrabalho.model;

import com.poo.terceirotrabalho.domain.models.Reserva;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoModel {
    private Long id;
    private String titulo;
    private String descricao;
    private String horarioentrada;
    private Reserva status;
}
