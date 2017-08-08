package sg.edu.nushigh.schooltvprojectabout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jeff Sieu on 6/8/2017.
 */

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.DeveloperViewHolder> {
    private List<Person> developers;
    private Context context;

    public DeveloperAdapter(Context context, List<Person> developers) {
        this.developers = developers;
        this.context = context;
    }
    @Override
    public DeveloperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DeveloperViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_developer, parent, false));
    }

    @Override
    public void onBindViewHolder(DeveloperViewHolder holder, int position) {
        Person person = developers.get(position);
        holder.mTitleView.setText(person.getName());
        holder.mContentView.setText(person.getDescription());
        holder.mImageView.setImageDrawable(person.getPicture());
    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

    protected class DeveloperViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTitleView, mContentView;
        protected ImageView mImageView;
        public DeveloperViewHolder (View v) {
            super(v);
            mTitleView = v.findViewById(R.id.item_developer_title);
            mContentView = v.findViewById(R.id.item_developer_content);
            mImageView = v.findViewById(R.id.item_developer_image);
        }
    }
}
