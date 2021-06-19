package br.com.covid19.controller;

import br.com.covid19.exceptions.CategoryException;
import br.com.covid19.model.Category;
import br.com.covid19.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/")
    public List<Category> listOfCategories(){
        try{
            return service.listOfCategories();
        }catch (CategoryException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não há categorias cadastradas.");
        }
    }

    @GetMapping("/{id}")
    public Category findCategory(@PathVariable Integer id){
        try{
            return service.findCategory(id);
        }catch (CategoryException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Categoria não encontrada.");
        }
    }

    @PostMapping("/register")
    public Category registerNewCategory(@RequestBody Category category){
        try {
            return service.registerNewCategory(category);
        }catch (CategoryException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não foi possível cadastrar a categoria.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Category deleteCategory(@PathVariable Integer id) {
        try{
            return service.deleteCategory(id);
        }catch (CategoryException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Categoria não encontrada.");
        }
    }

    @PutMapping("/edit")
    public Category editCategory(@RequestBody Category category){
        try{
            return service.registerNewCategory(category);
        }catch (CategoryException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Categoria não encontrada");
        }
    }

}

