package com.poo.terceirotrabalho.model.input;

import java.time.OffsetDateTime;

import com.poo.terceirotrabalho.domain.models.Reserva;
import com.poo.terceirotrabalho.model.UsuarioModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter     
@AllArgsConstructor
public class AgendamentoInput {
    
    @NotNull
    private UsuarioInput usuario;

    @NotBlank
    private String descricao;

    @NotBlank
    private String horarioentrada;
    
    private Reserva status;
}
