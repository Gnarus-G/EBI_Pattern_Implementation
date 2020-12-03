package core.usecase.snippet;

import java.util.Collection;
import java.util.stream.Collectors;

import core.entity.Snippet;
import core.gateway.SnippetGateway;
import core.usecase.Command;
import core.usecase.RequestModelBuilder;

public class FindMostRecentSnippets extends SnippetInteractor
        implements Command<FindMostRecentSnippets.RequestModel, FindMostRecentSnippets.ResponseModel> {

    public FindMostRecentSnippets(SnippetGateway gateway) {
        super(gateway);
    }

    @Override
    public ResponseModel execute(RequestModelBuilder<RequestModel> requestModelBuilder) {
        RequestModel req = requestModelBuilder.build(new RequestModel());

        Collection<Snippet> latestSnippets = gateway.findAll().stream().sorted().limit(req.size).collect(Collectors.toList());


        return new ResponseModel(){{
            snippets = latestSnippets;
        }};
    }

    public static class RequestModel{
        public int size;
    }

    public static class ResponseModel {
        public Collection<Snippet> snippets;
    }
}
