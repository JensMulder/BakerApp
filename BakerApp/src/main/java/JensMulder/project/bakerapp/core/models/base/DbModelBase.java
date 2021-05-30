package JensMulder.project.bakerapp.core.models.base;

import JensMulder.project.bakerapp.core.contracts.IDbModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class DbModelBase implements IDbModel, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPersisted() {
        return id != null;
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }

        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        var other = (DbModelBase) obj;

        if (getId() == null || other.getId() == null) {
            return false;
        }

        return getId().equals(other.getId());
    }
}
