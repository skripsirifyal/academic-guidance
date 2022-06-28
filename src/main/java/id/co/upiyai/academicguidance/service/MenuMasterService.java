package id.co.upiyai.academicguidance.service;

import id.co.upiyai.academicguidance.model.MenuMaster;
import id.co.upiyai.academicguidance.repository.MenuMasterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuMasterService {
    private final MenuMasterRepository repository;

    public MenuMasterService(MenuMasterRepository repository) {
        this.repository = repository;
    }

    public MenuMaster getMenuByPath(String path) {
        Optional<MenuMaster> dataMenu = repository.findByPath(path);
        MenuMaster menuMaster = new MenuMaster();

        dataMenu.ifPresentOrElse(menu -> {
            menuMaster.setMenuMasterId(menu.getMenuMasterId());
            menuMaster.setMenuGroupName(menu.getMenuGroupName());
            menuMaster.setMenuName(menu.getMenuName());
            menuMaster.setPath(menu.getPath());
            menuMaster.setPosition(menu.getPosition());
        }, () -> {});
        return menuMaster;
    }
}
