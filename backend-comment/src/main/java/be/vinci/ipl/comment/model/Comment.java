package be.vinci.ipl.comment.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte;
    private int evaluation;
    private Date dateCreation;
    private int idUser;
    private int idProduct;
    private boolean isAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}