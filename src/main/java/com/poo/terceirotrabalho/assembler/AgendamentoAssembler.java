package com.poo.terceirotrabalho.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.poo.terceirotrabalho.domain.models.Agendamento;
import com.poo.terceirotrabalho.model.AgendamentoModel;
import com.poo.terceirotrabalho.model.input.AgendamentoInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AgendamentoAssembler {

    private ModelMapper modelMapper;

    public Agendamento toEntity(AgendamentoInput AgendamentoInput){
        return modelMapper.map(AgendamentoInput, Agendamento.class);
    }

    public AgendamentoModel toModel(Agendamento Agendamento){
        return modelMapper.map(Agendamento, AgendamentoModel.class);
    }


    public List<AgendamentoModel> toCollectionModel(List<Agendamento> Agendamento){
        return Agendamento.stream()
            .map(this::toModel)
            .collect(Collectors.toList());
    }
}
