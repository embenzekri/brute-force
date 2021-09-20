package ma.sqli.brute.force;

import static ma.sqli.brute.force.core.validator.LoginValidator.newValidators;
import ma.sqli.brute.force.core.Device;
import ma.sqli.brute.force.core.User;
import ma.sqli.brute.force.core.WarningsCollector;
import ma.sqli.brute.force.core.persistence.UserStore;
import ma.sqli.brute.force.core.validator.LoginParams;
import ma.sqli.brute.force.presentation.StringWarningPresenter;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {
    public static final String USER_OR_PASSWORD_ARE_INCORRECT = "User or password are incorrect.";
    private UserStore userStore = new UserStore();

    public void addUser(String username, String password) {
        userStore.addUser(new User(username, password));
    }

    public String login(String username, String password) {
        return doLogin(username, password, Device.WEB);
    }

    public String loginWithAndroid(String username, String password) {
        return doLogin(username, password, Device.ANDROID);
    }

    private String doLogin(String username, String password, Device deviceName) {
        Optional<User> user = userStore.findUser(username);
        if (!user.isPresent()) {
            return USER_OR_PASSWORD_ARE_INCORRECT;
        }

        WarningsCollector warnings = new WarningsCollector();
        boolean canLogin = newValidators().validate(user.get(), new LoginParams(username, password, deviceName), warnings);
        if (canLogin) {
            user.get().loggedSuccess(deviceName);
        }
        if (canLogin && warnings.getWarnings().isEmpty()) {
            return String.format("Welcome %s!", username);
        }
        StringWarningPresenter presenter = new StringWarningPresenter();
        return warnings.getWarnings().stream().map(presenter::present).collect(Collectors.joining(" - "));
    }

    public void blacklist(String username) {
        Optional<User> user = userStore.findUser(username);
        user.ifPresent(user1 -> user1.blacklist());
    }

}
