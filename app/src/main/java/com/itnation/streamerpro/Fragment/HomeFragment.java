package com.itnation.streamerpro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DatabaseError;
import com.itnation.streamerpro.Adapter.ParentAdapter;
import com.itnation.streamerpro.ModelClass.ParentItem;
import com.itnation.streamerpro.R;
import com.itnation.streamerpro.ViewModel.FirebaseViewModel;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.List;

public class HomeFragment extends Fragment {


    RecyclerView parentRecyclerView;
    FirebaseViewModel firebaseViewModel;
    ParentAdapter parentAdapter;
    LottieAnimationView animationView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_home, container, false);


        ImageCarousel carousel = myView.findViewById(R.id.carousel);
        carousel.addData(new CarouselItem("https://s.studiobinder.com/wp-content/uploads/2020/05/Best-Action-Movies-of-All-Time-Featured-.jpg",""));
        carousel.addData(new CarouselItem("https://www.howtowatch.co.nz/wp-content/uploads/2021/11/best-Action-movies-1.jpg",""));
        carousel.addData(new CarouselItem("https://filmlifestyle.com/wp-content/uploads/2022/04/Best-Action-Movies52.jpg",""));
        carousel.addData(new CarouselItem("https://www.buzzingpoint.com/wp-content/uploads/2018/12/mile-22-best-action-movie-2018.png",""));
        carousel.addData(new CarouselItem("https://i.ytimg.com/vi/gKH1Kei5Bps/maxresdefault.jpg",""));
        carousel.addData(new CarouselItem("https://i0.wp.com/maactioncinema.com/wp-content/uploads/2023/01/323168317_5821278237987443_2252556676970014426_n.jpg?fit=1564%2C821&ssl=1",""));
        carousel.addData(new CarouselItem("https://www.filmibeat.com/img/1200x80x675/popcorn/movie_lists/cinephile-alert-for-december-2023:-10-must-see-films-to-end-the-year-with-a-bang-20231009111803-6522.jpg",""));
        carousel.addData(new CarouselItem("https://static1.srcdn.com/wordpress/wp-content/uploads/2022/12/untitled-2000-x-1000-px-6.jpg",""));
        carousel.addData(new CarouselItem("https://cdn.24.co.za/files/Cms/General/d/9844/9037562ebb9649f9ba5247b857a38344.png",""));
        carousel.addData(new CarouselItem("https://static1.colliderimages.com/wordpress/wp-content/uploads/2022/12/avatar-the-way-of-water-stephen-lang-everything-michelle-yeoh-the-batman-robert-pattinson.jpg",""));
        carousel.addData(new CarouselItem("https://toplist.info/images/800px/-767038.jpg",""));







        parentRecyclerView = myView.findViewById(R.id.main_recyclyer);
        animationView = myView.findViewById(R.id.animationView);



        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


        parentRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        parentAdapter = new ParentAdapter();
        parentRecyclerView.setAdapter(parentAdapter);

        firebaseViewModel = new ViewModelProvider(this).get(FirebaseViewModel.class);

        firebaseViewModel.getAllData();


        firebaseViewModel.getParentItemMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<ParentItem>>() {
            @Override
            public void onChanged(List<ParentItem> parentItemList) {
                parentAdapter.setParentItemList(parentItemList);
                parentAdapter.notifyDataSetChanged();

                animationView.setVisibility(View.GONE);
            }
        });
        firebaseViewModel.getDatabaseErrorMutableLiveData().observe(getViewLifecycleOwner(), new Observer<DatabaseError>() {
            @Override
            public void onChanged(DatabaseError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });











        return myView;
    }
}