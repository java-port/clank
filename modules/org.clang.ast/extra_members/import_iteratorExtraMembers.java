@Override
public import_iterator clone() {
  return new import_iterator(this);
}

@Override
public boolean $eq(Object other) {
  return $eq_import_iterator(this, (import_iterator) other);
}

@Override
public boolean $noteq(Object other) {
  return $noteq_import_iterator(this, (import_iterator) other);
}
