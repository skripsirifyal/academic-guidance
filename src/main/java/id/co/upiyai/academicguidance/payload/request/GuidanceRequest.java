package id.co.upiyai.academicguidance.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class GuidanceRequest implements Serializable {
    @JsonProperty(value = "guidance_date")
    private LocalDate guidanceDate;

    @JsonProperty(value = "guidance_problem")
    private String guidanceProblem;

    @JsonProperty(value = "guidance_solution")
    private String guidanceSolution;

    @JsonProperty(value = "guidance_kind")
    private String guidanceKind;

    @JsonProperty(value = "guidance_type")
    private String guidanceType;

    @JsonProperty(value = "purpose_id")
    private Integer purposeId;

    @JsonProperty(value = "support_id")
    private Integer supportId;
}
