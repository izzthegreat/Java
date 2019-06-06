package Stores;

import java.time.LocalTime;

public abstract class Store {

    String name, address;
    int sqrFeet;
    LocalTime openAt,closedAt;
    boolean openOnSaturday, openOnSunday;

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Store(String name, String address, int sqrFeet, LocalTime openAt, LocalTime closedAt, boolean openOnSaturday, boolean openOnSunday) {
        this.name = name;
        this.address = address;
        this.sqrFeet = sqrFeet;
        this.openAt = openAt;
        this.closedAt = closedAt;
        this.openOnSaturday = openOnSaturday;
        this.openOnSunday = openOnSunday;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSqrFeet() {
        return sqrFeet;
    }

    public void setSqrFeet(int sqrFeet) {
        this.sqrFeet = sqrFeet;
    }

    public LocalTime getOpenAt() {
        return openAt;
    }

    public void setOpenAt(int hr, int min) {
        this.openAt = LocalTime.of(hr, min);
    }

    public LocalTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(int hr, int min) {
        this.closedAt = LocalTime.of(hr,min);
    }

    public boolean isOpenOnSaturday() {
        return openOnSaturday;
    }

    public void setOpenOnSaturday(boolean openOnSaturday) {
        this.openOnSaturday = openOnSaturday;
    }

    public boolean isOpenOnSunday() {
        return openOnSunday;
    }

    public void setOpenOnSunday(boolean openOnSunday) {
        this.openOnSunday = openOnSunday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen (){
        return LocalTime.now().isAfter(openAt) && LocalTime.now().isBefore(closedAt);
    }
}
