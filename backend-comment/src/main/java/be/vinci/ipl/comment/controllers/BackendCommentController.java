package be.vinci.ipl.comment.controllers;

import be.vinci.ipl.comment.model.Comment;

import be.vinci.ipl.comment.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BackendCommentController {

  private CommentService service;

  public BackendCommentController(CommentService commentService){
    this.service = commentService;
  }

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
  public boolean updateTextAndValidity(@RequestBody int id,@RequestBody String text,@RequestBody Date newDate){
    return service.updateTextAndValidity(id,text,newDate);
  }


}
