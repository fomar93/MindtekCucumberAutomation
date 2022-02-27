package bookingsapipojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

public class BookingDates {

    private LocalDate checkin;
    private LocalDate checkout;

}
