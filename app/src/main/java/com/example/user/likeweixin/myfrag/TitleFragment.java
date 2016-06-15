package com.example.user.likeweixin.myfrag;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.user.likeweixin.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TitleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TitleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TitleFragment extends Fragment {
    private ImageButton userBth;


    public TitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rst = inflater.inflate(R.layout.fragment_title, container, false);
        userBth =  (ImageButton) rst.findViewById(R.id.user_btn);
        userBth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"i am a imagebutton in title fragmant",Toast.LENGTH_SHORT).show();
            }
        });

        return rst;
    }

}
