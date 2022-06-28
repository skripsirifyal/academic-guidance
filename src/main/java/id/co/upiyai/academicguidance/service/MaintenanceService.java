package id.co.upiyai.academicguidance.service;

import id.co.upiyai.academicguidance.exception.CommonException;
import id.co.upiyai.academicguidance.invocation.MaintenanceInvocation;
import id.co.upiyai.academicguidance.model.Maintenance;
import id.co.upiyai.academicguidance.model.MenuMaster;
import id.co.upiyai.academicguidance.payload.request.MaintenanceRequest;
import id.co.upiyai.academicguidance.payload.response.MaintenanceResponse;
import id.co.upiyai.academicguidance.repository.MaintenanceRepository;
import id.co.upiyai.academicguidance.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaintenanceService {
    private final MaintenanceRepository repository;
    private final MenuMasterService menuService;

    public MaintenanceService(MaintenanceRepository repository, MenuMasterService menuService) {
        this.repository = repository;
        this.menuService = menuService;
    }

    public Maintenance addData(String actions, String statuses, String path, MaintenanceRequest request){
        MenuMaster menu = menuService.getMenuByPath(path);
        String totalDataByMenu = String.valueOf(repository.countByMenu(menu));
        String primaryCode = CommonUtil.generatePrimaryCode(CommonUtil.action(actions).toString(), menu.getMenuName(), totalDataByMenu);
        String refNum = CommonUtil.generateReferenceNumber(menu.getMenuName());
        Maintenance maintenance = MaintenanceInvocation.convert(request, menu, primaryCode, refNum, actions, statuses);
        repository.save(maintenance);
        return maintenance;
    }

    public MaintenanceResponse getMaintenanceDataById(String primaryId) {
        Optional<Maintenance> data = repository.findByPrimaryId(primaryId);

        MaintenanceResponse response = new MaintenanceResponse();
        data.ifPresentOrElse(maintenance -> {
            response.setMaintenanceId(maintenance.getMaintenanceId());
            response.setOldValue(maintenance.getOldValue());
            response.setNewValue(maintenance.getNewValue());
            response.setPrimaryId(maintenance.getPrimaryId());
            response.setPrimaryCode(maintenance.getPrimaryCode());
            response.setReferenceNumber(maintenance.getReferenceNumber());
            response.setAction(maintenance.getAction().toString());
            response.setStatus(maintenance.getStatus().toString());
            response.setLastActionTime(maintenance.getLastActionTime());
        } , () -> {
            throw new CommonException();
        });
        return response;
    }
}
