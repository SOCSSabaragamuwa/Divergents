package com.divergents.eco.model;
//User Entity
public class User {
    private  int userId;
    private int mobile;
    private String nic;
    private String password;


    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User [id= %d ]", userId);
    }
}
