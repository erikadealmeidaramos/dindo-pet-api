package fit.model;

public class Breed {
    private int id;
    private Specie specie;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public Breed(Specie specie, int id, String description) {
        this.id = id;
        this.description = description;
        this.specie = specie;
    }

}
