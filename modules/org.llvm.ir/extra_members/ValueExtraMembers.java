protected Value() { 
  /*for descendants deleted ctors + for sentinels */ 
  UseList = null;
}

private int $sizeof_Value() {
  return 3 * $sizeof_ptr(/*Object */) + 2 * $sizeof_UInt();
}
