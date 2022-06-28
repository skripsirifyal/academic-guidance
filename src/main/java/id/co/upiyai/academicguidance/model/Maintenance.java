package id.co.upiyai.academicguidance.model;

import id.co.upiyai.academicguidance.model.audit.UserDateAudit;
import id.co.upiyai.academicguidance.util.ActionEnum;
import id.co.upiyai.academicguidance.util.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(name = "maintenances")
@Entity
@Proxy(lazy = false)
public class Maintenance extends UserDateAudit {

    @Id
    @Column(name = "maintenance_id")
    private UUID maintenanceId;

    @Column(name = "old_value", nullable = false)
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

    @Column(name = "primary_id", nullable = false, length = 32)
    private UUID primaryId;

    @Column(name = "primary_code", nullable = false, length = 32)
    private String primaryCode;

    @Column(name = "reference_number", nullable = false, length = 32)
    private String referenceNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "action")
    private ActionEnum action;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "last_action_time")
    private LocalDateTime lastActionTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_master_id", nullable = false)
    @JsonIgnore
    private MenuMaster menu;
}
