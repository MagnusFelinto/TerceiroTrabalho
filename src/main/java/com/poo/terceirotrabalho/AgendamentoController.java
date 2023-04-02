package com.poo.terceirotrabalho;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoRepositorio agendamentoRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String exibirFormularioDeCadastro(Agendamento agendamento) {
        return "formulario-de-cadastro"; // return "formulario-de-cadastro";
    }

    public String teste() {
        return "testado";
    }

    @PostMapping("/salvar")
    public String salvarAgendamento(@Validated Agendamento agendamento, BindingResult result) {
        if (result.hasErrors()) {
            return "formulario-de-cadastro";
        }
        agendamentoRepository.save(agendamento);
        return "redirect:/agendamentos/listar";
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        model.addAttribute("agendamentos", agendamentos);
        return "lista-de-usuarios";
    }

}
