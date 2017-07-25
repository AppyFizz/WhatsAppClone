package com.example.shreyan.whatsapp.Contact;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shreyan.whatsapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by AbinayaRajesh on 7/24/17.
 * <p>
 * A custom adapter to display a list of Contact objects, using a RecyclerView.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> contactList;
    Context context;

    public ContactAdapter(Context context, List<Contact> contactsList) {
        this.context = context;
        this.contactList = contactsList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.contacts_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        // set text here
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


    class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView circleImageView;
        TextView usernameTextView;
        TextView previewTextView;

        ContactViewHolder(View itemView) {
            super(itemView);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.contact_img);
            usernameTextView = (TextView) itemView.findViewById(R.id.contact_username);
            previewTextView = (TextView) itemView.findViewById(R.id.contact_preview);
            // set listener
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Contact contact = contactList.get(position);
                // Intent
            }
        }
    }

}
