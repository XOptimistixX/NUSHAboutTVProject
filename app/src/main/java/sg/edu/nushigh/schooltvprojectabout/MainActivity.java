package sg.edu.nushigh.schooltvprojectabout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mTimelineRecyclerView = (RecyclerView) findViewById(R.id.timeline_view);
        mTimelineRecyclerView.setAdapter(new TimelineAdapter(this));
        mTimelineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView mDeveloperRecyclerView = (RecyclerView) findViewById(R.id.developer_recycler_view);
        mDeveloperRecyclerView.setAdapter(new DeveloperAdapter(this));
        mDeveloperRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

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

    public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.DeveloperViewHolder> {
        private String[] titles, contents;

        public DeveloperAdapter(Context context) {
            titles = context.getResources().getStringArray(R.array.developer_titles);
            contents = context.getResources().getStringArray(R.array.developer_contents);
        }

        @Override
        public DeveloperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new DeveloperViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_developer, parent, false));
        }

        @Override
        public void onBindViewHolder(DeveloperViewHolder holder, int position) {
            holder.mTitleView.setText(titles[position]);
            holder.mContentView.setText(contents[position]);
        }

        @Override
        public int getItemCount() {
            return Math.min(titles.length, contents.length);
        }

        protected class DeveloperViewHolder extends RecyclerView.ViewHolder {
            protected TextView mTitleView;
            protected TextView mContentView;
            public DeveloperViewHolder(View v) {
                super(v);
                mTitleView = v.findViewById(R.id.item_developer_title);
                mContentView = v.findViewById(R.id.item_developer_content);
            }
        }
    }
}
