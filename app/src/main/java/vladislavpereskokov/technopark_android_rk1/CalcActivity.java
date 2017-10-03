package vladislavpereskokov.technopark_android_rk1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalcActivity extends AppCompatActivity {
    public static final String ACTION_SQUARE = "*";
    public static final String ACTION_FACTORIAL = "!";

    public static final String ERROR_INPUT_SQUARE = "Заполните все поля!";
    public static final String ERROR_INPUT_FACT = "Заполните все поля!";

    private EditText operand1;
    private EditText operand2;
    private TextView result;

    private final View.OnClickListener squareClick = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            String op1 = operand1.getText().toString();
            String op2 = operand2.getText().toString();

            if (op1.length() == 0 || op2.length() == 0) {
                result.setText(ERROR_INPUT_SQUARE);
                return;
            }

            result.setText(String.valueOf(square(Double.parseDouble(op1), Double.parseDouble(op2))));
        }
    };

    private final View.OnClickListener factClick = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            String op1 = operand1.getText().toString();

            if (op1.length() == 0) {
                result.setText(ERROR_INPUT_FACT);
            }

            result.setText(String.valueOf(fact(Integer.parseInt(op1))));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String action = getIntent().getAction();
        switch (action) {
            case ACTION_SQUARE:
                setContentView(R.layout.square);
                findViewById(R.id.btn_add).setOnClickListener(squareClick);
                break;
            case ACTION_FACTORIAL:
                setContentView(R.layout.factorial);
                findViewById(R.id.btn_add).setOnClickListener(factClick);
                break;
            default:
                break;
        }

        operand1 = (EditText) findViewById(R.id.operand1);
        operand2 = (EditText) findViewById(R.id.operand2);

        result = (TextView) findViewById(R.id.result);
    }

    private double square(double op1, double op2) {
        return op1 * op2;
    }

    private double fact(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * fact(n - 1);
    }
}
