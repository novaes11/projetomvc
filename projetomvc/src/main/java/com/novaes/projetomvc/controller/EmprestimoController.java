package com.novaes.projetomvc.controller;

import com.novaes.projetomvc.model.Emprestimo;
import com.novaes.projetomvc.model.Livro;
import com.novaes.projetomvc.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("emprestimos", emprestimos);
        return "emprestimos/lista";
    }

    @PostMapping
    public String cadastrar(
            @RequestParam String tituloLivro,
            @RequestParam String nomeUsuario,
            @RequestParam(required = false) String dataDevolucaoPrevista) {

        LocalDate devolucao = (dataDevolucaoPrevista != null && !dataDevolucaoPrevista.isBlank())
                ? LocalDate.parse(dataDevolucaoPrevista)
                : LocalDate.now().plusDays(7);

        Livro livro = new Livro();
        livro.setTitulo(tituloLivro);

        Usuario usuario = new Usuario();
        usuario.setNome(nomeUsuario);

        Emprestimo emprestimo = new Emprestimo(livro, usuario, devolucao);
        emprestimos.add(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/devolver/{indice}")
    public String devolverPorLink(@PathVariable int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.get(indice).registrarDevolucao();
        }
        return "redirect:/emprestimos";
    }

    @PostMapping("/devolver/{indice}")
    public String devolver(@PathVariable int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.get(indice).registrarDevolucao();
        }
        return "redirect:/emprestimos";
    }

    @GetMapping("/excluir/{indice}")
    public String excluirPorLink(@PathVariable int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }
}
