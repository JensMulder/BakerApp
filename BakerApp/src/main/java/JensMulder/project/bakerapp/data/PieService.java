package JensMulder.project.bakerapp.data;

import JensMulder.project.bakerapp.core.contracts.IPieRepository;
import JensMulder.project.bakerapp.core.models.Pie;
import JensMulder.project.bakerapp.data.base.ServiceBase;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class PieService extends ServiceBase<Pie> {
    private final IPieRepository repo;

    public PieService(IPieRepository repo, Logger logger) {
        super(repo, logger);

        this.repo = repo;
    }
}