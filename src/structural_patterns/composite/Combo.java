package structural_patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Item{
    private String nomeCombo;
    private List<Item> combo = new ArrayList<>();

    public Combo(String nomeCombo){
        this.nomeCombo = nomeCombo;
    }

    @Override
    public String getNome() {
        return this.nomeCombo;
    }

    @Override
    public Double getPreco() {
        return this.combo.stream()
            .mapToDouble(item -> item.getPreco())
            .sum();
    }

    public List<Item> getItens() {
        return this.combo;
    }

    public Combo adicionar(Item item){
        this.combo.add(item);
        return this;
    }

    public String remover(Item itemFind){
        Boolean findItem = this.combo.removeIf(item -> item == itemFind);
        String removedItem = findItem == false ? 
            "Item do combo não encontrado" : 
            "Item removido do combo com sucesso!";
        return removedItem;
    }
}
