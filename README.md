# Testing fully in Spock with 100% code coverage


_Disclaimer: This is not exclusively my knwoledge, but I record observations that were acquired slowly as Thanos Papapetrou, our team tech lead introduced this method_

In these short examples we try to point out the advantages of fully Java code testing in [Spock](http://spockframework.org/), with no compromises. We test fully instead of testing partially.

We observed that fully testing is an expensive task. However there is a gain that pays out the investment.

1. Tests without personal bias
2. Refactorings are safe
3. Post release modifications have higher probability to be caught
4. Classes are kept in reasonable length
5. When possible we test in full and not with sampled examples
6. Performance problems can be uncovered.
7. Advanced knowledge of Groovy is encouraged


The list of examples:

[Example1](src/test/groovy/pizza/loverz/example1)
[Example2](src/test/groovy/pizza/loverz/example2)
[Example3](src/test/groovy/pizza/loverz/example3)
[Example4](src/test/groovy/pizza/loverz/example4)
[Example5](src/test/groovy/pizza/loverz/example5)
[Example6](src/test/groovy/pizza/loverz/example6)
[Example7](src/test/groovy/pizza/loverz/example7)
