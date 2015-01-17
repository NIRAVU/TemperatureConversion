package niravu.unitconversions;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by Jazeem on 16/01/15.
 */
public class TempActivity extends ActionBarActivity {
    private RadioGroup rg;
    private EditText tempValue;
    float temperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
            tempValue= (EditText) findViewById(R.id.editText);
            rg= (RadioGroup) findViewById(R.id.temp_radio_button);
            rg.check(R.id.radio_celsius);
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    String tempString=tempValue.getText().toString();
                    if(!tempString.equals("")) {
                        switch (checkedId) {
                            case R.id.radio_celsius:
                                temperature = Float.parseFloat(tempString);
                                temperature -= 32;
                                temperature *= (5.0 / 9.0);
                                tempValue.setText(Float.toString(temperature));
                                break;
                            case R.id.radio_fahrenheit:
                                temperature = Float.parseFloat(tempString);
                                temperature *= (9.0 / 5.0);
                                temperature += 32;
                                tempValue.setText(Float.toString(temperature));
                                break;
                            default:
                                break;
                        }
                    }
                }
            });
    }
}
