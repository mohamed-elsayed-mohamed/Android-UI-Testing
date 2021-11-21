package com.alpha.a002_test_fragment.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alpha.a002_test_fragment.databinding.FragmentStarActorsBinding

class StarActorsFragment : Fragment(){

    private val binding: FragmentStarActorsBinding by lazy { FragmentStarActorsBinding.inflate(layoutInflater) }

    private val starActors: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            starActors.addAll(args.get("args_actors") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActors()
    }

    private fun setActors(){
        binding.starActorsTitle.text = stringBuilderForStarActors(starActors)
    }

    companion object{
        fun stringBuilderForStarActors(actors: ArrayList<String>): String{
            val sb = StringBuilder()
            for(actor in actors){
                sb.append(actor + "\n")
            }
            return sb.toString()
        }
    }
}














