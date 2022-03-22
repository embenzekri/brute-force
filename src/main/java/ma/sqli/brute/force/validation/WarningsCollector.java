package ma.sqli.brute.force.validation;

import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 22/03/2022, mar.
 **/
public class WarningsCollector {
    private List<String> warnings;

    public void addWarning(String warning) {
        warnings.add(warning);
    }
}
