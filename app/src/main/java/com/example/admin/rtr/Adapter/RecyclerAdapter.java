package com.example.admin.rtr.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.rtr.R;
import com.example.admin.rtr.SubTitle.SubTitle;
import com.example.admin.rtr.SubTitle.SubTitleViewHolder;
import com.example.admin.rtr.Title.TitleMenu;
import com.example.admin.rtr.Title.TitleViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Admin on 27-04-2017.
 */

public class RecyclerAdapter extends ExpandableRecyclerViewAdapter<TitleViewHolder, SubTitleViewHolder> {

    private Context context;
    private ItemClickChild mListener;
    public RecyclerAdapter(Context context, List<? extends ExpandableGroup> groups, Activity activity) {
        super(groups);
        this.context = context;
        mListener = (ItemClickChild) activity;
    }

    @Override
    public TitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_title, parent, false);
        return new TitleViewHolder(view);
    }

    @Override
    public SubTitleViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_subtitle, parent, false);
        return new SubTitleViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(final SubTitleViewHolder holder, final int flatPosition,
                                      final ExpandableGroup group, final int childIndex) {

        final SubTitle subTitle = ((TitleMenu) group).getItems().get(childIndex);
        //Log.e("vraj",((TitleMenu)group).getTitle());
        holder.setSubTitletName(subTitle.getName(),subTitle.getImg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                mListener.onChildClick(childIndex,group);

            }
        });
    }

    @Override
    public void onBindGroupViewHolder(TitleViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGenreTitle(context, group);
    }

    public interface ItemClickChild
    {
        void onChildClick(int position,ExpandableGroup group);
    }

}

