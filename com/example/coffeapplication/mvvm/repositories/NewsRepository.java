//package com.example.coffeapplication.mvvm.repositories;
//
//import com.example.coffeapplication.R;
//import com.example.coffeapplication.mvvm.models.News;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class NewsRepository {
//    ArrayList<News> holder;
//
//    public NewsRepository() {
//        holder = new ArrayList<>();
//
//        News n1 = new News(R.drawable.icedcoffee, "Iced Coffee", "21.04.2024");
//        holder.add(n1);
//
//        News n2 = new News(R.drawable.cappcoffee, "Cappuccino Gracias", "21.05.2024");
//        holder.add(n2);
//
//        News n3 = new News(R.drawable.latte, "Latte American Style", "21.03.2024");
//        holder.add(n3);
//
//        News n4 = new News(R.drawable.coffeenew, "New Arrival Again!", "21.02.2024");
//        holder.add(n4);
//    }
//
//
//    public ArrayList<News> getHolder() {
//        Collections.reverse(holder);
//        return holder;
//    }
//}

package com.example.coffeapplication.mvvm.repositories;

import com.example.coffeapplication.R;
import com.example.coffeapplication.mvvm.models.News;

import java.util.ArrayList;
import java.util.Collections;

public class NewsRepository {
    ArrayList<News> holder;

    public NewsRepository() {
        holder = new ArrayList<>();

        News n1 = new News(R.drawable.icedcoffee, "Iced Coffee", "21.04.2024");
        holder.add(n1);

        News n2 = new News(R.drawable.cappcoffee, "Cappuccino Gracias", "21.05.2024");
        holder.add(n2);

        News n3 = new News(R.drawable.latte, "Latte American Style", "21.03.2024");
        holder.add(n3);

        News n4 = new News(R.drawable.coffeenew, "New Arrival Again!", "21.02.2024");
        holder.add(n4);
    }


    public ArrayList<News> getHolder() {
        Collections.reverse(holder);
        return holder;
    }
}
