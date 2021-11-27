package Helper;

public class Helper {
    public boolean checkInt(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public boolean checkDouble(String input){
        try{
            Double.parseDouble(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
