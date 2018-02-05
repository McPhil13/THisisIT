package com.example.mcphil.avastus;


import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import com.example.mcphil.avastus.pdf.CustomAdapter;
import com.example.mcphil.avastus.pdf.PDFDoc;


import java.io.File;
import java.util.ArrayList;

public class DocumentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListView lv= (ListView) findViewById(R.id.lv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv.setAdapter(new CustomAdapter(DocumentActivity.this,getPDFs()));

            }
        });
    }

    private ArrayList<PDFDoc> getPDFs()

    {
        ArrayList<PDFDoc> pdfDocs=new ArrayList<>();
        //TARGET FOLDER
        File downloadsFolder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        PDFDoc pdfDoc;


        if(downloadsFolder.exists())
        {
            //GET ALL FILES IN DOWNLOAD FOLDER
            File[] files=downloadsFolder.listFiles();


                //LOOP THRU THOSE FILES GETTING NAME AND URI
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];

                    if (file.getPath().endsWith("pdf")) {
                        pdfDoc = new PDFDoc();
                        pdfDoc.setName(file.getName());
                        pdfDoc.setPath(file.getAbsolutePath());

                        pdfDocs.add(pdfDoc);
                    }

                }
        }

        return pdfDocs;
    }

}

