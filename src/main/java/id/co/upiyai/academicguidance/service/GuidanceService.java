package id.co.upiyai.academicguidance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.upiyai.academicguidance.model.Guidance;
import id.co.upiyai.academicguidance.model.Maintenance;
import id.co.upiyai.academicguidance.payload.CommonResponse;
import id.co.upiyai.academicguidance.payload.ErrorMessage;
import id.co.upiyai.academicguidance.payload.ErrorSchema;
import id.co.upiyai.academicguidance.payload.request.GuidanceRequest;
import id.co.upiyai.academicguidance.payload.request.MaintenanceRequest;
import id.co.upiyai.academicguidance.repository.GuidanceRepository;
import id.co.upiyai.academicguidance.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class GuidanceService {

    private final Logger logger = LoggerFactory.getLogger(GuidanceService.class);
    private final GuidanceRepository repository;
    private final PurposeService purposeService;
    private final SupportService supportService;
    private final ObjectMapper mapper = new ObjectMapper();
    private final MaintenanceService maintenanceService;

    public GuidanceService(GuidanceRepository repository, PurposeService purposeService, SupportService supportService, MaintenanceService maintenanceService) {
        this.repository = repository;
        this.purposeService = purposeService;
        this.supportService = supportService;
        this.maintenanceService = maintenanceService;
    }

    public CommonResponse requestGuidance(String actor, String action, String path, GuidanceRequest request) throws JsonProcessingException {
        logger.info("Entering method requestGuidance on class " + GuidanceService.class.getName() + " at " + System.currentTimeMillis(), request);
        Guidance guidance = new Guidance();
        guidance.setGuidanceId(UUID.randomUUID());
        guidance.setGuidanceDate(LocalDate.now());
        guidance.setGuidanceProblem(request.getGuidanceProblem());
        guidance.setGuidanceKind(CommonUtil.kind(request.getGuidanceKind()));
        guidance.setGuidanceType(CommonUtil.type(request.getGuidanceType()));
        guidance.setGuidanceSolution(null);
        guidance.setPurpose(purposeService.getDataPurposeById(request.getPurposeId()));
        guidance.setSupport(supportService.getDataSupportById(request.getSupportId()));

        String oldValue = mapper.writeValueAsString(guidance);

        MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
        maintenanceRequest.setOldValue(oldValue);
        Maintenance maintenance = maintenanceService.addData(action, "requested", path, maintenanceRequest);

        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish("SUCCESS");
        errorMessage.setBahasa("BERHASIL");
        errorSchema.setErrorCode("000000");
        errorSchema.setErrorMessage(errorMessage);

        CommonResponse response = new CommonResponse();
        response.setOutputSchema(List.of(maintenance));
        response.setErrorSchema(errorSchema);
        return response;
    }

    public void saveAsDraft() {}
    public void submit() {}
    public void update() {}
    public void view() {
        repository.findAll();
    }
    public void delete() {}
}
