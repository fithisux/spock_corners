package pizza.loverz.example2;

import pizza.loverz.domain.Gratitude;
import pizza.loverz.services.GratitudeService;
import pizza.loverz.services.PizzaBankService;
import pizza.loverz.services.PizzaService;
import pizza.loverz.services.StomachService;

public class PizzaEater2 {
    PizzaService pizzaService;
    StomachService stomachService;
    GratitudeService gratitudeService;
    PizzaBankService pizzaBankService;

    public Gratitude haveAPizzaMeal(int amount) {
        pizzaBankService.store(pizzaService.buyPizza(amount));
        Gratitude gratitude = gratitudeService.expressGratitude(pizzaBankService.retrieve());
        stomachService.eatPizza(pizzaBankService.retrieve());
        gratitude.setHuge(true);
        gratitude.setHuge(true);
        return gratitude;
    }
}
