package hotel.web.model;

import hotel.web.entity.Hotel;
import java.util.List;

/**
 *
 * @author John
 */
public class HotelService {

    private IHotelDAO hotelDAO;

    public HotelService() {

        hotelDAO = new HotelDAO();
    }

    public final List<Hotel> getAllHotels() throws Exception {

        return hotelDAO.getAllHotels();
    }

    public final Hotel getHotelById(Long hotelId) throws Exception {

        return hotelDAO.getHotelById(hotelId);
    }

    public final int deleteHotel(Hotel hotel) throws Exception {

        return hotelDAO.deleteHotel(hotel);
    }

    public final int addNewHotel(Hotel hotel) throws Exception {

        return hotelDAO.addNewHotel(hotel);
    }

    public final int updateHotel(Hotel hotel) throws Exception {

        return hotelDAO.updateHotel(hotel);
    }

    public static void main(String[] args) throws Exception {

        HotelService hotelService = new HotelService();

//        //getAllHotels
        List<Hotel> hotels = hotelService.getAllHotels();
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
        
//        //getHotelById
//        Hotel hotel = hotelService.getHotelById(Long.parseLong("4"));
//        System.out.println(hotel);

//        //deleteHotel
//        Hotel hotel = hotelService.getHotelById(Long.parseLong("4"));
//        hotelService.deleteHotel(hotel);   

//        //updateHotel        
//        Hotel hotel = hotelService.getHotelById(Long.parseLong("2"));
//        hotel.setCity("Duluth");
//        hotel.setState("MN");
//        hotel.setPostalCode("55555");
//        hotelService.updateHotel(hotel); 
 
//        //addNewHotel     
//        Hotel hotel = new Hotel("John's Hotel","927 Bay View Cir","Mukwonago",
//                "WI","53149","");
//        hotelService.addNewHotel(hotel);
    
    }
}
