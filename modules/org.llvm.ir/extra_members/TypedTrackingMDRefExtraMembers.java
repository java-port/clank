@Override public void $destroy() {
  Ref.$destroy();
}

@Override
public TypedTrackingMDRef<T> clone() {
  return new TypedTrackingMDRef<>(this);
}

@Override
public TypedTrackingMDRef<T> move() {
  return new TypedTrackingMDRef<>(JD$Move.INSTANCE, this);
}
