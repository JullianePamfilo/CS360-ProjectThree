package com.example.pamfilo_module3assignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    // I use these to grab input from the user
    private EditText inputItemName;
    private EditText inputItemDetail;

    // This is the button I tap to add a new item
    private Button buttonAddItem;

    // The grid will display items in a 2-column format
    private GridView gridView;

    // I’m just storing dummy items for now — no database yet
    private ArrayList<String> itemList;
    private SimpleGridAdapter adapter; // You’d create this separately if needed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        // Hook up all the UI elements from the layout
        inputItemName = findViewById(R.id.inputItemName);
        inputItemDetail = findViewById(R.id.inputItemDetail);
        buttonAddItem = findViewById(R.id.buttonAddItem);
        gridView = findViewById(R.id.gridView);

        // I initialize my dummy list of items
        itemList = new ArrayList<>();

        // For now, I’m just using a basic ArrayAdapter for testing
        adapter = new SimpleGridAdapter(this, itemList);
        gridView.setAdapter(adapter);

        // When I tap "Add Item", I capture the input and update the grid
        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = inputItemName.getText().toString().trim();
                String itemDetail = inputItemDetail.getText().toString().trim();

                if (itemName.isEmpty() || itemDetail.isEmpty()) {
                    Toast.makeText(GridActivity.this, "Please fill out both fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // For now, I just combine the fields into a string
                String combinedItem = itemName + ": " + itemDetail;
                itemList.add(combinedItem);
                adapter.notifyDataSetChanged(); // Refresh the grid

                inputItemName.setText("");
                inputItemDetail.setText("");
            }
        });
    }
}
