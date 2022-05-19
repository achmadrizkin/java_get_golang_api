package com.example.java_get_api_golang.model;

public class RecyclerData {
    private long id;
    private String name_product;
    private String image_url;
    private String description;
    private long price;
    private String nameUser;
    private String emailUser;
    private String category;

    public RecyclerData(long id, String nameProduct, String imageURL, String description, long price, String nameUser, String emailUser, String category) {
        this.id = id;
        this.name_product = nameProduct;
        this.image_url = imageURL;
        this.description = description;
        this.price = price;
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getImageURL() {
        return image_url;
    }

    public void setImageURL(String imageURL) {
        this.image_url = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
