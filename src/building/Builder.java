package building;

import java.io.Serializable;

public class Builder implements Serializable{
    private boolean free = true;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
