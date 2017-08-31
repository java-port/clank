private final static iterator END_ITERATOR = new iterator();

public static int $sizeof_Offset_type() { 
  return sizeof$uint32();
}
public static int $sizeof_Hash_Value_type() {
  return sizeof$uint32();
}

public static interface InfoInterface<external_key_type, internal_key_type, data_type> {
  // returns <Key-Length, Data-Length> information
  // Buf is const and must NOT be shifted;
  // Use getReadKeyDataLengthBytes when interested how many bytes were read!
  default /*std.pair<uint, uint>*/long ReadKeyDataLength(/*const uchar P&*/char$ptr Buf, int OffsetInBuf) {
    NativeTrace.assertTrueInConsole(false, "Must be implemented for faster reads");
    Buf = Buf.$add(OffsetInBuf);
    std.pairUIntUInt out = ReadKeyDataLength(Buf);
    assert Buf.$index() - OffsetInBuf == getReadKeyDataLengthBytes() : "expected to read " + getReadKeyDataLengthBytes() + ", but in reality shifted by " + (Buf.$index() - OffsetInBuf) + " from " + OffsetInBuf;
    return wrap_uint_uint_pair(out.first, out.second);
  }
  default /*uint*/int getReadKeyDataLengthBytes() {
    throw new UnsupportedOperationException("This methods must be implemented together with ReadKeyDataLength(Buf, OffsetInBuf) to return how many bytes were read without shifting:" + this.getClass());
  }

  // this method usually is implemented by default as static (shifts Buf pointer by using readNext)
  default std.pairUIntUInt ReadKeyDataLength(/*const uchar P&*/char$ptr Buf) {
    throw new UnsupportedOperationException("ReadKeyDataLength(Buf, OffsetInBuf) or ReadKeyDataLength(Buf) must be implemented:" + this.getClass() + ". Forgot to remove static?");
  }

  // reads Key from Buf stream; KeyLength specifies number of bytes used by Key in stream
  // Buf is const and must NOT be shifted, usually readNext is replaced by read method
  default internal_key_type ReadKey(char$ptr Buf, int OffsetInBuf, int KeyLength) {
    NativeTrace.assertTrueInConsole(false, "Must be implemented for faster reads");
    Buf = Buf.$add(OffsetInBuf);
    internal_key_type out = ReadKey(Buf, KeyLength);
    assert Buf.$index() - OffsetInBuf == getReadKeyDataLengthBytes() : "expected to read " + getReadKeyDataLengthBytes() + ", but in reality shifted by " + (Buf.$index() - OffsetInBuf) + " from " + OffsetInBuf;
    return out;
  }
  // this method usually is implemented by default as static (shifts Buf pointer by using readNext)
  default internal_key_type ReadKey(char$ptr Buf, int KeyLength) {
    throw new UnsupportedOperationException("ReadKey(Buf, OffsetInBuf, KeyLength) or ReadKey(Buf, KeyLength) must be implemented:" + this.getClass() + ". Forgot to remove static?");
  }

  // reads Data from Buf stream; DataLength specifies number of bytes used by Data in stream
  // Buf is const and must NOT be shifted
  default data_type ReadData(internal_key_type key, char$ptr Buf, int OffsetInBuf, int DataLength) {
    NativeTrace.assertTrueInConsole(false, "Must be implemented for faster reads");
    Buf = Buf.$add(OffsetInBuf);
    data_type out = ReadData(key, Buf, DataLength);
    assert Buf.$index() - OffsetInBuf == DataLength : "expected to read " + DataLength + ", but in reality shifted by " + (Buf.$index() - OffsetInBuf) + " from " + OffsetInBuf;
    return out;
  }
  // this method usually is implemented by default as static (shifts Buf pointer by using readNext)
  default data_type ReadData(internal_key_type key, char$ptr Buf, int DataLength) {
    throw new UnsupportedOperationException("ReadData(key, Buf, OffsetInBuf, DataLength) or ReadData(key, Buf, OffsetInBuf, DataLength) must be implemented:" + this.getClass() + ". Forgot to remove static?");
  }

  // this method usually is implemented by default as static
  default <file_type> file_type ReadFileRef(final char$ptr/*const uchar P&*/ Buf) {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
  }

  // this method usually is implemented by default as static 
  default internal_key_type GetInternalKey(external_key_type eKey) {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
  }

  // this method usually is implemented by default as static 
  default external_key_type GetExternalKey(internal_key_type x) {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
  }

  // this method usually is implemented by default as static 
  default /*uint32_t*/int ComputeHash(internal_key_type iKey) {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
  }

  // this method usually is implemented by default as static 
  default boolean EqualKey(internal_key_type a, internal_key_type b) {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass() + "? Forgot to remove static?");
  }
}

// PERF: method to directly read data by key vs access through interator. This is the copy of find with inlined find_hashed
public final data_type $get(/*const*/external_key_type /*&*/ EKey) {
  return $get(EKey, InfoObj);
}
public final data_type $get(/*const*/external_key_type /*&*/ EKey, InfoInterface<external_key_type, internal_key_type, data_type> /*P*/ InfoPtr/*= 0*/) {
  assert InfoPtr != null;
  assert InfoPtr == InfoObj;

  //JAVA: using namespace llvm::support;
  /*const*/internal_key_type /*&*/ IKey = InfoPtr.GetInternalKey(EKey);
  /*uint32_t*/int KeyHash = InfoPtr.ComputeHash(IKey);

  // Each bucket is just an offset into the hash table file.
  /*uint*/int Idx = KeyHash & (NumBuckets - 1);
  assert Idx >= 0 : "negative " + Idx + " for " + KeyHash + " with " + NumBuckets;
  /*const*/int/*uchar P*/ Bucket = /*Buckets.$add*/($sizeof_Offset_type() * Idx);

  /*uint*/int Offset = endian.read_uint32(little, aligned, Buckets, Bucket);
                              // Bucket+=$sizeof_Offset_type();
  if (Offset == 0) {
    return null; // Empty bucket.
  }
  /*const*/int/*uchar P*/ Items = /*Base.$add*/(Offset);

  // 'Items' starts with a 16-bit unsigned integer representing the
  // number of items in this bucket.
  /*uint*/int Len = endian.read_uint16(little, unaligned, Base, Items);
                           Items+=sizeof$uint16();//shift index

  for (/*uint*/int i = 0; i < Len; ++i) {
    // Read the hash.
    /*uint32_t*/int ItemHash = endian.read_uint32(little, unaligned, Base, Items);
                                      Items += $sizeof_Hash_Value_type();//shift index
    // Determine the length of the key and the data.
    /*const*//*std.pair<uint, uint>*/long/*&*/ L = InfoPtr.ReadKeyDataLength(Base, Items);
    Items += /*$inc*/(InfoPtr.getReadKeyDataLengthBytes());
    int KeyLen = $first_int(L);
    int DataLen = $second_int(L);
    /*uint*/int ItemLen = KeyLen + DataLen;

    // Compare the hashes.  If they are not the same, skip the entry entirely.
    if (ItemHash != KeyHash) {
      Items += /*$inc*/(ItemLen); // shift index
      continue;
    }

    // Read the key.
    /*const*/internal_key_type /*&*/ X = InfoPtr.ReadKey(Base, Items, KeyLen);

    // If the key doesn't match just skip reading the value.
    if (!InfoPtr.EqualKey(X, IKey)) {
      Items += /*$inc*/(ItemLen); // shift index
      continue;
    }

    // The key matches!
    return InfoPtr.ReadData(X, Base, Items += /*$inc*/KeyLen, DataLen);
  }

  return null;
}
