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

        Assertions.assertEquals(5_000, account.getBalance());
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
    public void shouldShowExceptionRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2_000, 1_000, 10_000, -4));
    }

    @Test
    public void shouldShowExceptionInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(500, 1_000, 10_000, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(11_000, 1_000, 10_000, 5));
    }

    @Test
    public void shouldShowExceptionMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2_000, -1_000, 10_000, 5));
    }

    @Test
    public void shouldShowMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        Assertions.assertEquals(1_000, account.getMinBalance());
    }

    @Test
    public void shouldShowMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        Assertions.assertEquals(10_000, account.getMaxBalance());
    }
}
