package dev;

public class Main
{
    public static void main(String[] args)
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(1.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.50);

        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Doritos");
        vendingMachine.insertMoney(2);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.50);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.50);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.50);
        vendingMachine.dispenseSnack();

    }
}
