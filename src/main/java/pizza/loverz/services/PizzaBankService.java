package pizza.loverz.services;

import pizza.loverz.domain.Pizza;

public interface PizzaBankService {
    void store(Pizza pizza);
    Pizza retrieve();
}
