package com.vvsk.ecommerce.ecommerceapi.dto.common;

public class Product {
    String id;
    String name;
    String description;
    String price;
    String image;
    Integer stock;
    String category;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
    

    
}
