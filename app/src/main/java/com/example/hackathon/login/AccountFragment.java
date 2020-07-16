package com.example.hackathon.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hackathon.R;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment {

    String[] settingList  = {"Your Profile   >","Change Password   >","Log Out   >"};
    ListView listView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_fragment, container, false);

        listView = view.findViewById(R.id.accountListview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,settingList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:
                        Intent intent = new Intent(getContext(),YourProfileActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getContext(),YourProfileActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:

                        break;
                }

            }
        });

        return view;
    }
}