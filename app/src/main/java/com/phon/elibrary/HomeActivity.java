package com.phon.elibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

       // HomeAdapter homeAdapter = new HomeAdapter();
        InnerHomeAdapter innerHomeAdapter = new InnerHomeAdapter();

       // Book book1 = new Book();
       // book1.setTitle("Java Programming");
        // book1.setAuthor("Mr. A");
       // book1.setSize("2MB");

       // Book book2 = new Book();
       // book2.setTitle("VB.Net");
      //  book2.setAuthor("Mr. B");
        //book2.setSize("2MB");

        //Book book3 = new Book();
        //book3.setTitle("PHP");
        //book3.setAuthor("Mr. C");
        //book3.setSize("2MB");

        //Book[] book = new Book[3];
        //book[0] = book1;
        //book[1] = book2;
        //book[2] = book3;

        DbBook dbBook = new DbBook(this);
        dbBook.insertData();
        Book[] books = dbBook.getAllBooks();

        innerHomeAdapter.setData(books);
        recyclerView.setAdapter(innerHomeAdapter);

       // homeAdapter.setData(book);
        //recyclerView.setAdapter(homeAdapter);
    }

    class InnerHomeAdapter extends RecyclerView.Adapter<InnerHomeAdapter.InnerEventViewHolder> {

        private Book[] data;
        public void setData(Book[] data){
            this.data = data;
            notifyDataSetChanged();

        }

        InnerHomeAdapter.InnerEventViewHolder eventViewHolder;

        @NonNull
        @Override
        public InnerHomeAdapter.InnerEventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            View viewHolder  = layoutInflater.inflate(R.layout.view_holder_home, viewGroup, false);
            eventViewHolder = new InnerEventViewHolder (viewHolder);
            return eventViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull InnerHomeAdapter.InnerEventViewHolder holder, int i) {
            Book book = data[i];
            eventViewHolder.txtTitle.setText(book.getTitle());
            eventViewHolder.txtAuthor.setText(book.getAuthor());
            eventViewHolder.txtSize.setText(book.getSize());
        }

        @Override
        public int getItemCount() {
            return (data == null) ? 0 : data.length;
        }

        class InnerEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private ImageView imgHome;
            private TextView txtTitle;
            private TextView txtAuthor;
            private TextView txtSize;
            public InnerEventViewHolder(View itemView) {
                super(itemView);

                imgHome = itemView.findViewById(R.id.images);
                txtTitle = itemView.findViewById(R.id.titles);
                txtAuthor = itemView.findViewById(R.id.authors);
                txtSize = itemView.findViewById(R.id.size);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BookDetail.class);

                //pass data
                int index = getAdapterPosition();
                Book book = data[index];
                intent.putExtra("title", book.getTitle());
                intent.putExtra("author", book.getAuthor());
                intent.putExtra("size", book.getSize());
                intent.putExtra("description", book.getDescription());

                startActivity(intent);
            }
        }

    }

}
