package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codencolors.statustan.R;

import java.util.List;

import model.Source;

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.MyViewHolder> {

    private List<Source> list;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView description, name, publishedAt;
        public
        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            description = (TextView) view.findViewById( R.id.description);
            imageView= (ImageView) view.findViewById( R.id.imageview);
            name = (TextView) view.findViewById( R.id.name);

        }
    }
    public SourceAdapter(List<Source> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Source source = list.get(position);
        //holder.title.setText(source.getTitle());
        holder.name.setText ( source.getName () );
        holder.description.setText(source.getDescription ());
        Glide.with ( context ).load ( source.getUrlToImage () );


    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    @Override
    public long getItemId(int position) {
        return position;
    }
    public void updateChannelList(List<Source> channelList){
        this.list.addAll(channelList);
        notifyDataSetChanged();
    }
}
