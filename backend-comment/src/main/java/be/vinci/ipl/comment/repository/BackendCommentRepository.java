package be.vinci.ipl.comment.repository;


import be.vinci.ipl.comment.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BackendCommentRepository extends CrudRepository<Comment, Integer> {


}
