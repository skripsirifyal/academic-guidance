package id.co.upiyai.academicguidance.service;

import id.co.upiyai.academicguidance.model.Purpose;
import id.co.upiyai.academicguidance.payload.CommonResponse;
import id.co.upiyai.academicguidance.payload.ErrorMessage;
import id.co.upiyai.academicguidance.payload.ErrorSchema;
import id.co.upiyai.academicguidance.payload.request.PurposeRequest;
import id.co.upiyai.academicguidance.repository.PurposeRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class PurposeService {

    private final PurposeRepository repository;

    public PurposeService(PurposeRepository repository) {
        this.repository = repository;
    }

    public Purpose getDataPurposeById(Integer purposeId) {
        AtomicReference<Purpose> purpose = new AtomicReference<>(new Purpose());
        repository.findById(purposeId).ifPresent(purpose::set);
        return purpose.get();
    }

    public CommonResponse addPurpose(String actor, String action, String path, PurposeRequest request) {
        Purpose purpose = new Purpose();
        purpose.setPurposeName(request.getPurposeName());
        purpose.setIsActive(true);

        CommonResponse response = new CommonResponse();
        ErrorSchema errorSchema = new ErrorSchema();
        errorSchema.setErrorCode("000000");
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish("Success");
        errorMessage.setBahasa("Berhasil");
        errorSchema.setErrorMessage(errorMessage);
        response.setErrorSchema(errorSchema);
        response.setOutputSchema(purpose);

        repository.save(purpose);
        return response;
    }

}
