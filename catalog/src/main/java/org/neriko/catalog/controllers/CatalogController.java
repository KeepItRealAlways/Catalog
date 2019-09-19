package org.neriko.catalog.controllers;

import com.sun.istack.NotNull;
import org.neriko.catalog.repositories.CatalogRepository;
import org.neriko.catalog.entities.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepository;

    @RequestMapping(value = "/catalog", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Catalog> listCatalogs(@RequestParam(required = false, value = "fields") List<String > fields) {
        return catalogRepository.findAll();
    }

    @GetMapping("/catalog/{id}")
    @ResponseBody
    public Catalog getCatalog(@PathVariable @NotNull String id, @RequestParam(required = false, value = "fields") List<String > fields) {
        return catalogRepository.getOne(id);
    }

    @PostMapping("/catalog")
    @ResponseBody
    public Catalog createCatalog(@RequestBody Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    //TODO реализовать
    @RequestMapping(value = "/catalog/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Catalog updateCatalog(@RequestBody Map<String, Object> patch, @PathVariable String id) {
        return catalogRepository.getOne(id);
    }

    @DeleteMapping("/catalog/{id}")
    @ResponseBody
    public void deleteCatalog(@PathVariable String id) {
        catalogRepository.deleteById(id);
    }
}
