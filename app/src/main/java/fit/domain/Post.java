package fit.domain;

public class Post {
    private int id;
    private String image;
    private String description;
    private Boolean type;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }
    public void setDesciption(String description) {
        this.description = description;
    }
    public Boolean getType() {
        return type;
    }
    public void setType(Boolean type) {
        this.type = type;
    }
    
    public Post(int id, String image, String description, Boolean type) {
        this.id = id;
        this.image = image;
        this.description = description;
        this.type = type;
    }
    
}
