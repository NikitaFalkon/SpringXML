package ru.nik;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class App {
    List<Client> clients;
    CacheEventLogger cacheEventLogger;

    public App(List<Client> clients1, CacheEventLogger cacheEventLogger1)
    {
        this.cacheEventLogger=cacheEventLogger1;
        this.clients=clients1;
        WriteClients();
    }
    public void WriteClients()
    {
        for (Client client: this.clients)
        {
            System.out.println(client.getLogin());
        }
    }

    public void logEvent(Event event)
    {
        cacheEventLogger.logEvent(event);
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("context");
        App app = ctx.getBean("app", App.class);
        Event event = ctx.getBean("event", Event.class);
        Event event1 = ctx.getBean("event1", Event.class);
        Event event2 = ctx.getBean("event2", Event.class);
        app.logEvent(event);
        app.logEvent(event1);
        app.logEvent(event2);
        ctx.close();
    }
}
