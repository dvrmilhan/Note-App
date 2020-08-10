package com.example.basicactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BasicActivityAdapter extends RecyclerView.Adapter<BasicActivityAdapter.ViewHolder> {

   private static final String TAG = "BasicActivityAdapter";
    //int count = 0;
    List<String> moviesList;

    public BasicActivityAdapter(List<String> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Log.i(TAG, "onCreateViewHolder: "+ count++);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        //don't forget why we use reclerview, even the number of rows are 200 we have msg: "onCreateViewHolder: " just 13
        return moviesList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)  {
        holder.textView2.setText(String.valueOf(position));
        holder.textView1.setText(moviesList.get(position));

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textView1, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(itemView.getContext(), moviesList.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}
