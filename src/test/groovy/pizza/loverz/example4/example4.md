# Non-commutative jeopardy.

In this case we introduce a packaging service that packages pizzas. 

    public interface PackageService {
        public void packagePizza(Pizza pizza);
    }
    
 In nature you cannot package a pizza after you have eaten it. In other worlds maybe. In this world, no! Consequently
 
 
     packageService.packagePizza(pizza);
     stomachService.eatPizza(pizza);
         
is legal and possible. But this sequence of calls, defy the laws of the Universe

    stomachService.eatPizza(pizza);
    packageService.packagePizza(pizza);
    

The second scenario is this example passes because it eradicates the commutativity question simply through an 

    and:
    
  We need after the
  
    when: 

the big sequence of thens

    then:

to impose commutatitivity restrictions. By checking the wording of the steps, we can understand our logical fallacy.
 
Being cautious and not throw-away the non-commutativity can work miracles. Having proper step descriptions telling a human comprehensible story is vital too.


We can replace the logical fallacy

    then: 'I eat the pizza'
        1 * pizzaEater4.stomachService.eatPizza(pizza)

    then: 'I package the pizza'
        1 * pizzaEater4.packageService.packagePizza(pizza)


with

       

    then: 'I package the pizza'
        1 * pizzaEater4.packageService.packagePizza(pizza)
        
    then: 'I eat the pizza'
        1 * pizzaEater4.stomachService.eatPizza(pizza)
                
Now , the test fails and we can save the sanity of the universe &#128521; !
