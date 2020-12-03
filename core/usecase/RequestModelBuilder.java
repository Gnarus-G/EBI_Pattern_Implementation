package core.usecase;

@FunctionalInterface
public interface RequestModelBuilder<Req> {
    Req build(Req req);
}
