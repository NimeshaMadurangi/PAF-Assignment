package lk.jun_we_29.gym_api.repository;

import lk.jun_we_29.gym_api.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<File,Long> {
}
