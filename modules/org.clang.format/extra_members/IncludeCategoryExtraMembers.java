public IncludeCategory(string Regex, int Priority) {
  this.Regex = Regex;
  this.Priority = Priority;
}

public IncludeCategory(char$ptr Regex, int Priority) {
  this.Regex = new std.string(Regex);
  this.Priority = Priority;
}

@Override
public IncludeCategory clone() {
  return new IncludeCategory(this);
}

public int$ref Priority_ref = new int$ref(){
  @Override
  public int $deref() {
    return Priority;
  }

  @Override
  public int $set(int value) {
    Priority = value;
    return Priority;
  }     
};
