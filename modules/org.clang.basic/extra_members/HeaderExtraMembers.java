@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static final Header EMPTY = new Header();

private Header() {
  this.NameAsWritten = new std.string();
  this.Entry = null;
}

// JAVA: initialization constuctor
public Header(string NameAsWritten, FileEntry Entry) {
  this.NameAsWritten = NameAsWritten;
  this.Entry = Entry;
}
public Header(StringRef NameAsWritten, FileEntry Entry) {
  this.NameAsWritten = NameAsWritten.$string();
  this.Entry = Entry;
}
public Header(char$ptr NameAsWritten, FileEntry Entry) {
  this.NameAsWritten = new std.string(NameAsWritten);
  this.Entry = Entry;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public Header $assign(Header other) {
  assert this != EMPTY;
  this.NameAsWritten.$assign(other.NameAsWritten);
  this.Entry = other.Entry;
  return this;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public Header $assignMove(Header other) {
  assert other != EMPTY;
  assert this != EMPTY;
  this.NameAsWritten.$assignMove(other.NameAsWritten);
  this.Entry = other.Entry;
  return this;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public Header clone() {
  return new Header(this);
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public Header move() {
  return new Header(JD$Move.INSTANCE, this);
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public boolean $noteq(Header other) {
  return !$eq(other);
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public boolean $eq(Header other) {
  return this.Entry == other.Entry && this.NameAsWritten.$eq(other.NameAsWritten);
}
