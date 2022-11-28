package entity.inputboundary;

public interface Populable {
    int popularity = 0;

    default Integer getPopularity() {
        return popularity;
    }
}
