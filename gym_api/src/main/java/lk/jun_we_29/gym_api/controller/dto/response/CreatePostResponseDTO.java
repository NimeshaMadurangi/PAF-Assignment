package lk.jun_we_29.gym_api.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostResponseDTO {
        private String title;
        private String content;
        private String filePath;
        private String mediaType;



}
