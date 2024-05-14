package lk.jun_we_29.gym_api.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;

    private String username;

    private String password;

    private String email;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

}
