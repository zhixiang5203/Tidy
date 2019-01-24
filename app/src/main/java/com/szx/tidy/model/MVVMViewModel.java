package com.szx.tidy.model;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.szx.tidy.bean.UserData;

public class MVVMViewModel extends AndroidViewModel {
    //生命周期观察的数据
    private LiveData<UserData> mLiveObservableData;

    public MVVMViewModel(@NonNull Application application) {
        super(application);
        mLiveObservableData = new MutableLiveData<>();
        UserData data = new UserData();
        data.setError(UserData.SUCCESS);
        data.setResults("name:szx age:32 address:shanghai");
        ((MutableLiveData<UserData>) mLiveObservableData).postValue(data);
    }


    /**
     * LiveData支持了lifecycle生命周期检测
     *
     * @return
     */
    public LiveData<UserData> getLiveObservableData() {
        return mLiveObservableData;
    }


    public void setData() {
        if (mLiveObservableData != null) {
            UserData data = new UserData();
            data.setError(UserData.SUCCESS);
            data.setResults("name:allen age:12 address:beijing");
            ((MutableLiveData<UserData>) mLiveObservableData).postValue(data);
        }
    }

    public void setData2() {
        if (mLiveObservableData != null) {
            UserData data = new UserData();
            data.setError(UserData.SUCCESS);
            data.setResults("name:janey age:23 address:nanjing");
            ((MutableLiveData<UserData>) mLiveObservableData).postValue(data);
        }
    }
}
