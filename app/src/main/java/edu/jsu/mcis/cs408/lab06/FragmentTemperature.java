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

import edu.jsu.mcis.cs408.lab06.databinding.FragmentTemperatureBinding;
import edu.jsu.mcis.cs408.lab06.databinding.FragmentTipBinding;
import edu.jsu.mcis.cs408.lab06.databinding.TabFragmentBinding;

public class FragmentTemperature extends Fragment {

    public static final String ARG_ID = "id";

    private FragmentTemperatureBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTemperatureBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editFahr = binding.editFahr;
                EditText editCels = binding.editCels;

                String fahr = editFahr.getText().toString();
                String cels = editCels.getText().toString();

                boolean hasFahr = !fahr.isEmpty();
                boolean hasCels = !cels.isEmpty();

                if (!hasFahr && !hasCels) {
                    Toast.makeText(getContext(), "All of the fields must be filled!",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    // default convert
                    if (hasFahr) {
                        try {
                            editCels.setText(TemperatureConverter.fahrenheitToCelcius(Double.valueOf(fahr)));
                        }
                        catch (NumberFormatException nfe) { displayNonNumericError(); }
                    }
                    else if (hasCels) {
                        try {
                            editFahr.setText(TemperatureConverter.celciusToFahrenheit(Double.valueOf(cels)));
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