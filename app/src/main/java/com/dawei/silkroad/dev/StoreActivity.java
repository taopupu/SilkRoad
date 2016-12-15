package com.dawei.silkroad.dev;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class StoreActivity extends BaseActivity implements View.OnClickListener {
    private EditText et_date, et_store_name, detaile_place, linkman, contact_number, et_abstract;
    private Spinner sp_native_place;
    private Button btn_next, btn_commit;
    private int mYear, mMonth, mDay, timeFlag;
    private LinearLayout lin_store1, lin_store2;
    private ImageView title_back, img_permit;
    private TextView tv_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        initView();
        spinner(sp_native_place);
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.store));
        et_date = get(R.id.et_date);
        sp_native_place = get(R.id.sp_native_place);
        title_back = get(R.id.title_back);
        et_store_name = get(R.id.et_store_name);
        detaile_place = get(R.id.detaile_place);
        contact_number = get(R.id.contact_number);
        et_abstract = get(R.id.et_abstract);
        btn_commit = get(R.id.btn_commit);
        tv_upload = get(R.id.upload);
        lin_store1 = get(R.id.store_1);
        lin_store2 = get(R.id.store_2);
        btn_next = get(R.id.btn_next);
        linkman = get(R.id.linkman);
        img_permit = get(R.id.img_permit);
        btn_next.setOnClickListener(this);
        btn_commit.setOnClickListener(this);
        et_date.setOnClickListener(this);
        title_back.setOnClickListener(this);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                lin_store1.setVisibility(View.GONE);
                lin_store2.setVisibility(View.VISIBLE);
                break;
            case R.id.et_date:
                timeFlag = 0;
                showDialog(0);
                break;
            case R.id.title_back:
                onBackPressed();
                break;
            case R.id.btn_commit:
                break;

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

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
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

    @Override
    public void onBackPressed() {
        if (lin_store1.getVisibility() == View.VISIBLE) {
            super.onBackPressed();
        } else if (lin_store2.getVisibility() == View.VISIBLE) {
            lin_store1.setVisibility(View.VISIBLE);
            lin_store2.setVisibility(View.GONE);
        }

    }
}
