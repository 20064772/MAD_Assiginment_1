package com.example.mad_assignment_1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Restaurant> restaurantMutableLiveData = new MutableLiveData<>();

    public void setRestaurantMutableLiveData(Restaurant restaurant) {
        restaurantMutableLiveData.setValue(restaurant);
    }

    public LiveData<Restaurant> getViewModelRes(){
        return restaurantMutableLiveData;
    }
}
