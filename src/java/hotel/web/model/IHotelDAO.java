package hotel.web.model;

import hotel.web.entity.Hotel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author John
 */
public interface IHotelDAO {

    void openConnection() throws ClassNotFoundException, SQLException;
    
    List<Hotel> getAllHotels() throws Exception;
    
    Hotel getHotelById(Long hotelId) throws Exception;
    
    int deleteHotel(Hotel hotel) throws Exception;
    
    int updateHotel(Hotel hotel) throws Exception;
    
    int addNewHotel(Hotel hotel) throws Exception;

}
