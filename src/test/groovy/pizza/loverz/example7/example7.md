# Groovy excellence.

Here we have one of that situations where a proper refactoring can make the code testable. We start with ... surprise surpise ... a pizza eater, PizzaEater7. The pizza eater buys a pizza, schedules to eat it at a later time and expesse gratitude. Things are very simple.

We have the simple pizza eating function

    public Gratitude haveAPizzaMealLazily(int amount)
    
 and the corresponding full test
 
    def 'Deferred pizza eating is partially tested'()
    
Everything is shiny in TestLand. 


*Really?*

Take a look in the defered execution

    def task = dolaterService.doLater {
            stomachService.eatPizza(pizza);
    }

what happens in __doLater__  is invisible. Someone can hide everything there and the test can work ok. You can either explode an atomic bomb there. No one will ever notice.

The code is not fully tests, but testing thoroughly calls for some advanced and useful Groovy knowledge. 

1. The content of the clojure becaomes a full blown method
2. The method can be tested
3. The __doLater__ calls a curried version of the method
4. Now we know what __doLater__ calls

These two scenarios reveal all the truth (And some advanced Groovy knowledge)

    def 'Deferred pizza eating is fully tested'
    def 'Pizza eater eats a pizza fully tested'
