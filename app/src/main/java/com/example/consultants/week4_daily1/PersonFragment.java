package com.example.consultants.week4_daily1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week4_daily1.model.DummyContent.DummyItem;
import com.example.consultants.week4_daily1.model.Person;

import java.util.ArrayList;


public class PersonFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String FIRST_NAME_PARAM = "FirstName";
    private static final String LAST_NAME_PARAM = "LastName";
    private static final String GENDER_PARAM = "PersonGender";
    private static final String AGE_PARAM = "PersonAge";
    private static final String NATIONALITY_PARAM = "PersonNationality";

    // TODO: Customize parameters

    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvAge;
    private TextView tvGenger;
    private TextView tvNationality;

//    private PersonListListener personListListener;
    private View view;
    private MyPersonRecyclerViewAdapter myPersonRecyclerViewAdapter;
    ArrayList<Person> personArrayList = new ArrayList<>();

    public PersonFragment() {
    }


    //    TODO not sure what this is doing besides passing arguments when fragment is created
    public static PersonFragment newInstance(String FName, String LName, String Gender, String pAge, String Natl) {
        PersonFragment fragment = new PersonFragment();
        Bundle args = new Bundle();
        args.putString(FIRST_NAME_PARAM, FName);
        args.putString(LAST_NAME_PARAM, LName);
        args.putString(GENDER_PARAM, Gender);
        args.putString(AGE_PARAM, pAge);
        args.putString(NATIONALITY_PARAM, Natl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            myPersonRecyclerViewAdapter = new MyPersonRecyclerViewAdapter(personArrayList);

            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(myPersonRecyclerViewAdapter);

//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//            recyclerView.setAdapter(new MyPersonRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvFirstName = view.findViewById(R.id.tvFirstName);
        tvLastName = view.findViewById(R.id.tvLastName);
        tvAge = view.findViewById(R.id.tvAge);
        tvGenger = view.findViewById(R.id.tvGender);
        tvNationality = view.findViewById(R.id.tvNationality);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
////            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
