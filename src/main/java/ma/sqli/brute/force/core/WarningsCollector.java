package ma.sqli.brute.force.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/20/21, lun.
 **/
public class WarningsCollector {
    private List<LoginValidationError> warnings = new ArrayList<>();

    public void addWarning(LoginValidationError warning) {
        warnings.add(warning);
    }

    public boolean hasWarnings() {
        return !warnings.isEmpty();
    }

    public <T> T present(WarningPresenter warningPresenter) {
        return (T) warningPresenter.present(warnings);
    }
}
