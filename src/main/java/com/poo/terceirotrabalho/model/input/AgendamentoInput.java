package com.poo.terceirotrabalho.model.input;

import com.poo.terceirotrabalho.domain.models.Reserva;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter     
public class AgendamentoInput {
    @NotNull
    private UsuarioInput usuario;

    @NotBlank
    private String descricao;

    private String titulo;

    @NotBlank
    private String horarioentrada;
    
    private Reserva status;
}
