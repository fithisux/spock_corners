package pizza.loverz.example6

import pizza.loverz.domain.FinalPizza
import pizza.loverz.domain.Gratitude
import pizza.loverz.domain.Pizza
import pizza.loverz.example6.PizzaEater6
import pizza.loverz.services.FinalPizzaService
import pizza.loverz.services.GratitudeService
import pizza.loverz.services.PizzaService
import pizza.loverz.services.StomachService
import spock.lang.Specification

class PizzaEater6SpySpec extends Specification {

    PizzaEater6 pizzaEater6;

    def setup() {
        pizzaEater6 = Spy(PizzaEater6)
        pizzaEater6.gratitudeService = Mock(GratitudeService)
        pizzaEater6.stomachService = Mock(StomachService)
        pizzaEater6.pizzaService = Mock(FinalPizzaService)
    }

    def 'Pizza eater eats a pizza fully tested with spies but poisonous'() {
        given: 'A pizza'
            FinalPizza pizza = new FinalPizza()

        and: 'A gratitude'
        Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater6.haveAPoisonedPizzaMeal(5)

        then:
            1 * pizzaEater6.haveAPoisonedPizzaMeal(5)

        then:
            1 * pizzaEater6.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater6.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater6.eatAPackagedPizza(pizza)

        then:
            1 * pizzaEater6.stomachService.eatPizza(pizza)

        then:
            1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
        someGratitude == gratitude

        and:
        0 * _

    }

    def 'Pizza eater eats a hawaian pizza fully tested'() {
        given: 'A pizza'
            FinalPizza pizza = new FinalPizza(taste: 'hawaian')

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater6.haveAPoisonedPizzaMeal(5)

        then:
            1 * pizzaEater6.haveAPoisonedPizzaMeal(5)

        then:
            1 * pizzaEater6.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater6.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater6.eatAPackagedPizza(pizza)

        then:
            1 * pizzaEater6.stomachService.eatPizza(_ as Pizza) >> {
                Pizza somePizza ->
                    assert somePizza.taste == 'hawaian'
            }

        then:
            1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
            someGratitude == gratitude

        and:
            0 * _

    }


}
