package com.example.hackathon.donor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hackathon.Init;
import com.example.hackathon.R;
import com.example.hackathon.data.NGOData;
import com.example.hackathon.handlers.DatabaseHandler;
import com.example.hackathon.login.SplashActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {

    ListView listView;
    List<NGOData> ngoList;
    CustomAdapter customAdapter;

    String url = Init.ip+"NgoList.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment,container,false);

        listView = view.findViewById(R.id.ngoListView);

        customAdapter = new CustomAdapter();

        ngoList = new ArrayList<>();

        listView.setAdapter(customAdapter);

        databaseOperation();



        return view;
    }

    private void databaseOperation()
    {
        DatabaseHandler databaseHandler = new DatabaseHandler(getContext(),url) {
            @Override
            public void getResponse(String response) throws Exception {
                Log.d("TAG", "getResponse: "+response);

                JSONArray jsonArray = new JSONArray(response);

                for (int i=0; i<jsonArray.length(); i++)
                {
                    JSONObject object = jsonArray.getJSONObject(i);

                    ngoList.add(new NGOData(object.getString("ngoName"),object.getString("ngoEmail"),object.getString("ngoMobile"),object.getString("ngoAddress"),object.getString("ngoCity")));
                }
                customAdapter.notifyDataSetChanged();
            }
        };

        Map<String,String> map = new HashMap<>();
        map.put("city", SplashActivity.sharedPrefrencesHandler.getCity());

        databaseHandler.putValues(map);

        databaseHandler.execute();
    }

    public class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return ngoList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.ngo_list_item_home,parent,false);

            TextView itemName = convertView.findViewById(R.id.ngoNameTextView);
            TextView itemEmail = convertView.findViewById(R.id.ngoEmailTextView);
            TextView itemAddress = convertView.findViewById(R.id.ngoAddressTextView);
            TextView itemMobile = convertView.findViewById(R.id.ngoMobileTextView);
            TextView itemCity = convertView.findViewById(R.id.ngoCityTextView);


            itemName.setText(new StringBuilder("Name :").append(ngoList.get(position).getNgoName()));
            itemEmail.setText(new StringBuilder("Email :").append(ngoList.get(position).getNgoEmail()));
            itemMobile.setText(new StringBuilder("Mobile :").append(ngoList.get(position).getNgoMobile()));
            itemAddress.setText(new StringBuilder("Address :").append(ngoList.get(position).getNgoAddress()));
            itemCity.setText(new StringBuilder("City :").append(ngoList.get(position).getNgoCity()));

            return convertView;
        }
    }
}