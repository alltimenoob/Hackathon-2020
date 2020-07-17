package com.example.hackathon.ngo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hackathon.Init;
import com.example.hackathon.R;
import com.example.hackathon.data.NGOData;
import com.example.hackathon.data.RequestData;
import com.example.hackathon.donor.HomeFragment;

import java.util.List;

public class DonorRequestList extends Fragment {

    ListView listView;
    List<RequestData> requestList;
    HomeFragment.CustomAdapter customAdapter;

    String url = Init.ip+".php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.donor_request_list_fragment, container, false);

        return view;
    }
}