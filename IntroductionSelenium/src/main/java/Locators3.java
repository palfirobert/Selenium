public class Locators3 {
    public static void main(String[] args) {
        // te plimbi cu xpath asa: /html/body/h3 -absolute path
        //relative path: //body
        //parent-child : //header/div/button[1]
        //parent-child-sibling(sibling-sibling travel)://header/div/button[1]/following-sibling::button[1]
        //child-parent traverse: //header/div/button[1]/parent::div,   //header/div/button[1]/parent::div/parent::header
        //parent-child-parent-child : //header/div/button[1]/parent::div/parent::header/a
        //not possible in css
        //daca vrem sa folosim css pt clasa .CLASA // si pt id #ID


    }
}
