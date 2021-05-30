package JensMulder.project.bakerapp.data.base;

import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import JensMulder.project.bakerapp.core.contracts.IDataService;
import JensMulder.project.bakerapp.core.contracts.IRepository;
import JensMulder.project.bakerapp.core.contracts.IDbModel;
import JensMulder.project.bakerapp.util.ApiException;
import JensMulder.project.bakerapp.util.CrudResult;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

/*
 * Base class for all services
 * */
@Transactional
public abstract class ServiceBase<T extends IDbModel> implements IDataService<T> {
    protected final Logger logger;
    private final IRepository<T> repo;

    public ServiceBase(final IRepository<T> repo, final Logger logger) {
        this.repo = repo;
        this.logger = logger;
    }

    public Long count() {
        return repo.count();
    }

    public Page<T> getPaged(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public CrudResult<T> getById(Long id) {
        var item = repo.findById(id).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, ErrorConstants.NOT_FOUND_ERROR_MSG));

        return new CrudResult<T>(null, item);
    }

    public CrudResult<T> update(Long id, T item) {
        if(!repo.existsById(id)) {
            throw new ApiException(HttpStatus.BAD_REQUEST, ErrorConstants.NOT_FOUND_ERROR_MSG);
        }

        item.setId(id);
        this.save(item);

        return new CrudResult<T>(null, item);
    }

    public CrudResult<T> create(T item) {
        return this.save(item);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private CrudResult<T> save(T item) {
        var result = repo.save(item);

        return new CrudResult<T>(null, result);
    }
}
