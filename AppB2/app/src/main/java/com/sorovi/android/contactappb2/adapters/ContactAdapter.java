package com.sorovi.android.contactappb2.adapters;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sorovi.android.contactappb2.R;
import com.sorovi.android.contactappb2.models.MyContact;

import java.util.List;




public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyContactViewHolder> {
    private List<MyContact> contactList;

    public ContactAdapter(List<MyContact> contacts) {
        this.contactList = contacts;
    }

    @NonNull
    @Override
    public MyContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyContactViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_row,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactViewHolder holder, int position) {
        holder.nameTV.setText(contactList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }



    class MyContactViewHolder extends RecyclerView.ViewHolder{
        TextView nameTV;
        ImageButton callBtn, smsBtn, emailBtn, infoBtn;

        public MyContactViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.rowContactNameTV);
            callBtn = itemView.findViewById(R.id.rowCallBtn);
            smsBtn = itemView.findViewById(R.id.rowSmsBtn);
            emailBtn = itemView.findViewById(R.id.rowEmailBtn);
            infoBtn = itemView.findViewById(R.id.rowinfoBtn);

//            final MyContact contact = contacts.get(position);


            callBtn.setOnClickListener(v -> {
                final int position = getAdapterPosition();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+contactList.get(position).getMobile()));
                Intent chooser = Intent.createChooser(intent,"Select app");
                try {
                    v.getContext().startActivity(chooser);
                }catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }

            });
            smsBtn.setOnClickListener(v -> {
                final int position = getAdapterPosition();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+contactList.get(position).getMobile()));
                intent.putExtra("sms_body","Hi");
                Intent chooser = Intent.createChooser(intent,"Select app");
                try {
                    v.getContext().startActivity(chooser);
                }catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            });

            emailBtn.setOnClickListener(v -> {
                final int position = getAdapterPosition();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                Intent chooser = Intent.createChooser(intent,"Select app");
                try {
                    v.getContext().startActivity(chooser);
                }catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }

            });
            infoBtn.setOnClickListener(v -> {
                final int position = getAdapterPosition();
            });

            };
        }
    }
