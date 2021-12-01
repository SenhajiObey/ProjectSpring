package be.vinci.ipl.comment.controllers;

import be.vinci.ipl.comment.model.Comment;

import be.vinci.ipl.comment.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class BackendCommentController {

  private CommentService service;

  @GetMapping
    public List<Comment> getAllComments() {
      return service.allComments();
  };

  @GetMapping("/{id}")
    public Comment getComments(@PathVariable("id") int id){
      return service.getComments(id);
  }

  @PostMapping()
    public boolean insertComments(@RequestBody Comment comment){
      return service.insertComments(comment);
  }

  @GetMapping("/{id}+{idProduct}")
    public Comment getCommentByIdAndByUser(@PathVariable("id") int idUser,@PathVariable("idProduct") int idProduct){
      return service.getCommentByIdAndByUser(idUser,idProduct);
  }

  @GetMapping("/list/{id}+{idProduct}")
  public List<Comment> getCommentOfProductsExceptUser(@PathVariable("id") int idUser,@PathVariable("idProduct") int idProduct){
    return service.getAllCommentOfProductsExceptUser(idUser,idProduct);
  }

  @GetMapping("/size/{id}")
  public int getNumberofCommentsByProductId(@PathVariable("id") int id){
    return service.getNumberOfCommentsByProductId(id);
  }

  @GetMapping("/average/{id}")
  public float getAverageEvaluationOfProduct(@PathVariable("id") int id){
    return service.getAverageEvaluationOfProduct(id);
  }

  @PostMapping("/updateTextAndDate")
  public boolean updateTextAndValidity(@RequestBody String text,@RequestBody Date newDate){
    return service.updateTextAndValidity(text,newDate);
  }


}
