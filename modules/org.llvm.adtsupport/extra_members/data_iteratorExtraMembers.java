private data_iterator(data_iterator<internal_key_type, data_type> other) {
  super(other);
  this.InfoObj = other.InfoObj;
}

@Override public data_iterator<internal_key_type, data_type> clone() {
  return new data_iterator(this);
}    

@Override
public boolean $eq(Object other) {
  return iterator_base.$eq_iterator_base$C(this, (data_iterator) other);
}
