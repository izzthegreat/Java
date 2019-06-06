package PLCMC;

import java.time.LocalDate;

interface Reservable {
    String reservationName = "";
    LocalDate PickUpDate = null;

    default void reserve(String name, int daysOut) {

    }
}
