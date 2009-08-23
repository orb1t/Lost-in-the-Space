package lost.in.the.space;

import java.lang.reflect.Method;
import java.util.Locale;

public class Main {
    
    public static void main(String[] args) {
        try {
            if (isMacOSX()) {
            	// Don't show the icon in the dock
                System.setProperty("apple.awt.UIElement", "true");
                // Register GURL to receive AppleEvents, such as magnet links.
                // Use reflection to not slow down non-OSX systems.
                // "GURLHandler.getInstance().register();"
                Class<?> clazz = Class.forName("org.limewire.ui.swing.GURLHandler");
                Method getInstance = clazz.getMethod("getInstance", new Class[0]);
                Object gurl = getInstance.invoke(null, new Object[0]);
                Method register = gurl.getClass().getMethod("register", new Class[0]);
                register.invoke(gurl, new Object[0]);
            }        
            
            Initializer initializer = new Initializer();
            initializer.initialize(args);
        } catch(Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /** Determines if this is running on OS X. */
    private static boolean isMacOSX() {
        return System.getProperty("os.name", "").toLowerCase(Locale.US).startsWith("mac os x");
    }
}
