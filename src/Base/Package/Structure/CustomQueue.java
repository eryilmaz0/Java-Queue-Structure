package Base.Package.Structure;

public class CustomQueue<T> implements Queue<T> {

    private T[] queueArray;
    private int queueLimit;
    private boolean queueHasLimit;


    public CustomQueue(){
        this.queueArray = (T[]) new Object[0];
        this.queueHasLimit = false;
    }


    public CustomQueue(int queueLimit){
        this.queueArray = (T[]) new Object[0];
        this.queueHasLimit = true;
        this.queueLimit = queueLimit;
    }


    public int getQueueLength(){
        return this.queueArray.length;
    }

    public void clear(){
        this.queueArray = (T[]) new Object[0];
    }

    public void printQueueInfo(){
        System.out.println("********* Queue Info*********");
        System.out.println("Queue Lenght : " +getQueueLength());
        System.out.println("Queue Members : ");

        for(T value : this.queueArray){
            System.out.println(value);
        }
    }

    public boolean pop(T value){
        if(this.checkQueueAtLimit())
            return false;  //Queue At Limit

        T[] tempArray = this.queueArray;
        this.queueArray = (T[])new Object[tempArray.length + 1];

        for(int i = 0; i < tempArray.length; i++)
        {
            this.queueArray[i] = tempArray[i];
        }

        //Add New Value in To End
        this.queueArray[tempArray.length] = value;
        return true;
    }

    public void push(){
        if(this.queueArray.length <= 0)
        {
            System.out.println("Queue Is Empty.");
            return;
        }

        T[] tempArray = this.queueArray;
        T pushedValue = tempArray[0];
        this.queueArray = (T[]) new Object[tempArray.length -1];

        for(int i = 0; i < this.queueArray.length; i++)
        {
            this.queueArray[i] = tempArray[i + 1];
        }

        System.out.println(pushedValue +"Pushed From Queue.");
    }

    //Adds To The Specified Order
    public boolean add(int orderNumber, T value){
        int index = orderNumber - 1 ;
        boolean indexSliderEnable = false;

        if(this.checkQueueAtLimit())
            return false;

        if(orderNumber == 1){
            addElementIntoFirstIndex(value);
            return true;
        }

        if(orderNumber == this.queueArray.length){
            addElementIntoLastIndex(value);
            return true;
        }

        T[] tempArray = this.queueArray;
        this.queueArray = (T[]) new Object[tempArray.length + 1];

        for(int i = 0; i < queueArray.length; i++)
        {
            if(i == index){
                this.queueArray[i] = value;
                indexSliderEnable = true;
                continue;
            }

            if(indexSliderEnable){
                this.queueArray[i] = tempArray[i - 1];
                continue;
            }

            this.queueArray[i] = tempArray[i];
        }

        return true;
    }

    public boolean replace(int orderNumber, T value){
        int index = orderNumber - 1;

        this.queueArray[index] = value;
        return true;
    }



    private boolean checkQueueAtLimit(){

        //If Queue Has No Limit, Then Return False Directly.
        if(!this.queueHasLimit)
            return false;

        //Check Queue Limit, If It's length is Under Limit, Then Return False.
        if(this.queueArray.length < this.queueLimit)
            return false;

        //Queue At Limit. Return True
        return true;
    }

    private void addElementIntoFirstIndex(T value){
        T[] tempArray = this.queueArray;
        this.queueArray = (T[]) new Object[tempArray.length + 1];

        this.queueArray[0] = value;

        for(int i = 0; i < tempArray.length; i++)
        {
            this.queueArray[i + 1] = tempArray[i];
        }
    }

    private void addElementIntoLastIndex(T value){
        T[] tempArray = this.queueArray;
        this.queueArray = (T[])new Object[tempArray.length + 1];

        for(int i = 0; i < tempArray.length; i++){
            this.queueArray[i] = tempArray[i];
        }

        this.queueArray[tempArray.length] = value;
    }
}
