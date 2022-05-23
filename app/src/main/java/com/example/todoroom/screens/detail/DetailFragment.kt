package com.example.todoroom.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.todoroom.APP
import com.example.todoroom.R
import com.example.todoroom.databinding.FragmentDetailBinding
import com.example.todoroom.model.NoteModel

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote:NoteModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        var viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.noteId.text = currentNote.title
        binding.noteDesc.text = currentNote.descriptor

        binding.btnDelete.setOnClickListener{
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

    }

}