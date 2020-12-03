package core.boundary;

import core.gateway.SnippetGateway;
import core.usecase.RequestModelBuilder;
import core.usecase.snippet.CreateSnippet;
import core.usecase.snippet.CreateSnippet.RequestModel;
import core.usecase.snippet.FindMostRecentSnippets;
import core.usecase.snippet.LikeSnippet;

public class SnippetInteractionOrchestrator implements SnippetInputBoundary {

    private SnippetGateway gateway;
    private SnippetOutputBoundary<?> oBoundary;

    public SnippetInteractionOrchestrator(SnippetGateway gateway, SnippetOutputBoundary<?> oBoundary) {
        this.gateway = gateway;
        this.oBoundary = oBoundary;
    }

    @Override
    public void createSnippet(RequestModelBuilder<RequestModel> requestModelBuilder) {
        oBoundary.onSnippetCreated(new CreateSnippet(gateway).execute(requestModelBuilder));
    }

    @Override
    public void likeASnippet(
            RequestModelBuilder<core.usecase.snippet.LikeSnippet.RequestModel> requestModelBuilder) {
        oBoundary.onSnippetLikedUser(new LikeSnippet(gateway).execute(requestModelBuilder));
    }

    @Override
    public void findMostRecentSnippets(
            RequestModelBuilder<core.usecase.snippet.FindMostRecentSnippets.RequestModel> requestModelBuilder) {
        oBoundary.onRecentSnippetsFound(new FindMostRecentSnippets(gateway).execute(requestModelBuilder));
    }

}
