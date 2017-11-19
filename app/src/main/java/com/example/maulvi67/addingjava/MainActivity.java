package com.example.maulvi67.addingjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view)
    {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view)
    {
        quantity = quantity - 1;
        display(quantity);
    }

    public void submitOrder(View view)
    {
        price = quantity * 5;

        EditText nameField = (EditText) findViewById(R.id.edtNama);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        String priceMessage= "Total $"+ price;
        priceMessage = priceMessage + "\nThank you !";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.order_summary_email_subject,name));
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);

        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
            displayMessage(priceMessage);
        }
    }

   private void display(int number)
    {
        TextView angkaQuantity = (TextView) findViewById(R.id.tvAngkaKuantitas);
        angkaQuantity.setText("" + number);
    }

    private void displayHarga(int number)
    {
        TextView angkaHarga = (TextView) findViewById(R.id.tvAngkaHarga);
        angkaHarga.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String pesan)
    {
        TextView pesanText = (TextView) findViewById(R.id.tvAngkaHarga);
        pesanText.setText(pesan);
    }
}
