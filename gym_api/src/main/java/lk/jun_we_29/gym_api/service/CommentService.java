package lk.jun_we_29.gym_api.service;

import lk.jun_we_29.gym_api.controller.dto.request.CommentRequestDTO;
import lk.jun_we_29.gym_api.model.Comment;

public interface CommentService {
    Comment addComment(CommentRequestDTO commentRequestDTO);
}
