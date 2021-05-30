package JensMulder.project.bakerapp.core.models;

import JensMulder.project.bakerapp.core.models.base.DbModelBase;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "Pies")
public class Pie extends DbModelBase {
    @NotBlank
    @Length(max = 50)
    private String name;
    @NotBlank
    @Length(max = 250)
    private String description;
    private byte[] img;
    private double price;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "pie",
            orphanRemoval = true,
            cascade = CascadeType.PERSIST
    )
    private Collection<Order> orders;

    public Pie() {}

    public Pie(String name, String description, byte[] img, double price) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
