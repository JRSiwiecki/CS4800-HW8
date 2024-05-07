package dev;

public interface VendingMachineState
{
    void selectSnack(String snackName);
    void insertMoney(double amount);
    Snack dispenseSnack();
}