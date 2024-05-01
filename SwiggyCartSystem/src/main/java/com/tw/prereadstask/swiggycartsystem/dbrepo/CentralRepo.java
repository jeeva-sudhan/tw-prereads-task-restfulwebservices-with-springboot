package com.tw.prereadstask.swiggycartsystem.dbrepo;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import java.util.HashMap;

import com.tw.prereadstask.swiggycartsystem.model.User;

import jakarta.annotation.PostConstruct;

import com.tw.prereadstask.swiggycartsystem.model.FoodItem;
import com.tw.prereadstask.swiggycartsystem.model.Restaurant;
import com.tw.prereadstask.swiggycartsystem.model.Cart;

@Component
public class CentralRepo {
	
	private static List<User> usersList;
	private static List<FoodItem> foodList;
	private static List<Restaurant> restaurantlist;
	private static Map<Long,ArrayList<Cart>> usersCart;
	private static Map<Long,ArrayList<FoodItem>> restaurantFoods;
	
	public List<User> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<User> usersList) {
		CentralRepo.usersList = usersList;
	}
	public List<FoodItem> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<FoodItem> foodList) {
		CentralRepo.foodList = foodList;
	}
	public List<Restaurant> getRestaurantlist() {
		return restaurantlist;
	}
	public Map<Long, ArrayList<Cart>> getUsersCart() {
		return usersCart;
	}
	public void setUsersCart(Map<Long, ArrayList<Cart>> userCart) {
		CentralRepo.usersCart = userCart;
	}
	public void setRestaurantlist(List<Restaurant> restaurantlist) {
		CentralRepo.restaurantlist = restaurantlist;
	}
	public Map<Long, ArrayList<FoodItem>> getRestaurantFoods() {
		return restaurantFoods;
	}
	public void setRestaurantFoods(Map<Long, ArrayList<FoodItem>> restaurantFoods) {
		CentralRepo.restaurantFoods = restaurantFoods;
	}

	public CentralRepo() {
		usersList = new ArrayList<User>();
		foodList = new ArrayList<FoodItem>();
		restaurantlist = new ArrayList<Restaurant>();
		restaurantFoods = new HashMap<Long,ArrayList<FoodItem>>();
		usersCart = new HashMap<Long, ArrayList<Cart>>();
	}
	
	@PostConstruct
	public void init() {
		User john = new User(2468L,"John",9976706368L,"john@10","Do no:12,ritchie street,chennai - 684 231");
		User david = new User(3972L,"David",9865843511L,"david@42","Do no:27,Thomas street,chennai - 689 242");
		usersList.add(john);
		usersList.add(david);
		
		FoodItem dosa = new FoodItem(205L,"Dosa","A dosa is a thin, savoury crepe in South Indian cuisine made from a fermented batter of ground white gram and rice. Dosas are served hot, often with chutney and sambar (a lentil-based vegetable stew)",250.0);
		FoodItem masalDosa = new FoodItem(206L,"Masal Dosa","This classic Masala dosa recipe makes perfectly light, soft and crispy crepes stuffed with a savory, wonderfully spiced potato and onion filling.",350.0);
		foodList.add(dosa);
		foodList.add(masalDosa);
		
		Restaurant sangeeth = new Restaurant(410L,"Sangeeth","Attracting a large footfall in every place the stall was set up, be it in malls or in trade fairs, it cleared a setting for the team to leverage on E-Commerce","Plot no 7, Agaram Main Rd, Selaiyur, Chennai, Tamil Nadu 600073");
		Restaurant a2b = new Restaurant(411L,"A2B","The restaurant chain is known for its authentic South Indian cuisine. The brand has also diversified into offering sweets and snacks, which has become extremely popular across India.","47, Bharathi Salai, Narayana Krishnaraja Puram, Triplicane, Chennai, Tamil Nadu 600005");
		restaurantlist.add(sangeeth);
		restaurantlist.add(a2b);
		
		
		ArrayList<FoodItem> sangeetFoodItems = new ArrayList<FoodItem>();
		sangeetFoodItems.add(dosa);
		ArrayList<FoodItem> a2bFoodItems = new ArrayList<FoodItem>();
		a2bFoodItems.add(dosa);
		a2bFoodItems.add(masalDosa);
		restaurantFoods.put(410L, sangeetFoodItems);
		restaurantFoods.put(411L, a2bFoodItems);
	}
}
