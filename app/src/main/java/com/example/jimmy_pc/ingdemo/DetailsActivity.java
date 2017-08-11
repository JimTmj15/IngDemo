package com.example.jimmy_pc.ingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {

    /**
     * Declare variables
     */
    String name,email,balance,image;

    @BindView(R.id.imgView)
    ImageView imageView;

    @BindView(R.id.nameLabelTV)
    TextView nameLabel;

    @BindView(R.id.emailLabelTV)
    TextView emailLabel;

    @BindView(R.id.balanceLabelTV)
    TextView balanceLabel;

    @BindView(R.id.dummyET)
    EditText dumEditText;

    @OnClick(R.id.footerBtn)
    void showEditText(){
        if(dumEditText.getVisibility() == View.GONE){
            dumEditText.setVisibility(View.VISIBLE);
        }else if(dumEditText.getVisibility() == View.VISIBLE){
            dumEditText.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(DetailsActivity.this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //enable back button

        /**
         * Get intent data passed from previous activity
         */
        Intent intent = getIntent();
        if(intent != null){
            name = intent.getStringExtra("name");
            email = intent.getStringExtra("email");
            balance = intent.getStringExtra("balance");
            image = intent.getStringExtra("image");
            Glide.with(DetailsActivity.this).load(image).into(imageView);
            nameLabel.setText(name);
            emailLabel.setText(email);
            balanceLabel.setText(balance);
            getSupportActionBar().setTitle(name);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); //back to previous activity
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
