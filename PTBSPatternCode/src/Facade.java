import java.io.IOException;
import java.util.Scanner;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList nProductList;

	private Person thePerson;

	public void invokeFacade() throws IOException {
		System.out.println("Select the userType: \n 0: Buyer \n 1: Seller");
		System.out.println("Enter userType:");
		Scanner sc = new Scanner(System.in);
		UserType = sc.nextInt();
		login();

	}

	public void login() throws IOException {
		Login user = new Login();
		boolean loginStatus = user.login(UserType);
		if(!loginStatus) {
			System.out.println("Invalid Credential");
		}
		else {
			createUser();
		}
	}

	// Implementing bridge pattern to show th menu items as per productInfo.txt
	public void createUser() throws IOException {
		System.out.println(UserType);
		if (UserType == 0) {
			Person buyer = new Buyer(new MeatProductMenu(), new ProduceProductMenu());
			buyer.showMenu();
			createProductList(buyer);
		}
		else {
			Person seller = new Seller(new MeatProductMenu(), new ProduceProductMenu());
			seller.showMenu();
			createProductList(seller);
		}

	}
	// Factory Design Implementation.
	public void createProductList(Person currentUser) throws IOException {
		if (UserType == 0) {
			System.out.println("Accessing menu based on products offering...............");
			ProductMenu menu = currentUser.CreateProductMenu();
			menu.createMenu(UserType);
		}
		else {
			System.out.println("Create menu to sell your products.......................");
			ProductMenu menu = currentUser.CreateProductMenu();
			menu.createMenu(UserType);
		}
	}

	public void AttachProductToUser() {

	}

	public void SelectProduct() {

	}

	public void productOperation() {

	}
	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

}
