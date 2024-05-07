package dev;

public abstract class SnackDispenserHandler
{
    private final VendingMachine vendingMachine;
    private final SnackDispenserHandler next;

    public SnackDispenserHandler(VendingMachine vendingMachine, SnackDispenserHandler next)
    {
        this.vendingMachine = vendingMachine;
        this.next = next;
    }

    public Snack handleRequest(String snackName)
    {
        if (next != null)
        {
            return next.handleRequest(snackName);
        }

        return null;
    }

    public VendingMachine getVendingMachine()
    {
        return vendingMachine;
    }
}
