package com.blogg;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "*")
@Service
public class BloggingService  {
	@Autowired
	BloggRepo repo;
	
//	to save blogg
	public Blogging saveBlogg(Blogging blogg, MultipartFile image) {
        try {
            byte[] imageData = image.getBytes();
            blogg.setImage(imageData);
            return repo.save(blogg);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error
            return null;
        }
    }
    
	
	
	
	
//   to update blogg
	
	public Blogging updateBlogging( Integer id,  Blogging blogg) {
		Optional<Blogging> optionalBloggingDetails = repo.findById(id);
		if(optionalBloggingDetails.isPresent()) {
			Blogging BloggingDetails = optionalBloggingDetails.get();
			BloggingDetails.setImage(blogg.getImage());;
			BloggingDetails.setName(blogg.name);
			BloggingDetails.setSubTitle(blogg.subTitle);
			BloggingDetails.setTitle(blogg.title);
			BloggingDetails.setDetails(blogg.details);
			return repo.save(BloggingDetails);
		}return null;		
	  }
	
	
//	delete blogg by id
	
	public void deleteBlogg( Integer id ){
		 repo.deleteById(id);
	}
	
//	get data by id
	public Optional<Blogging> getBloggById(Integer id) {
		return repo.findById(id);
	}
	
//	get all data
	
	  public List<Blogging> getBloggings() {
			return repo.findAll();
		}

}
