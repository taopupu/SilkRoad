package com.dawei.silkroad.dev;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ArtistDataActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout lin_artist1, lin_artist2, lin_artist3;
    private Button btn_next1, btn_next2, btn_submit;
    private ImageView img_back;
    private Spinner sp_place;
    private EditText et_date, et_name, another_name, et_place, detail_place, et_phone, valide;
    WHawkTimerBtn sendValide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        initView();
        spinner(sp_place);
    }

    private void initView() {
        lin_artist1 = get(R.id.artist_1);
        lin_artist2 = get(R.id.artist_2);
        lin_artist3 = get(R.id.artist_3);
        btn_next1 = get(R.id.next_1);
        btn_next2 = get(R.id.next_2);
        btn_submit = get(R.id.btn_submit);
        img_back = get(R.id.title_back);
        sp_place = get(R.id.sp_native_place);
        et_name = get(R.id.et_name);
        et_date = get(R.id.et_date);
        et_place = get(R.id.et_place);
        detail_place = get(R.id.detail_place);
        another_name = get(R.id.another_name);
        valide = get(R.id.valide);
        sendValide = get(R.id.sendValide);
        et_phone = get(R.id.et_phone);
        img_back.setOnClickListener(this);
        sendValide.setOnClickListener(this);
        btn_next1.setOnClickListener(this);
        btn_next2.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
        et_date.setOnClickListener(this);
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.artist));
        et_date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == true) {
                    timeFlag = 0;
                    hideIM(view);
                    showDialog(0);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (lin_artist1.getVisibility() == View.VISIBLE) {
            super.onBackPressed();
        } else if (lin_artist2.getVisibility() == View.VISIBLE) {
            lin_artist1.setVisibility(View.VISIBLE);
            lin_artist2.setVisibility(View.GONE);
        } else if (lin_artist3.getVisibility() == View.VISIBLE) {
            lin_artist3.setVisibility(View.GONE);
            lin_artist2.setVisibility(View.VISIBLE);
        }

    }


    private void spinner(Spinner sp) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            list.add(getResources().getStringArray(R.array.sp_native_place)[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayAdapter<String> adapter = (ArrayAdapter<String>) parent.getAdapter();
                String str = adapter.getItem(position);

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_1:
                lin_artist2.setVisibility(View.VISIBLE);
                lin_artist1.setVisibility(View.GONE);
                lin_artist3.setVisibility(View.GONE);
                break;
            case R.id.next_2:
                lin_artist2.setVisibility(View.GONE);
                lin_artist1.setVisibility(View.GONE);
                lin_artist3.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_submit:
                break;
            case R.id.title_back:
                onBackPressed();
                break;
            case R.id.et_date:
                timeFlag = 0;
                showDialog(0);
                break;
            case R.id.sendValide:
                sendValide.startDown();
                break;
        }
    }

    int mYear, mMonth, mDay;
    int timeFlag;
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            String mm;
            String dd;
            if (monthOfYear <= 9) {
                mMonth = monthOfYear + 1;
                mm = "0" + mMonth;
            } else {
                mMonth = monthOfYear + 1;
                mm = String.valueOf(mMonth);
            }
            if (dayOfMonth <= 9) {
                mDay = dayOfMonth;
                dd = "0" + mDay;
            } else {
                mDay = dayOfMonth;
                dd = String.valueOf(mDay);
            }
            mDay = dayOfMonth;
            if (timeFlag == 0) {
                et_date.setText(String.valueOf(mYear) + "-" + mm + "-"
                        + dd);
            } else {
                et_date.setText(String.valueOf(mYear) + "-" + mm + "-" + dd);
            }
        }
    };

    protected Dialog onCreateDialog(int id) {
        Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);
        mYear = dateAndTime.get(Calendar.YEAR);
        mMonth = dateAndTime.get(Calendar.MONTH);
        mDay = dateAndTime.get(Calendar.DAY_OF_MONTH);
        switch (id) {
            case 0:
                return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
                        mDay);
            case 1:
                return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
                        mDay);
        }
        return null;

    }

    // 隐藏手机键盘
    private void hideIM(View edt) {
        try {
            InputMethodManager im = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            IBinder windowToken = edt.getWindowToken();
            if (windowToken != null) {
                im.hideSoftInputFromWindow(windowToken, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
