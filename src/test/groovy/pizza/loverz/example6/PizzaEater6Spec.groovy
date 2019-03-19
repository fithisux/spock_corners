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

class PizzaEater6Spec extends Specification {

    PizzaEater6 pizzaEater6;

    def setup() {
        pizzaEater6 = new PizzaEater6(gratitudeService: Mock(GratitudeService), stomachService: Mock(StomachService), pizzaService: Mock(FinalPizzaService))
    }

    def 'Pizza eater eats a pizza fully tested'() {
        given: 'A pizza'
            FinalPizza pizza = new FinalPizza()

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater6.haveAPizzaMeal(5)

        then:
            1 * pizzaEater6.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater6.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater6.stomachService.eatPizza(pizza)

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

        and: 'A pizza'
            FinalPizza pizza = new FinalPizza()

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater6.haveAPizzaMeal(5)

        then:
            1 * pizzaEater6.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater6.gratitudeService.expressGratitude(_) >> gratitude

        and: 'I have a huge gratitude'
            someGratitude == gratitude
            someGratitude.isHuge()
    }

    def 'Victim pizza eater eats a pizza fully tested'() {
        given: 'A pizza'
            FinalPizza pizza = new FinalPizza()

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater6.haveAPoisonedPizzaMeal(5)

        then:
            1 * pizzaEater6.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater6.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater6.stomachService.eatPizza(pizza)

        then:
            1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
            someGratitude == gratitude

        and:
            0 * _
    }

    def 'Victim pizza eater eats a pizza and expresses gratitude, focus is on gratitude object'() {

        given: 'A gratitude'
            Gratitude gratitude = new Gratitude(huge: false)

        and: 'A pizza'
            FinalPizza pizza = new FinalPizza()

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater6.haveAPoisonedPizzaMeal(5)

        then:
            1 * pizzaEater6.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater6.gratitudeService.expressGratitude(_) >> gratitude

        and: 'I have a huge gratitude'
            someGratitude == gratitude
            someGratitude.isHuge()
    }
}
