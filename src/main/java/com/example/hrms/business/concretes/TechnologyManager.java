package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.TechnologyService;
import com.example.hrms.core.dtoConverter.DtoConverterService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.TechnologyDao;
import com.example.hrms.entities.concretes.Technology;
import com.example.hrms.entities.dtos.addDtos.TechnologyAddDto;
import com.example.hrms.entities.dtos.updateDtos.TechnologyUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private final TechnologyDao technologyDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
        this.technologyDao = technologyDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addTechnology(TechnologyAddDto technology) {
        this.technologyDao.save((Technology) this.dtoConverterService.dtoClassConverter(technology, Technology.class));
        return new SuccessResult("Programlama dili başarılı bir şekilde eklendi.");
    }

    @Override
    public Result updateTechnology(TechnologyUpdateDto technology) {
        this.technologyDao.save((Technology) this.dtoConverterService.dtoClassConverter(technology, Technology.class));
        return new SuccessResult("Programlama dili başarılı bir şekilde güncellendi.");
    }

    @Override
    public Result deleteTechnologyById(int id) {
        this.technologyDao.deleteTechnologyById(id);
        return new SuccessResult("Programlama dili başarılı bir şekilde silindi");
    }

    @Override
    public DataResult<List<Technology>> getTechnologies() {
        if (this.technologyDao.findAll().isEmpty()){
            return new WarningDataResult<>("Listelenecek programlama dili bulunamadı");
        }else{
            return new SuccessDataResult<>(this.technologyDao.findAll(),"Programlama dilleri başarılı şekilde listelendi");
        }
    }

    @Override
    public DataResult<List<Technology>> getTechnologyByResumeId(int id) {
        if (this.technologyDao.getTechnologyByResumeId(id).isEmpty()){
            return new WarningDataResult<>("Listelenecek programlama dili bulunamadı");
        }else{
            return new SuccessDataResult<>(this.technologyDao.getTechnologyByResumeId(id),"Programlama dili listelendi");
        }
    }
}
