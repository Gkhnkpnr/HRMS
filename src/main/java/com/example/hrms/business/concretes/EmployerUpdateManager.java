package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployerUpdateService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployerUpdateDao;
import com.example.hrms.entities.concretes.EmployerUpdate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerUpdateManager implements EmployerUpdateService {
    private final EmployerUpdateDao employerUpdateDao;

    @Autowired
    public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
        this.employerUpdateDao = employerUpdateDao;
    }

    @Override
    public DataResult<EmployerUpdate> getEmployerUpdateById(int employerId) {
        if (this.employerUpdateDao.getEmployerUpdateById(employerId)== null){
            return new WarningDataResult<>("Kayıtlı Şirket bulunamadı");
        }else{
            return new SuccessDataResult<>(
                    this.employerUpdateDao.getEmployerUpdateById(employerId), "Şirket başarıyla listelendi"
            );
        }
    }

    @Override
    public Result deleteEmployerUpdateById(int employerId) {
        this.employerUpdateDao.deleteEmployerUpdateById(employerId);
        return new SuccessResult("Şirket silindi");
    }

    @Override
    public Result addEmployerUpdate(EmployerUpdate employerUpdate) {
        this.employerUpdateDao.save(employerUpdate);
        return new SuccessResult("Şirket eklendi");
    }
}
