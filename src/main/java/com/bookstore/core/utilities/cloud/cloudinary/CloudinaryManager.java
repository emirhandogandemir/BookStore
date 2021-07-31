package com.bookstore.core.utilities.cloud.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.ErrorDataResult;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


@Service
public class CloudinaryManager implements CloudinaryService {

private Cloudinary cloudinary;
	
	public CloudinaryManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dlkz9szh8",
				"api_key", "386916385284692",
				"api_secret", "cQ_FXYzrPxBRbDvCZw5a4JdGSd0"));
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}
	
	
}
