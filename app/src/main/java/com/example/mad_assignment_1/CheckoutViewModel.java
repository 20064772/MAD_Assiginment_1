/**
 * CheckoutViewModel. This View model holds the basket so it may be shared between the register franment and the login fragment.
 *
 * @class           CheckOutViewModel
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

package com.example.mad_assignment_1;

import androidx.lifecycle.ViewModel;

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
