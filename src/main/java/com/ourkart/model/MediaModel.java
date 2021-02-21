package com.ourkart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MediaModel {

    @Id
    private String fileId;
    private String realFileName;
    private String url;


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getRealFileName() {
        return realFileName;
    }

    public void setRealFileName(String realFileName) {
        this.realFileName = realFileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
