package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    int size;

    private Toolbar mToolbar;

    private Resources mResources;

    private String[] mCategorisName = new String[1000];

    private TypedArray mCategorisImagePath;

    private RecyclerView mCategoriRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // setSupportActionBar(mToolbar);

        initWidgets();

        AdapterC categoriadapter = new AdapterC(mCategorisName, mCategorisImagePath, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);

//        //last position a ekta dekhanor jonno
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position == 8) return 2;
//                else return 1;
//            }
//        });

        mCategoriRecyclerview.setLayoutManager(gridLayoutManager);
//
//        int spanCount = 3; // 2 columns
//        int spacing = 50; // 50px
//        boolean includeEdge = true;
//
//         mCategoriRecyclerview.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        mCategoriRecyclerview.addItemDecoration(new EqualSpacingItemDecoration(16)); // 16px. In practice, you'll want to use getDimensionPixelSize

// Explicitly specify display orientation of items.
// Available display modes:
//   - HORIZONTAL
//   - VERTICAL
//   - GRID
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mCategoriRecyclerview.setHasFixedSize(true);

        mCategoriRecyclerview.setAdapter(categoriadapter);

    }

    private void initWidgets() {

     //   mToolbar = findViewById(R.id.toolbar);

        mResources = getResources();

        mCategoriRecyclerview = findViewById(R.id.recyclerview);

        mCategorisName = mResources.getStringArray(R.array.array_catergori_name);

        mCategorisImagePath = getResources().obtainTypedArray(R.array.array_categori_path);


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//                super.onCreateOptionsMenu(menu);
//
//     //   getMenuInflater().inflate( R.menu.mToolbar_items , menu );
//
//        return true;
//    }
}
