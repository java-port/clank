FILE_NAME = DenseMap
CLASS_SUFFIX = <KeyT, ValueT>
PAIR_TYPE = std.pair<KeyT, ValueT>
PAIR_NAME = std.pair
KEY_TYPE = KeyT
RAW_KEY_TYPE = Object
VALUE_TYPE = ValueT
VALUE_CLASS = Class<ValueT>
DENSE_MAP_INFO = DenseMapInfo<KeyT>
DENSE_MAP_BASE = DenseMapBase<DenseMap<KeyT, ValueT>, KeyT, ValueT>
CREATE_NEW_BUCKET_PAIR = isKeyPointerLike() ? \n\
\t                                            (isDataPointerLike() ? new std.pairPtrPtr() : new std.pairPtrType()) \n\
\t                                          : \n\
\t                                            (isDataPointerLike() ? new std.pairTypePtr() : new std.pairTypeType())
