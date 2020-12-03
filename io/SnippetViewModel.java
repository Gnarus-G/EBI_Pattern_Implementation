package io;

import java.util.Collection;

public class SnippetViewModel {

    private String alertMessage;
    private Collection<String> snippets;

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public void setSnippets(Collection<String> snippets) {
        this.snippets = snippets;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public Collection<String> getSnippets() {
        return snippets;
    }

}
