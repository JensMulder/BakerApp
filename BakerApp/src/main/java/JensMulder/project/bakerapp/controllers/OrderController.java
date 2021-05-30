package JensMulder.project.bakerapp.controllers;

import JensMulder.project.bakerapp.controllers.base.ControllerBase;
import JensMulder.project.bakerapp.core.models.Order;
import JensMulder.project.bakerapp.data.OrderService;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController extends ControllerBase<Order> {
    private final OrderService service;

    public OrderController(
            OrderService service,
            Logger logger,
            ApiResponseFactory responseFactory,
            ModelMapper modelMapper
    ) {
        super(service, logger, responseFactory, modelMapper);

        this.service = service;
    }


}
