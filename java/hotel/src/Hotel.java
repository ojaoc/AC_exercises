import java.util.ArrayList;

public class Hotel {

    private String company;

    private Room[] rooms;

    private ArrayList<Room> listOfAvailableRooms = new ArrayList<>();

    public Hotel(String hotelChain) {

        company = hotelChain;

        rooms = new Room[]{

                new Room(100),
                new Room(101),
                new Room(102),
                new Room(103),
                new Room(104)

        };

    }

    public void checkIn(Guest guest) {

       int availability = checkAvailableRooms();

       Room targetRoom;


       if (availability > 0) {



           System.out.println("The rooms " + listOfAvailableRooms. + " are available.");

           targetRoom = listOfAvailableRooms.get(0);

           targetRoom.setOccupant(guest);

       } else {

           System.out.println("No rooms available.");

       }

    }

    private int checkAvailableRooms() {

        int numberOfAvailableRooms = listOfAvailableRooms.size();

        for (Room each : rooms) {

            if (each.checkAvailability()) {

                listOfAvailableRooms.add(each);

            }

        }

        return numberOfAvailableRooms;

    }



}
