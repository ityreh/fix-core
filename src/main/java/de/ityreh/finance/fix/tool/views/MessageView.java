package de.ityreh.finance.fix.tool.views;

import java.io.IOException;

public class MessageView extends MenuView {
    public MessageView() throws IOException {
        super();
    }

    @Override
    protected void initNodes() throws IOException {
        fxList.addAll(loadMenu(), loadView("/fxml/message.fxml"));
    }
}
