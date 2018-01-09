package com.adventures.designpatterns.facade;

public class FacadePatternDemo {

	public static void main(String[] args) {
		HotelKeeper keeper = new HotelKeeper();

		VegMenu v = keeper.getVegMenu();
		NonVegMenu nv = keeper.getNonVegMenu();
		Both both = keeper.getVegNonMenu();

	}
}

class HotelKeeper {
	public VegMenu getVegMenu() {
		VegRestaurant v = new VegRestaurant();
		VegMenu vegMenu = (VegMenu) v.getMenus();
		return vegMenu;
	}

	public NonVegMenu getNonVegMenu() {
		NonVegRestaurant v = new NonVegRestaurant();
		NonVegMenu NonvegMenu = (NonVegMenu) v.getMenus();
		return NonvegMenu;
	}

	public Both getVegNonMenu() {
		VegNonBothRestaurant v = new VegNonBothRestaurant();
		Both bothMenu = (Both) v.getMenus();
		return bothMenu;
	}
}

class VegNonBothRestaurant implements Hotel {
	public Menus getMenus() {
		Both b = new Both();
		return b;
	}
}

class VegRestaurant implements Hotel {
	public Menus getMenus() {
		VegMenu v = new VegMenu();
		return v;
	}
}

class NonVegRestaurant implements Hotel {
	public Menus getMenus() {
		NonVegMenu nv = new NonVegMenu();
		return nv;
	}
}

interface Hotel {
	public Menus getMenus();
}

class Menus {
}

class VegMenu extends Menus {

}

class NonVegMenu extends Menus {

}

class Both extends Menus {

}