public final char$ptr $PtrBase() {
  return $Ptr;
}
    
protected iterator_base(iterator_base $Prm0) {
  this.$Ptr = $Prm0.$Ptr;
  this.Ptr = $Prm0.Ptr;
  this.NumItemsInBucketLeft = $Prm0.NumItemsInBucketLeft;
  this.NumEntriesLeft = $Prm0.NumEntriesLeft;
}

protected iterator_base $assignMove(iterator_base $Prm0) {
  this.$Ptr.$assignMove($Prm0.$Ptr);
  this.Ptr = $Prm0.Ptr;
  this.NumItemsInBucketLeft = $Prm0.NumItemsInBucketLeft;
  this.NumEntriesLeft = $Prm0.NumEntriesLeft;
  return this;
}
