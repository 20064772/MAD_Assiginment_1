package com.example.mad_assignment_1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class SharedViewModel extends ViewModel {
    //private MutableLiveData<String> name = new MutableLiveData();
    String name;
    List<Restaurant> restaurantList;

    public SharedViewModel(){}

    public SharedViewModel(List<Restaurant> res){
       // name = new MutableLiveData<String>();
       // name.setValue("");
        name = "";
        restaurantList = res;
    }

    public void setNameMutableLiveData(String name) {

        this.name = name;

    }

    public void setRestaurantList(List<Restaurant> resi){this.restaurantList = resi;}

    public String getViewModelName(){
        return name;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }
}
