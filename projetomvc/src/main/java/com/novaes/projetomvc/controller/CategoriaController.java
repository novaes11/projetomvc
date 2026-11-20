package com.novaes.projetomvc.controller;

import com.novaes.projetomvc.model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CategoriaController {
    private ArrayList<Categoria> categorias = new ArrayList<>();

    @PostMapping
    public String cadastrar(@ModelAttribute Categoria categoria){
        categorias.add(categoria);
        return  "redirect:/categorias";
    }

    @GetMapping("/inicio")
    public String inicio(){ return "livro/inicio"; }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("categorias", categorias);
        return "categorias/lista";
    }

    @DeleteMapping("/categorias/{indices}")
    public String excluir(@PathVariable int indice){
        if (indice >= 0 && indice < categorias.size()) {
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }
}
