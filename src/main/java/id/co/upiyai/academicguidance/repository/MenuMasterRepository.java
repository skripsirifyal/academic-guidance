package id.co.upiyai.academicguidance.repository;

import id.co.upiyai.academicguidance.model.MenuMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuMasterRepository extends JpaRepository<MenuMaster, Integer> {
    Optional<MenuMaster> findByPath(String path);
}
