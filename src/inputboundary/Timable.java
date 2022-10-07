package inputboundary;

import java.util.Timer;

public interface Timable {

    public Timer time = new Timer();

    public void setTime();
    public void getTime();
    public void changeTime();
    public void deleteTime();
}
