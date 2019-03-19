# The spy that ... poisoned me.

Here the scenario suite PizzaEater6Spec has the original tests of the method

    public Gratitude haveAPizzaMeal(int amount)

A peculiarity of the situation here is that we don't have a Pizza, but a FinalPizza, which is a sealed class and extends the Pizza. It cannot be extended. Mocks cannot be generated because it is a known limitation of Spock. Normally one, uses real objects to test.

A malicious dev adds a method that adds something useful to the pizza. The original suite works as expected, unfortunately. 
However a quick inspection through code coverage shows that methods of the class are used. So a Spy is most suitable and the test is rewritten as scenario 1 in PizzaEater6SpySpec to have a full test. *Not so fast though!* 

The test catches the interactions .. 


The malicious developer changes the useful stuff of pizza to cyanide. The test is full and the cyanide goes undetected. This is where the test should be proper. We test the cal to see exactly what goes in method calls

    then:
            1 * pizzaEater6.stomachService.eatPizza(_ as Pizza) >> {
                Pizza somePizza ->
                    assert somePizza.taste == 'hawaian'
            }


Now we are much better tested.
