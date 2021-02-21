package com.ourkart.service;

import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
    String save(MultipartFile file);

  /*  public Resource load(String filename);
    public void deleteAll();
    public Stream<Path> loadAll();*/
}
