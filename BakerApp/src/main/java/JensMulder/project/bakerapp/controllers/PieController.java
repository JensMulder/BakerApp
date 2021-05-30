package JensMulder.project.bakerapp.controllers;

import JensMulder.project.bakerapp.controllers.base.ControllerBase;
import JensMulder.project.bakerapp.core.models.Pie;
import JensMulder.project.bakerapp.data.PieService;
import JensMulder.project.bakerapp.dto.pie.CreatePieDto;
import JensMulder.project.bakerapp.dto.pie.PieDto;
import JensMulder.project.bakerapp.dto.pie.UpdatePieDto;
import JensMulder.project.bakerapp.util.ApiResponse;
import JensMulder.project.bakerapp.util.auth.AuthenticationFacade;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/pies")
public class PieController extends ControllerBase<Pie> {
    private final PieService service;

    public PieController(
            PieService service,
            Logger logger,
            ApiResponseFactory responseFactory,
            ModelMapper modelMapper,
            AuthenticationFacade authentication
    ) {
        super(service, logger, responseFactory, modelMapper, authentication);

        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getPage(@PathVariable Pageable pageable) {
        return super.<PieDto>getPage(pageable);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getOne(@PathVariable Long id) {
        return super.<PieDto>getOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody UpdatePieDto item) {
        return super.<PieDto, UpdatePieDto>update(id, item);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> create(@RequestBody CreatePieDto item) {
        return super.<PieDto, CreatePieDto>create(item);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}