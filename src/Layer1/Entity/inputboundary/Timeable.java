package Layer1.Entity.inputboundary;

import java.util.Timer;
/**
 * Author: Chen Jiang
 * Modified by: Yufei Chen
 */
public interface Timeable {

    final Timer time = new Timer();

    public String getTime();
}
