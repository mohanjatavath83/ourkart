package com.ourkart.service;

import com.ourkart.dao.MediaModelRepository;
import com.ourkart.model.MediaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service
public class FilesStorageServiceImpl implements FilesStorageService
{
    @Autowired
    MediaModelRepository mediaModelRepository;

    Path rootLocation = Paths.get("upload1");

    public String save(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try
        {
            String directory = System.getProperty("user.dir");
            MediaModel media = new MediaModel();
            media.setFileId(filename);
            filename = (new Date().getTime())+"_"+filename;
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            media.setRealFileName(filename);
            media.setUrl(directory+"/"+filename);
            mediaModelRepository.save(media);


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to store file " + filename, ex);
        }

        return filename;
    }
}
