public PartialSpecMatchResult() {}

public PartialSpecMatchResult(PartialSpecMatchResult Other) {
  this.Partial = Other.Partial;
  this.Args = Other.Args;
}

@Override
public PartialSpecMatchResult $assign(PartialSpecMatchResult Other) {
  this.Partial = Other.Partial;
  this.Args = Other.Args;
  return this;
}

@Override
public PartialSpecMatchResult clone() {
  return new PartialSpecMatchResult(this);
}