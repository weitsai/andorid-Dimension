
package com.example.pxtosp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText mIntpu;
    private TextView mRequest;

    private <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntpu = getView(R.id.input);
        mRequest = getView(R.id.request);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void submit(View v) {
        Resources r = this.getResources(); // 取得手機資源
        int px = Integer.parseInt(mIntpu.getText().toString());
        float sp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                px,
                r.getDisplayMetrics());
        mRequest.setTextSize(sp);
        mRequest.setText("Requset:" + sp);
    }

}
