package com.example.apifetchandpagingandhiltdaggerandmore.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;
import com.example.apifetchandpagingandhiltdaggerandmore.adapter.MoviesAdapter;
import com.example.apifetchandpagingandhiltdaggerandmore.adapter.MoviesLoadStateAdapter;
import com.example.apifetchandpagingandhiltdaggerandmore.databinding.ActivityMainBinding;
import com.example.apifetchandpagingandhiltdaggerandmore.util.GridSpace;
import com.example.apifetchandpagingandhiltdaggerandmore.util.MovieComparator;
import com.example.apifetchandpagingandhiltdaggerandmore.util.Utils;
import com.example.apifetchandpagingandhiltdaggerandmore.viewmodel.MovieViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    MovieViewModel mainActivityViewModel;
    ActivityMainBinding activityMainBinding;
    MoviesAdapter moviesAdapter;

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        if (Utils.API_KEY == null || Utils.API_KEY.isEmpty()) {
            Toast.makeText(this, "Please get your API key from themoviedb.org", Toast.LENGTH_SHORT).show();
        }

        moviesAdapter = new MoviesAdapter(new MovieComparator(), requestManager);

        mainActivityViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        initRecyclerViewAndAdapter();

        mainActivityViewModel.movePagingDataFlowable.subscribe(moviePagingData -> {
            moviesAdapter.submitData(getLifecycle(), moviePagingData);
        });
    }

    private void initRecyclerViewAndAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        activityMainBinding.recyclerView.setLayoutManager(gridLayoutManager);
        activityMainBinding.recyclerView.addItemDecoration(new GridSpace(2, 20, true));
        activityMainBinding.recyclerView.setAdapter(moviesAdapter.withLoadStateFooter(new MoviesLoadStateAdapter(view -> moviesAdapter.retry())));
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return moviesAdapter.getItemViewType(position) == MoviesAdapter.LOADING_ITEM ? 2 : 1;
            }
        });
    }
}