package id.co.upiyai.academicguidance.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MaintenanceRequest implements Serializable {
    @JsonProperty(value = "maintenance_id")
    private UUID maintenanceId;

    @JsonProperty(value = "old_value")
    private String oldValue;

    @JsonProperty(value = "new_value")
    private String newValue;

    @JsonProperty(value = "primary_id")
    private UUID primaryId;

    @JsonProperty(value = "primary_code")
    private String primaryCode;

    @JsonProperty(value = "reference_number")
    private String referenceNumber;

    @JsonProperty(value = "action")
    private String action;

    @JsonProperty(value = "status")
    private String status;

    @JsonProperty(value = "last_action_time")
    private String lastActionTime;

    @JsonProperty(value = "refuse_reason")
    private String refuseReason;

    @JsonProperty(value = "menu_master_id")
    private UUID menuMasterId;
}
