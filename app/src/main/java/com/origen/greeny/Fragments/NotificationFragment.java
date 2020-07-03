package com.origen.greeny.Fragments;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TimePicker;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.origen.greeny.Adapter.NotifAdapter;
import com.origen.greeny.Model.NotifModel;
import com.origen.greeny.R;
import com.origen.greeny.Utils.ReminderBroadcast;
import com.origen.greeny.Utils.TimePickerFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private List<NotifModel> list = new ArrayList<>();

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3, floatingActionButton4,
            floatingActionButton5,floatingActionButton6;


    public NotificationFragment(String id) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createNotificationChanel();
        progressBar = view.findViewById(R.id.notif_progres);
        recyclerView = view.findViewById(R.id.notif_recycler);
        materialDesignFAM = (FloatingActionMenu) view.findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) view.findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) view.findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) view.findViewById(R.id.material_design_floating_action_menu_item3);
        floatingActionButton4 = (FloatingActionButton) view.findViewById(R.id.material_design_floating_action_menu_item4);
        floatingActionButton5 = (FloatingActionButton) view.findViewById(R.id.material_design_floating_action_menu_item5);
        floatingActionButton6 = (FloatingActionButton) view.findViewById(R.id.material_design_floating_action_menu_item6);

        NotifModel notifModel = new NotifModel("Sula","Hər gün 14.30da",true);
        NotifModel notifModel2 = new NotifModel("Gübrələ","Hər gün 19.40da",false);
        NotifModel notifModel3 = new NotifModel("Dərmanla","Hər gün 12.30da",true);
        NotifModel notifModel4 = new NotifModel("Buda","Hər gün 16.34da",true);
        NotifModel notifModel5 = new NotifModel("Sula","Hər gün 20.35da",false);
        list.add(notifModel);
        list.add(notifModel2);
        list.add(notifModel3);
        list.add(notifModel4);
        list.add(notifModel5);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final NotifAdapter adapter = new NotifAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.INVISIBLE);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        NotifModel notif = new NotifModel("Sula","Hər gün " + hourOfDay +"." +minute,true);
                        list.add(notif);
                        adapter.notifyDataSetChanged();
                        Intent intent = new Intent(getActivity(), ReminderBroadcast.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(),0,intent,0);

                        AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);

                        long timeAtButtonClick = System.currentTimeMillis();
                        long tenSecond = 1000 * 10;

                        Calendar myAlarmDate = Calendar.getInstance();
                        myAlarmDate.setTimeInMillis(System.currentTimeMillis());
                        myAlarmDate.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, hourOfDay, minute, 0);

                        alarmManager.set(AlarmManager.RTC_WAKEUP,myAlarmDate.getTimeInMillis(),pendingIntent);
                    }
                },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true);
                timePickerDialog.show();

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        NotifModel notif = new NotifModel("Gübrələ","Hər gün " + hourOfDay +"." +minute,true);
                        list.add(notif);
                        adapter.notifyDataSetChanged();
                    }
                },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true);
                timePickerDialog.show();
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        NotifModel notif = new NotifModel("Yerini dəyiş","Hər gün " + hourOfDay +"." +minute,true);
                        list.add(notif);
                        adapter.notifyDataSetChanged();
                    }
                },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true);
                timePickerDialog.show();
            }
        });
        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        NotifModel notif = new NotifModel("Toxum ək","Hər gün " + hourOfDay +"." +minute,true);
                        list.add(notif);
                        adapter.notifyDataSetChanged();
                    }
                },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true);
                timePickerDialog.show();
            }
        });

        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        NotifModel notif = new NotifModel("Dərmanla","Hər gün " + hourOfDay +"." +minute,true);
                        list.add(notif);
                        adapter.notifyDataSetChanged();
                    }
                },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true);
                timePickerDialog.show();
            }
        });

        floatingActionButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        NotifModel notif = new NotifModel("Budamaq","Hər gün " + hourOfDay +"." +minute,true);
                        list.add(notif);
                        adapter.notifyDataSetChanged();
                    }
                },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true);
                timePickerDialog.show();
            }
        });
    }

    private void createNotificationChanel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "taskschanel";
            String description = "Chanel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("tasks",name,importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = getContext().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }


}
