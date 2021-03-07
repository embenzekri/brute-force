package ma.sqli.brute.force;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

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
}
