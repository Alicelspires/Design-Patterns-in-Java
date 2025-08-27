package strategy;

public class Strategy {
    public StrategyBehavior getStrategyDefensive(){
        StrategyBehavior defensive = new StrategyDefensiveBehavior();
        return defensive;
    }

    public StrategyBehavior getStrategyAgressive(){
        StrategyBehavior agressive = new StrategyAgressiveBehavior();
        return agressive;
    }

    public StrategyBehavior getStrategyNormal(){
        StrategyBehavior normal = new StrategyNormalBehavior();
        return normal;
    }

    public String getAllStrategies(){
        StrategyRobot robot = new StrategyRobot();

        robot.setStrategy(getStrategyNormal());
        String normalMove = robot.mover();

        robot.setStrategy(getStrategyAgressive());
        String agressiveMove = robot.mover();

        robot.setStrategy(getStrategyDefensive());
        String defensiveMove = robot.mover();

        return normalMove + "\n" + agressiveMove + "\n" + defensiveMove + "\n";
    }
    
    @Override
    public String toString() {
        return "\t=== Strategy === \n" + getAllStrategies() + "\n";
    }
}
