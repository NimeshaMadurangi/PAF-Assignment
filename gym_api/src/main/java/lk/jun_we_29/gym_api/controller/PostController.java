package lk.jun_we_29.gym_api.controller;

import lk.jun_we_29.gym_api.controller.dto.response.CreatePostResponseDTO;
import lk.jun_we_29.gym_api.exception.PostNotFoundException;
import lk.jun_we_29.gym_api.exception.UserNotFoundException;
import lk.jun_we_29.gym_api.model.Post;
import lombok.AllArgsConstructor;
import lk.jun_we_29.gym_api.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostService postService;

    @PostMapping("/users/{user-id}/posts")
    public ResponseEntity<Void> addPost(@PathVariable("user-id") Long userId,
                                        @RequestParam("content") String content,
                                        @RequestParam("title") String title,
                                        @RequestParam("mediaFiles") List<MultipartFile> mediaFiles) {
        try {
            postService.createPost(userId, content, title, mediaFiles);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<?> getAllPosts(@PathVariable("id") Long id) {
        try {
            List<CreatePostResponseDTO> responseList = postService.getAllPost(id);
            return ResponseEntity.ok(responseList);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @DeleteMapping("/posts/{post-id}")
    public ResponseEntity<?> deletePost(@PathVariable("post-id") Long postId) throws PostNotFoundException {
        try {
            postService.deletePost(postId);
            return ResponseEntity.ok("Post deleted successfully");
        } catch (PostNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @PutMapping("/posts/{post-id}")
    public ResponseEntity<?> updatePost(@PathVariable("post-id") Long postId,
                                        @RequestParam("content") String content,
                                        @RequestParam("title") String title,
                                        @RequestParam("mediaFiles") List<MultipartFile> mediaFiles) {
        try {
            postService.updatePost(postId, content, title, mediaFiles);
            return ResponseEntity.ok("Post updated successfully");
        } catch (PostNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

}

