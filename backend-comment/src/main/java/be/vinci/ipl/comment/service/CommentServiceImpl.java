package be.vinci.ipl.comment.service;

import be.vinci.ipl.comment.model.Comment;
import be.vinci.ipl.comment.repository.BackendCommentRepository;

import java.util.Date;
import java.util.List;

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
        return null;
    }

    @Override
    public boolean insertComments(Comment comment) {
        return false;
    }

    @Override
    public Comment getCommentByIdAndByUser(int idUser, int idProduct) {
        return null;
    }

    @Override
    public List<Comment> getAllCommentOfProductsExceptUser(int idUser, int idProduct) {
        return null;
    }

    @Override
    public int getNumberOfCommentsByProductId(int idProduct) {
        return 0;
    }

    @Override
    public float getAverageEvaluationOfProduct(int idProduct) {
        return 0;
    }

    @Override
    public boolean updateTextAndValidity(String text, Date newDate) {
        return false;
    }
}
