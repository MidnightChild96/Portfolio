import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ItemInventory {// Item Inventory class
    private static ArrayList<ItemEntry> entries;// instantiate ArrayList

    public ItemInventory() {// default constructor used in the store
    }

    private ItemInventory(int inputSize) {// private constructor used only in the load
        entries = new ArrayList<ItemEntry>(inputSize);
    }

    public void print(String sort) {// printer method used to print the store and it's inventory
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-30s %10s %10s %10s\n", "Title", "Type", "Price", "Quantity");// prints out the header
        System.out.println("---------------------------------------------------------------");
        String filter = sort;// used as a filter
        if (sort.equals("all")) {// if filter is all then prints everything
            for (int i = 0; i < entries.size(); i++) {
                System.out.printf("%-30s %10s %10s %10s\n", entries.get(i).getItem().getTitle(),
                        entries.get(i).getItem().getType(), String.format("%.2f", entries.get(i).getItem().getPrice()),
                        entries.get(i).getQuantity());// prints out necessary variables
            }
        } else {
            for (int i = 0; i < entries.size(); i++) {// prints based on whatever sort method was chosen
                if (entries.get(i).getItem().getType().equals(filter)) {
                    System.out.printf("%-30s %10s %10s %10s\n", entries.get(i).getItem().getTitle(),
                            entries.get(i).getItem().getType(),
                            String.format("%.2f", entries.get(i).getItem().getPrice()), entries.get(i).getQuantity());// prints
                                                                                                                      // out
                                                                                                                      // the
                                                                                                                      // necessary
                                                                                                                      // variables
                }
            }
        }
    }

    public static ItemInventory load(String file) {// loads the file
        ItemInventory output = new ItemInventory(0);// instatiates the output of the method
        String[] line;// used to break the lines in each file
        try {
            File inputFile = new File(file);// opens the file
            Scanner reader = new Scanner(inputFile);// scanner used to read the file
            ItemEntry item = null;// item entry set to null
            while (reader.hasNextLine()) {// while there is a next line loop will continue
                line = reader.nextLine().split("\\|");// splits the line into each word
                switch (line[0].toLowerCase()) {// switch based on what item is being read can be easily updated if
                                                // store adds more items
                    case "book":// book case
                        Book bookEntry = new Book(line[1], Double.parseDouble(line[6]), line[2], line[3], line[4],
                                Integer.parseInt(line[5]));// creates a book object
                        item = new ItemEntry(bookEntry, Integer.parseInt(line[7]));// creates a new Item entry object
                        break;
                    case "music":// music case
                        MusicCD cdEntry = new MusicCD(line[1], Double.parseDouble(line[8]), line[2], line[3], line[4],
                                line[5], Integer.parseInt(line[6]), line[7]);// creates a new music object
                        item = new ItemEntry(cdEntry, Integer.parseInt(line[9]));// creates a new Itementry object
                        break;
                    case "software":// software case
                        Software softwareEntry = new Software(line[1], Double.parseDouble(line[3]), line[1]);// creates
                                                                                                             // a new
                                                                                                             // software
                                                                                                             // object
                        item = new ItemEntry(softwareEntry, Integer.parseInt(line[4]));// creates a new itementry object
                }
                entries.add(item);// appends the new item to inventory
            }
            reader.close();// closes the scanner
        } catch (FileNotFoundException e) {// handles if file is not found
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        return output;// returns the inventory
    }
}
