package com.poo.terceirotrabalho.model.input;

import com.poo.terceirotrabalho.domain.models.Reserva;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoEditarInput {
    private String descricao;

    private String titulo;
    
    private String horarioentrada;
}
/* 
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
   @NotBlank
    private String descricao;

    private String titulo;

    @NotBlank
    private String horarioentrada;
    
    private Reserva status;
}*/