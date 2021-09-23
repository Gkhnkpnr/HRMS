package com.example.hrms.core.services;

import com.example.hrms.core.utilities.results.DataResult;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


public interface CloudinaryService {
    DataResult<Map> addPicture(MultipartFile file) throws IOException;
}
