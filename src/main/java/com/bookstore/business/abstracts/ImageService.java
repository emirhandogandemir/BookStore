package com.bookstore.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.domain.Image;




public interface ImageService {

	Result add(Image image,MultipartFile imageFile);
	
	Result update(Image image);
	
	Result delete(int id);
	
	DataResult<Image>  getById(int id);
	
	
	DataResult<List<Image>>  getAll();

	
}
