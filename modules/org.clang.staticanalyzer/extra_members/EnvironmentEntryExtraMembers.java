@Override public EnvironmentEntry clone() { 
  return new EnvironmentEntry(this); 
}

@Override public EnvironmentEntry move() { 
  return new EnvironmentEntry(JD$Move.INSTANCE, this); 
}

@Override
public boolean $less(Object obj) {
  EnvironmentEntry other = (EnvironmentEntry) obj;
  int hash1 = System.identityHashCode(this.first);
  int hash2 = System.identityHashCode(other.first);
  if (hash1 < hash2) {
    return true;
  }
  if (hash1 > hash2) {
    return false;
  }
  hash1 = System.identityHashCode(this.second);
  hash2 = System.identityHashCode(other.second);
  if (hash1 < hash2) {
    return true;
  }
  return false;
}
