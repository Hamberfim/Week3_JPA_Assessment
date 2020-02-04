
import java.util.List;
import java.util.Scanner;
import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {
	    //Anthony Hamlin
		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();
		
		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter an appliance maker: ");
			String maker = in.nextLine();
			System.out.print("Enter the appliance model: ");
			String model = in.nextLine();
			System.out.print("Enter the appliance category type: ");
			String category = in.nextLine();
			ListItem toAdd = new ListItem(maker, model, category);
			lih.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the appliance maker to delete: ");
			String maker = in.nextLine();
			System.out.print("Enter the appliance model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the appliance category type to delete: ");
			String category = in.nextLine();
			ListItem toDelete = new ListItem(maker, model, category);
			lih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Maker");
			System.out.println("2 : Search by Model");
			System.out.println("3 : Search by Category Type");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the maker name: ");
				String makerName = in.nextLine();
				foundItems = lih.searchForItemByMaker(makerName);
			} else if (searchBy == 2) {
				System.out.print("Enter the model name: ");
				String modelName = in.nextLine();
				foundItems = lih.searchForItemByModel(modelName);
			} else {
				System.out.print("Enter the category name: ");
				String categoryName = in.nextLine();
				foundItems = lih.searchForItemByCategory(categoryName);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.returnItemDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getMaker() + " category type of " + toEdit.getCategory());
				System.out.println("1 : Update Maker");
				System.out.println("2 : Update Model");
				System.out.println("3 : Update Category Type");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Maker: ");
					String newMaker = in.nextLine();
					toEdit.setModel(newMaker);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				} else {
					System.out.print("New Category Type: ");
					String newCategory = in.nextLine();
					toEdit.setModel(newCategory);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our appliance list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("    Arrivederci!    ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListItem> allItems = lih.showAllItems();
			for(ListItem singleItem : allItems) {
				System.out.println(singleItem.returnItemDetails());
			}

		}

	}

