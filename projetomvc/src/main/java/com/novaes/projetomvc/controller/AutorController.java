package com.novaes.projetomvc.controller;

import com.novaes.projetomvc.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/autores")
public class AutorController {
    private ArrayList<Autor> autores = new ArrayList<>();

    @GetMapping
    public String listarAutores(Model model) {
        model.addAttribute("autores", autores);
        return "autores/lista"; // aponta para templates/autores/lista.html
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Autor autor) {
        autores.add(autor);
        return "redirect:/autores";
    }

    @PutMapping("/editar/{indice}")
    public String editar(@PathVariable int indice, @ModelAttribute Autor autorAtualizado) {
        if (indice >= 0 && indice < autores.size()) {
            Autor autorExistente = autores.get(indice);
            autorExistente.setNome(autorAtualizado.getNome());
            autorExistente.setNacionalidade(autorAtualizado.getNacionalidade());
        }
        return "redirect:/autores";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}