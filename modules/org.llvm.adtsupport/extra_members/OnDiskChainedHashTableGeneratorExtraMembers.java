public static interface EmitInfoInterface<internal_key_type, data_type, file_type> extends InfoInterface<Void/*unused*/, internal_key_type, data_type> {

  /**
   * returns <Key-Length, Data-Length> information.
   * @param out
   * @param key
   * @param data
   * @return pair<key-length, data-length>
   */
  public default /*std.pair<uint, uint>*/long EmitKeyDataLength$WrapPair(raw_ostream out, internal_key_type key, data_type data) {
    NativeTrace.assertTrueInConsole(false, "Must be implemented for faster writes and less memory allocations. Usually it's enough to change return type and wrap pair into long as here.");
    std.pairUIntUInt ret = EmitKeyDataLength(out, key, data);
    return wrap_uint_uint_pair(ret.first, ret.second);
  }
  public default std.pairUIntUInt EmitKeyDataLength(raw_ostream out, internal_key_type key, data_type data) {
    throw new UnsupportedOperationException("EmitKeyDataLength must be implemented:" + this.getClass() + ". Forgot to remove static?");
  }

  public default void EmitKey(raw_ostream out, internal_key_type key, int sizeof) {
    throw new UnsupportedOperationException("EmitKey must be implemented:" + this.getClass() + ". Forgot to remove static?");
  }

  public default void EmitData(raw_ostream out, internal_key_type key, data_type data, int sizeof) {
    throw new UnsupportedOperationException("EmitData must be implemented:" + this.getClass() + ". Forgot to remove static?");
  }

  public default void EmitFileRef(raw_ostream OutStream, file_type/*P*/ FileRef) {
    throw new UnsupportedOperationException("EmitFileRef must be implemented:" + this.getClass() + ". Forgot to remove static?");
  }

  @Override
  public default boolean EqualKey(internal_key_type a, internal_key_type b) {
    throw new UnsupportedOperationException("Should be implemented for EmitInfoInterface if 'contains' need to be supported " + this.getClass());
  }   

  public default /*const*/char$ptr/*char P*/ strings_begin() /*const*/ {
    throw new UnsupportedOperationException("Should be implemented for EmitInfoInterface in " + this.getClass());
  }   

  public default /*const*/char$ptr/*char P*/ strings_end() /*const*/ {
    throw new UnsupportedOperationException("Should be implemented for EmitInfoInterface in " + this.getClass());
  }   

  public default void $destroy() {
    throw new UnsupportedOperationException("Should be implemented for EmitInfoInterface in " + this.getClass());
  }

  // Read methods in fact are not provided by Emit interface
  @Override
  public default data_type ReadData(internal_key_type key, char$ptr data, int OffsetInBuf, int len) {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }

  @Override
  public default data_type ReadData(internal_key_type key, char$ptr Buf, int DataLength) {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }

  @Override
  public default internal_key_type GetInternalKey(Void eKey) {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }

  @Override
  public default Void GetExternalKey(internal_key_type x) {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }

  @Override
  public default /*std.pair<uint, uint>*/long ReadKeyDataLength(char$ptr d, int OffsetInBuf) {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }
  @Override
  public default /*uint*/int getReadKeyDataLengthBytes() {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }

  @Override
  public default pairUIntUInt ReadKeyDataLength(char$ptr Buf) {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }

  @Override
  public default internal_key_type ReadKey(char$ptr d, int OffsetInBuf, int var) {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }

  @Override
  public default internal_key_type ReadKey(char$ptr Buf, int KeyLength) {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }

  @Override
  public default <file_type> file_type ReadFileRef(char$ptr Buf) {
    throw new UnsupportedOperationException("Not supported for EmitInfoInterface");
  }
}  
