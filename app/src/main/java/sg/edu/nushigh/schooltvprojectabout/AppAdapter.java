package sg.edu.nushigh.schooltvprojectabout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff Sieu on 6/8/2017.
 */


public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {
    private List<App> apps;
    private Context context;

    public AppAdapter(Context context, List<App> apps) {
        this.apps = apps;
        this.context = context;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AppViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false));
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        App app = apps.get(position);
        holder.mTitleView.setText(app.getName());
        holder.mContentView.setAdapter(new DeveloperAdapter(context, app.getDevelopers()));
        holder.mContentView.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    protected class AppViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTitleView;
        protected RecyclerView mContentView;
        public AppViewHolder(View v) {
            super(v);
            mTitleView = v.findViewById(R.id.item_app_title);
            mContentView = v.findViewById(R.id.item_app_content);
        }
    }
}
