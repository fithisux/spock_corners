# &#8704; testing

Purpose of this example is to showcase the difference of a full blown test for the functionality of the class with the simple input / output testing of the class. In the next examples we will delve in the importance of mocking everything.

In the first scenario we test all interactions and mock everything we can. We also leave no space for unnoticed interactions through

    and:
        0 * _

The second scenario is totally Spartan. We mock what is necessary to support the input/output functionality. We just pay an amount to consume a pizza and get huge gratitude.

Pay some close look in the third scenario, where one believes that the test is more complete because we have a pizza. Here we introduce a **bias**, we test for the **specific** pizza with empty taste. **Not every pizza** , even though we choose a **representative** sample. Instead the first secenario tests for **every** pizza. The *representative* scenario is a matter of taste and can be ambiguous. But in the first scenario, the ambiguity is resolved.
