package com.dawei.silkroad.dev.cooperative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class CooperationOpportunityActivity extends BaseActivity {
    private RecyclerView rv_opportunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooperation_opportunity);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        tv_title.setText(getResources().getText(R.string.cooperation_opportunities));
        onBack(get(R.id.title_back));
        rv_opportunity = get(R.id.rv_opportunity);
        rv_opportunity.setLayoutManager(new LinearLayoutManager(this));
        rv_opportunity.setAdapter(new OpportunityAdapter());
    }

    public class OpportunityAdapter extends RecyclerView.Adapter<OpportunityAdapter.MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_opportunity, parent, false));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 4;
        }

        public class MyHolder extends RecyclerView.ViewHolder {
            public MyHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
