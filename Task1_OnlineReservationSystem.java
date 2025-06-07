import java.util.*;
public class OnlineReservationSystem {
static Scanner sc=new Scanner(System.in);
static HashMap<String,String>users=new HashMap<>();
static List<String>reservations = new ArrayList<>();
public static void main(String args[]){
users.put("user","pass");
System.out.println("___Welcome to Online Reservation System___");
System.out.println("Enter Login ID:");
String id=sc.nextLine();
System.out.println("Enter Password:");
String pass=sc.nextLine();
if(authenticate(id,pass)){
menu();
}else{
System.out.println("Invalid credentials...");
}
}
static boolean authenticate(String id,String pass){
return users.containsKey(id)&&users.get(id).equals(pass);
}
static void menu(){
while(true){
System.out.println("\n1.Make Reservation\n2.Cancel Reservation\n3.View Reservations\n4.Exit");
int choice=sc.nextInt();
sc.nextLine();
switch(choice){
case 1-> makeReservation();
case 2-> cancelReservation();
case 3-> viewReservations();
case 4-> {
    System.out.println("Thank You...!");
return;
}
default-> System.out.println("Invalid Option...");
}
}
}
static void makeReservation(){
System.out.println("Enter name:");
String name=sc.nextLine();
System.out.println("Enter Train no:");
String train=sc.nextLine();
System.out.println("From:");
String from=sc.nextLine();
System.out.println("To:");
String to=sc.nextLine();
System.out.println("Date of Journey:");
String date=sc.nextLine();
String res="PNR"+(reservations.size()+1001)+":"+name+",Train"+train+", "+from+" to "+to+" on "+date;
reservations.add(res);
}
static void cancelReservation(){
System.out.println("Enter PNR number:");
String pnr=sc.nextLine();
boolean found=false;
for(int i=0;i<reservations.size();i++){
if(reservations.get(i).startsWith(pnr)){
reservations.remove(i);
found=true;
System.out.println("Reservation Cancelled...");
break;
}
}
if(!found){
System.out.println("PNR not found");
}
}
static void viewReservations(){
if(reservations.isEmpty()){
System.out.println("No Reservations Found...");
}else{
System.out.println("Reservations:");
for(String res:reservations){
System.out.println(res);
}
}
}
}

