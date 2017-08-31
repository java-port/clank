public global_object_iterator_t(global_object_iterator_t $Prm0) {
  this.IsConst = $tryClone($Prm0.IsConst);
  this.function_i = $tryClone($Prm0.function_i);
  this.function_e = $tryClone($Prm0.function_e);
  this.global_i = $tryClone($Prm0.global_i);
}

@Override public global_object_iterator_t clone() {
  return new global_object_iterator_t(this);
}

/*JAVA*/private boolean IsConst;

@Override
public boolean $eq(Object other) {
  return !$noteq((global_object_iterator_t)other);
}
