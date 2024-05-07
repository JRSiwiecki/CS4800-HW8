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
        Snack snack = vendingMachine.getHandler()
                .handleRequest(vendingMachine.getSelectedSnack().getName());
        System.out.println("Dispensing snack " + snack.getName() + ".");
        return snack;
    }
}
