package hotel.web.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author John
 */
public interface IDB_MySql {

    void openConnection(String driverClassName, String url, String username, 
            String password) throws ClassNotFoundException, SQLException;
    
    List<Map<String, Object>> getAllRecords(String tableName) 
            throws SQLException;
    
    Map getRecordById(String tableName, String primaryKeyField, Object keyValue) 
            throws SQLException;
    
    int deleteRecord(String tableName, String whereField, Object whereValue) 
            throws SQLException;
    
    int updateRecord(String tableName, List colDescriptors, List colValues, 
            String whereField, Object whereValue)throws SQLException;
    
    int insertNewRecord(String tableName, List colDescriptors, List colValues) 
            throws SQLException ;
    
}
