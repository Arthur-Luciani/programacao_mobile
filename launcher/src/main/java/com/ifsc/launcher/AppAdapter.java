package com.ifsc.launcher;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {
    private List<AppInfo> appList;
    private Context mContext;

    public AppAdapter(Context context, List<AppInfo> appList) {
        this.mContext = context;
        this.appList = appList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppInfo app = appList.get(position);
        holder.appName.setText(app.getName());
        holder.appPackage.setText(app.getPackageName());
        holder.appIcon.setImageDrawable(app.getIcon());

        holder.itemLayout.setOnClickListener(v -> {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(app.getPackageName());

            if (launchIntent == null) {
                Toast.makeText(mContext, "Aplicativo não pode ser iniciado", Toast.LENGTH_SHORT).show();
                return;
            }

            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                mContext.startActivity(launchIntent);
            } catch (Exception e) {
                Toast.makeText(mContext, "Erro ao iniciar o aplicativo", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView appIcon;
        TextView appName, appPackage;
        LinearLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            appIcon = itemView.findViewById(R.id.appIcon);
            appName = itemView.findViewById(R.id.appName);
            appPackage = itemView.findViewById(R.id.appPackage);
            itemLayout = itemView.findViewById(R.id.itemLayout);
        }
    }
}
