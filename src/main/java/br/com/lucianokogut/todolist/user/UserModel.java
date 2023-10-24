package br.com.lucianokogut.todolist.user;

public class UserModel {

    private String username;
    private String name;
    private String password;

    /**
     * Métodos para Get e Set (getters e setters)
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}