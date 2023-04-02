package com.poo.terceirotrabalho.entidade;
import java.time.OffsetDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// @Table(name = "agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotBlank
    private String nome;

    // @NotBlank
    private String email;
    
    // @NotBlank
    private OffsetDateTime horarioEntrada;

    // @NotBlank
    private  OffsetDateTime horarioSaida;

}
