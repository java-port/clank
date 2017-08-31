@Override
public UnresolvedConflict $assign(UnresolvedConflict other) {
  this.Id = new ClankAliases.ModuleId(other.Id);
  this.Message = new std.string(other.Message);
  return this;
}

@Override
public UnresolvedConflict clone() {
  return new UnresolvedConflict(this);
}

@Override
public UnresolvedConflict $assignMove(UnresolvedConflict other) {
  this.Id = other.Id;
  this.Message = other.Message;
  other.Id = null;
  other.Message = null;
  return this;
}
