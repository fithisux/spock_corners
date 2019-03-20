# Uncover performance problems

The purpose of this example is to showcase the optimization opportunities offered by full blown Spock testing as opposed to just stubbing interactions. Take a close look at

    then:
        1 * pizzaEater2.pizzaBankService.retrieve() >> pizza


This can incur a very pricey performance cost. Imagine that it happens two times as in the code (we shaved one variable and made our application twice slower). Here we can identify an opportunity of replacing

    Gratitude gratitude = gratitudeService.expressGratitude(pizzaBankService.retrieve());
    stomachService.eatPizza(pizzaBankService.retrieve());

with

    Pizza pizza = pizzaBankService.retrieve()
    Gratitude gratitude = gratitudeService.expressGratitude(pizza);
    stomachService.eatPizza(pizzaBankService.retrieve(pizza);

half the performance toll, eh?

We also see this unnecessary

    then:
        2 * gratitude.setHuge(true)

Being thankful once is enough &#128521; !

This not evident in the non-full blown scenario 2.
