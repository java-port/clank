@Override
public Iterator<Node> iterator() {
  return new JavaIterator<>(begin(), end());
}

@Override
public boolean isAtBeginning() {
  return IsAtBeginning;
}

@Override
public void setAtBeginning(boolean v) {
  IsAtBeginning = v;
}

@Override
public boolean isAtEnd() {
  return IsAtEnd;
}

@Override
public void setAtEnd(boolean v) {
  IsAtEnd = v;
}

@Override
public Node getCurrentEntry() {
  return CurrentEntry;
}
