@Override 
public shadow_iterator clone() { 
  return new shadow_iterator(this); 
}

@Override
public boolean $eq(Object other) {
  return $eq_shadow_iterator(this, (shadow_iterator) other);
}

@Override
public boolean $noteq(Object other) {
  return $noteq_shadow_iterator(this, (shadow_iterator) other);
}
