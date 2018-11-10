package jp.gcreate.databindingsamplejava;

import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

/**
 * Copyright 2018 G-CREATE
 */
public class MainViewModel extends ViewModel implements Observable {

    private PropertyChangeRegistry callbacks = new PropertyChangeRegistry();
    @Bindable
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        callbacks.notifyChange(this, BR.name);
        this.name = name;
    }

    @Bindable({"name"})
    public boolean isButtonEnabled() {
        return !name.isEmpty();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }
}
