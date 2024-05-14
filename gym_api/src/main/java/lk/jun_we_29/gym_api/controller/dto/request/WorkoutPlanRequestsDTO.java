package lk.jun_we_29.gym_api.controller.dto.request;

import lk.jun_we_29.gym_api.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutPlanRequestsDTO {
    private Long id;

    private String goal;

    private String description;

    private String exercises;

    private int sets;

    private String repetition;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private User user;
}
