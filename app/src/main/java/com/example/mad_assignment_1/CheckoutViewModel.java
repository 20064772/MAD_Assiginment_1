package com.example.mad_assignment_1;

import androidx.lifecycle.ViewModel;

/**
 * This class allows the basket to be shared between the LoginFragment and the Registerfragment
 */

public class CheckoutViewModel extends ViewModel {

    private Basket basket;
    public CheckoutViewModel(){}

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Basket getBasket() {
        return basket;
    }
}
