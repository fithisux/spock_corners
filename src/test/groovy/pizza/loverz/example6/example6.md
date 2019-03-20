# The spy that ... poisoned me.

Here the scenario suite PizzaEater6Spec has the original tests of the method

    public Gratitude haveAPizzaMeal(int amount)

A peculiarity of the situation here is that we don't have a Pizza, but a FinalPizza, which is a sealed class and extends the Pizza. It cannot be extended. Mocks cannot be generated because it is a known limitation of Spock. Normally one, uses real objects to test.

A malicious develeoper adds a method that adds something to the pizza. The original suite works as expected, unfortunately. 
However a quick inspection through code coverage shows that methods of the class are used. So a Spy is most suitable and the test is rewritten as scenario 1 in PizzaEater6SpySpec to have a full test. We are safe. 

*Not so fast though!*. The test catches the interactions. Is it the only thing we need to catch? 


The malicious developer changes the useful stuff added to the pizza to cyanide. While the test is full in terms of interactions , the cyanide goes undetected. This is where the test should be more throrough. We test the call to see exactly what goes in  when a method is called.

    then:
        1 * pizzaEater6.stomachService.eatPizza(_ as Pizza) >> {
            Pizza somePizza ->
                assert somePizza.taste == 'hawaian'
        }


Now we have a much better test. We made sure that the object is not modified in transit. If a modification happens, we can detect it.
