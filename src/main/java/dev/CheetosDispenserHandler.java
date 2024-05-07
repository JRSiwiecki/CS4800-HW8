package dev;

public class CheetosDispenserHandler extends SnackDispenserHandler
{
    public CheetosDispenserHandler(VendingMachine vendingMachine, SnackDispenserHandler next)
    {
        super(vendingMachine, next);
    }

    @Override
    public Snack handleRequest(String snackName)
    {
        if (snackName.equals("Cheetos"))
        {
            VendingMachine vendingMachine = super.getVendingMachine();
            Snack selectedSnack = vendingMachine.getSelectedSnack();

            if (selectedSnack.getQuantity() > 0)
            {
                selectedSnack.setQuantity(selectedSnack.getQuantity() - 1);
                vendingMachine.setState(new IdleState(vendingMachine));
                vendingMachine.setInsertedMoney(
                        vendingMachine.getInsertedMoney() - selectedSnack.getPrice());
                return selectedSnack;
            }

            else
            {
                System.out.println("ERROR -> Selected snack out of stock, returning money.");
                return null;
            }
        }

        return super.handleRequest(snackName);
    }
}