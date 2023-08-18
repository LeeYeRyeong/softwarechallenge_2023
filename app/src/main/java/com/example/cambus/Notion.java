package com.example.cambus;
import com.google.gson.annotations.SerializedName;

public class Notion {
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("id")
    private int id;
    @SerializedName("image") // JSON 필드 이름과 매핑 (이미지 URL)
    private String image;
    @SerializedName("productId")
    private int productId;
    @SerializedName("productTitle")
    private String productTitle;
    @SerializedName("productContent")
    private String productContent;
    @SerializedName("productPrice")
    private String productPrice;

    @SerializedName("productOption")
    private String productOption;


    public Notion(String title, String content, String image, String productTitle, String productContent, String productPrice,String productOption) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.productTitle = productTitle;
        this.productContent = productContent;
        this.productPrice = productPrice;
        this.productOption = productOption;

    }

    // Getter 메서드

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getContent() { return content;}
    public String getImage() { return image; }
    public String getProductTitle() { return productTitle; }
    public String getProductContent() { return productContent; }
    public String getProductPrice() { return productPrice; }
    public String getProductOption() { return productOption; }



    // Setter 메서드

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    public void setProductOption(String productOption) {
        this.productOption = productOption;
    }


}