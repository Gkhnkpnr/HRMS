package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getLanguages")
    public DataResult<List<Language>> getLanguages(){
        return this.languageService.getLanguages();
    }

    @PostMapping("/addLanguages")
    public DataResult<List<Language>> addLanguages(@RequestBody List<Language> languages){
        return this.languageService.addLanguages(languages);
    }
}
