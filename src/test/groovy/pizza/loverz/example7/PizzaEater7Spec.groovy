package pizza.loverz.example7

import org.codehaus.groovy.runtime.CurriedClosure

import pizza.loverz.domain.Gratitude
import pizza.loverz.domain.Pizza
import pizza.loverz.services.DolaterService
import pizza.loverz.services.GratitudeService
import pizza.loverz.services.PizzaService
import pizza.loverz.services.StomachService
import spock.lang.Specification

class PizzaEater7Spec extends Specification {

    PizzaEater7 pizzaEater7;

    def setup() {
        pizzaEater7 = GroovySpy(PizzaEater7)
        pizzaEater7.gratitudeService = Mock(GratitudeService)
        pizzaEater7.stomachService = Mock(StomachService)
        pizzaEater7.pizzaService = Mock(PizzaService)
        pizzaEater7.dolaterService = Mock(DolaterService)
    }

    def 'Deferred pizza eating is partially tested'() {

        given: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        and: 'A pizza'
            Pizza pizza = Mock(Pizza)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater7.haveAPizzaMealLazily(5)

        then:
            1 * pizzaEater7.haveAPizzaMealLazily(5)

        then:
            1 * pizzaEater7.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater7.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater7.dolaterService.doLater (_)

        then:
            1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
            someGratitude == gratitude

        and: 'No other interctions happen'
            0 * _
    }


    def 'Deferred pizza eating is fully tested'(){
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater7.eatPizza(pizza)

        then:
            1 * pizzaEater7.stomachService.eatPizza(pizza)


    }

    def 'Pizza eater eats a pizza fully tested'() {
        given: 'A pizza'
            Pizza pizza = Mock(Pizza)

        and: 'A gratitude'
            Gratitude gratitude = Mock(Gratitude)

        when: 'I eat a pizza'
            Gratitude someGratitude = pizzaEater7.haveAPizzaMealLazilyWithCurry(5)

        then:
            1 * pizzaEater7.haveAPizzaMealLazilyWithCurry(5)

        then:
            1 * pizzaEater7.pizzaService.buyPizza(5) >> pizza

        then:
            1 * pizzaEater7.gratitudeService.expressGratitude(pizza) >> gratitude

        then:
            1 * pizzaEater7.dolaterService.doLater (_) >> {
                args ->
                    CurriedClosure curriedClosure = args[0]
                    assert curriedClosure.getUncurriedArguments() == [pizza]
                    assert curriedClosure.delegate == pizzaEater7
                    assert curriedClosure.owner.method == 'eatPizza'
            }

        then:
            1 * gratitude.setHuge(true)

        and: 'I have a huge gratitude'
            someGratitude == gratitude

        and: 'No other interctions happen'
            0 * _


    }
}
