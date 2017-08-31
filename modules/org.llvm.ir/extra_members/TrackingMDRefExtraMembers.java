@Override
public TrackingMDRef clone() {
    return new TrackingMDRef(this);
}

private final type$ptr<Metadata/*P*/> /*P*/ MD$Ptr = new type$ptr$inout<Metadata/*P*/>() {
  @Override
  protected Metadata/*P*/ $star$impl() {
    return MD;
  }

  @Override
  protected Metadata/*P*/ $set$impl(Metadata/*P*/ value) {
    return MD = value;
  }

  @Override
  public type$ptr$inout<Metadata> clone() {
    assert false : "why was cloned?";
    return this;
  }
};
