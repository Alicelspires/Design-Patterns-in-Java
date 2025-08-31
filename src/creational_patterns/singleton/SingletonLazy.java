package creational_patterns.singleton;
public class SingletonLazy {
    private static SingletonLazy instacia;
    
    private SingletonLazy(){
        super();
    }

    public static SingletonLazy getInstance(){
        if(instacia == null){
            instacia = new SingletonLazy();
        }
        return instacia;
    }
}

