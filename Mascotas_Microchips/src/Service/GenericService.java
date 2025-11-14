
package Service;
import java.util.List; 
public interface GenericService<T>{
    
    void save(T entity) throws Exception;
    
    T findById(long id) throws Exception;
    List <T> findAll() throws Exception;
    void update(T entity) throws Exception;
    void delete(long id) throws Exception;
    
    void saveTx(T entity) throws Exception;
}
