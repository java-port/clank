@Override
public TrackingVH $assign(TrackingVH $Prm0) {
  super.$assign($Prm0.$T$P());
  return this;
}

@Override
public TrackingVH clone() {
  return new TrackingVH(Value$Class, this.$T$P());
}

private final Class<ValueTy> Value$Class;
