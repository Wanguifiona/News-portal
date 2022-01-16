package models;

import java.util.Objects;

public class News {
    private String author;
    private String description;
    private String title;
    private String type;
    private int id;

    public News(String description,String title) {
        this.description = description;
        this.title = title;
        this.type = "General";
    }


    public String getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
    public String getType() {
        return type;
    }
    public int getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getId() == news.getId() &&
                Objects.equals(getTitle(), news.getTitle()) &&
                Objects.equals(getDescription(), news.getDescription()) &&
                Objects.equals(getType(), news.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, type, id);
    }
}