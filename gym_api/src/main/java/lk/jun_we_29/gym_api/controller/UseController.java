package lk.jun_we_29.gym_api.controller;

import lk.jun_we_29.gym_api.controller.dto.request.UserRequestDTO;
import lk.jun_we_29.gym_api.controller.dto.request.WorkoutPlanRequestsDTO;
import lk.jun_we_29.gym_api.model.User;
import lk.jun_we_29.gym_api.model.WorkOutPlan;
import lk.jun_we_29.gym_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/users")
public class UseController {

    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.addUser(userRequestDTO);
    }
}
