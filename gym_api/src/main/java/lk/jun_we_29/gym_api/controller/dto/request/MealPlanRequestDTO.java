package lk.jun_we_29.gym_api.controller.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.jun_we_29.gym_api.enums.DietType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealPlanRequestDTO {

    private String mealName;

    private String ingredients;

    private String instructions;

    private String dietType;

}
