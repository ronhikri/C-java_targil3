package clasinEx.chat;

import java.util.ArrayList;
import java.util.List;

public class chatManager {

    private final List<SingleChatEnty> chatDataList;

    public chatManager() {
        chatDataList = new ArrayList<>();
    }

    public synchronized void addChatString(String chatString, String username) {
        chatDataList.add(new SingleChatEnty(chatString, username));
    }

    public synchronized List<SingleChatEnty> getChatEntries(int fromIndex){
        if (fromIndex < 0 || fromIndex > chatDataList.size()) {
            fromIndex = 0;
        }
        return chatDataList.subList(fromIndex, chatDataList.size());
    }

    public int getVersion() {
        return chatDataList.size();
    }
}
