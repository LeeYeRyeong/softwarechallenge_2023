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


    public Notion(String title, String content, String image) {
        this.id = id;
        this.title = title;
        this.content = content;


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




    // Setter 메서드

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


}