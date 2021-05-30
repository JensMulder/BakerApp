package JensMulder.project.bakerapp.core.models;

import JensMulder.project.bakerapp.core.enums.PieSize;
import JensMulder.project.bakerapp.core.models.base.DbModelBase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order extends DbModelBase {
    @NotBlank
    private Date deliverDate;
    @NotBlank
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private PieSize size;
    private String notes;

    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "pieId")
    private Pie pie;

    public Order() {};

    public Order(Date deliverDate, Date orderDate, PieSize size, String notes, User user, Pie pie) {
        this.deliverDate = deliverDate;
        this.orderDate = orderDate;
        this.size = size;
        this.notes = notes;
        this.user = user;
        this.pie = pie;
    }

    public Pie getPie() {
        return pie;
    }

    public void setPie(Pie pie) {
        this.pie = pie;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PieSize getPieSize() {
        return size;
    }

    public void setPieSize(PieSize size) {
        this.size = size;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
