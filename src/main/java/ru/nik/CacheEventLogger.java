package ru.nik;

import java.util.*;

public class CacheEventLogger {
    private int CacheSize;
    List<Event> cache = new ArrayList<>();
    ConsoleEventLogger consoleEventLogger;
    FileEventLogger fileEventLogger;

    public CacheEventLogger(int cacheSize) {
        CacheSize = cacheSize;
    }

    public void setConsoleEventLogger(ConsoleEventLogger consoleEventLogger) {
        this.consoleEventLogger = consoleEventLogger;
    }
    public void setFileEventLogger(FileEventLogger fileEventLogger) {
        this.fileEventLogger = fileEventLogger;
    }
    public void setCacheSize(int cacheSize) {
        CacheSize = cacheSize;
    }

    public void logEvent(Event event)
    {
        cache.add(event);
        if(cache.size() == CacheSize)
        {
            WriteEventsFromCache();
            cache.clear();
        }
    }
    public void WriteEventsFromCache()
    {
        String str="";
        for (Event event: cache) {
            str=str+consoleEventLogger.logEvent(event)+"\n";
        }
        fileEventLogger.logEvent(str);
    }
    public void Destroy()
    {
        if(!cache.isEmpty())
        {
            WriteEventsFromCache();
        }
    }
}
