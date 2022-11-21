package com.damiankain.mynotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.damiankain.mynotes.R
import com.damiankain.mynotes.databinding.FragmentAddNoteBinding
import com.damiankain.mynotes.db.Note
import com.damiankain.mynotes.db.NoteViewModel


class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAddNoteBinding.inflate(layoutInflater,container,false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteViewModel: NoteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        with(binding) {
            binding.btnSave.setOnClickListener {
                val noteTitle = editTitle.text.toString()
                val noteBody = editNote.text.toString()

                if(noteTitle.isEmpty()){
                    editTitle.error = "Title required"
                    editTitle.requestFocus()
                    return@setOnClickListener
                }
                if(noteBody.isEmpty()){
                    editNote.error = "Note required"
                    editNote.requestFocus()
                    return@setOnClickListener
                }

                val note = Note(null,noteTitle,noteBody)
                noteViewModel.addNote(note)
                Toast.makeText(
                    requireContext(),
                    "Successfully added",
                    Toast.LENGTH_SHORT).show()

                findNavController().navigate(R.id.to_back_home)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}