package com.example.isaac.pruebam8uf2;

public class ImageUploadInfo {
    public String imageName;
    public String imageURL;
    public boolean status;

    public ImageUploadInfo() {
    }

    public ImageUploadInfo(String imageName, String imageURL, boolean status) {
        this.imageName = imageName;
        this.imageURL = imageURL;
        this.status = status;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
