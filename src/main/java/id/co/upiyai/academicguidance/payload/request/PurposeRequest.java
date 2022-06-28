package id.co.upiyai.academicguidance.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PurposeRequest implements Serializable {
    @JsonProperty(value = "purpose_name")
    private String purposeName;
}
