package com.novaes.projetomvc.controller;

import com.novaes.projetomvc.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/autores")
public class AutorController {
    private ArrayList<Autor> autores = new ArrayList<>();

    @GetMapping
    public String listarAutores(Model model) {
        model.addAttribute("autores", autores);
        return "autores/lista";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Autor autor) {
        autores.add(autor);
        return "redirect:/autores";
    }

    @PostMapping("/editar/{indice}")
    public String editar(@PathVariable int indice, @ModelAttribute Autor autorAtualizado) {
        if (indice >= 0 && indice < autores.size()) {
            Autor autorExistente = autores.get(indice);
            autorExistente.setNome(autorAtualizado.getNome());
            autorExistente.setNacionalidade(autorAtualizado.getNacionalidade());
        }
        return "redirect:/autores";
    }

    @GetMapping("/excluir/{indice}")
    public String excluirPorLink(@PathVariable int indice) {
        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/autores";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}