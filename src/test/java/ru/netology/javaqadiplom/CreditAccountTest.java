package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                10_000,
                15_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(13_000, account.getBalance());
    }

    @Test
    public void addMoneyAboveCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                999_999_998,
                15
        );

        account.add(999_999_999);

        Assertions.assertEquals(999_999_998, account.getBalance());
    }

    @Test
    public void payAboveCreditLimitMin() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                15
        );

        account.pay(20_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void yearTestRate() {
        CreditAccount account = new CreditAccount(
                200,
                100_0000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void payAndBalanceTest() {
        CreditAccount account = new CreditAccount(
                20_000,
                100_000,
                15
        );

        account.pay(5_000);

        Assertions.assertEquals(15_000, account.getBalance());
    }

    @Test
    public void accountTest() {


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CreditAccount(15, -15, 10));
    }

    @Test
    public void accountTest_1() {


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CreditAccount(-15, 15, 10));
    }
}
