package pizza.loverz.example2

import pizza.loverz.domain.Gratitude
import pizza.loverz.domain.Pizza
import pizza.loverz.example2.PizzaEater2
import pizza.loverz.services.GratitudeService
import pizza.loverz.services.PizzaBankService
import pizza.loverz.services.PizzaService
import pizza.loverz.services.StomachService
import spock.lang.Specification

class PizzaEater2Spec extends Specification {

    PizzaEater2 pizzaEater2;

    def setup() {
        pizzaEater2 = new PizzaEater2(gratitudeService: Mock(GratitudeService), stomachService: Mock(StomachService), pizzaService: Mock(PizzaService), pizzaBankService: Mock(PizzaBankService))
    }

    def 'Pizza eater eats a pizza fully tested'() {
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater2.haveAPizzaMeal(5)

        then:
            1 * pizzaEater2.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater2.pizzaBankService.store(pizza)

        then:
            1 * pizzaEater2.pizzaBankService.retrieve() >> pizza

        then:
            1 * pizzaEater2.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater2.pizzaBankService.retrieve() >> pizza

        then:
            1 * pizzaEater2.stomachService.eatPizza(pizza)

        then:
            2 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
            someGratitude == gratitude

        and:
            0 * _
    }

    def 'Pizza eater eats a pizza I/O tested'() {
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        and: 'Interactioins here'
            pizzaEater2.pizzaBankService.retrieve() >> pizza
            pizzaEater2.gratitudeService.expressGratitude(pizza) >> gratitude
            pizzaEater2.stomachService.eatPizza(pizza)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater2.haveAPizzaMeal(5)

        then: 'I have a huge gratitude'
            someGratitude == gratitude
    }
}
