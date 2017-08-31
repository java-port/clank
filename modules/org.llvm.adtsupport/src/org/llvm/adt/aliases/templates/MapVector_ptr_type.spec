FILE_NAME = MapVectorPtrType
CLASS_SUFFIX = <KeyT, ValueT>
MAP_TYPE = DenseMapTypeUInt<KeyT>
MAP_ITER = DenseMapIteratorTypeUInt<KeyT>
MAP_PAIR = std.pairTypeUInt<KeyT>
VECTOR_TYPE = std.vector<std.pairPtrType<KeyT, ValueT>>
VECTOR_ITER = std.vector.iterator<std.pairPtrType<KeyT, ValueT> >
VECTOR_REVERSE_ITER = std.reverse_iterator<std.pairPtrType<KeyT, ValueT>>
VECTOR_PAIR = std.pairPtrType<KeyT, ValueT>
KEY_TYPE = KeyT
VALUE_TYPE = ValueT
VALUE_REFERENCE_TYPE = type$ref<ValueT>
IS_DATA_POINTER_LIKE = false
DEFAULT_VALUE = (ValueT)$Clone((NativeCloneable)defaultValue)
DENSE_MAP_INFO = DenseMapInfo<KeyT>
DEFAULT_DENSE_MAP_INFO = /*use constructor with keyInfo and defaultValue!*/null
EMPTY_DEFAULT_KEY=null
EMPTY_DEFAULT_VALUE=defaultValue
ASSERT_DEFAULT_VALUE= (defaultValue instanceof NativeCloneable) && NativeTrace.assertDefaultValue(defaultValue)
