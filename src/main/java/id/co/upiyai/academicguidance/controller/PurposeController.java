package id.co.upiyai.academicguidance.controller;

import id.co.upiyai.academicguidance.payload.CommonResponse;
import id.co.upiyai.academicguidance.payload.request.PurposeRequest;
import id.co.upiyai.academicguidance.service.PurposeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/purposes")
public class PurposeController {
    private final Logger logger = LoggerFactory.getLogger(PurposeController.class);

    private final PurposeService service;

    public PurposeController(PurposeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommonResponse> addDataPurpose(
            @Valid @RequestBody PurposeRequest request,
            @RequestHeader(name = "x-access-actor") String actor,
            @RequestHeader(name = "x-access-action") String action,
            @RequestHeader(name = "x-access-path") String path
    ) {
        logger.info("Entering addDataPurpose method on class " + PurposeController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.addPurpose(actor, action, path, request);
        logger.info("Leaving addDataGuidance method on class " + PurposeController.class.getName() + " at " + System.currentTimeMillis(), response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
