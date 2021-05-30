package JensMulder.project.bakerapp.controllers;

import JensMulder.project.bakerapp.controllers.base.ControllerBase;
import JensMulder.project.bakerapp.core.models.Pie;
import JensMulder.project.bakerapp.data.PieService;
import JensMulder.project.bakerapp.dto.pie.CreatePieDto;
import JensMulder.project.bakerapp.dto.pie.PieDto;
import JensMulder.project.bakerapp.dto.pie.UpdatePieDto;
import JensMulder.project.bakerapp.util.ApiResponse;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pies")
public class PieController extends ControllerBase<Pie> {
    private final PieService service;

    public PieController(
            PieService service,
            Logger logger,
            ApiResponseFactory responseFactory,
            ModelMapper modelMapper
    ) {
        super(service, logger, responseFactory, modelMapper);

        this.service = service;
    }

    @Override
    public ResponseEntity<ApiResponse> getPage(@PathVariable Pageable pageable) {
        return super.<PieDto>getPage(pageable);
    }

    @Override
    public ResponseEntity<ApiResponse> getOne(@PathVariable Long id) {
        return super.<PieDto>getOne(id);
    }

    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody UpdatePieDto item) {
        return super.<PieDto, UpdatePieDto>update(id, item);
    }

    public ResponseEntity<ApiResponse> create(@RequestBody CreatePieDto item) {
        return super.<PieDto, CreatePieDto>create(item);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return super.delete(id);
    }
}