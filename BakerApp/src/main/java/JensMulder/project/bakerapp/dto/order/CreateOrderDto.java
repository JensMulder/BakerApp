package JensMulder.project.bakerapp.dto.order;

import JensMulder.project.bakerapp.core.enums.PieSize;
import JensMulder.project.bakerapp.core.models.Pie;
import JensMulder.project.bakerapp.core.models.User;
import JensMulder.project.bakerapp.dto.order.base.OrderDtoBase;

import java.util.Date;

public class CreateOrderDto extends OrderDtoBase {
    public CreateOrderDto() {}

    public CreateOrderDto(Date deliverDate, Date orderDate, PieSize size, String notes, User user, Pie pie) {
        super(deliverDate, orderDate, size, notes, user, pie);
    }
}
