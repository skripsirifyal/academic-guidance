package id.co.upiyai.academicguidance.model;

import id.co.upiyai.academicguidance.model.audit.DateAudit;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "supports")
@Proxy(lazy = false)
public class Support extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "support_id")
    private Integer serviceId;

    @Column(name = "support_name", nullable = false, length = 100)
    private String supportName;

    @Column(name = "is_active")
    private Boolean isActive;
}
