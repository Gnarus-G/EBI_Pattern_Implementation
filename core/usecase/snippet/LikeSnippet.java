package core.usecase.snippet;

import core.entity.Snippet;
import core.gateway.SnippetGateway;
import core.usecase.Command;
import core.usecase.RequestModelBuilder;

public class LikeSnippet extends SnippetInteractor
        implements Command<LikeSnippet.RequestModel, LikeSnippet.ResponseModel> {

    public LikeSnippet(SnippetGateway gateway) {//In fact, we would need to inject a UserGateway here as well.
        super(gateway);
    }

    @Override
    public ResponseModel execute(RequestModelBuilder<RequestModel> requestModelBuilder) {

        RequestModel req = requestModelBuilder.build(new RequestModel());

        Snippet snippet = gateway.findById(req.snippetId);

        String resMessage = snippet != null ? "User #" + req.userId + " liked snippet #" + snippet.getId() : "No such snippet to like: #" +req.snippetId;

        return new ResponseModel() {
            {
                responseMsg = resMessage;
            }
        };
    }

    public static class RequestModel {
        public long snippetId;
        public int userId;
    }

    public static class ResponseModel {
        public String responseMsg;
    }

}
