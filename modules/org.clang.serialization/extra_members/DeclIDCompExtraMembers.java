@Override
public boolean $less(Object one, Object other) {
  if (one instanceof SourceLocation) {
     return $call((SourceLocation)one, (Integer)other);
  } else if (other instanceof SourceLocation) {
     return $call((Integer)one, (SourceLocation)other);
  } else {
     return $call((Integer)one, (Integer)other);
  }
}
