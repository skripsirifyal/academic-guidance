package id.co.upiyai.academicguidance.repository;

import id.co.upiyai.academicguidance.model.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurposeRepository extends JpaRepository<Purpose, Integer> {
}
