package core.gateway;

import java.util.Collection;

public interface GateWay<T, ID> {

    T findById(ID id);

    void saveById(T snippet);

    Collection<T> findAll();
    
}
