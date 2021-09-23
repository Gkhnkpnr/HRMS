package com.example.hrms.core.adapters;

import com.example.hrms.core.services.CloudinaryService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.imageUploader.CloudinaryManager;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public class CloudinaryUploaderManagerAdapter implements CloudinaryService {

    private final CloudinaryManager cloudinaryManager;

    public CloudinaryUploaderManagerAdapter(CloudinaryManager cloudinaryManager) {
        this.cloudinaryManager = cloudinaryManager;
    }

    @Override
    public DataResult<Map> addPicture(MultipartFile file) throws IOException {
        return this.cloudinaryManager.addPicture(file);
    }
}
