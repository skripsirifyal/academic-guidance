package id.co.upiyai.academicguidance.model;

import id.co.upiyai.academicguidance.model.audit.DateAudit;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "menu_masters")
@Proxy(lazy = false)
public class MenuMaster extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_master_id")
    private Integer menuMasterId;

    @Column(name = "menu_group_name", nullable = false)
    private String menuGroupName;

    @Column(name = "menu_name", nullable = false, unique = true)
    private String menuName;

    @Column(name = "path", nullable = false, unique = true)
    private String path;

    @Column(name = "position", nullable = false)
    private Integer position;
}
