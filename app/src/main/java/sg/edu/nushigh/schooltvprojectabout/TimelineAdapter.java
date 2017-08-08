package sg.edu.nushigh.schooltvprojectabout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jeff Sieu on 6/8/2017.
 */


public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {
    private String[] titles, contents;

    public TimelineAdapter(Context context) {
        titles = context.getResources().getStringArray(R.array.timeline_titles);
        contents = context.getResources().getStringArray(R.array.timeline_contents);
    }

    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TimelineViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timeline, parent, false));
    }

    @Override
    public void onBindViewHolder(TimelineViewHolder holder, int position) {
        holder.mTitleView.setText(titles[position]);
        holder.mContentView.setText(contents[position]);
        holder.mStartConnectorView.setVisibility(View.VISIBLE);
        holder.mEndConnectorView.setVisibility(View.VISIBLE);
        if (position == 0)
            holder.mStartConnectorView.setVisibility(View.INVISIBLE);
        if (position == getItemCount() - 1)
            holder.mEndConnectorView.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return Math.min(titles.length, contents.length);
    }

    protected class TimelineViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTitleView;
        protected TextView mContentView;
        protected View mStartConnectorView;
        protected View mEndConnectorView;
        public TimelineViewHolder(View v) {
            super(v);
            mTitleView = v.findViewById(R.id.item_timeline_title);
            mContentView = v.findViewById(R.id.item_timeline_content);
            mStartConnectorView = v.findViewById(R.id.connector_start);
            mEndConnectorView = v.findViewById(R.id.connector_end);
        }
    }
}
