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
        vendingMachine.setSelectedSnack(snackName);
        vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
        System.out.println("Setting selected snack to " + vendingMachine.getSelectedSnack().getName() + ".");
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
