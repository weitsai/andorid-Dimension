
package com.example.pxtosp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText mIntpu;
    private TextView mRequest;
    private Spinner mSpinner;
    private String[] mValueTypeStrinArray;
    private int mSpinnerSelected = 0;

    private int[] mValueType = {
            0, TypedValue.COMPLEX_UNIT_DIP, TypedValue.COMPLEX_UNIT_PX,
            TypedValue.COMPLEX_UNIT_SP
    };

    private <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntpu = getView(R.id.input);
        mRequest = getView(R.id.request);
        mSpinner = getView(R.id.spinner);
        mValueTypeStrinArray = getResources().getStringArray(R.array.type);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mValueTypeStrinArray);
        mSpinner.setAdapter(mAdapter);
        mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSpinnerSelected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void submit(View v) {
        if (0 == mSpinnerSelected) {
            Toast.makeText(this, "請先選擇單位", 0).show();
            return;
        }

        Resources r = this.getResources(); // 取得手機資源
        int input = Integer.parseInt(mIntpu.getText().toString());
        float request = TypedValue.applyDimension(mValueType[mSpinnerSelected],
                input,
                r.getDisplayMetrics());
        mRequest.setTextSize(request);
        mRequest.setText("Requset:" + request);
    }

}
