public /*inline*/ PreambleFileHash /*&*/ $assign(PreambleFileHash /*&&*/$Prm0) {
  this.Size = $Prm0.Size;
  this.ModTime = $Prm0.ModTime;
  __builtin_memcpy(/*AddrOf*/this.MD5, /*AddrOf*/$Prm0.MD5, sizeof($Prm0.MD5));
  return /*Deref*/this;
}

@Override public PreambleFileHash clone() {
  return new PreambleFileHash().$assign(this);
}

@Override public PreambleFileHash move() {
  return new PreambleFileHash(JD$Move.INSTANCE, this);
}
