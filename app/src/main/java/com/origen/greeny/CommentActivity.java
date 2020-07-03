package com.origen.greeny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.origen.greeny.Adapter.CommentAdapter;
import com.origen.greeny.Model.CommentModel;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CommentAdapter adapter;
    private List<CommentModel> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        recyclerView = findViewById(R.id.comment_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CommentModel commentModel = new CommentModel("Tural Sufanzadə",
                "Bəllidir ki, məhsuldarlığın artırılması üçün kənd təsərrüfatı sahələrinin yeni texnikalarla təchiz olunması vacibdir. ","2 gün əvvəl",
                "https://images.freeimages.com/images/premium/previews/2274/22745971-farmer-picking-vegetables.jpg");

        CommentModel commentModel2 = new CommentModel("Azər Abışov",
                "Fermerlərə sadəcə satış qiymətinin 20%-lik hissəsini ilkin ödəniş şəklində ödəmək qalacaq.","2 gün əvvəl",
                "https://dam.farmjournal.com/m/c645271f06ffc66/webimage-313510B2-3DB1-489A-8DDD9ABCCD4279D3.jpg");

        CommentModel commentModel3 = new CommentModel("Hüseyn Bağırov",
                "Fermerlərə sadəcə satış qiymətinin 20%-lik hissəsini ilkin ödəniş şəklində ödəmək qalacaq.","1 gün əvvəl",
                "https://non-gmoreport.com/wp-content/uploads/2019/02/farmer-field.jpg");

        CommentModel commentModel4 = new CommentModel("Tural Sufanzadə",
                "Fermerlərə sadəcə satış qiymətinin 20%-lik hissəsini ilkin ödəniş şəklində ödəmək qalacaq.","3 gün əvvəl",
                "https://images.freeimages.com/images/premium/previews/2274/22745971-farmer-picking-vegetables.jpg");

        CommentModel commentModel5 = new CommentModel("Azər Abışov",
                "Fermerlərə sadəcə satış qiymətinin 20%-lik hissəsini ilkin ödəniş şəklində ödəmək qalacaq.","2 gün əvvəl",
                "https://dam.farmjournal.com/m/c645271f06ffc66/webimage-313510B2-3DB1-489A-8DDD9ABCCD4279D3.jpg");

        CommentModel commentModel6 = new CommentModel("Hüseyn Bağırov",
                "Fermerlərə sadəcə satış qiymətinin 20%-lik hissəsini ilkin ödəniş şəklində ödəmək qalacaq.","5",
                "https://non-gmoreport.com/wp-content/uploads/2019/02/farmer-field.jpg");

        list.add(commentModel);
        list.add(commentModel2);
        list.add(commentModel3);
        list.add(commentModel4);
        list.add(commentModel5);
        list.add(commentModel6);

        adapter = new CommentAdapter(this,list);
        recyclerView.setAdapter(adapter);

    }
}
