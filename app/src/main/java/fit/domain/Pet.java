package fit.domain;

public class Pet {
    private int id;
    private String name;
    private String image;
    private Boolean status;
    private Float cash;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Float getCash() {
        return cash;
    }
    public void setCash(Float cash) {
        this.cash = cash;
    }
    public Pet(int id, String name, String image, Boolean status, Float cash) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
        this.cash = cash;
    }
}
