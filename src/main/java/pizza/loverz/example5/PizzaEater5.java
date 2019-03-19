package pizza.loverz.example5;

import pizza.loverz.domain.Gratitude;
import pizza.loverz.domain.Pizza;
import pizza.loverz.services.GratitudeService;
import pizza.loverz.services.PackageService;
import pizza.loverz.services.PizzaService;
import pizza.loverz.services.StomachService;

public class PizzaEater5 {

    PizzaService pizzaService;
    StomachService stomachService;
    GratitudeService gratitudeService;
    PackageService packageService;

    protected void eatAPackagedPizza(Pizza pizza) {
        packageService.packagePizza(pizza);
        stomachService.eatPizza(pizza);

    }


    public Gratitude haveAPizzaMealOld(int amount) {
        Pizza pizza = pizzaService.buyPizza(amount);
        Gratitude gratitude = gratitudeService.expressGratitude(pizza);
        packageService.packagePizza(pizza);
        stomachService.eatPizza(pizza);
        gratitude.setHuge(true);
        return gratitude;
    }

    public Gratitude haveAPizzaMealIntended(int amount) {
        Pizza pizza = pizzaService.buyPizza(amount);
        Gratitude gratitude = gratitudeService.expressGratitude(pizza);
        this.eatAPackagedPizza(pizza);
        gratitude.setHuge(true);
        return gratitude;
    }

    public Gratitude haveAPizzaMeal(int amount) {
        Pizza pizza = pizzaService.buyPizza(amount);
        Gratitude gratitude = gratitudeService.expressGratitude(pizza);
        gratitude.setHuge(true);
        return gratitude;
    }
}
