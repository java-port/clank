private final Source$SmallVector2Void<Source, T> Loader;

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public LazyVector(Source$SmallVector2Void<Source, T> Loader, /*uint*/int LoadedStorage/* = 2*/, /*uint*/int LocalStorage /* = 4*/) {
  assert Loader != null;
  this.Loader = Loader;
  this.Loaded = new SmallVector<>(LoadedStorage, (T)null);
  this.Local = new SmallVector<>(LocalStorage, (T)null);
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override public void $destroy() {
  this.Local.$destroy();
  this.Loaded.$destroy();
  Destructors.$destroy(this.Loader);
}
