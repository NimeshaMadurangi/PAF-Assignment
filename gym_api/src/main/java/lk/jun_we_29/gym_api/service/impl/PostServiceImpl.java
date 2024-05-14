package lk.jun_we_29.gym_api.service.impl;

import lk.jun_we_29.gym_api.controller.dto.response.CreatePostResponseDTO;
import lk.jun_we_29.gym_api.exception.PostNotFoundException;
import lk.jun_we_29.gym_api.exception.UserNotFoundException;
import lk.jun_we_29.gym_api.model.File;
import lk.jun_we_29.gym_api.model.Post;
import lk.jun_we_29.gym_api.model.User;
import lk.jun_we_29.gym_api.repository.FileDataRepository;
import lk.jun_we_29.gym_api.repository.PostRepository;
import lk.jun_we_29.gym_api.repository.UserRepository;
import lk.jun_we_29.gym_api.service.FileUploadUtil;
import lk.jun_we_29.gym_api.service.PostService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final FileDataRepository fileDataRepository;
    private final FileUploadUtil fileSaved;


//    @Override
//    public Post createPost(Long id, String content, String mediaType, MultipartFile[] files) throws Exception {
//
//        String uploadDir = "PostImage";
//        List<String> fileUrls = new ArrayList<>();
//
//
//        for (MultipartFile file : files) {
//            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//            fileUrls.add(filename);
//            try {
//                FileUploadUtil.saveFile(uploadDir, filename, file);
//                String fileUrl = "/home/thushan/Desktop/paf2023/paf-assignment-2024-jun_we_29/gym_api/src/main/java/lk/jun_we_29/gym_api/photos/" + uploadDir + "/" + filename;
//                fileUrls.add(fileUrl);
//            } catch (IOException e) {
//                throw new Exception("Faild to save file" + filename, e);
//            }
//        }
//
//        Optional<User> userOptional = userRepository.findById(id);
//        if (userOptional.isPresent()) {
//
//            Post post = new Post();
//            post.setContent(content);
//            post.setType(mediaType);
//            if (!fileUrls.isEmpty()) {
//                post.setMediaUrl(fileUrls.get(0));
//            }
//
//            User user = userOptional.get();
////            user.setId(user.getId());
//            post.setUser(user);
//            postRepository.save(post);
//            return null;
//        }
//        return null;
//    }


    @Override
    public void createPost(Long id, String content, String title, List<MultipartFile> mediaFiles) throws Exception {

        Optional<User> userOptinal = userRepository.findById(id);
        if (userOptinal.isPresent()) {
            User user = userOptinal.get();
            Post post = new Post();
            post.setTitle(title);
            post.setContent(content);
            post.setUser(user);
            postRepository.save(post);

            try{
                List<String> savedPaths = fileSaved.saveMedia(mediaFiles);
                for (String path : savedPaths) {
                    File file = new File();
//                    file = new File(); // Create a new FileTest object for each file
                    file.setFilePath(path);

                    String fileType = path.substring(path.lastIndexOf(".") + 1);
                    file.setMediaType(fileType);

                    file.setPost(post); // Associate each FileTest with the same PostTest
                    fileDataRepository.save(file);

                }
//                return post; // Return the created post
            } catch (Exception e) {
                // Handle exception, possibly rollback transaction
                throw new Exception("Error saving media files", e);
            }
        } else {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
    }



    @Override
    public List<CreatePostResponseDTO> getAllPost(Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        List<Post> posts = postRepository.findAllByUserId(id);
        List<CreatePostResponseDTO> responseList = new ArrayList<>();
        for (Post post : posts) {
            CreatePostResponseDTO postDTO = new CreatePostResponseDTO();
            postDTO.setContent(post.getContent());
            postDTO.setTitle(post.getTitle());

            List<File> files = post.getFiles();
            for (File file : files) {
                postDTO.setMediaType(file.getMediaType());
                postDTO.setFilePath(file.getFilePath());
//                if (file.getMediaType().equals("image")) {
//                    postDTO.setFilePath(file.getFilePath());
//                }
//                if (file.getMediaType().equals("video")) {
//                    postDTO.setFilePath(file.getFilePath());
//                }
            }



            responseList.add(postDTO);
        }
        return responseList;
    }

    @Override
    public void deletePost(Long postId) throws PostNotFoundException {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (!postOptional.isPresent()) {
            throw new PostNotFoundException("Post with id" + postId + "not found");
        }
        postRepository.deleteById(postId);
    }

    @Override
    public Post updatePost(Long postId, String content, String title, List<MultipartFile> mediaFiles) throws Exception {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setTitle(title);
            post.setContent(content);
            postRepository.save(post);

            try {
                List<String> savedPaths = fileSaved.saveMedia(mediaFiles);
                for (String path : savedPaths) {
                    File file = new File();
                    file.setFilePath(path);

                    String fileType = fileSaved.getFileExtension(path);
                    file.setMediaType(fileType);

                    file.setPost(post);
                    fileDataRepository.save(file);
                }
                return post;
            } catch (Exception e) {
                // Handle exception, possibly rollback transaction
                throw new Exception("Error saving media files", e);
            }
        } else {
            throw new PostNotFoundException("Post with id " + postId + " not found");
        }
    }

}





