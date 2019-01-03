package entity;

public class Admin {
    String account;
    String password;
    int id;
    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
}
