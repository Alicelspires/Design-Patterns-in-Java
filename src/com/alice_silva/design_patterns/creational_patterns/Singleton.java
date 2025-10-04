package com.alice_silva.design_patterns.creational_patterns;

/*
 * Uma empresa de software está desenvolvendo um sistema que 
 * precisa garantir que determinados componentes críticos existam 
 * apenas uma vez durante toda a execução da aplicação.
 * 
 * Implementando 3 variações de singleton:
 * 
 * => Singleton Lazy – a instância é criada apenas quando solicitada 
 * pela primeira vez (preguiçoso).
 * 
 * => Singleton Eager – a instância é criada imediatamente na carga da 
 * classe (ansioso).
 * 
 * => Singleton Lazy Holder – usa uma classe estática interna para criar 
 * a instância de forma thread-safe e eficiente.
 */

// Singleton 1
class SingletonLazyHolder {
    private static class InstanceHolder {
        private static SingletonLazyHolder instacia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder(){
        super();
    }

    public static SingletonLazyHolder getInstance(){
        return InstanceHolder.instacia;
    }
}

// Singleton 2
class SingletonEager {
    private static SingletonEager instacia = new SingletonEager();
    
    private SingletonEager(){
        super();
    }

    public static SingletonEager getInstance(){
        return instacia;
    }
}

// Singleton 3
class SingletonLazy {
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

// ======================================
// USING THE PATTERN - SINGLETON
// ======================================

class Singleton {

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
