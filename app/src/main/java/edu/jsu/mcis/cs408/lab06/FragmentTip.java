package edu.jsu.mcis.cs408.lab06;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.math.BigDecimal;

import edu.jsu.mcis.cs408.lab06.databinding.FragmentTipBinding;

public class FragmentTip extends Fragment {

    public static final String ARG_ID = "id";

    private FragmentTipBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTipBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b = binding.editTotalBill.getText().toString();
                String t = binding.editTipPercentage.getText().toString();
                String n = binding.editNumOfPeople.getText().toString();

                if (b.isEmpty() | t.isEmpty() | n.isEmpty()) {
                    Toast.makeText(view.getContext(), "All of the fields must be filled!",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    BigDecimal bill = new BigDecimal(b);
                    BigDecimal tip = new BigDecimal(t);
                    BigDecimal numOfPeople = new BigDecimal(n);

                    String tpp = "Total Per Person: $" +
                            TipCalculator.calculateTip(bill, tip, numOfPeople);

                    binding.totalPerPerson.setText(tpp);
                }

            }
        });
    }
}
