package lk.jun_we_29.gym_api.service;

import lk.jun_we_29.gym_api.exception.PostNotFoundException;
import org.springframework.web.multipart.MultipartFile;
import lk.jun_we_29.gym_api.controller.dto.request.CreatePostRequestDTO;
import lk.jun_we_29.gym_api.controller.dto.response.CreatePostResponseDTO;
import lk.jun_we_29.gym_api.model.Post;

import java.util.List;

public interface PostService {

    void createPost(Long id,String content,String title,List<MultipartFile> mediaFiles)throws Exception;

    List<CreatePostResponseDTO> getAllPost(Long id)throws Exception;

    void deletePost(Long postId) throws PostNotFoundException;

    Post updatePost(Long postId,String content,String title,List<MultipartFile> mediaFiles) throws Exception;
}
