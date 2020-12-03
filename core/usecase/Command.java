package core.usecase;

public interface Command<Req, Res> {
    Res execute(RequestModelBuilder<Req> requestModelBuilder);
}
