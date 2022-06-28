package id.co.upiyai.academicguidance.repository;

import id.co.upiyai.academicguidance.model.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support, Integer> {
}
