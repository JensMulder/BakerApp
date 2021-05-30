package JensMulder.project.bakerapp.core.models;

import JensMulder.project.bakerapp.core.enums.BakerRoles;
import JensMulder.project.bakerapp.core.models.base.DbModelBase;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role extends DbModelBase {
    @Enumerated(EnumType.STRING)
    private BakerRoles name;

    public Role() {
    }

    public Role(BakerRoles name) {
        this.name = name;
    }

    public BakerRoles getName() {
        return name;
    }

    public void setName(BakerRoles name) {
        this.name = name;
    }
}
