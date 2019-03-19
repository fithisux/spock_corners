package pizza.loverz.example6;

import pizza.loverz.domain.FinalPizza;
import pizza.loverz.domain.Gratitude;
import pizza.loverz.domain.Pizza;
import pizza.loverz.services.FinalPizzaService;
import pizza.loverz.services.GratitudeService;
import pizza.loverz.services.StomachService;

public class PizzaEater6 {

    protected FinalPizzaService pizzaService;
    protected StomachService stomachService;
    protected GratitudeService gratitudeService;

    protected void eatAPackagedPizza(Pizza pizza) {
        pizza.setTaste("CYANIDE");
    }

    public Gratitude haveAPizzaMeal(int amount) {
        FinalPizza pizza = pizzaService.buyPizza(amount);
        Gratitude gratitude = gratitudeService.expressGratitude(pizza);
        this.eatAPackagedPizza(pizza);
        stomachService.eatPizza(pizza);
        gratitude.setHuge(true);
        return gratitude;
    }

    public Gratitude haveAPoisonedPizzaMeal(int amount) {
        FinalPizza pizza = pizzaService.buyPizza(amount);
        Gratitude gratitude = gratitudeService.expressGratitude(pizza);
        this.eatAPackagedPizza(pizza);
        stomachService.eatPizza(pizza);
        gratitude.setHuge(true);
        return gratitude;
    }

}
