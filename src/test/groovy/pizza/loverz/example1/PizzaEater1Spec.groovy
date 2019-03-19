package pizza.loverz.example1

import pizza.loverz.domain.Gratitude
import pizza.loverz.domain.Pizza
import pizza.loverz.example1.PizzaEater1
import pizza.loverz.services.GratitudeService
import pizza.loverz.services.PizzaService
import pizza.loverz.services.StomachService
import spock.lang.Specification

class PizzaEater1Spec extends Specification {

    PizzaEater1 pizzaEater1;

    def setup() {
        pizzaEater1 = new PizzaEater1(gratitudeService: Mock(GratitudeService), stomachService: Mock(StomachService), pizzaService: Mock(PizzaService))
    }

    def 'Pizza eater eats a pizza fully tested'() {
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
           Gratitude someGratitude = pizzaEater1.haveAPizzaMeal(5)

        then:
           1 * pizzaEater1.pizzaService.buyPizza(5) >> pizza

        then:
           1 * pizzaEater1.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
           1 * pizzaEater1.stomachService.eatPizza(pizza)

        then:
          1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
           someGratitude == gratitude

        and:
            0 * _
    }

    def 'Pizza eater eats a pizza and expresses gratitude, focus is on gratitude object'() {

        given: 'A gratitude'
            Gratitude gratitude = new Gratitude(huge: false)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater1.haveAPizzaMeal(5)

        then:
            1 * pizzaEater1.gratitudeService.expressGratitude(_) >> gratitude

        and: 'I have a huge gratitude'
            someGratitude == gratitude
            someGratitude.isHuge()
    }

    def 'Pizza eater eats a pizza and expresses gratitude, focus is on gratitude object, we add a pizza to the mix'() {
        given: 'A pizza'
            Pizza pizza = new Pizza()

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater1.haveAPizzaMeal(5)

        then:
            1 * pizzaEater1.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater1.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater1.stomachService.eatPizza(pizza)

        then:
            1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
            someGratitude == gratitude

        and:
            0 * _
    }
}
