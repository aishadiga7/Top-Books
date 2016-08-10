package com.example.aishwarya.topbooks.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aishwarya.topbooks.R;
import com.example.aishwarya.topbooks.intf.BookClickListener;
import com.example.aishwarya.topbooks.model.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Adapter that supplies book related dats for the recycler view
 */
public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    private ArrayList<Book> mBooks;
    private Context mContext;
    private BookClickListener mBookClickListener;

    public BooksAdapter(ArrayList<Book> books, Context context, BookClickListener bookClickListener) {
        mBooks = books;
        mContext = context;
        mBookClickListener = bookClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_book_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBooks.get(position);
        holder.mName.setText(book.getName());
        holder.mAuthor.setText(book.getAuthor());
        holder.mCategory.setText(book.getCategory());
        holder.mReleasedOn.setText(book.getReleasedOn());
        holder.mPrice.setText(book.getPrice());
        Picasso.with(mContext).load(book.getBookImageUrl()).into(holder.mBookImage);
        holder.bind(book, mBookClickListener);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public void updateRecyclerView(ArrayList<Book> books) {
        mBooks.clear();
        mBooks.addAll(books);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mAuthor;
        TextView mCategory;
        TextView mReleasedOn;
        TextView mPrice;
        ImageView mBookImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name);
            mAuthor = (TextView) itemView.findViewById(R.id.author);
            mCategory = (TextView) itemView.findViewById(R.id.category);
            mReleasedOn = (TextView) itemView.findViewById(R.id.released_on);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mBookImage = (ImageView) itemView.findViewById(R.id.book_image);
        }

        public void bind(final Book book, final BookClickListener bookClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bookClickListener.onBookClicked(book);
                }
            });
        }
    }
}
