package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightOption implements Comparable <FlightOption> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTimeMin;

    public boolean matches(String from, String to) {
        return (from.equalsIgnoreCase(airportFrom)) && (to.equalsIgnoreCase(airportTo));
    }

    @Override
    public int compareTo(FlightOption o) {
        return price - o.price;
    }
}
