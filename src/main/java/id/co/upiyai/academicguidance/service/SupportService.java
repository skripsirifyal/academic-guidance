package id.co.upiyai.academicguidance.service;

import id.co.upiyai.academicguidance.model.Support;
import id.co.upiyai.academicguidance.payload.CommonResponse;
import id.co.upiyai.academicguidance.payload.ErrorMessage;
import id.co.upiyai.academicguidance.payload.ErrorSchema;
import id.co.upiyai.academicguidance.payload.request.SupportRequest;
import id.co.upiyai.academicguidance.repository.SupportRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class SupportService {
    private final SupportRepository repository;

    public SupportService(SupportRepository repository) {
        this.repository = repository;
    }

    public Support getDataSupportById(Integer supportId) {
        AtomicReference<Support> support = new AtomicReference<>(new Support());
        repository.findById(supportId).ifPresent(support::set);
        return support.get();
    }

    public CommonResponse addSupport(String actor, String action, String path, SupportRequest request) {
        Support support = new Support();
        support.setSupportName(request.getSupportName());
        support.setIsActive(true);

        CommonResponse response = new CommonResponse();
        ErrorSchema errorSchema = new ErrorSchema();
        errorSchema.setErrorCode("000000");
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish("Success");
        errorMessage.setBahasa("Berhasil");
        errorSchema.setErrorMessage(errorMessage);
        response.setErrorSchema(errorSchema);
        response.setOutputSchema(support);
        repository.save(support);
        return response;
    }
}
