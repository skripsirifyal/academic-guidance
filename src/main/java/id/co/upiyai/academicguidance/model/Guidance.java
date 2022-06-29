package id.co.upiyai.academicguidance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.co.upiyai.academicguidance.model.audit.UserDateAudit;
import id.co.upiyai.academicguidance.util.KindEnum;
import id.co.upiyai.academicguidance.util.TypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "guidances")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Guidance extends UserDateAudit {

    @Id
    @Column(name = "guidance_id")
    private UUID guidanceId;

    @Column(name = "guidance_date")
    private LocalDate guidanceDate;

    @Column(name = "guidance_problem")
    private String guidanceProblem;

    @Column(name = "guidance_solution")
    private String guidanceSolution;

    @Enumerated(EnumType.STRING)
    @Column(name = "guidance_kind")
    private KindEnum guidanceKind;

    @Enumerated(EnumType.STRING)
    @Column(name = "guidance_type")
    private TypeEnum guidanceType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purpose_id", nullable = false)
    @JsonIgnore
    private Purpose purpose;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "support_id", nullable = false)
    @JsonIgnore
    private Support support;
}
