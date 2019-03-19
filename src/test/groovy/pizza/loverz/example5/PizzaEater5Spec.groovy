package pizza.loverz.example5

import pizza.loverz.domain.Gratitude
import pizza.loverz.domain.Pizza
import pizza.loverz.example5.PizzaEater5
import pizza.loverz.services.FinalPizzaService
import pizza.loverz.services.GratitudeService
import pizza.loverz.services.PackageService
import pizza.loverz.services.PizzaService
import pizza.loverz.services.StomachService
import spock.lang.Specification

class PizzaEater5Spec extends Specification {

    PizzaEater5 pizzaEater5;

    def setup() {
        pizzaEater5 = new PizzaEater5(gratitudeService: Mock(GratitudeService), stomachService: Mock(StomachService), pizzaService: Mock(PizzaService), packageService: Mock(PackageService))
    }

    def 'Pizza eater eats a pizza fully tested'() {
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater5.haveAPizzaMeal(5)

        then:
            1 * pizzaEater5.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater5.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater5.stomachService.eatPizza(pizza)

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
            Pizza pizza = Mock(Pizza)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater5.haveAPizzaMeal(5)

        then:
            1 * pizzaEater5.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater5.gratitudeService.expressGratitude(_) >> gratitude

        and: 'I have a huge gratitude'
            someGratitude == gratitude
            someGratitude.isHuge()
    }

    def 'Pizza eater eats a pizza and expresses gratitude the old way, focus is on gratitude object'() {

        given: 'A gratitude'
            Gratitude gratitude = new Gratitude(huge: false)

        and: 'A pizza'
            Pizza pizza = Mock(Pizza)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater5.haveAPizzaMealOld(5)

        then:
            1 * pizzaEater5.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater5.gratitudeService.expressGratitude(_) >> gratitude

        and: 'I have a huge gratitude'
            someGratitude == gratitude
            someGratitude.isHuge()
    }

    def 'Pizza eater eats a pizza and expresses gratitude as intended, focus is on gratitude object'() {

        given: 'A gratitude'
            Gratitude gratitude = new Gratitude(huge: false)

        and: 'A pizza'
            Pizza pizza = Mock(Pizza)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater5.haveAPizzaMealIntended(5)

        then:
            1 * pizzaEater5.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater5.gratitudeService.expressGratitude(_) >> gratitude

        and: 'I have a huge gratitude'
            someGratitude == gratitude
            someGratitude.isHuge()
    }
}
