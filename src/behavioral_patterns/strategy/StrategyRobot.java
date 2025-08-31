package behavioral_patterns.strategy;

public class StrategyRobot {
    private StrategyBehavior strategy;

    public void setStrategy(StrategyBehavior strategy) {
        this.strategy = strategy;
    }

    public String mover(){
        return strategy.mover();
    }
}   
