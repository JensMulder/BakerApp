package JensMulder.project.bakerapp.dto.order;

import JensMulder.project.bakerapp.core.enums.PieSize;
import JensMulder.project.bakerapp.core.models.Pie;
import JensMulder.project.bakerapp.core.models.User;
import JensMulder.project.bakerapp.dto.order.base.OrderDtoBase;

import java.util.Date;

public class OrderDto extends OrderDtoBase {
    private Long id;

    public OrderDto() {}

    public OrderDto(Date deliverDate, Date orderDate, PieSize size, String notes, User user, Pie pie, Long id) {
        super(deliverDate, orderDate, size, notes, user, pie);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
