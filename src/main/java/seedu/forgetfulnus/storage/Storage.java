package seedu.forgetfulnus.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.forgetfulnus.commons.exceptions.DataConversionException;
import seedu.forgetfulnus.model.ReadOnlyGlossary;
import seedu.forgetfulnus.model.ReadOnlyUserPrefs;
import seedu.forgetfulnus.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends GlossaryStorage, UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getGlossaryFilePath();

    @Override
    Optional<ReadOnlyGlossary> readGlossary() throws DataConversionException, IOException;

    @Override
    void saveGlossary(ReadOnlyGlossary glossary) throws IOException;

}