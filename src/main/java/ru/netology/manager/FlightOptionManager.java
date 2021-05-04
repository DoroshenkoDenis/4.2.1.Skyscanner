package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.FlightOption;
import ru.netology.repository.FlightOptionRepository;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
public class FlightOptionManager {
    private FlightOptionRepository repository;

    public void add(FlightOption item) {
        repository.save(item);
    }

    public FlightOption[] findAll(String airportFrom, String airportTo) {
        FlightOption[] result = new FlightOption[0];
        for (FlightOption option : repository.findAll()) {
            if (option.matches(airportFrom, airportTo)) {
                FlightOption[] tmp = new FlightOption[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = option;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
