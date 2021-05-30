package JensMulder.project.bakerapp.core.contracts;

import JensMulder.project.bakerapp.util.CrudResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDataService<T extends IDbModel> {
    Page<T> getPaged(Pageable pageable);

    CrudResult<T> getById(Long id);

    CrudResult<T> update(Long id, T item);

    CrudResult<T> create(T item);

    void delete(Long id);

    Long count();
}
