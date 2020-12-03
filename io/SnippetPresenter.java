package io;

import java.util.stream.Collectors;

import core.boundary.SnippetOutputBoundary;
import core.usecase.snippet.CreateSnippet.ResponseModel;

public class SnippetPresenter extends SnippetOutputBoundary<Void> {

    SnippetViewModel vModel;

    public SnippetPresenter(SnippetViewModel vModel){
        this.vModel = vModel;
    }

    @Override
    protected Void onSnippetCreated(ResponseModel responseModel) {
        vModel.setAlertMessage(responseModel.okMessage);
        return null;
    }

    @Override
    protected Void onRecentSnippetsFound(core.usecase.snippet.FindMostRecentSnippets.ResponseModel responseModel) {
        vModel.setSnippets(responseModel.snippets.stream().map(snippet -> snippet.toString()).collect(Collectors.toList()));
        return null;
    }

    @Override
    protected Void onSnippetLikedUser(core.usecase.snippet.LikeSnippet.ResponseModel responseModel) {
        vModel.setAlertMessage(responseModel.responseMsg);
        return null;
    }
    
}
