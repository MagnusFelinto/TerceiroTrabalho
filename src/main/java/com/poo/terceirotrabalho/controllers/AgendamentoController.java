package com.poo.terceirotrabalho.controllers;
import java.util.List;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.poo.terceirotrabalho.assembler.AgendamentoAssembler;
import com.poo.terceirotrabalho.domain.models.Agendamento;
import com.poo.terceirotrabalho.domain.repositorio.AgendamentoRepositorio;
import com.poo.terceirotrabalho.domain.service.AgendamentoService;
import com.poo.terceirotrabalho.model.AgendamentoModel;
import com.poo.terceirotrabalho.model.input.AgendamentoInput;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/agendamento")
@AllArgsConstructor
public class AgendamentoController {
    @Autowired
    private AgendamentoRepositorio AgendamentoRepository;
    private AgendamentoAssembler agendamentoAssembler;
    private AgendamentoService agendamentoService;

    //Listar Todas as Agendamentos
    @GetMapping
    public List<Agendamento> listar(){
        return AgendamentoRepository.findAll();
    }

    //Busca uma Agendamento por ID
    @GetMapping("/{AgendamentoId}")
    public ResponseEntity<Agendamento> buscar(@PathVariable Long AgendamentoId){
        return AgendamentoRepository.findById(AgendamentoId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //Criar nova Agendamento
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoModel criar(@Valid @RequestBody AgendamentoInput agendamentoInput ){
        Agendamento novoAgendamento   = agendamentoAssembler.toEntity(agendamentoInput);
        Agendamento agendamentoCriado = agendamentoService.novaAgendamento(novoAgendamento);

        return agendamentoAssembler.toModel(agendamentoCriado);

    }

    @PutMapping("/editar/{AgendamentoId}")
    public AgendamentoModel editarAgendamento(@PathVariable Long AgendamentoId, @RequestBody AgendamentoInput agendamentoInput){
        Long usuarioId = agendamentoInput.getUsuario().getId();
        return agendamentoService.editar(usuarioId, AgendamentoId, agendamentoInput);
    }

    //Deletar uma Agendamento pelo ID do Agendamento
    @DeleteMapping("/{AgendamentoId}")
    public ResponseEntity<Void> deletar(@PathVariable Long AgendamentoId){
        if(!AgendamentoRepository.existsById(AgendamentoId)){
            return ResponseEntity.notFound().build();
        }
        AgendamentoRepository.deleteById(AgendamentoId);
        return ResponseEntity.noContent().build();
    }

    // Listar todas os agendamentos de um usuario
    @GetMapping("/user/{userId}")
    public List<AgendamentoModel> AgendamentosDeUmUsuario(@Valid @PathVariable Long userId){
        return agendamentoAssembler.toCollectionModel(AgendamentoRepository.findByUsuarioId(userId));
    }

    @PutMapping("/editar/{AgendamentoId}/reserva")
    public Agendamento editarReservaAgendamento(@PathVariable Long AgendamentoId){
        return agendamentoService.editarReserva(AgendamentoId);
    }

     //Deleta todos os Agendamentos de um usuario
    @DeleteMapping("/user/{userId}")
    public void deletarTodasAgendamentosUser(@PathVariable Long userId){
        agendamentoService.deletarTodosAgendamentoDoUsuario(userId);
    }

}
