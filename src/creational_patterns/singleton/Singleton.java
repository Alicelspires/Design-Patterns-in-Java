package creational_patterns.singleton;

public class Singleton {

    public String getSingletonLazy(){
        SingletonLazy lazy = SingletonLazy.getInstance();
        SingletonLazy lazyCopy = SingletonLazy.getInstance();

        return lazy + "\n" + lazyCopy;
    }

    public String getSingletonEager(){
        SingletonEager eager = SingletonEager.getInstance();
        SingletonEager eagerCopy = SingletonEager.getInstance();

        return eager + "\n" + eagerCopy;
    }

    public String getSingletonLazyHolder(){
        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstance();
        SingletonLazyHolder lazyHolderCopy = SingletonLazyHolder.getInstance();

        return lazyHolder + "\n" + lazyHolderCopy;
    }

    @Override
    public String toString() {
        return "\t=== SINGLETON === \n" + getSingletonLazy() + "\n---------\n" + 
            getSingletonEager() + "\n---------\n" + 
            getSingletonLazyHolder() + "\n";
    }
    
}
