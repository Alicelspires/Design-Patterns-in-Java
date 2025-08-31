// 1 Interface da Abstract Factory:
class AbstractFactory{
    criaProdutoA(){}
    criaProdutoB(){}
}

// 1 Fabrica 1 Concreta que Cria Produto do Tipo A e B:
class FabricaConcreta1 extends AbstractFactory{
    criaProdutoA(){
        return new ProdutoConcretoA1();
    }

    criaProdutoB(){
        return new ProdutoConcretoB1();
    }
}

// 1 Fabrica 2 Concreta que Cria Produto do Tipo A e B:
class FabricaConcreta2 extends AbstractFactory{
    criaProdutoA(){
        return new ProdutoConcretoA2();
    }

    criaProdutoB(){
        return new ProdutoConcretoB2();
    }
}

// 2 Interface dos Produtos do Tipo A:
class ProdutoAbstratoA{
    metodoA(){}
}

// 2 Implementação Concreta do Produto do Tipo A - Fabrica 1:
class ProdutoConcretoA1 extends ProdutoAbstratoA{
    metodoA(){
        return "Produto do Tipo A da Fabrica 1";
    }
}

// 2 Implementação Concreta do Produto do Tipo A - Fabrica 2:
class ProdutoConcretoA2 extends ProdutoAbstratoA{
    metodoA(){
        return "Produto do Tipo A da Fabrica 2";
    }
}

// 3 Interface dos Produtos do Tipo B:
class ProdutoAbstratoB{
    metodoB(){}
}

// 3 Implementação Concreta do Produto do Tipo B - Fabrica 1:
class ProdutoConcretoB1 extends ProdutoAbstratoB{
    metodoB(){
        return "Produto do Tipo B da Fabrica 1";
    }
}

// 3 Implementação Concreta do Produto do Tipo B - Fabrica 2:
class ProdutoConcretoB2 extends ProdutoAbstratoB{
    metodoB(){
        return "Produto do Tipo B da Fabrica 2";
    }
}

// 4 USO DO PADRÃO ABSTRACT FACTORY - IMPLEMENTAÇÃO:
function clienteCod(factory){
    const produtoA = factory.criaProdutoA();
    const produtoB = factory.criaProdutoB();

    console.log(produtoA.metodoA());
    console.log(produtoB.metodoB());
}

// Exemplo de uso da Fabrica 1:
const factory1 = new FabricaConcreta1();
clienteCod(factory1);

// Exemplo de uso da Fabrica 2:
const factory2 = new FabricaConcreta2();
clienteCod(factory2);
