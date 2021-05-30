package JensMulder.project.bakerapp.data.seerders;

import JensMulder.project.bakerapp.core.enums.BakerRoles;
import JensMulder.project.bakerapp.core.models.Pie;
import JensMulder.project.bakerapp.core.models.Role;
import JensMulder.project.bakerapp.core.models.User;
import JensMulder.project.bakerapp.data.PieService;
import JensMulder.project.bakerapp.data.RoleService;
import JensMulder.project.bakerapp.data.UserService;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DataSeeder implements CommandLineRunner {
    private final UserService userService;
    private final PieService pieService;
    private final RoleService roleService;
    private final Logger logger;

    public DataSeeder(UserService userService, PieService pieService, RoleService roleService, Logger logger) {
        this.roleService = roleService;
        this.userService = userService;
        this.pieService = pieService;
        this.logger = logger;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();

        var testData = userService.getPaged(PageRequest.of(0, 20)).map(User::toString).stream().collect(Collectors.toCollection(ArrayList::new));

        logger.info(String.format("successfully loaded data: \n%s", String.join(", \n", testData)));
    }

    private void loadData() {
        if (roleService.count() < 1) {
            roles.forEach(roleService::create);
        }

        if (userService.count() < 1) {
            users.forEach(userService::create);
        }
        if (pieService.count() < 1) {
            pies.forEach(pieService::create);
        }
    }

    private static final Set<Role> roles = new HashSet<>(Arrays.asList(
        new Role(BakerRoles.USER),
        new Role(BakerRoles.ADMIN)
    ));

    private static final List<User> users = Arrays.asList(
        new User("user", "Test123", "user@baker.nl", "Test", "User", "0612345678", "Teststraat", "3743QR", 20, "a", "Zuid-Holland", roles.stream().filter(e -> e.getName() != BakerRoles.ADMIN).collect(Collectors.toSet())),
        new User("admin", "Test123", "user@baker.nl", "Test", "User", "0612345678", "Teststraat", "3743QR", 20, "a", "Zuid-Holland", roles)
    );

    private static final List<Pie> pies = Arrays.asList(
        new Pie("Ronde taart", "Een sappige ronde taart", null, 10.00),
        new Pie("Vierkante taart", "Een malse vierkante taart", null, 12.75)
    );
}
