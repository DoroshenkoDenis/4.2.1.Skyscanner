package ru.netology.repository;

import ru.netology.domain.FlightOption;
import ru.netology.exception.NotFoundException;

public class FlightOptionRepository {
    private FlightOption[] items = new FlightOption[0];

    public void save(FlightOption item) {
        int length = items.length + 1;
        FlightOption[] tmp = new FlightOption[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FlightOption[] findAll() {
        return items;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("====> Element with id: " + id + " not found <====");
        }
        int length = items.length - 1;
        FlightOption[] tmp = new FlightOption[length];
        int index = 0;
        for (FlightOption item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public FlightOption findById(int id) {
        for (FlightOption item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
