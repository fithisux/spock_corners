package pizza.loverz.example3

import pizza.loverz.domain.Gratitude
import pizza.loverz.domain.Pizza
import pizza.loverz.example3.PizzaEater3
import pizza.loverz.services.GratitudeService
import pizza.loverz.services.PizzaService
import pizza.loverz.services.StomachService
import pizza.loverz.services.TreacherousPizzaService
import spock.lang.Specification

class PizzaEater3Spec extends Specification {

    PizzaEater3 pizzaEater3;

    def setup() {
        pizzaEater3 = new PizzaEater3(gratitudeService: Mock(GratitudeService), stomachService: Mock(StomachService), pizzaService: Mock(PizzaService))
    }

    def 'Pizza eater eats a pizza so\'n\'so tested'() {
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater3.haveAPizzaMeal(5)

        then:
            1 * pizzaEater3.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater3.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater3.stomachService.eatPizza(pizza)

        then:
            1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
            someGratitude == gratitude

        and:
            0 * _
    }

    def 'Pizza eater eats a pizza fully tested'() {
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        and: 'A treacherous pizza service'
            TreacherousPizzaService treacherousPizzaService = Mock(TreacherousPizzaService)
            pizzaEater3.pizzaService = treacherousPizzaService

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater3.haveAPizzaMeal(5)

        then:
            1 * pizzaEater3.pizzaService.buyPizza(5) >> pizza

        then:
           1 * treacherousPizzaService.sendSecretMessageToAlienInvaders()

        then:
            1 * pizzaEater3.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater3.stomachService.eatPizza(pizza)

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
            Gratitude someGratitude = pizzaEater3.haveAPizzaMeal(5)

        then:
            1 * pizzaEater3.gratitudeService.expressGratitude(_) >> gratitude

        and: 'I have a huge gratitude'
            someGratitude == gratitude
            someGratitude.isHuge()
    }
}
