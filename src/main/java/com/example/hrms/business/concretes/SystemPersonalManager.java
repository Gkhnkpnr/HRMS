package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.SystemPersonalService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.SystemPersonalDao;
import com.example.hrms.entities.concretes.SystemPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPersonalManager implements SystemPersonalService {

    private final SystemPersonalDao systemPersonalDao;

    @Autowired
    public SystemPersonalManager(SystemPersonalDao systemPersonalDao) {
        this.systemPersonalDao = systemPersonalDao;
    }

    @Override
    public DataResult<List<SystemPersonal>> getSystemPersonals() {
        if ((long) this.systemPersonalDao.findAll().size() >0){
            return new SuccessDataResult<>(this.systemPersonalDao.findAll(), "Personeller Listelendi");
        }else{
            return new WarningDataResult<>(this.systemPersonalDao.findAll(), "Listelenecek personel bulunamadı");
        }
    }

    @Override
    public Result addSystemPersonal(SystemPersonal systemPersonal) {
        try{
            this.systemPersonalDao.save(systemPersonal);
            return new SuccessResult("Personel başarılı bir şekilde kaydedildi");
        }catch (Exception e){
            if (e.getMessage().contains("[uc_users_email]")){
                return new ErrorResult("Eposta sistemde mevcut, lütfen kayıtlı olmayan bir eposta ile deneyin");
            }else{
                return new ErrorResult("Kullanıcı adı sistemte kayıtlı lütfen başka bir kullanıcı adı ile deneyin");
            }
        }
    }

    @Override
    public Result updateSystemPersonal(SystemPersonal systemPersonal) {
        try{
            this.systemPersonalDao.save(systemPersonal);
            return new SuccessResult("Personel başarılı bir şekilde güncellendi.");
        }catch (Exception e){
            if (e.getMessage().contains("[uc_users_email]")){
                return new ErrorResult("Eposta sistemde mevcut, lütfen kayıtlı olmayan bir eposta ile deneyin");
            }else{
                return new ErrorResult("Kullanıcı adı sistemte kayıtlı lütfen başka bir kullanıcı adı ile deneyin");
            }
        }
    }

    @Override
    public DataResult<SystemPersonal> getSystemPersonalById(int systemPersonalId) {
        if (this.systemPersonalDao.getSystemPersonalById(systemPersonalId)== null){
            return new WarningDataResult<>("Kayıtlı personel bulunamadı");
        }else{
            return new SuccessDataResult<>(this.systemPersonalDao.getSystemPersonalById(systemPersonalId), "Personel listelendi");
        }
    }

    @Override
    public Result deleteSystemPersonalById(int systemPersonalId) {
        this.systemPersonalDao.deleteSystemPersonalById(systemPersonalId);
        return new SuccessResult("Personel başarılı bir şekilde silindi");
    }
}
