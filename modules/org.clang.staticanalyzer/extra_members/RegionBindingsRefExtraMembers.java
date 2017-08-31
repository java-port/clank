private void dumpToString(raw_ostream OS) {
  dump(OS, $LF);
}

@Override
public RegionBindingsRef move() {
  return new RegionBindingsRef(JD$Move.INSTANCE, this);
}
