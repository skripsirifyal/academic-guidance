package id.co.upiyai.academicguidance.repository;

import id.co.upiyai.academicguidance.model.Guidance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuidanceRepository extends PagingAndSortingRepository<Guidance, UUID> {
}
