package ru.nik;
public class ConsoleEventLogger {
    public String logEvent (Event event)
    {
        System.out.println(event.toString());
        return event.toString();
        //fileEventLogger.logEvent();
    }
}
