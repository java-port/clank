public bool$ref Consistent_ref = new bool$ref(){
  @Override
  public boolean $deref() {
    return Consistent;
  }

  @Override
  public boolean $set(boolean value) {
    Consistent = value;
    return Consistent;
  }
};

public FullDependence(FullDependence Other) {
  super(Other);
}
