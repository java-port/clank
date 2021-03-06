FILE_NAME = MapVectorTypeUInt
CLASS_SUFFIX = <KeyT>
MAP_TYPE = DenseMapTypeUInt<KeyT>
MAP_ITER = DenseMapIteratorTypeUInt<KeyT>
MAP_PAIR = std.pairTypeUInt<KeyT>
VECTOR_TYPE = std.vector<std.pairTypeUInt<KeyT>>
VECTOR_ITER = std.vector.iterator<std.pairTypeUInt<KeyT> >
VECTOR_REVERSE_ITER = std.reverse_iterator<std.pairTypeUInt<KeyT>>
VECTOR_PAIR = std.pairTypeUInt<KeyT>
KEY_TYPE = KeyT
VALUE_TYPE = /*uint*/int
VALUE_REFERENCE_TYPE = uint$ref
IS_DATA_POINTER_LIKE = false
DEFAULT_VALUE = defaultValue
ASSERT_DEFAULT_VALUE=true
DENSE_MAP_INFO = DenseMapInfo<KeyT>
DEFAULT_DENSE_MAP_INFO = DenseMapInfo$LikePtr.$Info()
EMPTY_DEFAULT_KEY=null
EMPTY_DEFAULT_VALUE=0
