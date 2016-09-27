package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

public class FindTagCommand extends Command {

    public static final String COMMAND_WORD = "findtag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Finds all persons whose tags contain any of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n\t"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n\t"
            + "Example: " + COMMAND_WORD + " friends colleagues";

    private final Set<Tag> keywords;

    public FindTagCommand(Set<String> keywords) {
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : keywords) {
            try {
                tagSet.add(new Tag(tagName));
            } catch (IllegalValueException e) {
                e.printStackTrace();
            }
        }
        this.keywords = tagSet;
    }

    /**
     * Returns copy of keywords in this command.
     */
    public Set<Tag> getKeywords() {
        return new HashSet<>(keywords);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithTagContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieve all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithTagContainingAnyKeyword(Set<Tag> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<Tag> tagList = person.getTags().toSet();
            if (!Collections.disjoint(tagList, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
