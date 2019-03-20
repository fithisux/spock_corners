# Have Safe ... Refactors

In this example what happens is very typical. A call is refactored to call a helper function that packs some calls to make the original method shorter.
Moreover we have a reusable piece of code that makes sense and make uncle Bob proud of you. *With a catch* :

    Thou shalt not forgot to use the refactored method!

It happens to everyone, it is very common. Unfortunately it is also very common to not test properly. Scenarios 2,3,4 pass because it is the same test that tests partially 

1. the old behavior
2. the intended behavior
3. and guess what ... the unintended behavior

The unintended behavior is a consequence of the transformation. However, by doing the refactor against the scenario 1 that tests fully, we can catch easily the problem. As a matter of fact the morale is


    Thou shalt refactor against full tests and (normally) be invariant against them!
    
Full testing saved the day again!
