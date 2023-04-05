package com.poo.terceirotrabalho.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {
    
    @NotNull
    private Long id;
}
