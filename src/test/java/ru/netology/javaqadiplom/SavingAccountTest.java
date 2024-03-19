package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddEqualToMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(8_000);

        int expected = 10_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotAddUnderMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(10_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotAddNegativeAmount() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(-1_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPayNegativeAmount() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.pay(-1_000);

        int expected = 2_000;
        int actual = account.getBalance();
    }

    @Test
    public void shouldPayEqualToMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_500, 10_000, 5);

        account.pay(500);

        int expected = 1_500;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPayWhenLessMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_500, 10_000, 5);

        account.pay(1_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCountRate() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        int expected = 100;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowException() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, -4);

        Assertions.assertThrows(IllegalArgumentException.class, () -> account.yearChange());
    }
}
