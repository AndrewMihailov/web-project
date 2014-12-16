package org.mihaylov.furniture.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mihaylov.furniture.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadTest {
	
	@Autowired
	private PhotoService photoService;
	
	@RequestMapping(value = "/imageDisplay.jpg", method = RequestMethod.GET)
	@ResponseBody public byte[] getImage() throws IOException {
	        // setContentType is ignored for @ResponseBody. 
	        // The content type returned is "application/octet-stream" unless "produces" is set.
		// resp.setContentType("image/jpg");
	
		Path path = Paths.get("C:\\tmp\\abc.jpg");
		byte[] response;
		response = Files.readAllBytes(path);
		return response;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
    	
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\tmp\\" + name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "Downloaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "error " + name + " => " + e.getMessage();
            }
        } else {
            return "error " + name + " because of emptyness";
        }
    }

}
