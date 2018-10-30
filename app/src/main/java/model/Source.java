package model;

import java.util.List;

/**
 * Created by DELL on 10/27/2018.
 */

public
class Source {
    public
    String title;

    public
    String getUrlToImage() {
        return urlToImage;
    }

    public
    void setUrlToImage(String urlToImage) {
        this.urlToImage=urlToImage;
    }

    public String urlToImage;


    public
    String getName() {
        return name;
    }

    public
    void setName(String name) {
        this.name=name;
    }

    public String name;

    public
    Source(List<Source> list) {
    }

    public
    String getDescription() {
        return description;
    }

    public
    void setDescription(String description) {
        this.description=description;
    }

    public String description;

    public
    String getPublishedAt() {
        return publishedAt;
    }

    public
    void setPublishedAt(String publishedAt) {
        this.publishedAt=publishedAt;
    }

    public String publishedAt;
    
    public Source(String title,String description,String publishedAt,String name,String urlToImage){
        this.title=title;
        this.description=description;
        this.publishedAt=publishedAt;
        this.name=name;
        this.urlToImage=urlToImage;
    }

    public
    String getTitle() {
        return title;
    }

    public
    void setTitle(String title) {
        this.title=title;
    }
}
