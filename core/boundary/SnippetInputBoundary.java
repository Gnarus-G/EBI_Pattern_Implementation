package core.boundary;

import core.usecase.RequestModelBuilder;
import core.usecase.snippet.*;

public interface SnippetInputBoundary {
    void createSnippet(RequestModelBuilder<CreateSnippet.RequestModel> requestModelBuilder);
    void likeASnippet(RequestModelBuilder<LikeSnippet.RequestModel> requestModelBuilder);
    void findMostRecentSnippets(RequestModelBuilder<FindMostRecentSnippets.RequestModel> requestModelBuilder);
}
