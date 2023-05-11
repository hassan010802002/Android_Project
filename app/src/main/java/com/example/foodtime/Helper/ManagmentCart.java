package com.example.foodtime.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.foodtime.Domain.FoodDomain;
import com.example.foodtime.Interface.ChandeNumberItemsListener;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private  TinyDB tinyDB;
    public  ManagmentCart(Context context,TinyDB tinyDB){
        this.context=context;
        this.tinyDB=tinyDB;

    }
    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listFood=getListCart();
        boolean existAlready=false;
        int n=0;
        for(int i=0;i< listFood.size();i++){
            if(listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=1;
                break;
            }

        }
        if (existAlready){
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            listFood.add(item);
        }
        tinyDB.putListObject("CardList",listFood);
        Toast.makeText(context, "Added to your Card", Toast.LENGTH_SHORT).show();
    }
    private ArrayList<FoodDomain> getListCart(){
        return tinyDB.getListObject("cardList");
    }
    public void minusNumberFood(ArrayList<FoodDomain>listfood, int position, ChandeNumberItemsListener chandeNumberItemsListener){
        if (listfood.get(position).getNumberInCart()==1){
            listfood.remove(position);

        }else{
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("cardlist",listfood);
        chandeNumberItemsListener.changed();

    }
    public void plusNumberFood(ArrayList<FoodDomain>listfood, int position, ChandeNumberItemsListener chandeNumberItemsListener){
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("cardlist",listfood);
        chandeNumberItemsListener.changed();
    }


    public Double getTotalFee() {
        ArrayList<FoodDomain> listfood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listfood2.size(); i++) {
fee=fee+(listfood2.get(i).getFee()*listfood2.get(i).getNumberInCart());
        }
return  fee;
    }
}
