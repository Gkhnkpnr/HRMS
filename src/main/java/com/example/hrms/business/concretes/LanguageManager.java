package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.WarningDataResult;
import com.example.hrms.dataAccess.abstracts.LanguageDao;
import com.example.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> addLanguages(List<Language> languages) {
        return new SuccessDataResult<>(this.languageDao.saveAll(languages), "Dil ekleme işleme başarılı");
    }

    @Override
    public DataResult<List<Language>> getLanguages() {
        if (this.languageDao.findAll().isEmpty()){
            return new WarningDataResult<>("Kayıtlı yabancı dil bulunamadı");
        }
        return new SuccessDataResult<>(this.languageDao.findAll(),"Yabancı diller başarıyla listelendi.");
    }
}
