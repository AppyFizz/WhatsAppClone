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
 * Created by AbinayaRajesh and AppyFizz on 7/24/17.
 *
 * A custom adapter to display a list of Contact objects, using a RecyclerView.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private List<Contact> contactList;
    private Context context;

    public ContactsAdapter(Context context, List<Contact> contactsList) {
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
        holder.circleImageView.setImageResource(contact.getImgResource());
        holder.usernameTextView.setText(contact.getUsername());
        holder.previewTextView.setText(contact.getPreview());
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
            // Set OnClickListener here.

            /**
             * TODO: Use some other method of setting OnClickListener.
             * This method is very inefficient, and defeats the purpose
             * of using a RecyclerView.
             */
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Contact contact = contactList.get(position);
                // Intent to MessagingActivity for this particular contact.
            }
        }
    }

}
