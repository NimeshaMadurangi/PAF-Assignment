package lk.jun_we_29.gym_api.controller;

import lk.jun_we_29.gym_api.controller.dto.request.CommentRequestDTO;
import lk.jun_we_29.gym_api.model.Comment;
import lk.jun_we_29.gym_api.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/comment")
public class CommentController {

//    private final CommentService commentService;
//
//    @PostMapping("/workoutPlan/{id}")
//    public Comment addComment(@PathVariable Long id, @RequestBody CommentRequestDTO commentRequestDTO) {
//        return commentService.addComment(id, commentRequestDTO);
//    }
}
