package com.example.justknow;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class diseases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solution_to_disease);

     //   List<diseaseModel> diseaseModelList = getDiseaseData();
        //initRecyclerView(diseaseModelList);
    }



//    private void initRecyclerView(List<diseaseModel> diseaseModelList) {
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
//        recyclerView.setHasFixedSize(true);
//        diseaseListAdapter adapter = new diseaseListAdapter(diseaseModelList, (diseaseListAdapter.DiseaseListClickListener) this);
//        recyclerView.setAdapter(adapter);
//    }
//
//
//
//    private List<diseaseModel> getDiseaseData() {
//        InputStream is = getResources().openRawResource(R.raw.resturant);
//        Writer writer = new StringWriter();
//        char[] buffer = new char[1024];
//        try {
//            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            int n;
//            while ((n = reader.read(buffer)) != -1) {
//                writer.write(buffer, 0, n);
//            }
//        } catch (Exception e) {
//
//        }
//        String jsonStr = writer.toString();
//        Gson gson = new Gson();
//        diseaseModel[] diseaseModels = gson.fromJson(jsonStr, diseaseModel[].class);
//        List<diseaseModel> restList = Arrays.asList(diseaseModels);
//
//        return restList;
//    }
//

//    public void onItemClick(diseaseModel diseaseModel) {
//
//    }

}