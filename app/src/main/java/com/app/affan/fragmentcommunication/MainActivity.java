package com.app.affan.fragmentcommunication;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  implements  FragmentA.OnFragmentInteractionListener,FragmentB.OnFragmentBInteractionListener{


    Fragment fragmentA;
    Fragment fragmentB;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentA = new FragmentA();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.content_frame,fragmentA).commit();
        fragmentB = new FragmentB();
        fragmentManager.beginTransaction().add(R.id.below_content_frame,fragmentB).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void sendData(String string) {

        Bundle args = new Bundle();
        args.putString(FragmentB.ARG_PARAM1,string);
        fragmentManager = getSupportFragmentManager();
        fragmentB = new FragmentB();
        fragmentB.setArguments(args);
        fragmentManager.beginTransaction().replace(R.id.below_content_frame,fragmentB).commit();
    }

    @Override
    public void onFragmentBInteraction(Uri uri) {

    }


//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()){
//
//            case R.id.fragment_a_button: {
//
//                Toast.makeText(this,"Fragment A",Toast.LENGTH_SHORT).show();
//                fragment = new FragmentA();
//                fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.content_frame,fragment).commit();
//
//            }break;
//            case R.id.fragment_b_button: {
//
//                Toast.makeText(this,"Fragment B",Toast.LENGTH_SHORT).show();
//                fragment = new FragmentB();
//                fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.content_frame,fragment).commit();
//            }break;
//        }
//    }

}
