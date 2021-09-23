package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Technology;
import com.example.hrms.entities.dtos.addDtos.TechnologyAddDto;
import com.example.hrms.entities.dtos.updateDtos.TechnologyUpdateDto;

import java.util.List;

public interface TechnologyService {
    Result addTechnology(TechnologyAddDto technology);
    Result updateTechnology(TechnologyUpdateDto technology);
    Result deleteTechnologyById(int id);
    DataResult<List<Technology>> getTechnologies();
    DataResult<List<Technology>> getTechnologyByResumeId(int id);

}
