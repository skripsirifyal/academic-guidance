package id.co.upiyai.academicguidance.controller;

import id.co.upiyai.academicguidance.payload.CommonResponse;
import id.co.upiyai.academicguidance.payload.request.SupportRequest;
import id.co.upiyai.academicguidance.service.SupportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/supports")
public class SupportController {
    private final Logger logger = LoggerFactory.getLogger(SupportController.class);
    private final SupportService service;

    public SupportController(SupportService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommonResponse> addDataSupport(
            @Valid @RequestBody SupportRequest request,
            @RequestHeader(name = "x-access-actor") String actor,
            @RequestHeader(name = "x-access-action") String action,
            @RequestHeader(name = "x-access-path") String path
    ) {
        logger.info("Entering addDataPurpose method on class " + SupportController.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = service.addSupport(actor, action, path, request);
        logger.info("Leaving addDataGuidance method on class " + SupportController.class.getName() + " at " + System.currentTimeMillis(), response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
