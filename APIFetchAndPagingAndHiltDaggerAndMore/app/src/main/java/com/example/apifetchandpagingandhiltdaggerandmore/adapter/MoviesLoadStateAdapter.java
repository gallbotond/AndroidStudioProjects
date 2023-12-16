package com.example.apifetchandpagingandhiltdaggerandmore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apifetchandpagingandhiltdaggerandmore.R;
import com.example.apifetchandpagingandhiltdaggerandmore.databinding.LoadStateItemBinding;

public class MoviesLoadStateAdapter extends LoadStateAdapter<MoviesLoadStateAdapter.LoadStateViewHolder> {
    private View.OnClickListener mRetryCallback;
    public MoviesLoadStateAdapter(View.OnClickListener retryCallback) {
        mRetryCallback = retryCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull LoadStateViewHolder loadStateViewHolder, @NonNull LoadState loadState) {
        loadStateViewHolder.bind(loadState);
    }

    @NonNull
    @Override
    public LoadStateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, @NonNull LoadState loadState) {
        return new LoadStateViewHolder(parent, mRetryCallback);
    }


    public static class LoadStateViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar mProgressBar;
        private TextView mErrorMsg;
        private Button mRetryBtn;

        public LoadStateViewHolder(@NonNull ViewGroup parent, @NonNull View.OnClickListener retryCallback) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.load_state_item, parent, false));

            LoadStateItemBinding binding = LoadStateItemBinding.bind(itemView);
            mProgressBar = binding.progressBar;
            mErrorMsg = binding.errorMsg;
            mRetryBtn = binding.retryBtn;
            mRetryBtn.setOnClickListener(retryCallback);
        }

        public void bind(LoadState loadState) {
            if(loadState instanceof LoadState.Error) {
                mErrorMsg.setText(((LoadState.Error) loadState).getError().getLocalizedMessage());
            }

            mProgressBar.setVisibility(loadState instanceof LoadState.Loading ? View.VISIBLE : View.GONE);
            mRetryBtn.setVisibility(loadState instanceof LoadState.Error ? View.VISIBLE : View.GONE);
            mErrorMsg.setVisibility(loadState instanceof LoadState.Error ? View.VISIBLE : View.GONE);
        }
    }
}
