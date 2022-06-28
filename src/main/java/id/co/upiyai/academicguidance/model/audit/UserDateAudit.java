package id.co.upiyai.academicguidance.model.audit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class UserDateAudit implements Serializable {
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private UUID createdBy;
    private UUID updatedBy;

    @PrePersist
    public void prePersist() {
//        this.setCreatedBy();
        this.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.setUpdatedDate(LocalDateTime.now());
    }
}
