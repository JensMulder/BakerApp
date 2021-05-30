package JensMulder.project.bakerapp.dto.order.base;

import JensMulder.project.bakerapp.core.enums.PieSize;
import JensMulder.project.bakerapp.core.models.Pie;
import JensMulder.project.bakerapp.core.models.User;

import java.util.Date;

public abstract class OrderDtoBase {
    private Date deliverDate;
    private Date orderDate;
    private PieSize size;
    private String notes;
    private User user;
    private Pie pie;

    public OrderDtoBase() {}

    public OrderDtoBase(Date deliverDate, Date orderDate, PieSize size, String notes, User user, Pie pie) {
        this.deliverDate = deliverDate;
        this.orderDate = orderDate;
        this.size = size;
        this.notes = notes;
        this.user = user;
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

    public PieSize getSize() {
        return size;
    }

    public void setSize(PieSize size) {
        this.size = size;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pie getPie() {
        return pie;
    }

    public void setPie(Pie pie) {
        this.pie = pie;
    }
}
