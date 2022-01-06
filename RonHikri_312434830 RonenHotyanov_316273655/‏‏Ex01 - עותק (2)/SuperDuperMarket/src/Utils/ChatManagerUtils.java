package Utils;

import clasinEx.chat.chatManager;

import javax.servlet.ServletContext;

public class ChatManagerUtils {

    private static final String CHAT_MANAGER_ATTRIBUTE_NAME = "chatManager";
    private static final Object chatManagerLock = new Object();

    public static chatManager getChatManager(ServletContext servletContext) {
        synchronized (chatManagerLock) {
            if (servletContext.getAttribute(CHAT_MANAGER_ATTRIBUTE_NAME) == null) {
                servletContext.setAttribute(CHAT_MANAGER_ATTRIBUTE_NAME, new chatManager());
            }
        }
        return (chatManager) servletContext.getAttribute(CHAT_MANAGER_ATTRIBUTE_NAME);
    }
}
