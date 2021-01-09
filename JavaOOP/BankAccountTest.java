package BankAccount;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Target;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void testBankAccountCreationStartsWithZeroBalance(){
        BankAccount bankAccount = new BankAccount();
        double balance = bankAccount.getBalance();
        assertEquals(0,balance, 0);
    }

    @Test
    public void testDepositShouldIncreaseAmountCorrectly(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance(), 0);
    }

}
