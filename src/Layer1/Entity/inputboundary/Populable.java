package Layer1.Entity.inputboundary;

public interface Populable {
    int popularity = 0;

    default Integer getPopularity() {
        return popularity;
    }
}
