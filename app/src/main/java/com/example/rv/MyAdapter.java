package com.example.rv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MYViewHolder> {
    String data1[],data2[];
    int images[];
    Context context;
    public MyAdapter(Context ct, String s1[],String s2[],int img[]){
        data1=s1;
        data2=s2;
        context=ct;
        images=img;

    }
    public class MYViewHolder extends RecyclerView.ViewHolder {
        TextView myText1,myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;
        public MYViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1=itemView.findViewById(R.id.myText1);
            myText2=itemView.findViewById(R.id.myText2);
            myImage=itemView.findViewById(R.id.myImageView);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
    @NonNull
    @Override
    public MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
       View view= inflater.inflate(R.layout.my_row,parent,false);

        return new  MYViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MYViewHolder holder,final int position) {

      holder.myText1.setText(data1[position]);
      holder.myText2.setText(data2[position]);
      holder.myImage.setImageResource(images[position]);
      holder.mainLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent= new Intent(context,SeconedActivity.class);
              intent.putExtra("data1",data1[position]);
              intent.putExtra("data2",data2[position]);
              intent.putExtra("myImages",images[position]);
              context.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


}
