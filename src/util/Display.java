package util;

import model.CompanyInfo;
import model.DeliveryInfo;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

public class Display {
    private static TextIO textIO= TextInterface.getTextIO();
    private static TextTerminal<?> terminal=TextInterface.getTerminal();
    static int logoWidth=80;
    private static final String logo=
         "+------------------------------------------------------------------------------+\n"
        +"|                                                                              |\n"
        +"|    ######   #######   ##    ##   #######   ##    ##   #######   #######      |\n"
        +"|      ##     ##   ##   ##    ##   ##        ##   ##    ##        ##   ##      |\n"
        +"|      ##     ##   ##   ##    ##   ##        ##  ##     ##        ##   ##      |\n"
        +"|      ##     #######   ##    ##   ##        #####      #######   #######      |\n"
        +"|      ##     ## ##     ##    ##   ##        ##  ##     ##        ## ##        |\n"
        +"|      ##     ##  ##    ##    ##   ##        ##   ##    ##        ##  ##       |\n"
        +"|      ##     ##   ##   ########   #######   ##    ##   #######   ##   ##      |\n"
        +"|                                                                              |\n"
        +"+------------------------------------------------------------------------------+\n";
    private static final String module= "CUSTOMER EDITION 1.0";
    public static void printLogo(){
        print(logo,TextInterface.promptColor,true);
        printCentered(module,TextInterface.moduleColor);
        terminal.println();
        terminal.println();
        terminal.setBookmark(TextInterface.LOGOTAG);
    }

    public static void cls(){
        terminal.resetToBookmark(TextInterface.LOGOTAG);
    }

    public static void print(String message){
        terminal.println(message);
    }

    public static void print(String message,String color){
        terminal.executeWithPropertiesConfigurator(
                props -> props.setPromptColor(Color.decode(color)),
                t -> terminal.println(message));
    }

    public static void print(String message,String color,boolean sameLine){
        terminal.executeWithPropertiesConfigurator(
                props -> props.setPromptColor(Color.decode(color)),
                t -> {
                    if(sameLine) terminal.print(message); else terminal.println(message);
                });
    }

    public static void printCentered(String message){
        int width=logoWidth/2-message.length()/2;
        terminal.printf(getSpace(width)+"%s",message);
    }

    public static void printCentered(String message,String color){
        terminal.executeWithPropertiesConfigurator(
                props -> props.setPromptColor(Color.decode(color)),
                t ->{
                    int width=logoWidth/2-message.length()/2;
                    t.printf(getSpace(width)+"%s",message);
                });
    }

    private static String  getSpace(int width){
        int i=0;
        StringBuilder stringBuilder= new StringBuilder();
        while (i<width){
            stringBuilder.append(" ");
            i++;
        }
        return stringBuilder.toString();
    }


    public static void companyInfoTable(CompanyInfo[] companyInfos){
        String leftAlignFormat = "| %-2d| %-12s | %-13s | %.2f     | %.2f         | %-9d |%n";

        terminal.printf("+---+--------------+---------------+--------------+--------------+-----------+%n");
        print("|   | Company name | Delivery Date | Pricing(ETB) | Satisfaction | Delivered |",TextInterface.skyBlue);
        terminal.printf("+---+--------------+---------------+--------------+--------------+-----------+%n");
        int count=1;
        for(CompanyInfo companyInfo:companyInfos){
            terminal.printf(
                    leftAlignFormat,
                    count++,
                    companyInfo.getCompanyName(),
                    "Jan 02 2019",
                    BigDecimal.valueOf(companyInfo.getPricing()),
                    companyInfo.getCustomerSatisfaction(),
                    companyInfo.getNumberOfDeliveries()
            );
        }
        terminal.printf("+---+--------------+---------------+--------------+--------------+-----------+%n");
    }
    public static void pricingOptionsTable(CompanyInfo.PricingOption[] pricingOptions){
        String leftAlignFormat1 = "|     %-10.2f   |     %-10.2f   |     %-10.2f   |%n";

        terminal.printf("+------------------+------------------+------------------+%n");
        print("|      Slow        |      Regular     |      Urgent      |",TextInterface.skyBlue);
        terminal.printf("+------------------+------------------+------------------+%n");
        terminal.printf(
                leftAlignFormat1,
                pricingOptions[0].getPrice(),
                pricingOptions[1].getPrice(),
                pricingOptions[2].getPrice()

        );
        terminal.printf("|                                                        |%n");
        terminal.printf("|    arrives at    |    arrives at    |    arrives at    |%n");
        terminal.printf("|                                                        |%n");
        terminal.printf("|   Feb 20 2019    |   Feb 02 2019    |   Jan 10 2019    |%n");
        terminal.printf("+------------------+------------------+------------------+%n");
    }

    private static int getSize(float num){
        int count=0;
        int num1=(int) num;
        while (num1>0){
            num1/=10;
            count++;
        }
        return count;
    }
    public static void centered(String s) {

    }



    public static void displayDeliveryInfo(DeliveryInfo deliveryInfo) {
//        String leftAlignFormat = "| %-2d| %-12s | %-13s | %.2f     | %.2f         | %-9d |%n";
//
//        terminal.printf("+---+--------------+---------------+--------------+--------------+-----------+%n");
//        terminal.printf("|    Company name                                                  Delivered |%n");
//        terminal.printf("|    Company name                                                  Delivered |%n");
//        terminal.printf("|    Company name                                                  Delivered |%n");
//        terminal.printf("|    Company name                                                  Delivered |%n");
//        terminal.printf("|    Company name                                                  Delivered |%n");
//        terminal.printf("|    Company name                                                  Delivered |%n");
//        terminal.printf("|    Company name                                                  Delivered |%n");
//        terminal.printf("+---+--------------+---------------+--------------+--------------+-----------+%n");
//        terminal.printf("+---+--------------+---------------+--------------+--------------+-----------+%n");

    }
}
