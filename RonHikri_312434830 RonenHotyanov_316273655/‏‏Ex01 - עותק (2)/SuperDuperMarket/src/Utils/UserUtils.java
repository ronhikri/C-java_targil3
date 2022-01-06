package Utils;

import javax.servlet.ServletContext;

public class UserUtils {
    private static final String USER_MANAGER_ATTRIBUTE_NAME = "userManager";
    private static final Object userManagerLock = new Object();

    public static userManegerToServet getuser(ServletContext servletContext) {
        synchronized (userManagerLock) {
            if(servletContext.getAttribute(USER_MANAGER_ATTRIBUTE_NAME)==null)
servletContext.setAttribute(USER_MANAGER_ATTRIBUTE_NAME,new userManegerToServet());
                return (userManegerToServet)servletContext.getAttribute(USER_MANAGER_ATTRIBUTE_NAME);
            }


    }
}