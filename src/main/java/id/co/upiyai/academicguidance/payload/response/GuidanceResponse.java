package id.co.upiyai.academicguidance.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class GuidanceResponse implements Serializable {
    @JsonProperty(value = "guidance_id")
    private UUID guidanceId;

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
}
