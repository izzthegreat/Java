package Store;

import java.time.LocalDate;
import java.time.LocalTime;

abstract class Store {

    private String name, address;
    private boolean openOnSaturday=true, openOnSunday=false;
    private LocalTime openAt, closedAt;
    private int squareFootage;

    public Store(){}

    public Store(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isOpen() {
        boolean isOpen = false;
        if (openAt.isBefore(LocalTime.now()) && closedAt.isAfter(LocalTime.now())) {
            switch (LocalDate.now().getDayOfWeek()) {
                case SATURDAY:
                    if (openOnSaturday) isOpen = true;
                    break;
                case SUNDAY:
                    if (openOnSunday) isOpen = true;
                    break;
                default:
                    isOpen =true;
                    break;
            }
        }
        return isOpen;
    }

    public boolean isOpenOnSaturday() {
        return openOnSaturday;
    }

    public void setOpenOnSaturday( boolean openOnSaturday ) {
        this.openOnSaturday = openOnSaturday;
    }

    public boolean isOpenOnSunday() {
        return openOnSunday;
    }

    public void setOpenOnSunday( boolean openOnSunday ) {
        this.openOnSunday = openOnSunday;
    }

    public String getHours() {
        return String.format("%s to %s", openAt.toString(), closedAt.toString());
    }

    public void setHours( int openHour, int openMinute, int closeHour, int closeMinute ) {
        this.openAt = LocalTime.of( openHour, openMinute );
        this.closedAt = LocalTime.of( closeHour, closeMinute );
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSize( int squareFootage ) {
        this.squareFootage = squareFootage;
    }
}
