package io;

import core.boundary.SnippetInputBoundary;
import core.boundary.SnippetOutputBoundary;
import core.usecase.snippet.CreateSnippet.ResponseModel;

public class SnippetController extends SnippetOutputBoundary<Void> {

    SnippetInputBoundary interactor;

    public SnippetController(SnippetInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void createSnippetRequest(int id) {

        interactor.createSnippet(req -> {
            req.snippetId = id;
            return req;
        });
    }

    @Override
    protected Void onSnippetCreated(ResponseModel responseModel) {
        System.out.println(responseModel.okMessage);
        return null;
    }

    public void findRecentSnippetsRequest(int size) {

        interactor.findMostRecentSnippets(req -> {
            req.size = size;
            return req;
        });
    }

    @Override
    protected Void onRecentSnippetsFound(core.usecase.snippet.FindMostRecentSnippets.ResponseModel responseModel) {
        System.out.println(responseModel.snippets);
        return null;
    }

    public void userLikesASnippetRequest(int userId, int id) {

        interactor.likeASnippet(req -> {
            req.userId = userId;
            req.snippetId = id;

            return req;
        });
    }

    @Override
    protected Void onSnippetLikedUser(core.usecase.snippet.LikeSnippet.ResponseModel responseModel) {
        System.out.println(responseModel.responseMsg);
        return null;
    }

}
