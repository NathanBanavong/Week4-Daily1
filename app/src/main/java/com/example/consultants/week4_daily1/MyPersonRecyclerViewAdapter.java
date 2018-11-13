package com.example.consultants.week4_daily1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week4_daily1.PersonFragment.OnListFragmentInteractionListener;
//import com.example.consultants.week4_daily1.model.DummyContent.DummyItem;
import com.example.consultants.week4_daily1.model.Person;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link } and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPersonRecyclerViewAdapter extends RecyclerView.Adapter<MyPersonRecyclerViewAdapter.ViewHolder> {

    private final List<Person> personList;
    //    private final OnListFragmentInteractionListener mListener;
    private RecyclerView rvPersonList;
    private MyPersonRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public MyPersonRecyclerViewAdapter(List<Person> leList) {
        this.personList = leList;
//        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_person, parent, false);

        return new ViewHolder(view);
    }

//    public void updateRecyclerView(String fName, String lName, String gender, String pAge, String nationality) {
//
//        tvFirstName = fName;
//    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        Person person = personList.get(position);

        viewHolder.tvFirstName.setText(person.getFirstname());
        viewHolder.tvLastName.setText(person.getLastname());
        viewHolder.tvAge.setText(person.getAge());
        viewHolder.tvGender.setText(person.getGender());
        viewHolder.tvNationality.setText(person.getNationality());

//        viewHolder.mItem = personList.get(position);
//        viewHolder.mIdView.setText(personList.get(position).id);
//        viewHolder.mContentView.setText(personList.get(position).content);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvFirstName;
        private final TextView tvLastName;
        private final TextView tvAge;
        private final TextView tvGender;
        private final TextView tvNationality;

        public ViewHolder(View itemView) {
            super(itemView);

            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvNationality = itemView.findViewById(R.id.tvNationality);
        }

    }
}
