package pizza.loverz.example4;

import pizza.loverz.domain.Gratitude;
import pizza.loverz.domain.Pizza;
import pizza.loverz.services.GratitudeService;
import pizza.loverz.services.PackageService;
import pizza.loverz.services.PizzaService;
import pizza.loverz.services.StomachService;

public class PizzaEater4 {

    PizzaService pizzaService;
    StomachService stomachService;
    GratitudeService gratitudeService;
    PackageService packageService;

    public Gratitude haveAnAbnormalPizzaMeal(int amount) {
        Pizza pizza = pizzaService.buyPizza(amount);
        Gratitude gratitude = gratitudeService.expressGratitude(pizza);
        stomachService.eatPizza(pizza);
        packageService.packagePizza(pizza);
        gratitude.setHuge(true);
        return gratitude;
    }
}
