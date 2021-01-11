package com.example.recycler_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter {

    DataTransferInterface dtInterface;

    public adapter(DataTransferInterface dtInterface) {
        this.dtInterface = dtInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent, false);
        return new SingleViewHolder(view, dtInterface);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    private class SingleViewHolder extends RecyclerView.ViewHolder {
        TextView add, sub, count;
        Button print_btn;

        public SingleViewHolder(View view, DataTransferInterface dtInterface) {
            super(view);
            add = view.findViewById(R.id.add);
            sub = view.findViewById(R.id.sub);
            count = view.findViewById(R.id.counter);
            print_btn = view.findViewById(R.id.print_btn);

            final int[] count_ = {0};

            add.setOnClickListener(v -> {
                count_[0]++;
                count.setText(String.valueOf(count_[0]));
            });

            sub.setOnClickListener(v -> {
                count_[0]--;
                count.setText(String.valueOf(count_[0]));
            });

            print_btn.setOnClickListener(v -> dtInterface.setValues(String.valueOf(count_[0])));
        }
    }
    public interface DataTransferInterface {
        public void setValues(String count);
    }
}