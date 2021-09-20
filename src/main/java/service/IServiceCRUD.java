package service;
import java.util.List;

public interface IServiceCRUD<P> {
    P save(P p);
    List<P> findAll();
    P update(P p);
}
