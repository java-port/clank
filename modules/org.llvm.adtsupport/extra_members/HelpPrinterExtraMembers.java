@Override
public Boolean $deref() {
  return ShowHidden;
}

@Override
public Boolean $set(Boolean value) {
  assert ShowHidden == value;
  return value;
}

@Override
public String toString() {
  return this.getClass().getSimpleName() + "{" + "ShowHidden=" + ShowHidden + '}' + System.identityHashCode(this);
}
