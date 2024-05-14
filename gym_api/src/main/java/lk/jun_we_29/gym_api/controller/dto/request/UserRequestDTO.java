package lk.jun_we_29.gym_api.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private Long id;

    private String username;

    private String password;

    private String email;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

}
