package lk.jun_we_29.gym_api.service;

import lk.jun_we_29.gym_api.controller.dto.request.UserRequestDTO;
import lk.jun_we_29.gym_api.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User addUser(UserRequestDTO userRequestDTO);
}
