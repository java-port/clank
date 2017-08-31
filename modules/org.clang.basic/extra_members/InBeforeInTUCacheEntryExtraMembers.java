@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public InBeforeInTUCacheEntry $assign(InBeforeInTUCacheEntry $Prm0) {
  this.LQueryFID = $Prm0.LQueryFID;
  this.RQueryFID = $Prm0.RQueryFID;
  this.IsLQFIDBeforeRQFID = $Prm0.IsLQFIDBeforeRQFID;
  this.CommonFID = $Prm0.CommonFID;
  this.LCommonOffset = $Prm0.LCommonOffset;
  this.RCommonOffset = $Prm0.RCommonOffset;
  return this;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public InBeforeInTUCacheEntry $assignMove(InBeforeInTUCacheEntry $Prm0) {
  this.LQueryFID = $Prm0.LQueryFID;
  this.RQueryFID = $Prm0.RQueryFID;
  this.IsLQFIDBeforeRQFID = $Prm0.IsLQFIDBeforeRQFID;
  this.CommonFID = $Prm0.CommonFID;
  this.LCommonOffset = $Prm0.LCommonOffset;
  this.RCommonOffset = $Prm0.RCommonOffset;
  return this;
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public InBeforeInTUCacheEntry clone() {
  return new InBeforeInTUCacheEntry(this);
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
@Override
public boolean $eq(InBeforeInTUCacheEntry other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (this.LQueryFID != other.LQueryFID) {
    return false;
  }
  if (this.RQueryFID != other.RQueryFID) {
    return false;
  }
  if (this.IsLQFIDBeforeRQFID != other.IsLQFIDBeforeRQFID) {
    return false;
  }
  if (this.CommonFID != other.CommonFID) {
    return false;
  }
  if (this.LCommonOffset != other.LCommonOffset) {
    return false;
  }
  if (this.RCommonOffset != other.RCommonOffset) {
    return false;
  }
  return true;
}
