package com.novaes.projetomvc.controller;

import com.novaes.projetomvc.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/livros")
public class LivroController {
    private ArrayList<Livro> livros = new ArrayList<>();

    @PostMapping
    public String cadastrar (@ModelAttribute Livro livro){
        livros.add(livro);
        return  "redirect:/livros";
    }


    @GetMapping("/livro")
    public String inicio(){
        return "livros/inicio";
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("livros", livros);
        return "livros/lista";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
        }
        return "redirect:/livros";
    }
}
