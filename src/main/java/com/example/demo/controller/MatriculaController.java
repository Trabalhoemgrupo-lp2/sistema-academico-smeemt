package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Matricula;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.MatriculaRepository;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // 🔹 Lista todas as matrículas
    @GetMapping
    public String listarMatriculas(Model model) {
        model.addAttribute("listaMatriculas", matriculaRepository.findAll());
        return "lista-matriculas";
    }

    // 🔹 Exibe o formulário de nova matrícula
    @GetMapping("/nova")
    public String novaMatricula(Model model) {
        model.addAttribute("matricula", new Matricula());
        model.addAttribute("alunos", alunoRepository.findAll());
        model.addAttribute("cursos", cursoRepository.findAll());
        return "cadastro-matricula";
    }

    // 🔹 Salvar a matrícula
    @PostMapping("/salvar")
    public String salvarMatricula(@ModelAttribute Matricula matricula) {
        matriculaRepository.save(matricula);
        return "redirect:/matriculas";
    }

    // 🔹 Excluir matrícula
    @GetMapping("/excluir/{id}")
    public String excluirMatricula(@PathVariable("id") Long id) {
        matriculaRepository.deleteById(id);
        return "redirect:/matriculas";
    }
}
