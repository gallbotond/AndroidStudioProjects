package com.example.viewmodelpreserve;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
        private MutableLiveData<Integer> counterLiveData = new MutableLiveData<>();
        private int counter = 0;

        public MutableLiveData<Integer> getCounter() {
            counterLiveData.setValue(counter);
            return counterLiveData;
        }

        public void incrementCounter() {
            counterLiveData.setValue(++counter);
        }
}
