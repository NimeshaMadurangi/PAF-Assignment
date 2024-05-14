package lk.jun_we_29.gym_api.controller.dto.response;

import lk.jun_we_29.gym_api.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutPlanResponseDTO {
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
