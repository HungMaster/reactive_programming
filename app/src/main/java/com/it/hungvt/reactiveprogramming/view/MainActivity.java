package com.it.hungvt.reactiveprogramming.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.it.hungvt.reactiveprogramming.R;
import com.it.hungvt.reactiveprogramming.model.AndroidOS;
import com.it.hungvt.reactiveprogramming.service.ApiServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvAndroidVersion;
    private AndroidOSAdapter adapter;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {

        compositeDisposable = new CompositeDisposable();

        rcvAndroidVersion = findViewById(R.id.rcv_android_os);
        rcvAndroidVersion.setHasFixedSize(true);
        rcvAndroidVersion.setLayoutManager(new LinearLayoutManager(this));

        loadData();

    }

    private void loadData() {

        Disposable disposable = ApiServiceBuilder.getApiService().register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()) // network request hay các công việc liên quan đến database
                .subscribe(this::handleResponse,this::handleError,this::handleSuccess);

        compositeDisposable.add(disposable);

    }

    // onComplete()
    private void handleSuccess() {
        Toast.makeText(this, "Get data success", Toast.LENGTH_SHORT).show();
    }

    // onError()
    private void handleError(Throwable throwable) {
        Toast.makeText(this, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    // nhận dữ liệu từ hàm onNext() của subscribe và hiển thị dữ liệu lên RecyclerView.
    private void handleResponse(List<AndroidOS> androidOS) {
        androidOS = new ArrayList<>(androidOS);
        adapter = new AndroidOSAdapter(androidOS);
        rcvAndroidVersion.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
