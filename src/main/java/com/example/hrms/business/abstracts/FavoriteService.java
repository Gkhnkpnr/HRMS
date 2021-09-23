package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Favorite;
import com.example.hrms.entities.dtos.addDtos.FavoriteAddDto;

import java.util.List;

public interface FavoriteService {
    Result addFavorite(FavoriteAddDto favorite);
    Result deleteFavoriteById(int id);
    DataResult<List<Favorite>> getAllFavorites();
    DataResult<List<Favorite>> getFavoriteById(int id);
    Result deleteFavoriteByJobSeekerIdAndJobPostId(int jobSeekerId, int jobPostId);
}
