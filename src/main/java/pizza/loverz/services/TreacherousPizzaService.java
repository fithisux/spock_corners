package pizza.loverz.services;

import pizza.loverz.domain.Pizza;

public interface TreacherousPizzaService extends PizzaService {
    public void sendSecretMessageToAlienInvaders();

    @Override
    public Pizza buyPizza(int amount);
}
