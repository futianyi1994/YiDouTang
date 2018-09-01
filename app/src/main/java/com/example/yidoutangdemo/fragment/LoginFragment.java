package com.example.yidoutangdemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.yidoutangdemo.R;
import com.example.yidoutangdemo.ui.GouWuDanActivity;
import com.example.yidoutangdemo.ui.ShouCangActivity;


public class LoginFragment extends BaseFragment{

    private ListView listView;
    private Button button_sc;
    private Button button_gwd;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
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
        // Inflate the layout for this fragment
        View rootView  = inflater.inflate(R.layout.fragment_login, container, false);
        button_sc = (Button) rootView.findViewById(R.id.button_sc);
        button_gwd = (Button) rootView.findViewById(R.id.button_gwd);
        button_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShouCangActivity.class);
                startActivity(intent);
            }
        });
        button_gwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GouWuDanActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
