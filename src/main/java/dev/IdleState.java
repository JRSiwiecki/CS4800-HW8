package dev;

public class IdleState implements VendingMachineState
{
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName)
    {
        vendingMachine.selectSnack(snackName);
        vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
    }

    @Override
    public void insertMoney(double amount)
    {
        System.out.println("ERROR -> Please select a snack first.");
    }

    @Override
    public Snack dispenseSnack()
    {
        System.out.println("ERROR -> Please select a snack first.");
        return null;
    }
}
