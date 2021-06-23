package br.com.covid19.service;

import br.com.covid19.exceptions.CategoryException;
import br.com.covid19.exceptions.DistrictException;
import br.com.covid19.model.Category;
import br.com.covid19.model.District;
import br.com.covid19.repository.CategoryRepository;
import br.com.covid19.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listOfCategories(){
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()){
            throw new CategoryException("Não há categorias cadastradas no banco de dados.");
        }
        return categoryRepository.findAll();
    }

    public Category findCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()){
            throw new CategoryException("Categoria de id "+id+" não encontrada.");
        }
        return optionalCategory.get();
    }

}
