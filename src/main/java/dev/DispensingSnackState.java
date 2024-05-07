package dev;

public class DispensingSnackState implements VendingMachineState
{
    private final VendingMachine vendingMachine;

    public DispensingSnackState(VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName)
    {
        System.out.println("ERROR -> Snack already selected, wait for snack to be dispensed.");
    }

    @Override
    public void insertMoney(double amount)
    {
        System.out.println("ERROR -> Snack already paid for, wait for snack to be dispensed.");
    }

    @Override
    public Snack dispenseSnack()
    {
        Snack selectedSnack = vendingMachine.getSelectedSnack();

        if (selectedSnack.getQuantity() > 0)
        {
            selectedSnack.setQuantity(selectedSnack.getQuantity() - 1);
            vendingMachine.setState(new IdleState(vendingMachine));
            return selectedSnack;
        }

        System.out.println("ERROR -> Selected snack out of stock, returning money.");
        return null;
    }
}
