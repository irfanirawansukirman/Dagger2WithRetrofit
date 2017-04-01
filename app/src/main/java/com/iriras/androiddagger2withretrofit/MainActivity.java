package com.iriras.androiddagger2withretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.iriras.androiddagger2withretrofit.api.dao.Province;
import com.iriras.androiddagger2withretrofit.api.service.Service;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @Inject
    Retrofit mRetrofit;

    private TextView mTxtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtInfo = (TextView) findViewById(R.id.txt_info);

        /**
         * Component inject
         */
        ((MyApp) getApplication()).getNetComponent().inject(this);

        /**
         * call rest api
         */
        Observable<Province> mCall = mRetrofit.create(Service.class).getPosts();
        mCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Province>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error ", e.getMessage());
                    }

                    @Override
                    public void onNext(Province province) {
                        mTxtInfo.setText(province.getData().get(5).getPropinsi());
                    }
                });
    }
}
