package com.example.nikolai.ulitka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2Activity extends AppCompatActivity {
    public static final String Extra_Message = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView);
        Intent extra = getIntent();
        String str = extra.getStringExtra(Extra_Message);
        textView.setText(toSpiral(str));
        Toast.makeText(Main2Activity.this, str, Toast.LENGTH_SHORT).show();
    }
    public static void start(AppCompatActivity app, String str)
    {
        Intent intent = new Intent(app,Main2Activity.class);
        intent.putExtra(Extra_Message,str);
        app.startActivity(intent);
    }
    public static String toSpiral(String s) {
        String fin = "";
        StringTokenizer st;
        st = new StringTokenizer(s," ");
        int[] data = new int[st.countTokens()];
        for(int i = 0; st.hasMoreTokens(); ++i){
            data[i] = Integer.parseInt(st.nextToken());
        }
        // Max length of array items
        int maxItemLength = 0;
        for (int i=0; i<data.length; i++){
            int length = String.valueOf(data[i]).length();
            if (length > maxItemLength) {maxItemLength = length;}
        }
        // Prepare matrix
        int size = (int) Math.sqrt(data.length-1);
        size++;
        int[][] matrix = new int[size][size];
        // Find center
        int center = (size-1) / 2;
        // Fill matrix
        int x=center, y=center; // Initial coordinates
        int dx=0, dy=-1; // Initial direction
        int pos=0; // Element number
        int dist=0; // Initial distance
        while (pos<data.length) {
            // Step
            for (int k=0; k<dist; k++) {
                if (pos>=data.length) {break;}
                matrix[x][y] = data[pos];
                pos++;
                x+=dx;
                y+=dy;
            }
            // Clocwise turn
            int temp = -dx;
            dx = dy;
            dy = temp;
            // Step
            for (int k=0; k<dist; k++) {
                if (pos>=data.length) {break;}
                matrix[x][y] = data[pos];
                pos++;
                x+=dx;
                y+=dy;

            }
            // Clocwise turn
            int t = -dx;
            dx = dy;
            dy = t;
            dist++;
        }
        // Print matrix
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                //System.out.printf("| %"+ maxItemLength+"d |",matrix[i][j]);
                fin=fin+"| ";
                for(int k = String.valueOf(matrix[i][j]).length(); k < maxItemLength; ++k) fin+="  ";
                fin+=matrix[i][j]+" |";
            }
            //System.out.print("\n\n");
            fin+="\n\n";
        }
        return fin;
    }
}
