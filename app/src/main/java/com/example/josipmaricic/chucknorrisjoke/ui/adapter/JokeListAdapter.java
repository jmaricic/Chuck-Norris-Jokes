package com.example.josipmaricic.chucknorrisjoke.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josipmaricic.chucknorrisjoke.R;
import com.example.josipmaricic.chucknorrisjoke.ui.holder.JokeListHolder;
import com.example.josipmaricic.chucknorrisjoke.ui.listener.OnListItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josip on 13.11.2016..
 */

public class JokeListAdapter extends RecyclerView.Adapter<JokeListHolder> {

    private List<String> mData = new ArrayList<>();
    private OnListItemClickListener mListener;

    public void setListener(OnListItemClickListener listener) {
        this.mListener = listener;
    }

    public void setData(List<String> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public JokeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View currentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_holder_jokes, parent, false);
        return new JokeListHolder(currentView, mListener);
    }

    @Override
    public void onBindViewHolder(JokeListHolder holder, int position) {
        String mJoke = getItem(position);
        holder.setJoke(mJoke);
    }

    private String getItem(int position) {
        return !mData.isEmpty() ? mData.get(position) : null;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
