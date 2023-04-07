package edu.jsu.mcis.cs408.lab06;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.math.BigDecimal;
import java.math.RoundingMode;

import edu.jsu.mcis.cs408.lab06.databinding.FragmentDistanceBinding;
import edu.jsu.mcis.cs408.lab06.databinding.FragmentTemperatureBinding;
import edu.jsu.mcis.cs408.lab06.databinding.FragmentTipBinding;
import edu.jsu.mcis.cs408.lab06.databinding.TabFragmentBinding;

public class FragmentDistance extends Fragment {

    public static final String ARG_ID = "id";

    private FragmentDistanceBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDistanceBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editMiles = binding.editMiles;
                EditText editKilo = binding.editKilometers;

                String mile = editMiles.getText().toString();
                String kilo = editKilo.getText().toString();

                boolean hasMile = !mile.isEmpty();
                boolean hasKilo = !kilo.isEmpty();

                if (!hasMile && !hasKilo) {
                    Toast.makeText(getContext(), "All of the fields must be filled!",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    BigDecimal bd;
                    // default convert
                    if (hasMile) {
                        try {
                            bd = new BigDecimal(mile);
                            editKilo.setText(bd.multiply(BigDecimal.valueOf(1.609344)).toString());
                        }
                        catch (NumberFormatException nfe) { displayNonNumericError(); }
                    }
                    else if (hasKilo) {
                        try {
                            bd = new BigDecimal(kilo);
                            editMiles.setText(bd.divide(BigDecimal.valueOf(1.609344),
                                    4, RoundingMode.HALF_UP).toString());
                        }
                        catch (NumberFormatException nfe) { displayNonNumericError(); }
                    }
                }

            }
        });
    }

    private void displayNonNumericError() {
        Toast.makeText(getContext(), "Both fields must contain numeric values!",
                Toast.LENGTH_SHORT).show();
    }

}