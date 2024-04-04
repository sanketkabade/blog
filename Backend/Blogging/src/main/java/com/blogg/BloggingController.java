package com.blogg;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
public class BloggingController {
    @Autowired
	BloggingService bloggService;
    
    @PostMapping("/addBlogg")
    public Blogging saveBlogging(@RequestParam("image") MultipartFile image,
                                 @RequestParam("name") String name,
                                 @RequestParam("title") String title,
                                 @RequestParam("subTitle") String subTitle,
                                 @RequestParam("details") String details) {
        try {
            byte[] imageData = image.getBytes();
            Blogging blogg = new Blogging();
            blogg.setImage(imageData);
            blogg.setName(name);
            blogg.setTitle(title);
            blogg.setSubTitle(subTitle);
            blogg.setDetails(details);
            return bloggService.saveBlogg(blogg, image);
            
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error
            return null;
        }
    }
    
    
    @PutMapping("/updateBlogg/{id}")
    public ResponseEntity<Blogging> updateBlogg(@PathVariable Integer id, @RequestBody Blogging blogg) {
        try {
            Blogging updatedBlogging = bloggService.updateBlogging(id, blogg);
            if (updatedBlogging == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            return ResponseEntity.ok(updatedBlogging);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    @DeleteMapping("/deleteBlogg/{id}")

	public void deleteBlogg(@PathVariable Integer id) {
    	bloggService.deleteBlogg(id);
	}
    
	@GetMapping("/selectById/{id}")
	public Optional<Blogging> getBloggById(@PathVariable Integer id) {
		return bloggService.getBloggById(id);
	}
	
	@GetMapping("/allBlogg")
	public List<Blogging> getEmployeeDetailss() {
		return bloggService.getBloggings();

	}
}
