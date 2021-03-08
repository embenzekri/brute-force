package ma.sqli.brute.force;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class User {
    private String name;
    private String password;
    private int essays = 0;
}
