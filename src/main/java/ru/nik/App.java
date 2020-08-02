package ru.nik;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    ConsoleEventLogger consoleEventLogger;
    public App(Client client1, ConsoleEventLogger consoleEventLogger1)
    {
        this.consoleEventLogger=consoleEventLogger1;
        this.client=client1;
    }
    public void logEvent(Event event)
    {
        //String som = something.replaceAll(client.getName(), client.getLogin());
        consoleEventLogger.logEvent(event);
    }
    public static void main(String[] args) {
        ApplicationContext  ctx = new ClassPathXmlApplicationContext("context");
        App app = ctx.getBean("app", App.class);
        Event event = ctx.getBean("event", Event.class);
        app.logEvent(event);
        //ctx.close();
        //App app = new App();
        //app.client = new Client("Ia","Login");
        //app.consoleEventLogger = new ConsoleEventLogger();
        //app.logEvent("For some user Ima");
    }
}
