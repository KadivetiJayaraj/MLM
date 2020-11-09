package com.example.mlmsoftware.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mlmsoftware.R;
import com.example.mlmsoftware.model.WalletClass;

import java.util.List;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.ViewHolder> {

    private Context context;
    private List<WalletClass> personUtils;

    public WalletAdapter(Context context, List personUtils) {
        this.context = context;
        this.personUtils = personUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallet_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(personUtils.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Context context = v.getContext();
                Intent intent = new Intent(context, DetailsActivity.class);
                context.startActivity(intent);*/
            }
        });





        WalletClass pu = personUtils.get(position);

        holder.date.setText(pu.getDate());
        holder.particular.setText(pu.getParticular());
        String Credited = String.valueOf(pu.getCredited());
        holder.credited.setText(Credited);
        String Debited = String.valueOf(pu.getDebited());
        holder.debited.setText(Debited);


    }

    @Override
    public int getItemCount() {
        return personUtils.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView date,particular,credited,debited;

        public ViewHolder(View itemView) {
            super(itemView);

            date = (TextView) itemView.findViewById(R.id.date);
            particular = (TextView) itemView.findViewById(R.id.particular);
            credited = (TextView) itemView.findViewById(R.id.credited);
            debited = (TextView) itemView.findViewById(R.id.debited);

        }
    }

}


