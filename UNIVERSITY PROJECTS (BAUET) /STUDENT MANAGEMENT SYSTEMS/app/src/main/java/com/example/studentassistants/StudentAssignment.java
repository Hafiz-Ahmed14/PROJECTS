package com.example.studentassistants;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentAssignment extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    List<putPDF> uploadPDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_assignment);

        listView = findViewById(R.id.list_item);
        uploadPDF = new ArrayList<>();

        retrievePDFFiles();
    }

    private void retrievePDFFiles() {
        databaseReference = FirebaseDatabase.getInstance().getReference("uploadPDF/Assignment");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                uploadPDF.clear();

                for (DataSnapshot ds : snapshot.getChildren()) {
                    putPDF putPDF = ds.getValue(putPDF.class);
                    if (putPDF != null) {
                        uploadPDF.add(putPDF);
                    }
                }

                String[] uploadsName = new String[uploadPDF.size()];

                for (int i = 0; i < uploadsName.length; i++) {
                    uploadsName[i] = uploadPDF.get(i).getFilename();
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        uploadsName
                );

                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(StudentAssignment.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openPDFFile(String pdfUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(pdfUrl);

        intent.setDataAndType(uri, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No PDF viewer installed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPdfUrl = uploadPDF.get(position).getUrl();
                openPDFFile(selectedPdfUrl);
            }
        });
    }
}
