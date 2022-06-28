package id.co.upiyai.academicguidance.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.co.upiyai.academicguidance.payload.CommonResponse;
import id.co.upiyai.academicguidance.payload.request.GuidanceRequest;
import id.co.upiyai.academicguidance.service.GuidanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/guidances")
public class GuidanceController {

    private final Logger logger = LoggerFactory.getLogger(GuidanceController.class);
    private final GuidanceService service;

    public GuidanceController(GuidanceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommonResponse> addDataGuidance(
            @Valid @RequestBody GuidanceRequest request,
            @RequestHeader(name = "x-access-actor") String actor,
            @RequestHeader(name = "x-access-action") String action,
            @RequestHeader(name = "x-access-path") String path
    ) throws JsonProcessingException {
        logger.info("Entering addDataGuidance method on class " + GuidanceController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.requestGuidance(actor, action, path, request);
        logger.info("Leaving addDataGuidance method on class " + GuidanceController.class.getName() + " at " + System.currentTimeMillis(), response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
