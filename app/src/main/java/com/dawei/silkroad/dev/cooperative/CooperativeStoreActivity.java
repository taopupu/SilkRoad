package com.dawei.silkroad.dev.cooperative;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;

public class CooperativeStoreActivity extends BaseActivity {
    private RecyclerView rv_catalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooperative_store);
        initView();
        init();
    }

    private void initView() {
        TextView textView = get(R.id.tv_title);
        textView.setText(getResources().getText(R.string.cooperative_store_directory));
        rv_catalog = get(R.id.cooperative_store);
        rv_catalog.setLayoutManager(new LinearLayoutManager(this));
    }

    private void init() {
        CooperativeStoreAdapter adapter = new CooperativeStoreAdapter();
        rv_catalog.setAdapter(adapter);
    }

    public class CooperativeStoreAdapter extends RecyclerView.Adapter<CooperativeStoreAdapter.MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catalog, parent, false));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        public class MyHolder extends RecyclerView.ViewHolder {
            ImageView img_head;
            TextView tv_name, tv_type, tv_place, tv_way;

            public MyHolder(View itemView) {
                super(itemView);
                img_head = (ImageView) itemView.findViewById(R.id.img_head);
                tv_name = (TextView) itemView.findViewById(R.id.tv_name);
                tv_type = (TextView) itemView.findViewById(R.id.tv_type);
                tv_place = (TextView) itemView.findViewById(R.id.tv_place);
                tv_way = (TextView) itemView.findViewById(R.id.tv_way);
            }
        }
    }
}
