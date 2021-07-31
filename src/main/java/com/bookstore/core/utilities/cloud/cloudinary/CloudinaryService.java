package com.bookstore.core.utilities.cloud.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.bookstore.core.utilities.results.DataResult;



public interface CloudinaryService {
	
	@SuppressWarnings("rawtypes")
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
