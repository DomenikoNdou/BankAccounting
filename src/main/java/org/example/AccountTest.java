package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account1;
    private Account account2;

    @BeforeEach
    void setUp() {
        account1 = new Account(500);
        account2 = new Account(300);
    }

    @Test
    void deposit() {
        account1.deposit(200);
        assertEquals(700, account1.checkBalance());
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-50));
    }

    @Test
    void withdraw() {
        account1.withdraw(100);
        assertEquals(400, account1.checkBalance());
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(600));
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(-50));
    }

    @Test
    void checkBalance() {
        assertEquals(500, account1.checkBalance());
        assertEquals(300, account2.checkBalance());
    }

    @Test
    void transfer() {
        account1.transfer(200, account2);
        assertEquals(300, account1.checkBalance());
        assertEquals(500, account2.checkBalance());

        assertThrows(IllegalArgumentException.class, () -> account1.transfer(500, account2));
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(-100, account2));
    }
}
