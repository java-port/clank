@Override
public Conflict $assign(Conflict other) {
  this.Other = other.Other;
  this.Message = new std.string(other.Message);
  return this;
}

@Override
public Conflict clone() {
  return new Conflict(this);
}

@Override
public Conflict $assignMove(Conflict other) {
  this.Other = other.Other;
  this.Message = other.Message;
  other.Other = null;
  other.Message = null;
  return this;
}
