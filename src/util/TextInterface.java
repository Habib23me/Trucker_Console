package util;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import java.awt.*;

public class TextInterface {
    private static TextIO textIO= TextIoFactory.getTextIO();
    private static TextTerminal<?> terminal=textIO.getTextTerminal();
    public static final String LOGOTAG="Logo";
    public static final String promptColor="#A3A6B4";
    public static final String moduleColor="#E8E9EC";
    public static final String inputColor="#5EE2A0";
    public static final String skyBlue="#87CEFA";
    public static final String bgColor="#252525";
    static {
        terminal.getProperties().setPaneDimension(730,1000);
        terminal.getProperties().setPromptColor( Color.decode(promptColor));
        terminal.getProperties().setInputColor(Color.decode(inputColor));
        terminal.getProperties().setPaneBackgroundColor( Color.decode(bgColor));
        terminal.getProperties().setPromptBold(true);
    }

    public static TextIO getTextIO() {
        return textIO;
    }

    public static TextTerminal<?> getTerminal() {
        return terminal;
    }
}
