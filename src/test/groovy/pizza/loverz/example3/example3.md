# Satisfy coverage threshold

Here a treacherous pizza service that sends messages to alien invaders is introduced. The introduction happens after finalizing the tests. The input/output test (scenario 3) continues passing. Even the **full** first scenario passes. We are in very big trouble because our build is green and can go into production. The opportunity here is the fact that we have introduced an *if*.

The only way to catch this kind of error is to target 100% coverage and not to satisfy the threshold. 

Sometimes files are too big and the threshold is an attractive shelter.

Please, don't do it ^^^^ &#128521; !

