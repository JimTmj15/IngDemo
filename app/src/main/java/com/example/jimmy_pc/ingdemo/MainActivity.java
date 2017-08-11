package com.example.jimmy_pc.ingdemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jimmy_pc.ingdemo.Adapter.MainRecyclerViewAdapter;
import com.example.jimmy_pc.ingdemo.Model.ApiDataImpl;
import com.example.jimmy_pc.ingdemo.Model.ApiPojo.ApiInfo;
import com.example.jimmy_pc.ingdemo.Model.RecyclerViewPojo.RecyclerViewItem;
import com.example.jimmy_pc.ingdemo.Utils.Helper.OnRequestListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnRequestListener{

    /***
     * Declare variables
     */
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    LinearLayoutManager linearLayoutManager;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;
    ArrayList<RecyclerViewItem> dataList = new ArrayList<>();
    ApiDataImpl apiDataImp;
    AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        initParam();

        if(savedInstanceState != null){
            dataList = savedInstanceState.getParcelableArrayList("dataKey");
            mainRecyclerViewAdapter = new MainRecyclerViewAdapter(MainActivity.this,dataList);
            recyclerView.setAdapter(mainRecyclerViewAdapter);
        }else{
            getData();
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("dataKey",dataList);
    }

    /***
     * This method is to initialize/instantiate instances & variables
     */
    private void initParam(){
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(MainActivity.this,dataList);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mainRecyclerViewAdapter);
        apiDataImp = new ApiDataImpl(MainActivity.this);
        alertDialog = new AlertDialog.Builder(MainActivity.this);
    }

    /***
     * Call API to retreive data from remote server
     */
    private void getData(){
        apiDataImp.getApiData(MainActivity.this);
    }

    @Override
    public void onSuccess(List<ApiInfo> apiInfo) {
        dataList.clear();
        for(int i = 0; i < apiInfo.size(); i++) {
            if(apiInfo.get(i).getIsActive().equals("true")){
                dataList.add(new RecyclerViewItem(apiInfo.get(i).getName(),
                        apiInfo.get(i).getPhone(),
                        apiInfo.get(i).getEmail(),
                        apiInfo.get(i).getBalance(),
                        apiInfo.get(i).getPicture()));
            }
        }
        mainRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String errorMsg) {
        showErrorMsg(errorMsg);
    }

    /**
     *
     * This method is to show error message obtained from the OnFailure callback method.
     *
     * @param errMsg
     */
    public void showErrorMsg(String errMsg){
        alertDialog.setMessage(errMsg)
                .setTitle(getResources().getString(R.string.alert_dialog_err_title))
                .setPositiveButton(getResources().getString(R.string.pos_btn),null)
                .create()
                .show();
    }
}
