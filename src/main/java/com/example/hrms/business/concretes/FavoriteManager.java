package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.FavoriteService;
import com.example.hrms.core.dtoConverter.DtoConverterService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.FavoriteDao;
import com.example.hrms.entities.concretes.Favorite;
import com.example.hrms.entities.dtos.addDtos.FavoriteAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteManager implements FavoriteService {

    private final FavoriteDao favoriteDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public FavoriteManager(FavoriteDao favoriteDao, DtoConverterService dtoConverterService) {
        this.favoriteDao = favoriteDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addFavorite(FavoriteAddDto favorite) {
        this.favoriteDao.save((Favorite) this.dtoConverterService.dtoClassConverter(favorite, Favorite.class));
        return new SuccessResult("Favorilere eklendi");
    }

    @Override
    public Result deleteFavoriteById(int id) {
        this.favoriteDao.deleteById(id);
        return new SuccessResult("Favori başarılı bir şekilde kaldırıldı");
    }

    @Override
    public DataResult<List<Favorite>> getAllFavorites() {
        if (this.favoriteDao.findAll().size() >0){
            return new SuccessDataResult<>(this.favoriteDao.findAll(), "Favoriler başarılı bir şekilde listelendi.");
        }else{
            return new WarningDataResult<>(this.favoriteDao.findAll(), "Kayıtlı Favori listesi bulunamadı");
        }

    }

    @Override
    public DataResult<List<Favorite>> getFavoriteById(int id) {
        if (this.favoriteDao.getFavoriteByJobSeekerId(id).size() > 0){
            return new SuccessDataResult<>(this.favoriteDao.getFavoriteByJobSeekerId(id), " " + id + " id li iş arayana ait favoriler listelendi.");
        }else{
            return new WarningDataResult<>(this.favoriteDao.getFavoriteByJobSeekerId(id), " "+ id + " id li iş arayana ait favori bulunamadı");
        }
    }

    @Override
    public Result deleteFavoriteByJobSeekerIdAndJobPostId(int jobSeekerId, int jobPostId) {
        this.favoriteDao.deleteFavoriteByJobSeekerIdAndJobPostId(jobSeekerId, jobPostId);
        return new SuccessResult("Favori başarılı bir şekilde kaldırıldı");
    }
}
