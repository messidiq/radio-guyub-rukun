package com.guyubrukun.radio.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guyubrukun.radio.R;
import com.guyubrukun.radio.listeners.ListItemClickListener;
import com.guyubrukun.radio.model.Program;
import com.guyubrukun.radio.model.ProgramTime;
import com.guyubrukun.radio.utils.ActivityUtils;
import com.guyubrukun.radio.utils.AppUtility;

import java.util.ArrayList;


public class ProgramListAdapter extends RecyclerView.Adapter<ProgramListAdapter.MyViewHolder> {

    private ArrayList<Program> programArrayList;
    private Context mContext;
    private ListItemClickListener listItemClickListener;

    public ProgramListAdapter(Context mContext, ArrayList<Program> dataArrayList) {
        this.programArrayList = dataArrayList;
        this.mContext = mContext;

    }

    public void setItemClickListener(ListItemClickListener listItemClickListener){
        this.listItemClickListener = listItemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout ll_list_row;
        public TextView tvProgramName, tvProgramHostName, tvProgramTime;
        public ImageView imgProgramAlarm;
        public View spaceView;

        public MyViewHolder(View view) {
            super(view);
            ll_list_row = view.findViewById(R.id.ll_list_row);
            tvProgramName = view.findViewById(R.id.tv_program_name);
            tvProgramHostName = view.findViewById(R.id.tv_program_host_name);
            tvProgramTime = view.findViewById(R.id.tv_program_time);
            imgProgramAlarm = view.findViewById(R.id.img_program_alarm_icon);
            spaceView = view.findViewById(R.id.space_view);

            imgProgramAlarm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listItemClickListener.onAlarmIconClick(imgProgramAlarm, getAdapterPosition());
                }
            });
        }
    }

    @Override
    public ProgramListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_program_list, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ProgramListAdapter.MyViewHolder holder, final int position) {
        holder.tvProgramName.setText(programArrayList.get(position).getProgramName());
        holder.tvProgramHostName.setText(programArrayList.get(position).getProgramHostName());
        ProgramTime programTime = AppUtility.getTime(programArrayList.get(position).getProgramStartTime());
        holder.tvProgramTime.setText(programTime.getTime());
        if (!ActivityUtils.isProgramAlarmAlreadySet(mContext, String.valueOf(programArrayList.get(position).getProgramId()))) {
            holder.imgProgramAlarm.setImageResource(R.drawable.img_alarm_inactive_icon);
        } else {
            holder.imgProgramAlarm.setImageResource(R.drawable.img_arlarm_active_icon);
        }

        if (position == programArrayList.size() - 1) {
            holder.spaceView.setVisibility(View.VISIBLE);
        } else {
            holder.spaceView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return programArrayList.size();
    }

}