package be.vinci.ipl.comment.service;

import be.vinci.ipl.comment.model.Comment;

import java.util.Date;
import java.util.List;

public interface CommentService {

    public List<Comment> allComments();

    public Comment getComments(int id);

    public boolean insertComments(Comment comment);

    public Comment getCommentByIdAndByUser(int idUser,int idProduct);

    public List<Comment> getAllCommentOfProductsExceptUser(int idUser, int idProduct);

    public int getNumberOfCommentsByProductId(int idProduct);

    public float getAverageEvaluationOfProduct(int idProduct);

    public boolean updateTextAndValidity(String text, Date newDate);
}
