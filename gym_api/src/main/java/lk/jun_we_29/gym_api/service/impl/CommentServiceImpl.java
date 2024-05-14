package lk.jun_we_29.gym_api.service.impl;

import lk.jun_we_29.gym_api.controller.dto.request.CommentRequestDTO;
import lk.jun_we_29.gym_api.model.Comment;
import lk.jun_we_29.gym_api.repository.CommentRepository;
import lk.jun_we_29.gym_api.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepo;

    @Override
    public Comment addComment(CommentRequestDTO commentRequestDTO) {
        Comment comment = new Comment();

        comment.setId(commentRequestDTO.getId());
        comment.setContent(commentRequestDTO.getContent());

        commentRepo.save(comment);
        return comment;
    }


}
