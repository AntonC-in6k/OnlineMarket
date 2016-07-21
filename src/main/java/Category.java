/**
 * Created by employee on 7/21/16.
 */
public class Category {
    private int id;
    private String name;
    private int numberOfItems;

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumberOfItems(Integer numberOfItems){
        this.numberOfItems = numberOfItems;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getNumberOfItems(){
        return numberOfItems;
    }

}
