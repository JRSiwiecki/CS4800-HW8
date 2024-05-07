package dev;

import java.util.Map;

public class VendingMachine
{
    private VendingMachineState state = new IdleState(this);
    private SnackDispenserHandler handler;
    private final Map<String, Snack> snackMap;
    private Snack selectedSnack;
    private double insertedMoney = 0.0;

    public VendingMachine()
    {
        snackMap = Map.ofEntries(
                Map.entry("Coke", new Snack("Coke", 1.00, 3)),
                Map.entry("Pepsi", new Snack("Pepsi", 0.50, 3)),
                Map.entry("Cheetos", new Snack("Cheetos", 1.50, 3)),
                Map.entry("Doritos", new Snack("Doritos", 2.00, 3)),
                Map.entry("KitKat", new Snack("KitKat", 1.00, 3)),
                Map.entry("Snickers", new Snack("Snickers", 1.50, 3))
        );

        handler = new CokeDispenserHandler(this,
                new PepsiDispenserHandler(this,
                        new CheetosDispenserHandler(this,
                                new DoritosDispenserHandler(this,
                                        new KitKatDispenserHandler(this,
                                                new SnickersDispenserHandler(this, null))))));
    }

    public void setState(VendingMachineState newState)
    {
        state = newState;
    }

    public void selectSnack(String snackName)
    {
        state.selectSnack(snackName);
    }

    public void insertMoney(double amount)
    {
        state.insertMoney(amount);
    }

    public void dispenseSnack()
    {
        state.dispenseSnack();
    }

    public Snack getSelectedSnack()
    {
        return selectedSnack;
    }

    public void setSelectedSnack(String snackName)
    {
        this.selectedSnack = snackMap.get(snackName);
    }

    public double getInsertedMoney()
    {
        return insertedMoney;
    }

    public void setInsertedMoney(double insertedMoney)
    {
        this.insertedMoney = insertedMoney;
    }

    public SnackDispenserHandler getHandler()
    {
        return handler;
    }
}
