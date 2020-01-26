package alya.ikb.myviewholder;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private static final String API_KEY = "ISI SESUAI API_KEY ANDA";
    private MutableLiveData<ArrayList<WeatherItems>> listWeathers = new MutableLiveData<>();
}
