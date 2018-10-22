package com.example.app;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {
    Adapter adapter;
    ArrayList<Modle> filterList;

    public CustomFilter(ArrayList<Modle> filterList , Adapter adapter  ) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results =new FilterResults();

        if (constraint != null && constraint.length()>0){

            constraint=constraint.toString().toUpperCase();

            ArrayList<Modle> filteredModles =new ArrayList<>();

            for (int i = 0; i<filterList.size(); i++){

                if (filterList.get(i).getTitle().toUpperCase().contains(constraint)){

                    filteredModles.add(filterList.get(i));
                }
            }

            results.count  = filteredModles.size();
            results.values = filteredModles;
        }
        else {
            results.count  = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.modles = (ArrayList<Modle>) results.values;
        adapter.notifyDataSetChanged();
    }
}
