package com.master.auth.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
  //  @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    //@Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
  //  @Size(min = 6, max = 40)
    private String password;

    private String fname;//edw egw
    private String lname;

  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
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
    
    public Set<String> getRole() {
      return this.role;
    }


    public String getFname() {//edw egw
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
