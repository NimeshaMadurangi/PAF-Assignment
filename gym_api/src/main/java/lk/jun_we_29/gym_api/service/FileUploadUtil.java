package lk.jun_we_29.gym_api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileUploadUtil {

    @Value("${media.upload.path}")
    private String uploadPath;


    public List<String> saveMedia(List<MultipartFile> mediaFiles) throws IOException {
        List<String> savedPaths = new ArrayList<>();
        for (MultipartFile multipartFile : mediaFiles) {
            String fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
            Path path = Paths.get(uploadPath + fileName);
            Files.write(path, multipartFile.getBytes());

            savedPaths.add(path.toString());
        }
        return savedPaths;
    }

    public String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex != -1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return ""; // Or throw an exception if file extension is required and not found
    }


}
