package JensMulder.project.bakerapp.dto.order;

import JensMulder.project.bakerapp.core.enums.PieSize;
import JensMulder.project.bakerapp.core.models.Pie;
import JensMulder.project.bakerapp.core.models.User;

import java.util.Date;

public class UpdateOrderDto extends OrderDto {
    public UpdateOrderDto() {}

    public UpdateOrderDto(Date deliverDate, Date orderDate, PieSize size, String notes, User user, Pie pie, Long id) {
        super(deliverDate, orderDate, size, notes, user, pie, id);
    }
}
