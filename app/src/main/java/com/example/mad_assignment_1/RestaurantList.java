package com.example.mad_assignment_1;

import java.util.List;

public class RestaurantList {


        public static void getList(List<Restaurant> list) {
            Menu grilldMenu = new Menu();
            grilldMenu.addDish("chips", "snack sized hot chips", 5.0, R.drawable.grilld_chips_snack);
            grilldMenu.addDish("Crispy bacon and cheese Burger", "Famous burger patty with cripsy bacon chedder cheese ", 15.0, R.drawable.grilld_crispybaconandcheese);
            grilldMenu.addDish("Mighty Traditional Burger", "Our famous burger just MIGHTY", 18.0, R.drawable.grilld_mighty_trad);
            grilldMenu.addDish("Mustard and pickle", "Our famous burger with lots of mustard and picles", 16.0, R.drawable.grilld_mustardandpickled);
            grilldMenu.addDish("Traditional grilld", "A simple classic burger", 14.0, R.drawable.grilld_simply_grilld_traditional);
            grilldMenu.addDish("Summer sunset burger", "Buger with guac, grilled pineapple and aioli", 16.0, R.drawable.grilld_summersunset);
            grilldMenu.addDish("Sweet potato chips", "snack sized hot sweet potato chips", 6.0, R.drawable.grilld_sweetpotatochips);
            Restaurant grilld = new Restaurant("Grilld", R.drawable.grilld_logo, grilldMenu);
            Menu hj = new Menu();
            hj.addDish("Double Cheese Burger", "Flame grilled burger with doulbe patty and double cheese", 10.0, R.drawable.hj_double_cheeseburger);
            hj.addDish("Fried Chicken Classic Burger", "Fried chicken burger", 10.0, R.drawable.hj_fried_chicken_classic);
            hj.addDish("Ultimate Whopper", "A whopper with double beef, double cheese and bacon", 12.0, R.drawable.hj_ultimate_double_whopper);
            hj.addDish("Whopper", "Our famous Flame grilled burger", 9.0, R.drawable.hj_whopper);
            hj.addDish("Whopper", "Our famous Flame grilled burger with cheese", 9.50, R.drawable.hj_whopper_with_cheese);
            Restaurant HungryJacks = new Restaurant("Hungry Jack's", R.drawable.hj_logo, hj);
            list.add(HungryJacks);
            Menu kfc = new Menu();
            kfc.addDish("Orginal Recipe fried chicken", "Our world famous fried chicken coated in 7 secret herbs and spices", 15.0, R.drawable.kfc_original_recipe);
            kfc.addDish("Orginal Recipe fried chicken", "Our world famous fried chicken coated in 7 secret herbs and spices", 15.0, R.drawable.kfc_original_recipe);
            kfc.addDish("Orginal Recipe fried chicken burger", "Our world famous fried chicken coated in 7 secret herbs and spices in a burger", 15.0, R.drawable.kfc_original_recipe_buger);
            kfc.addDish("Popcorn chicken", "small peices of fried chicken ", 10.0, R.drawable.kfc_popcorn_chicken);
            kfc.addDish("Potato and gravy", "Smooth mash potato with rich gravy", 8.0, R.drawable.kfc_potatogravy);
            kfc.addDish("Tister wrap", "Our world famous fried chicken in a wrap", 12.0, R.drawable.kfc_twister);
            kfc.addDish("Zinger Burger", "Spicy fried chicken buger", 12.0, R.drawable.kfc_zinger_burger);
            Restaurant KFC = new Restaurant("KFC", R.drawable.kfc_logo, kfc);
            list.add(KFC);
            Menu mcdonaladsMenu = new Menu();
            mcdonaladsMenu.addDish("Big Mac", "double beef buger with special sauce", 10.0, R.drawable.mcdonals_big_mac);
            mcdonaladsMenu.addDish("Four chicken nuggets", "Four chicken nuggets with you choice of sauce", 7.0, R.drawable.mcdonals_chicken_mcnuggets_4pc);
            mcdonaladsMenu.addDish("Double Cheese Burger", "double beef, double cheese with pickles", 7.50, R.drawable.mcdonals_double_cheeseburger);
            mcdonaladsMenu.addDish("Fries", "Medium Fries", 4.0, R.drawable.mcdonals_fries);
            mcdonaladsMenu.addDish("Hot fudge Sundae", "Soft serve ice cream with hot chocolate fudge sauce", 5.50, R.drawable.mcdonals_fudge_sundae);
            mcdonaladsMenu.addDish("Mcfulurry", "Soft serve ice cream whipped with your choice of toppings", 4.0, R.drawable.mcdonals_mcflurry);
            mcdonaladsMenu.addDish("Quarter Ponder", "Grilled 1/4lb beef burger with sauce and pickles", 9.0, R.drawable.mcdonals_quarter_pounder);
            Restaurant mcdonalds = new Restaurant("Mcdonalds", R.drawable.mcdonalds_logo_1, mcdonaladsMenu);
            list.add(mcdonalds);
            Menu pizzaHutMenu = new Menu();
            pizzaHutMenu.addDish("BBQ meat lovers", "All the meat with a BBQ sauce base", 13.0, R.drawable.pizzahut_bbq_meatlovers_pizza);
            pizzaHutMenu.addDish("Cheese lovers", "Just cheese on a tomato base", 10.0, R.drawable.pizzahut_cheese_lovers_pizza);
            pizzaHutMenu.addDish("Chicken Supreme", "Chicken and all the veggies on a tomato base", 12.0, R.drawable.pizzahut_chicken_supreme_pizza);
            pizzaHutMenu.addDish("Hawaiian", "Ham and pineapple on a tomato base", 11.50, R.drawable.pizzahut_hawaiian_pizza);
            pizzaHutMenu.addDish("Pepperoni", "Pepperoni with cheese on a tomato base", 11.0, R.drawable.pizzahut_pepperoni_pizza);
            pizzaHutMenu.addDish("Super Supreme", "Everything on a tomato base", 13.0, R.drawable.pizzahut_super_supreme_pizza);
            Restaurant pizzaHut = new Restaurant("Pizza Hut", R.drawable.pizzahut_logo, pizzaHutMenu);
            list.add(pizzaHut);
            Menu redMenu = new Menu();
            redMenu.addDish("BBQ chicken", "A whole BBQ chicken coated in herbs and spices", 15.0, R.drawable.red_bbq_chicken);
            redMenu.addDish("Chicken roll", "Hot BBQ chicken in a long roll with mayo", 8.0, R.drawable.red_chicken_roll);
            redMenu.addDish("Chicken Strips", "3 Fried Chicken tender loins with your choice of sauce", 9.0, R.drawable.red_chicken_strip);
            redMenu.addDish("Chicken Wings", "3 crispy fried chicken wings with BBQ sauce", 8.50, R.drawable.red_chicken_wings);
            redMenu.addDish("Ripper roll", "Fried tender loins in a long roll with lettuce and mayo", 10.0, R.drawable.red_rippa);
            Restaurant redRooster = new Restaurant("Red Rooster", R.drawable.redrooster_logo, redMenu);
            list.add(redRooster);
            Menu subwayMenu = new Menu();
            subwayMenu.addDish("BLT sub", "12 inch sub with Bacon, lettuce and tomato", 12.0, R.drawable.subway_blt);
            subwayMenu.addDish("Chicken teriyaki sub", "12 inch sub with teriyaki chicken", 13.0, R.drawable.subway_chicken_teriyak);
            subwayMenu.addDish("MeatBall sub", "12 inch sub with meatballs and red sauce", 13.20, R.drawable.subway_meatball_sub);
            subwayMenu.addDish("Steak Melt sub", "12 inch sub with Steak strips and melted cheese", 14.0, R.drawable.subway_steak_melt);
            subwayMenu.addDish("Tuna and mayo sub", "12 inch sub with tuna peices and mayo", 10.0, R.drawable.subway_tuna_mayo);
            subwayMenu.addDish("White Chocolate and macadamia cookie", "Fresh cookie with White Chocolate pieces and macadamia nuts", 3.0, R.drawable.subway_whitechipmacadamianutcookie);
            subwayMenu.addDish("Choc chip cookie", "Fresh chocolate chip cookie", 3.0, R.drawable.subway_chocolatechipcookie);
            Restaurant subway = new Restaurant("Subway", R.drawable.subway_logo, subwayMenu);
            list.add(subway);
            Menu zamMenu = new Menu();
            zamMenu.addDish("Burrito bowl", "Grilled chicken, lettuce, corn, rice, beans and cheese served in a bowl", 15.0, R.drawable.zam_bowl);
            zamMenu.addDish("Burrito", "PUlled pork, lettuce, corn, rice, beans and cheese in a tortilla", 15.0, R.drawable.zam_burrito);
            zamMenu.addDish("Chips", "Medium hot chips with mexican seasoning", 5.0, R.drawable.zam_chips);
            zamMenu.addDish("Dos capas", "Grilled chicken, lettuce, corn, rice, beans and cheese in a hard taco shell wrapped in a tortilla", 11.0, R.drawable.zam_dos_capas);
            zamMenu.addDish("Nachos", "Puled beef, salsa, cheese, guac and sour cream over corn chips ", 15.0, R.drawable.zam_nachos);
            zamMenu.addDish("Quesadilla", "Grilled chicken, lettuce, corn, rice, beans and cheese between a toasted flour tortilla", 15.0, R.drawable.zam_bowl);
            Restaurant zambrero = new Restaurant("Zambrero", R.drawable.zambrero_logo, zamMenu);
            list.add(zambrero);
            list.add(grilld);
        }

}
