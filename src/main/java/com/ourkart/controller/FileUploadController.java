package com.ourkart.controller;

import com.ourkart.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ResponseBody
@RequestMapping("/file/upload")
@RestController
public class FileUploadController {

    @Autowired
    FilesStorageService filesStorageService;

    @PostMapping
    @ResponseBody
    public String uploadFile(@RequestParam("files") MultipartFile[] files)
    {
        try {

            for(int i =0;i< files.length;i++)
            {
                filesStorageService.save(files[i]);
                System.out.println(files[i].getOriginalFilename());
            }
        }catch (Exception ex)
        {

        }
        return "uploaded successfully";
    }


}
