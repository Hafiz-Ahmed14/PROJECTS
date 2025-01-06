package com.example.studentassistants;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentAssignmentGet extends AppCompatActivity {

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_assignment_get);

        databaseReference = FirebaseDatabase.getInstance().getReference("uploadPDF/Assignment");

        findViewById(R.id.stdassgetbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadPDF();
            }
        });
    }

    private void downloadPDF() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String pdfUrl = dataSnapshot.child("url").getValue(String.class);
                    if (pdfUrl != null && !pdfUrl.isEmpty()) {
                        startDownload(pdfUrl);
                    } else {
                        Toast.makeText(StudentAssignmentGet.this, "PDF URL not found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(StudentAssignmentGet.this, "Assignment not found in the database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(StudentAssignmentGet.this, "Error downloading PDF: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startDownload(String pdfUrl) {
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(pdfUrl);

        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
                .setAllowedOverRoaming(false)
                .setTitle("Assignment.pdf")
                .setDescription("Downloading")
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Assignment.pdf");

        downloadManager.enqueue(request);
    }
}
