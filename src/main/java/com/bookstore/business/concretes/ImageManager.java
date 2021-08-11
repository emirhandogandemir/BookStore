package com.bookstore.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookstore.business.abstracts.ImageService;
import com.bookstore.business.constants.Messages;
import com.bookstore.core.utilities.cloud.cloudinary.CloudinaryService;
import com.bookstore.core.utilities.results.DataResult;
import com.bookstore.core.utilities.results.Result;
import com.bookstore.core.utilities.results.SuccessDataResult;
import com.bookstore.core.utilities.results.SuccessResult;
import com.bookstore.domain.Image;
import com.bookstore.repository.ImageRepository;

@Service
public class ImageManager implements ImageService {

	private final ImageRepository imageRepository;
	private final CloudinaryService cloudinaryService;
	
	
	public ImageManager(ImageRepository imageRepository,CloudinaryService cloudinaryService) {
		
		this.imageRepository = imageRepository;
		this.cloudinaryService=cloudinaryService;
	}

	@Override
	public Result add(Image image, MultipartFile imageFile) {
		Map<String,String> uploadImage = this.cloudinaryService.uploadImageFile(imageFile).getData();
		image.setUrl(uploadImage.get("url"));
	this.imageRepository.save(image);
	return new SuccessResult(Messages.imageAdded);
	}

	@Override
	public Result update(Image image) {
		this.imageRepository.save(image);
		return new SuccessResult(Messages.imageUpdated);
	}

	@Override
	public Result delete(int id) {
		this.imageRepository.deleteById(id);
		return new SuccessResult(Messages.imageDeleted);
	}

	@Override
	public DataResult<Image> getById(int id) {
	return new SuccessDataResult<Image> (this.imageRepository.getById(id));
	}

	@Override
	public DataResult<List<Image>> getByBook_Id(int id) {
	return new SuccessDataResult<List<Image>> (this.imageRepository.getByBook_Id(id));
	}

}
