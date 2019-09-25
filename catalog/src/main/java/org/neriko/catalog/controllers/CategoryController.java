package org.neriko.catalog.controllers;

import org.neriko.catalog.entities.Category;
import org.neriko.catalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = "/category")
    @ResponseBody
    public List<Category> listCategories(@RequestParam(required = false, value = "fields") List<String> fields) {
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    @ResponseBody
    public Category getCategory(@PathVariable String id,
                              @RequestParam(required = false, value = "fields") List<String> fields) {
        return categoryRepository.getOne(id);
    }

    @PostMapping("/category")
    @ResponseBody
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    //TODO реализовать
    @PatchMapping(value = "/category/{id}")
    @ResponseBody
    public void updateCategory(@RequestBody Map<String, Object> patch, @PathVariable String id) { }

    @DeleteMapping("/category/{id}")
    @ResponseBody
    public void deleteCategory(@PathVariable String id) {
        categoryRepository.deleteById(id);
    }
}
