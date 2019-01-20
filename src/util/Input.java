package util;

import controller.Navigator;
import model.AuthInfo;
import model.CompanyInfo;
import model.ContactInfo;
import model.DeliveryInfo;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import view.Screen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Input {
    private static TextIO textIO = TextInterface.getTextIO();
    private static TextTerminal<?> terminal = TextInterface.getTerminal();


    public static void menu(String label, String[] choices, Screen[] screens) {
        assert (choices.length == screens.length);
        String choice = textIO.newStringInputReader()
                .withNumberedPossibleValues(choices).read(label);
        int command = Arrays.asList(choices).indexOf(choice);
        Navigator.to(screens[command]);
    }

    public static ContactInfo getContactInfo() {
        String firstName;
        String lastName;
        String username;
        ContactInfo.City city;
        String phone;
        String password;


        terminal.resetToBookmark(TextInterface.LOGOTAG);
        terminal.println("Please Complete Your Profile Information to Create an Account");
        terminal.println();
        firstName = textIO
                .newStringInputReader()
                //.withPattern()
                .withMinLength(2)
                .read("First Name");
        lastName = textIO
                .newStringInputReader()
                .withMinLength(2)
                .read("Last Name");
        city = textIO
                .newEnumInputReader(ContactInfo.City.class)
                .read("Select City");
        phone = textIO
                .newStringInputReader()
                .withPattern("09[0-9]{8}")
                .read("Phone");
        username = textIO
                .newStringInputReader()
                .withMinLength(4)
                .withIgnoreCase()
                .read("Username");
        password = textIO
                .newStringInputReader()
                .withMinLength(6)
                .withInputMasking(true)
                .read("Password");
        textIO.newStringInputReader()
                .withValueChecker((s, s2) -> s.equals(password) ? null : new ArrayList<String>() {{
                    add("Password Doesn't Match");
                }})
                .withInputMasking(true)
                .read("Confirm Password");

        return new ContactInfo(firstName, lastName, city, phone, username, password);
    }

    public static AuthInfo getAuthInfo() {
        terminal.resetToBookmark(TextInterface.LOGOTAG);
        terminal.println("Welcome Back Please Login to continue");
        terminal.println();
        String username;
        String password;


        username = textIO
                .newStringInputReader()
                .withIgnoreCase()
                .read("Username");
        password = textIO.newStringInputReader()
                .withMinLength(6)
                .withInputMasking(true)
                .read("Password");

        return new AuthInfo(username, password);
    }


    public static DeliveryInfo getDeliveryInfo() {
        String productName;
        int amount;
        DeliveryInfo.WeightClass weightClass;
        ContactInfo.City from;
        ContactInfo.City to;
        Calendar departureDate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");

        terminal.resetToBookmark(TextInterface.LOGOTAG);
        terminal.println("Delivery Request Description");
        terminal.println();

        productName = textIO
                .newStringInputReader()
                .withMinLength(1)
                .read("Product Name");
        amount = textIO
                .newIntInputReader()
                .withMinVal(1)
                .withDefaultValue(1)
                .read("Amount");
        weightClass = textIO
                .newEnumInputReader(DeliveryInfo.WeightClass.class)
                .read("Weight Class(Kg)");
        from = textIO
                .newEnumInputReader(ContactInfo.City.class)
                .read("From");
        to = textIO
                .newEnumInputReader(ContactInfo.City.class)
                .read("To");
        try {
            departureDate.setTime(
                    sdf.parse(textIO
                            .newStringInputReader()
                            .withPattern("[A-z][a-z]{2} [0-9]{2} [0-9]{4}")
                            .read("Departure Date(Jan 01 2019)")
                    ));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new DeliveryInfo(productName, amount, weightClass, from, to, departureDate);
    }

    public static int getCompanyId() {
        CompanyInfo[] companyInfos = new CompanyInfo[]{
                new CompanyInfo("Company 1", 12, "lorem ipsum dolur sit amet sit amet lorem ipsum dolur sit amet", Calendar.getInstance(),
                        12000, 8.1f, 123),
                new CompanyInfo("Company 2", 13, "lorem ipsum dolur sit amet sit amet lorem ipsum dolur sit amet", Calendar.getInstance(),
                        14000, 9.0f, 130),
                new CompanyInfo("Company 3", 15, "lorem ipsum dolur sit amet sit amet lorem ipsum dolur sit amet", Calendar.getInstance(),
                        11000, 7.2f, 103),

        };
        terminal.resetToBookmark(TextInterface.LOGOTAG);
        terminal.println("Select Freight Forwarding Company");
        terminal.println();

        Display.companyInfoTable(companyInfos);

        return textIO.newIntInputReader().withMinVal(1).withMaxVal(companyInfos.length).read("Choose Company") - 1;
    }


    public static CompanyInfo.Options getPricing() {
        CompanyInfo.PricingOption[] pricingOptions = {
                new CompanyInfo.PricingOption(CompanyInfo.Options.Slow, 12000, Calendar.getInstance()),
                new CompanyInfo.PricingOption(CompanyInfo.Options.Regular, 12000, Calendar.getInstance()),
                new CompanyInfo.PricingOption(CompanyInfo.Options.Urgent, 16000, Calendar.getInstance()),
        };


        terminal.resetToBookmark(TextInterface.LOGOTAG);
        terminal.println("Select Pricing Options");
        terminal.println();

        Display.pricingOptionsTable(pricingOptions);

        return textIO.newEnumInputReader(CompanyInfo.Options.class).read("Pricing Option");
    }

    

    public static boolean confirmDeliveryInfo(DeliveryInfo deliveryInfo) {
        Display.displayDeliveryInfo(deliveryInfo);
        return true;

    }

}
