package id.co.upiyai.academicguidance.model;

import id.co.upiyai.academicguidance.model.audit.DateAudit;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "purposes")
@Proxy(lazy = false)
public class Purpose extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purpose_id")
    private Integer purposeId;

    @Column(name = "purpose_name", nullable = false, length = 100)
    private String purposeName;

    @Column(name = "is_active")
    private Boolean isActive;
}