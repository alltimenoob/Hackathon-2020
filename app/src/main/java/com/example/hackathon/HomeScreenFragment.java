package com.example.hackathon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.hackathon.handlers.DatabaseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeScreenFragment extends Fragment {

    ListView listView;


    CustomAdapter customAdapter;
    List<Item> itemList = new ArrayList<>();

    String url = "http://10.0.2.2/UsersList.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homescreen_fragment,container,false);

        listView = view.findViewById(R.id.homeListView);

        customAdapter = new CustomAdapter();

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

                    itemList.add(new Item(object.getString("itemName"),object.getString("itemEmail"),object.getString("itemImage")));
                }
                customAdapter.notifyDataSetChanged();
            }
        };

        databaseHandler.execute();
    }

    public class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return itemList.size();
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
            convertView = getLayoutInflater().inflate(R.layout.list_item_homescreen,parent,false);

            TextView itemName = convertView.findViewById(R.id.itemNameTextView);
            TextView itemEmail = convertView.findViewById(R.id.itemEmailTextView);
            ImageView itemImage = convertView.findViewById(R.id.itemImageView);

            itemName.setText(itemList.get(position).getItemName());
            itemEmail.setText(itemList.get(position).getItemEmail());

            Bitmap bitmap = getImage(itemList.get(position).getItemProfile());
            itemImage.setImageBitmap(bitmap);

            return convertView;
        }

        private Bitmap getImage(String imagebase4) {
            byte[] imagedecoded = Base64.decode(imagebase4, Base64.DEFAULT);
            Bitmap decodedimage = BitmapFactory.decodeByteArray(imagedecoded, 0, imagedecoded.length);
            return decodedimage;

        }
    }


}
