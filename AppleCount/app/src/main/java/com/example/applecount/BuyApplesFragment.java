package com.example.applecount;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BuyApplesFragment extends Fragment {
    private EditText metBuy;
    private CommunicationListener listener;
    int number;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
           number = getArguments().getInt("TotalApples");
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_buy_apples, container, false);
    }
    @Override
    public void onStop() {
        super.onStop();
        int buyApples = Integer.parseInt(metBuy.getText().toString());
        number = number - buyApples;
        Bundle bundle = new Bundle();
        bundle.putInt("applesLeft", number);

        if (listener != null){
            listener.sendApplesData(bundle);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        metBuy = view.findViewById(R.id.etAppleToBuy);

    }


}