package JensMulder.project.bakerapp.data;

import org.slf4j.Logger;
import JensMulder.project.bakerapp.core.contracts.IOrderRepository;
import JensMulder.project.bakerapp.core.models.Order;
import JensMulder.project.bakerapp.data.base.ServiceBase;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceBase<Order> {
    private final IOrderRepository repo;

    public OrderService(final IOrderRepository repo, final Logger logger) {
        super(repo, logger);

        this.repo = repo;
    }
}
