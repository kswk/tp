package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.ListIterator;

import seedu.address.model.Model;
import seedu.address.model.flashcard.FlashCard;

public class EndQuizCommand extends Command {
    public static final String COMMAND_WORD = "end";

    public static final String MESSAGE_SUCCESS = "Quiz ended!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        List<FlashCard> lastShownList = model.getFilteredFlashCardList();
        ListIterator<FlashCard> iterator = lastShownList.listIterator();
        while (iterator.hasNext()) {
            FlashCard toEdit = iterator.next();
            FlashCard changeTo = toEdit.copy();
            changeTo.updateShowingEnglish(true);
            model.setFlashCard(toEdit, changeTo);
        }
        model.setQuizMode(false);
        model.updateQuizModeIndex(0);
        model.updateFilteredPhraseList();
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}
