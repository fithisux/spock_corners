package pizza.loverz.example1;

import pizza.loverz.domain.Gratitude;
import pizza.loverz.domain.Pizza;
import pizza.loverz.services.GratitudeService;
import pizza.loverz.services.PizzaService;
import pizza.loverz.services.StomachService;

public class PizzaEater1 {
    PizzaService pizzaService;
    StomachService stomachService;
    GratitudeService gratitudeService;

    public Gratitude haveAPizzaMeal(int amount) {
        Pizza pizza = pizzaService.buyPizza(amount);
        Gratitude gratitude = gratitudeService.expressGratitude(pizza);
        stomachService.eatPizza(pizza);
        gratitude.setHuge(true);
        return gratitude;
    }
}
