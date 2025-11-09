package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        return "alunos"; // ✅ Nome do arquivo alunos.html
    }

    @GetMapping("/cadastro-aluno")
    public String formAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "cadastro-aluno"; // ✅ Nome do arquivo cadastro-aluno.html
    }

    @PostMapping("/salvar-aluno")
    public String salvarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/alunos";
    }
}
