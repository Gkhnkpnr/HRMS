package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.FavoriteService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Favorite;
import com.example.hrms.entities.dtos.addDtos.FavoriteAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/getFavorites")
    public DataResult<List<Favorite>> getFavorites(){
        return this.favoriteService.getAllFavorites();
    }

    @GetMapping("/getFavoritesByJobSeekerId")
    public DataResult<List<Favorite>> getFavoritesByJobSeekerId(@RequestParam int jobSeekerId){
        return this.favoriteService.getFavoriteById(jobSeekerId);
    }

    @PostMapping("/addFavorite")
    public Result addFavorite(@RequestBody FavoriteAddDto favorite){
        return this.favoriteService.addFavorite(favorite);
    }

    @DeleteMapping("/deleteFavorite")
    public Result deleteFavoriteById(@RequestParam int id){
        return this.favoriteService.deleteFavoriteById(id);
    }

    @DeleteMapping("/deleteFavoriteByJobSeekerIdAndJobPostId")
    public Result deleteFavoriteByJobSeekerIdAndJobPostId(@RequestParam int jobSeekerId, int jobPostId){
        return this.favoriteService.deleteFavoriteByJobSeekerIdAndJobPostId(jobSeekerId, jobPostId);
    }
}
