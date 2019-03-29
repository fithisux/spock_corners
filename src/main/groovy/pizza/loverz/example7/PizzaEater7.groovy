package pizza.loverz.example7;

import pizza.loverz.domain.FinalPizza;
import pizza.loverz.domain.Gratitude;
import pizza.loverz.domain.Pizza
import pizza.loverz.services.DolaterService;
import pizza.loverz.services.FinalPizzaService;
import pizza.loverz.services.GratitudeService
import pizza.loverz.services.PizzaService;
import pizza.loverz.services.StomachService;

class PizzaEater7 {

    PizzaService pizzaService
    StomachService stomachService
    GratitudeService gratitudeService
    DolaterService dolaterService

    protected void eatPizza(Pizza pizza) {
        stomachService.eatPizza(pizza)
    }

    Gratitude haveAPizzaMealLazily(int amount) {
        Pizza pizza = pizzaService.buyPizza(amount)
        Gratitude gratitude = gratitudeService.expressGratitude(pizza)
        dolaterService.doLater {
            stomachService.eatPizza(pizza)
        }
        gratitude.setHuge(true)
        return gratitude
    }

    Gratitude haveAPizzaMealLazilyWithCurry(int amount) {
        Pizza pizza = pizzaService.buyPizza(amount)
        Gratitude gratitude = gratitudeService.expressGratitude(pizza)
        dolaterService.doLater this.&eatPizza.curry(pizza)
        gratitude.setHuge(true)
        return gratitude
    }

}
