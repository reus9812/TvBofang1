package com.scujcc.tv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ChannelViewHolder> {
    private List<Channel> channels;
    private ChannelClickAuidence auidence;
    private Context context;

    public ChannelListAdapter(List<Channel> channels, ChannelClickAuidence auidence) {
        this.auidence = auidence;
        this.channels = channels;
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.channel, parent,false);
        ChannelViewHolder holder = new ChannelViewHolder(row);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auidence.onClick(v, holder.getLayoutPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, int position) {
        holder.bind(context, channels.get(position));
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    public class ChannelViewHolder extends RecyclerView.ViewHolder {
        private TextView headline;
        private TextView quality;
        private ImageView logo;

        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            headline = itemView.findViewById(R.id.head);
            quality = itemView.findViewById(R.id.quality);
            logo = itemView.findViewById(R.id.imageView);
        }

        public void bind(Context context, Channel c) {
            headline.setText(c.getTitle());
            quality.setText(c.getQuality());
            Glide.with(context)
                    .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558071506574&di=eeab05b85e2963c8446ed34f14fb0e6b&imgtype=0&src=http%3A%2F%2Fs2.sinaimg.cn%2Fmw690%2F005LKisygy722sIQw2B41%26690")
                    .override(320,320)
                    .into(logo);
        }
    }
}
