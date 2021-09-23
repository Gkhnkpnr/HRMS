package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.WarningDataResult;
import com.example.hrms.dataAccess.abstracts.CityDao;
import com.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private final CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getCities() {
        if ((long) this.cityDao.findAll().size()>0){
            return new SuccessDataResult<>(this.cityDao.findAll(), "Success: Şehirler başarı ile listelendi");
        }
        return new WarningDataResult<>(this.cityDao.findAll(), "Warning: Herhangi bir şehir bulunamadı");
    }
}
