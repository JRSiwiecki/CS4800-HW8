package dev;

public class WaitingForMoneyState implements VendingMachineState
{
    private final VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName)
    {
        System.out.println("ERROR -> Snack already selected, waiting for money.");
    }

    @Override
    public void insertMoney(double amount)
    {
        vendingMachine.setInsertedMoney(vendingMachine.getInsertedMoney() + amount);

        if (vendingMachine.getInsertedMoney()
                >= vendingMachine.getSelectedSnack().getPrice())
        {
            vendingMachine.setState(new DispensingSnackState(vendingMachine));
            System.out.println("Payment accepted, currently $" + amount + " in the vending machine.");
        }

        else
        {
            System.out.println("Not enough money inserted for selected snack.");
        }
    }

    @Override
    public void dispenseSnack()
    {
        System.out.println("ERROR -> Insert money first.");
    }
}
