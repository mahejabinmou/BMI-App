package com.sorovi.android.contactappb2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sorovi.android.contactappb2.adapters.ContactAdapter;
import com.sorovi.android.contactappb2.databinding.FragmentContactListBinding;
import com.sorovi.android.contactappb2.models.MyContact;

public class ContactListFragment extends Fragment {
    private FragmentContactListBinding binding;
    public ContactListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContactListBinding.inflate(inflater);
        final ContactAdapter adapter = new ContactAdapter(MyContact.getContacts());
        final LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        binding.contactRV.setLayoutManager(llm);
        binding.contactRV.setAdapter(adapter);
        return binding.getRoot();
    }
}