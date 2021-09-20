package ma.sqli.brute.force;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BruteForceTest {
    private BruteForceApp app = new BruteForceApp();

    @Before
    public void setup() {
        app.addUser("admin", "123");
        app.addUser("sqli", "0000");
    }

    @Test
    public void shouldLogin() {
        String result = app.login("admin", "123");

        assertEquals("Welcome admin!", result);
    }

    @Test
    public void shouldNotLoginWhenWrongCredentials() {
        String result = app.login("admin", "qsd");

        assertEquals("User or password are incorrect.", result);
    }

    @Test
    public void shouldNotLoginWhenBruteForce() {
        app.login("admin", "wrong1");
        app.login("admin", "wrong2");
        String result = app.login("admin", "wrong3");

        assertEquals("Multiple erroneous credentials, your account is locked.", result);

        String result2 = app.login("admin", "wrong3");
        assertEquals("Multiple erroneous credentials, your account is locked.", result2);

        String result3 = app.login("sqli", "0000");

        assertEquals("Welcome sqli!", result3);
    }

    @Test
    public void shouldResetBruteForceWhenLoginSuccess() {
        app.login("admin", "wrong1");
        app.login("admin", "wrong2");
        String result = app.login("admin", "123");

        assertEquals("Welcome admin!", result);

        app.login("admin", "wrong3");
        String result2 = app.login("admin", "wrong3");
        assertEquals("User or password are incorrect.", result2);

        String result3 = app.login("admin", "123");

        assertEquals("Welcome admin!", result3);
    }

    @Test
    public void shouldLoginInAnotherWhenLocked() {
        app.login("admin", "wrong1");
        app.login("admin", "wrong2");
        String result = app.login("admin", "wrong3");

        assertEquals("Multiple erroneous credentials, your account is locked.", result);

        app.loginWithAndroid("admin", "wrong3");
        String result2 = app.loginWithAndroid("admin", "wrong3");
        assertEquals("User or password are incorrect.", result2);

        String result3 = app.loginWithAndroid("admin", "123");

        assertEquals("Welcome admin!", result3);
    }

    @Test
    public void shouldNotLoginWhenBlacklisted() {
        app.blacklist("sqli");
        String result = app.login("sqli", "0000");

        assertEquals("Your account is blacklisted, contact the CRC to resolve the problem.", result);
    }

    @Test
    public void shouldDisplayWarningWhenPasswordWeak() {
        app.addUser("newuser", "1");
        String result = app.login("newuser", "1");

        assertEquals("Your password is too weak, please update it by going to your my account.", result);
    }

    @Test
    public void shouldDisplayWarningWhenMultipleLogin() {
        String resultWeb = app.login("admin", "123");
        String resultAndroid = app.loginWithAndroid("admin", "123");

        assertEquals("Welcome admin!", resultWeb);
        assertEquals("We detected that your account is logged in multiple devices", resultAndroid);
    }

    @Test
    public void shouldDisplayWarnings() {
        app.addUser("newuser", "1");
        String resultWeb = app.login("newuser", "1");
        String resultAndroid = app.loginWithAndroid("newuser", "1");

        assertEquals("Your password is too weak, please update it by going to your my account.", resultWeb);
        assertEquals("Your password is too weak, please update it by going to your my account. " +
                "- We detected that your account is logged in multiple devices", resultAndroid);
    }
}
