package be.vinci.ipl.frontenduser.model;

import java.util.Date;

public class UserDTO extends User{

    private int id;
    private String lastName,firstName,adress,email;
    private Date dateOfBirth;
    private String role;

    public UserDTO(User user){
        this.id = user.getId();
        this.adress = user.getAdress();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.role = user.getRole();
    }
}
