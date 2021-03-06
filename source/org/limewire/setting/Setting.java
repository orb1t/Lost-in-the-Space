package org.limewire.setting;

import org.limewire.inject.MutableProvider;
import org.limewire.setting.evt.SettingListener;

/**
 * Defines the interface for a setting that can be used
 * within this package.
 */
public interface Setting<T> extends MutableProvider<T> {    
    
    /** Gets the current value of the setting. */
    T get();
    
    /** Sets the new value for this setting. */
    void set(T newValue);

    /**
     * Registers a {@link SettingListener}.
     */
    void addSettingListener(SettingListener l);

    /**
     * Removes a {@link SettingListener}.
     */
    void removeSettingListener(SettingListener l);

    /**
     * Returns all {@link SettingListener}s or null of there are none.
     */
    SettingListener[] getSettingListeners();

    /**
     * Reload value from properties object.
     */
    void reload();

    /**
     * Revert to the default value.
     * It is critically important that the DEFAULT_VALUE is valid,
     * otherwise an infinite loop will be encountered when revertToDefault
     * is called, as invalid values call revertToDefault.
     * Because default values are hard-coded into the program, this is okay.
     */
    boolean revertToDefault();

    /**
     * Determines whether or not this value should always be saved to disk.
     */
    boolean shouldAlwaysSave();

    /**
     * Sets whether or not this setting should always save, even if
     * it is default.
     * Returns this so it can be used during assignment.
     */
    Setting<T> setAlwaysSave(boolean alwaysSave);

    /**
     * Sets whether or not this setting should be reported in bug reports.
     */
    Setting<T> setPrivate(boolean isPrivate);

    /**
     * Determines whether or not a setting is private.
     */
    boolean isPrivate();

    /**
     * Determines whether or not the current value is the default value.
     */
    boolean isDefault();

    /** Get the key for this setting.     */
    String getKey();

    /**  Returns the value as stored in the properties file.    */
    String getValueAsString();

}