package com.ifsc.launcher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AppAdapter adapter;
    private List<AppInfo> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        appList = getInstalledApps();
        adapter = new AppAdapter(this, appList);
        recyclerView.setAdapter(adapter);
    }

    private List<AppInfo> getInstalledApps() {
        PackageManager pm = getPackageManager();

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        return pm.queryIntentActivities(mainIntent, PackageManager.MATCH_ALL).stream()
                .map(resolveInfo -> {
                    String packageName = resolveInfo.activityInfo.packageName;
                    String name = (String) resolveInfo.loadLabel(pm);
                    Drawable icon = resolveInfo.loadIcon(pm);
                    return new AppInfo(name, packageName, icon);
                }).collect(Collectors.toList());
    }
}