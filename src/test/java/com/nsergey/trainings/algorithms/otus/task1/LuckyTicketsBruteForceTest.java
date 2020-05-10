package com.nsergey.trainings.algorithms.otus.task1;

import org.junit.jupiter.api.Test;

import static com.nsergey.trainings.algorithms.TestUtils.runTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LuckyTicketsBruteForceTest {

    public final LuckyTicketsBruteForce luckyTickets = new LuckyTicketsBruteForce();

    @Test
    void testLuckyTicketsBrute() {
        runTest(new LuckyTicketsBrute(), "1.Tickets");
    }

    @Test
    void testLuckyTicketsBruteForce() {
        runTest(new LuckyTicketsBruteForce(), "1.Tickets");
    }

    @Test
    void getFirstNumber() {
        assertEquals(10, luckyTickets.getFirstNumber(1));
        assertEquals(1000, luckyTickets.getFirstNumber(2));
        assertEquals(100000, luckyTickets.getFirstNumber(3));
    }

    @Test
    void getLastNumber() {
        assertEquals(99, luckyTickets.getLastNumber(1));
        assertEquals(9999, luckyTickets.getLastNumber(2));
        assertEquals(999999, luckyTickets.getLastNumber(3));
    }

    @Test
    void sumOfFirstHalf() {
        int n = 3;
        byte[] bytes = "123456".getBytes();
        assertEquals(6, luckyTickets.sumOfFirstHalf(bytes, n));
    }

    @Test
    void sumOfSecondHalf() {
        int n = 3;
        byte[] bytes = "123456".getBytes();
        assertEquals(15, luckyTickets.sumOfSecondHalf(bytes, n));
    }
}