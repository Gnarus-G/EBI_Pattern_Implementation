package core.boundary;

public abstract class SnippetOutputBoundary<T> {

    protected abstract T onSnippetCreated(core.usecase.snippet.CreateSnippet.ResponseModel responseModel);
    protected abstract T onRecentSnippetsFound(core.usecase.snippet.FindMostRecentSnippets.ResponseModel responseModel);
    protected abstract T onSnippetLikedUser(core.usecase.snippet.LikeSnippet.ResponseModel responseModel);
    
}
