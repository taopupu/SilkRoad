package com.dawei.silkroad.dev.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawei.silkroad.R;
import com.dawei.silkroad.been.Message;

import java.util.List;

/**
 * Created by yuanbaojun on 2016/12/17.
 */

public class MessageAdapter extends RecyclerView.Adapter {

    List<Message> data ;
    Context context;

    public MessageAdapter(List<Message> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null ) context = parent.getContext();
        if (viewType == 1) return new Message1ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message_add_friends,parent,false));
        return new Message2ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message_audit,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }

    class Message1ViewHolder extends RecyclerView.ViewHolder{

        public Message1ViewHolder(View itemView) {
            super(itemView);
        }
    }
    class Message2ViewHolder extends RecyclerView.ViewHolder{

        public Message2ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
