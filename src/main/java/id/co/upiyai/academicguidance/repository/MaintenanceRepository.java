package id.co.upiyai.academicguidance.repository;

import id.co.upiyai.academicguidance.model.Maintenance;
import id.co.upiyai.academicguidance.model.MenuMaster;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MaintenanceRepository extends PagingAndSortingRepository<Maintenance, UUID> {
    Optional<Maintenance> findByPrimaryId(String primaryId);
    long countByMenu(MenuMaster menu);
}
