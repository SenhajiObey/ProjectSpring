package be.vinci.ipl.comment.service;

import be.vinci.ipl.comment.model.Comment;
import be.vinci.ipl.comment.repository.BackendCommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {


    private final BackendCommentRepository repo;

    public CommentServiceImpl(BackendCommentRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<Comment> allComments() {
        return (List<Comment>) repo.findAll();
    }


    @Override
    public Comment getComments(int id) {
        return repo.findById(id).get();

    }

    @Override
    public boolean insertComments(Comment comment) {
        return repo.save(comment)==null?true:false;
    }

    @Override
    public Comment getCommentByIdAndByUser(int idUser, int idProduct) {
        List<Comment> comments = allComments();
        for (Comment c:comments) {
            if(c.getIdProduct()==idProduct && c.getIdUser()==idUser){
                return c;
            }
        }
        return null;
    }



    @Override
    public List<Comment> getAllCommentOfProductsExceptUser(int idUser, int idProduct) {
        List<Comment> comments = allComments();
        List<Comment> commentsExcept = new ArrayList<>();
        for (Comment c:comments) {
            if(c.getIdProduct()==idProduct && c.getIdUser()!=idUser){
                commentsExcept.add(c);
            }
        }
        return commentsExcept;
    }

    @Override
    public int getNumberOfCommentsByProductId(int idProduct) {
        List<Comment> comments = allComments();
        int cmpt = 0;
        for (Comment c:comments) {
            if(c.getIdProduct()==idProduct){
                cmpt++;
            }
        }
        return cmpt;
    }

    @Override
    public float getAverageEvaluationOfProduct(int idProduct) {
        List<Comment> comments = allComments();
        int cmpt = 0;
        int cmpt2 = 0;
        for (Comment c:comments) {
            if(c.getIdProduct()==idProduct){
                cmpt+=c.getEvaluation();
                cmpt2++;
            }
        }
        return cmpt/cmpt2;
    }


    @Override
    public boolean updateTextAndValidity(int idComment,String text, Date newDate) {
        Comment com = getComments(idComment);
        this.repo.delete(com);
        com.setTexte(text);
        com.setDateCreation(newDate);
        return this.repo.save(com)==null?true:false;


    }
}
