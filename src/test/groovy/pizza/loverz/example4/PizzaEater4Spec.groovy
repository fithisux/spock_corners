package pizza.loverz.example4

import pizza.loverz.domain.Gratitude
import pizza.loverz.domain.Pizza
import pizza.loverz.example4.PizzaEater4
import pizza.loverz.services.GratitudeService
import pizza.loverz.services.PackageService
import pizza.loverz.services.PizzaService
import pizza.loverz.services.StomachService
import spock.lang.Specification

class PizzaEater4Spec extends Specification {

    PizzaEater4 pizzaEater4;

    def setup() {
        pizzaEater4 = new PizzaEater4(gratitudeService: Mock(GratitudeService), stomachService: Mock(StomachService), pizzaService: Mock(PizzaService), packageService: Mock(PackageService))
    }

    def 'Pizza eater eats abnormally a pizza fully tested'() {
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater4.haveAnAbnormalPizzaMeal(5)

        then:
            1 * pizzaEater4.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater4.gratitudeService.expressGratitude(pizza) >> gratitude

        then: 'I eat the pizza'
            1 * pizzaEater4.stomachService.eatPizza(pizza)

        then: 'I package the pizza'
            1 * pizzaEater4.packageService.packagePizza(pizza)

        then:
            1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
            someGratitude == gratitude

        and:
            0 * _
    }

    def 'Pizza eater eats abnormally a pizza almost tested'() {
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater4.haveAnAbnormalPizzaMeal(5)

        then:
            1 * pizzaEater4.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater4.gratitudeService.expressGratitude(pizza) >> gratitude

        and: 'I eat a packaged pizza'
            1 * pizzaEater4.packageService.packagePizza(pizza)
            1 * pizzaEater4.stomachService.eatPizza(pizza)

        then:
            1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
            someGratitude == gratitude

        and:
            0 * _
    }

}
