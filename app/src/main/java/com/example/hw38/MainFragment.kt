package com.example.hw38

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw38.databinding.ActivityMainBinding
import com.example.hw38.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val filmList = arrayListOf<Film>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = FilmsAdapter(filmList,this::onClick)
        binding.recycler.adapter = adapter
    }

    private fun loadData() {
        filmList.add(
            Film("Hangover","https://flxt.tmsimg.com/assets/p192248_p_v8_am.jpg",
                "The tale of how three friends tries to find the lost groom before his wedding after their crazy night in Las Vegas. The movie gets funny from the Las Vegas part right till the end. There is hilarious stuff in every other scene. Not to be missed, one of the best comedy of 2009. \t\n"
        )
        )
        filmList.add(
            Film("Hangover 2","https://static.wikia.nocookie.net/impdb4600/images/3/35/Hangover_2_poster.jpg/revision/latest?cb=20180812041545",
            "Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding."
             )
        )
        filmList.add(Film("Bad Santa","https://upload.wikimedia.org/wikipedia/en/c/cc/Bad_Santa_film.jpg",
            "A miserable conman and his partner pose as Santa and his Little Helper to rob department stores on Christmas Eve. But they run into problems when the conman befriends a troubled kid. A miserable conman and his partner pose as Santa and his Little Helper to rob department stores on Christmas Eve."
         )
        )
        filmList.add(
            Film("Elf","https://franklindrive-in.com/wp-content/uploads/2020/11/elf_ver6.jpg",
            "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit. Buddy was a baby in an orphanage who stowed away in Santa's sack and ended up at the North Pole."
            )
        )
        filmList.add(
            Film("Super Bad","https://cdn.kinocheck.com/images/6npzym06ww.jpg",
            "Hilarious comedy about two high school seniors who have been best friends since they were young and are preparing to finally graduate. They aren't exactly \"popular\", however, that won't stop them from doing whatever they can to finally lose their virginity before college to the prettiest and coolest girls in school."
              )
        )
        filmList.add(
            Film("21 Jump Street","https://daman.co.id/daman.co.id/wp-content/uploads/2012/03/21-Jump-Street-2012-Movie-Poster11.jpg?x87703",
            "In 2005, Schmidt and Jenko are high school students, one an honor roll geek, the other a cool, athletic underachiever. By 2012, they are rookie cops, paired together, on bike patrol yearning to make arrests. After a screw up, they're sent undercover back to high school to find the source of a dangerous synthetic drug."
     )
        )
        filmList.add(
            Film("22 Jump Street ","https://flxt.tmsimg.com/assets/p10372543_p_v8_av.jpg",
            "It is the sequel to the 2012 film 21 Jump Street, which is in turn based on the television series of the same name. The plot follows police officers Schmidt and Jenko as they go undercover at a college in order to find the supplier of a new drug."
               )
        )
        filmList.add(Film("SCARFACE","https://s3.amazonaws.com/static.rogerebert.com/uploads/movie/movie_poster/scarface-1983/large_yr3tfCMJwN95Lq6tuX9sla0UXX8.jpg",
            "Loosely based on the 1929 novel of the same name and serving as a loose remake of the 1932 film, it tells the story of Cuban refugee Tony Montana (Al Pacino), who arrives penniless in Miami during the Mariel boatlift and becomes a powerful and extremely homicidal drug lord."
               ))
    }
    private fun onClick(position:Int){
        val bundle = Bundle()
        bundle.putSerializable("key",filmList[position])
        findNavController().navigate(R.id.secondFragment,bundle)
    }

}