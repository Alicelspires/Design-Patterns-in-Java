import facade.Facade;
import singleton.Singleton;
import strategy.Strategy;

public class App {
    public static void main(String[] args) throws Exception {

        // Singleton
        Singleton singletonDesignPattern = new Singleton();
        System.out.println(singletonDesignPattern.toString());


        // Strategy

        Strategy strategyDesignPattern = new Strategy();
        System.out.println(strategyDesignPattern.toString());

        // Facade

        System.out.println("\t=== Facade ===");
        Facade facadeDesignPattern = new Facade();
        facadeDesignPattern.migrarCliente("Alice", "555599-0");
        System.out.println();
    }
}
