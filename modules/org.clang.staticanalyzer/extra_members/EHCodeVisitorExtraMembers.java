public bool$ref inEH$ref = new bool$ref() {
  @Override
  public boolean $deref() {
    return inEH;
  }
  @Override
  public boolean $set(boolean value) {
    inEH = value;
    return inEH;
  }
};

@Override
public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
  // no Traverse* methods with Queue params
  return false;
}
