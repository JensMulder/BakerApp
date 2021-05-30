package JensMulder.project.bakerapp.core.contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepository<T extends IDbModel> extends JpaRepository<T, Long> {

}