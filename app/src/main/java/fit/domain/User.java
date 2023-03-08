package fit.domain;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String pix;

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPix() {
        return pix;
    }
    public void setPix(String pix) {
        this.pix = pix;
    }
    
    public User(int id, String name, String email, String password, String cpf, String pix) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.pix = pix;
    }   
    
    
    
}
