package command.helper;

public class ConstantVariables {
    public final String COMMAND_KEY_FOR_MENU = "m";
    public final String COMMAND_KEY_FOR_EXIT = "x";
    public final String DECIMAL_FORMAT = "%.02f";
    private final String NOT_NUMBER_MESSAGE = "Your input is not a number. Please re-enter.";
    private final String SELECTION_NOT_AVAILABLE_MESSAGE = "Your selection is not available. Please re-enter";

    public String COMMAND_KEY_FOR_EXIT() {
        return COMMAND_KEY_FOR_EXIT;
    }

    public String getCommandKeyForMenu(){
        return COMMAND_KEY_FOR_MENU;
    }

    public void printSelectionNotAvailableMessage() {
        System.out.println(SELECTION_NOT_AVAILABLE_MESSAGE);
    }

    public void printNotNumberMessage() {
        System.out.println(NOT_NUMBER_MESSAGE);
    }

    public void printMenuAndExitOptions(){
        System.out.println("---------------");
        System.out.println("["+COMMAND_KEY_FOR_MENU+"] Menu | ["+COMMAND_KEY_FOR_EXIT+"] Exit");
        System.out.println("===============");
    }
}
