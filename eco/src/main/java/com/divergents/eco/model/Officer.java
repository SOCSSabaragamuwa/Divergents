package com.divergents.eco.model;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class Officer {

    @Pattern(regexp = "/\\b\\d{5}\\b/g", message = "Employee No complexity requirement not met")
    @NotBlank(message = "Employee no is not set")
    private long eNo;

    @Value("${some.key:employee}")
    private String role;

    public Officer(@NotBlank(message = "Employee number is mandatory") long eNo, String role) {
        this.eNo = eNo;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "eNo=" + eNo +
                ", role='" + role + '\'' +
                '}';
    }

    public long geteNo() {
        return eNo;
    }

    public void seteNo(long eNo) {
        this.eNo = eNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
