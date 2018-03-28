package com.force.click.cfapbadmobbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.clickforce.ad.AdSize;
import com.clickforce.ad.AdView;
import com.clickforce.ad.Listener.AdViewListener;

public class MainActivity extends AppCompatActivity {

    private AdView ad ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ad = (AdView) this.findViewById(R.id.ad);
        ad.getAd(7292, AdSize.MA320X50,true);

        //Ad Load Callback
        ad.setOnAdViewLoaded(new AdViewListener() {
            @Override
            public void OnAdViewLoadSuccess() {
                Log.d("Ad Response Result", "成功請求廣告");

                ad.show(); //顯示banner廣告
            }

            @Override
            public void OnAdViewLoadFail() {
                Log.d("Ad Response Result", "請求廣告失敗");
            }

            @Override
            public void OnAdViewClickToAd() {
                Log.d("Ad Click", "點擊廣告");
            }
        });

    }
}
