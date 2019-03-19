package pizza.loverz.example3;

import pizza.loverz.domain.Gratitude;
import pizza.loverz.domain.Pizza;
import pizza.loverz.services.GratitudeService;
import pizza.loverz.services.PizzaService;
import pizza.loverz.services.StomachService;
import pizza.loverz.services.TreacherousPizzaService;

public class PizzaEater3 {
    PizzaService pizzaService;
    StomachService stomachService;
    GratitudeService gratitudeService;

    public Gratitude haveAPizzaMeal(int amount) {
        Pizza pizza = pizzaService.buyPizza(amount);
        if (pizzaService instanceof TreacherousPizzaService) {
            ((TreacherousPizzaService) pizzaService).sendSecretMessageToAlienInvaders();
        }
        Gratitude gratitude = gratitudeService.expressGratitude(pizza);
        stomachService.eatPizza(pizza);
        gratitude.setHuge(true);
        return gratitude;
    }
}
