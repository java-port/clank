public /*explicit*/ redecl_iterator(redecl_iterator<decl_type> $Prm0) {
  //START JInit
  this.Current = $Prm0.Current;
  this.Starter = $Prm0.Starter;
  this.PassedFirst = $Prm0.PassedFirst;
  //END JInit
}

@Override
public boolean $eq(Object other) {
  return $eq_redecl_iterator(this, (redecl_iterator)other);
}

@Override
public boolean $noteq(Object other) {
  return $noteq_redecl_iterator(this, (redecl_iterator)other);
}

@Override public redecl_iterator<decl_type> clone() { 
  return new redecl_iterator(this); 
}