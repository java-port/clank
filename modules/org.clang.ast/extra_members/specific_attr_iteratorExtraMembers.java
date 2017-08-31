private final Class<SpecificAttr> clazz;   

public specific_attr_iterator(specific_attr_iterator  C) {
  // : Current(C) 
  this.Current = $tryClone(C.Current);
  this.clazz = C.clazz;
}

@Override
public boolean $eq(Object other) {
  return $eq_specific_attr_iterator$SpecificAttr(this, (specific_attr_iterator)other);
}

@Override
public specific_attr_iterator clone() {
  return new specific_attr_iterator(this);
}
