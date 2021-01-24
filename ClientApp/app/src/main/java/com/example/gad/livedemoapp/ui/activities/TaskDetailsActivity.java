package com.example.gad.livedemoapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gad.livedemoapp.R;

public class TaskDetailsActivity extends BaseActivity
{
    private final static String IKEY_TITLE = "com.example.intent.keys.EXTRA_TITLE";

    private TextView mTaskTitle;

    public static Intent getStartingIntent(Context ctx, String task_title) {
        Intent intent = new Intent(ctx, TaskDetailsActivity.class);
        intent.putExtra(IKEY_TITLE, task_title);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        initViews();

        String task_title = getIntent().getStringExtra(IKEY_TITLE);
        mTaskTitle.setText(task_title);
    }

    private void initViews() {
        mTaskTitle = findViewById(R.id.actTaskDetails_taskTitle);
    }
}