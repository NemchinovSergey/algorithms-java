package com.nsergey.trainings.algorithms.otus.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static com.nsergey.trainings.algorithms.TestUtils.runTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LuckyTicketsBruteForceTest {

    public final LuckyTicketsBruteForce luckyTickets = new LuckyTicketsBruteForce();

    @Timeout(5)
    @Test
    void testLuckyTicketsBruteForce() {
        runTest(new LuckyTicketsBruteForce(), "1.Tickets");
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