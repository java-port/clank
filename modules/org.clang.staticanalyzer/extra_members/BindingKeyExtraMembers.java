@Override public boolean $less(Object obj) { 
  return this.$less((BindingKey)obj); 
}

public /*inline*/ BindingKey /*&*/ $assign(final BindingKey /*&&*/$Prm0) {
  this.P.$assign($Prm0.P);
  this.Data = $Prm0.Data;
  return /*Deref*/this;
}

public BindingKey() {
  this.P = new PointerIntPair<>();
  this.Data = 0;
}

@Override public BindingKey clone() {
  return new BindingKey(this);
}

@Override public String toString() {
  if (true) {
    std.string Buf = new std.string();
    raw_string_ostream OS = new raw_string_ostream(Buf);    
    $out_raw_ostream_BindingKey(OS, this);
    OS.flush();      
    return Buf.toJavaString();
  }        
  return "" + "P=" + P // NOI18N
            + ", Data=" + Data; // NOI18N
}
