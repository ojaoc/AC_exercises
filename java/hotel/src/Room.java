public class Room {

    private boolean availability;

    private int door;
    
    private Guest occupant;

    public Room(int doorNumber) {

        availability = true;

        door = doorNumber;

    }

    public boolean checkAvailability() {

        return availability;

    }

    public int getDoor() {

        return door;

    }

    private void setAvailability(boolean available) {

        availability = available;

    }

    public void setOccupant(Guest guest) {

        setAvailability(false);

        occupant = guest;

        System.out.println("You booked the room number " + door);

    }

}
