package hotel.web.model;

import hotel.web.entity.Hotel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author John
 */
public class HotelDAO implements IHotelDAO {

    private static final String TABLE_NAME = "hotel";
    private static final String PRIMARY_KEY = "hotel_id";
    private DB_MySql db;
    private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/hotel";
    private String userName = "admin";
    private String password = "admin";

    public HotelDAO() {
        db = new DB_MySql();
    }

    @Override
    public final void openConnection() throws ClassNotFoundException,
            SQLException {

        db.openConnection(driverClassName, url, userName, password);
    }

    @Override
    public final List<Hotel> getAllHotels() throws Exception {

        List<Map<String, Object>> rawData = new ArrayList<>();
        List<Hotel> records = new ArrayList<>();
        HotelDAO dao = new HotelDAO();

        try {
            db.openConnection(driverClassName, url, userName, password);
            rawData = db.getAllRecords(TABLE_NAME);
            Hotel hotel = null;

            for (Map record : rawData) {
                hotel = dao.buildHotelRecord(record);
                records.add(hotel);
            }
        } catch (SQLException sqle) {
            throw sqle;
        }
        return records;
    }

    @Override
    public final Hotel getHotelById(Long hotelId) throws Exception {

        HotelDAO dao = new HotelDAO();
        Hotel hotel = null;

        try {
            db.openConnection(driverClassName, url, userName, password);
            Map<String, Object> record = db.getRecordById(TABLE_NAME,
                    PRIMARY_KEY, hotelId);
            hotel = dao.buildHotelRecord(record);
        } catch (SQLException sqle) {
            throw sqle;
        }
        return hotel;
    }

    public final Hotel buildHotelRecord(Map record) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(Long.parseLong(record.get("hotel_id").toString()));
        hotel.setHotelName(record.get("hotel_name").toString());
        hotel.setStreetAddress(record.get("street_address").toString());
        hotel.setCity(record.get("city").toString());
        hotel.setState(record.get("state").toString());
        hotel.setPostalCode(record.get("postal_code").toString());
        if (record.get("notes") != null) {
            hotel.setNotes(record.get("notes").toString());
        }
        return hotel;
    }

    @Override
    public int deleteHotel(Hotel hotel) throws SQLException, Exception {
        HotelDAO dao = new HotelDAO();
        String whereField = "hotel_id";
        String whereValue = hotel.getHotelId().toString();
        try {
            db.openConnection(driverClassName, url, userName, password);
            return db.deleteRecord(TABLE_NAME, whereField, whereValue); 
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

    public final int updateHotel(Hotel hotel) throws SQLException, Exception {
        
        Object whereValue = hotel.getHotelId();
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("hotel_name");
        fieldNames.add("street_address");
        fieldNames.add("city");
        fieldNames.add("state");
        fieldNames.add("postal_code");
        fieldNames.add("notes");

        List fieldValues = new ArrayList();
        fieldValues.add(hotel.getHotelName());
        fieldValues.add(hotel.getStreetAddress());
        fieldValues.add(hotel.getCity());
        fieldValues.add(hotel.getState());
        fieldValues.add(hotel.getPostalCode());
        fieldValues.add(hotel.getNotes());  

        try {
            db.openConnection(driverClassName, url, userName, password);
            return db.updateRecord(TABLE_NAME, fieldNames, fieldValues, 
                    PRIMARY_KEY, whereValue);
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

    @Override
    public final int addNewHotel(Hotel hotel) throws SQLException, Exception {

        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("hotel_name");
        fieldNames.add("street_address");
        fieldNames.add("city");
        fieldNames.add("state");
        fieldNames.add("postal_code");
        fieldNames.add("notes");

        List fieldValues = new ArrayList();
        fieldValues.add(hotel.getHotelName());
        fieldValues.add(hotel.getStreetAddress());
        fieldValues.add(hotel.getCity());
        fieldValues.add(hotel.getState());
        fieldValues.add(hotel.getPostalCode());
        fieldValues.add(hotel.getNotes());

        try {
            db.openConnection(driverClassName, url, userName, password);
            return db.insertNewRecord(TABLE_NAME, fieldNames, fieldValues);
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

}
