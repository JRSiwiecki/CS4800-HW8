package dev;

public abstract class SnackDispenserHandler
{
    private final SnackDispenserHandler next;

    public SnackDispenserHandler(SnackDispenserHandler next)
    {
        this.next = next;
    }

    public void handleRequest(String requestType)
    {
        if (next != null)
        {
            next.handleRequest(requestType);
        }
    }
}
