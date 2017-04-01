import java.util.*;

/**
 * Created by Jiuding on 2017/3/28.
 */
public class Vehicle {
    private String name;
    private String type;
    private ArrayList<Booking> bookings;
    private String location;

    /**
     * @param name name of the vehicle
     * @param type type of the vehicle
     */
    public Vehicle(String name, String type) {
        this.name = name;
        this.type = type;
        this.bookings = new ArrayList<>();
    }

    /**
     * @return name of the vehicle
     */
    public String getName() {
        return name;
    }

    /**
     * @return type of the vehicle (auto/manual)
     */
    public String getType() {
        return type;
    }

    /**
     * @return list of rental record
     */
    public ArrayList<Booking> getBookings() {
        return this.bookings;
    }


    public boolean isAvailable(Calendar startDate, Calendar endDate) {
        for (Booking booking : bookings){
            if (endDate.before(booking.getStartDate())||startDate.after(booking.getEndDate())) continue;
            else {
                Calendar tempDate = (Calendar) startDate.clone();
                while (tempDate.compareTo(endDate) != 0) {
                    if (tempDate.compareTo(booking.getStartDate()) >= 0 && tempDate.compareTo(booking.getEndDate())<=0) return false;
                    tempDate.add(Calendar.DATE, 1);
                }
                if (tempDate.compareTo(booking.getStartDate())>=0 && tempDate.compareTo(booking.getEndDate()) <= 0) return false;
            }
        }
        return true;
    }

    /**
     * @param startDate start date of the rental record
     * @param endDate end date of the rental record
     */
    public void insertRentalRecord(int id, Vehicle vehicle, Calendar startDate, Calendar endDate){
        bookings.add(new Booking(id, vehicle, startDate, endDate));
        System.out.print(", " + this.name);
    }

    /**
     * @param id id of the booking
     */
    public void deleteRentalRecord(int id){
        for (Booking booking : bookings){
            if (booking.getId() == id){
                bookings.remove(booking);
            }
        }

    }
}
