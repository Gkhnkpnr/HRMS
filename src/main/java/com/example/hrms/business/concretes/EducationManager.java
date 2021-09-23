package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.dtoConverter.DtoConverterService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EducationDao;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.dtos.addDtos.EducationAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {
    private final EducationDao educationDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
        this.educationDao = educationDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addEducation(EducationAddDto education) {
        this.educationDao.save((Education) this.dtoConverterService.dtoClassConverter(education, Education.class));
        return new SuccessResult("Success: Eğitim Başarılı bir şekilde eklendi.");
    }

    @Override
    public DataResult<List<Education>> getAllEducation() {
        if (this.educationDao.findAll().isEmpty()){
            return new WarningDataResult<>("Listelenecek bir eğitim bulunamadı");
        }else{
            return new SuccessDataResult<>(this.educationDao.findAll(), "Tüm eğitim bilgileri başarılı ile listelendi");
        }
    }

    @Override
    public DataResult<List<Education>> getEducationByResumeId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
        if (this.educationDao.getEducationEndDateByResumeId(id, sort).isEmpty()){
            return new WarningDataResult<>("Listelenecek eğitim bilgisi bulunamadı");
        }else{
            return new SuccessDataResult<>(
                    this.educationDao.getEducationEndDateByResumeId(id,sort), "Eğitim geçmişi başarılı bir şekilde listelendi"
            );
        }
    }

    @Override
    public Result deleteEducationById(int id) {
        this.educationDao.deleteEducationById(id);
        return new SuccessResult("Eğitim bilgisi başarılı bir şekilde silindi");
    }
}
