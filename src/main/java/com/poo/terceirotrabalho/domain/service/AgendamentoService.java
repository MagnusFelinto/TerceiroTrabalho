package com.poo.terceirotrabalho.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import com.poo.terceirotrabalho.domain.models.Agendamento;
import com.poo.terceirotrabalho.domain.models.Reserva;
import com.poo.terceirotrabalho.domain.models.Usuario;
import com.poo.terceirotrabalho.domain.repositorio.AgendamentoRepositorio;
import com.poo.terceirotrabalho.domain.repositorio.UsuarioRepositorio;
import com.poo.terceirotrabalho.model.AgendamentoModel;
import com.poo.terceirotrabalho.model.input.AgendamentoInput;
import com.poo.terceirotrabalho.domain.excecoes.EntidNaoEncotradaExepstion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AgendamentoService {

    private AgendamentoRepositorio AgendamentoRepository;
    private UsuarioService usuarioService;
    private ModelMapper modelMapper;
    @PackagePrivate UsuarioRepositorio usuarioRepository;

    public Agendamento novaAgendamento(Agendamento Agendamento){
        Usuario usuario = usuarioService.buscar(Agendamento.getUsuario().getId());
        Agendamento.setStatus(Reserva.LIVRE);
        Agendamento.setUsuario(usuario);
        return AgendamentoRepository.save(Agendamento);

    }

    @Transactional
    public Agendamento editarReserva(Long agendaId){
        Agendamento Agendamento = AgendamentoRepository.findById(agendaId).orElseThrow(()-> new EntidNaoEncotradaExepstion("Agendamento não encontrado"));
        Agendamento.setStatus(Reserva.AGENDADA);
        return AgendamentoRepository.save(Agendamento);
    }


    public AgendamentoModel editar(Long usuarioId, Long agendaId, AgendamentoInput agendamentoInput){
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(()-> new EntidNaoEncotradaExepstion("Usuario não encontrado"));
        Agendamento Agendamento = AgendamentoRepository.findById(agendaId).orElseThrow(()-> new EntidNaoEncotradaExepstion("Agendamento não encontrado"));
        modelMapper.map(agendamentoInput, Agendamento);
        Agendamento.setUsuario(usuario);
        Agendamento = AgendamentoRepository.save(Agendamento);
        return modelMapper.map(Agendamento, AgendamentoModel.class);
    }

    
    public List<Agendamento> buscarAgendamento(Long userId){
        return AgendamentoRepository.findByUsuarioId(userId);
    }

    @Transactional
    public void excluir(Long agendaId){
        AgendamentoRepository.deleteById(agendaId);
    }

    public void deletarTodosAgendamentoDoUsuario(Long userId){
        List<Agendamento> Agendamento = AgendamentoRepository.findByUsuarioId(userId);

        if(Agendamento.isEmpty())
            throw new EntidNaoEncotradaExepstion("Não há nenhum agendamento encontrado desse usuario");
        
        AgendamentoRepository.deleteAll(Agendamento);
    }
}
