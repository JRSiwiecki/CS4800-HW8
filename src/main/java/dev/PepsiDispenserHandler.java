package dev;

public class PepsiDispenserHandler extends SnackDispenserHandler
{
    public PepsiDispenserHandler(VendingMachine vendingMachine, SnackDispenserHandler next)
    {
        super(vendingMachine, next);
    }

    @Override
    public Snack handleRequest(String snackName)
    {
        if (snackName.equals("Pepsi"))
        {
            VendingMachine vendingMachine = super.getVendingMachine();
            Snack selectedSnack = vendingMachine.getSelectedSnack();

            if (selectedSnack.getQuantity() > 0)
            {
                selectedSnack.setQuantity(selectedSnack.getQuantity() - 1);
                vendingMachine.setInsertedMoney(
                        vendingMachine.getInsertedMoney() - selectedSnack.getPrice());
                vendingMachine.setState(new IdleState(vendingMachine));
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
