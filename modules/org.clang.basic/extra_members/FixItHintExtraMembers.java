@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
@SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
public FixItHint clone() {
  return new FixItHint(this);
}

@Override public FixItHint move() {
  return new FixItHint(JD$Move.INSTANCE, this);
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public boolean $eq(FixItHint other) {
  if (this.BeforePreviousInsertions != other.BeforePreviousInsertions) {
    return false;
  }
  if (!this.RemoveRange.$eq(other.RemoveRange)) {
    return false;
  }
  if (!this.InsertFromRange.$eq(other.InsertFromRange)) {
    return false;
  }
  if (!this.CodeToInsert.$eq(other.CodeToInsert)) {
    return false;
  }
  return true;
}
