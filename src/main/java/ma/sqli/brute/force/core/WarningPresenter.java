package ma.sqli.brute.force.core;

import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 9/20/21, lun.
 **/
public interface WarningPresenter<T> {
    T present(List<LoginValidationError> warnings);
}
