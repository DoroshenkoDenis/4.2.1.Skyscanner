package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOption;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.FlightOptionRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlightOptionsManagerTest {
    private FlightOptionRepository repository = new FlightOptionRepository();
    private FlightOptionManager manager = new FlightOptionManager(repository);
    private FlightOption option1 = new FlightOption(1, 600, "DME", "KHV", 500);
    private FlightOption option11 = new FlightOption(11, 250, "DME", "KHV", 550);
    private FlightOption option111 = new FlightOption(111, 350, "DME", "KHV", 570);
    private FlightOption option2 = new FlightOption(2, 200, "SVO", "CDG", 600);
    private FlightOption option3 = new FlightOption(3, 300, "GOJ", "KXK", 700);
    private FlightOption option4 = new FlightOption(4, 400, "SVO", "CDG", 800);

    @BeforeEach
    public void setUp() {
        manager.add(option1);
        manager.add(option11);
        manager.add(option111);
        manager.add(option2);
        manager.add(option3);
        manager.add(option4);
    }

    @Test
    void shouldFindAllAndSortByPrice() {
        FlightOption[] expected = new FlightOption[]{option11, option111, option1};
        FlightOption[] actual = manager.findAll("DME", "KHV");
        assertArrayEquals(expected, actual);
        }

    @Test
    void shouldNotFound() {
        FlightOption[] expected = new FlightOption[0];
        FlightOption[] actual = manager.findAll("PAR", "KHV");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIgnoreCase() {
        FlightOption[] expected = new FlightOption[]{option2, option4};
        FlightOption[] actual = manager.findAll("svo", "cDg");
        assertArrayEquals(expected, actual);
    }
}