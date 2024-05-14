package lk.jun_we_29.gym_api.controller.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealPlanResponseDTO {

    private String mealName;

    private String ingredients;

    private String instructions;

    private String dietType;

    private LocalDateTime createDate;

}
