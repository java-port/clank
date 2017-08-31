FILE_NAME = DenseMapTypeUShort
CLASS_SUFFIX = <KeyT>
PAIR_TYPE = std.pairTypeUShort<KeyT>
PAIR_NAME = std.pairTypeUShort
KEY_TYPE = KeyT
RAW_KEY_TYPE = Object
VALUE_TYPE = /*ushort*/char
VALUE_CLASS = Class<Char>
DENSE_MAP_INFO = DenseMapInfo<KeyT>
DENSE_MAP_BASE = DenseMapBaseTypeUShort<DenseMapTypeUShort<KeyT>, KeyT>
CREATE_NEW_BUCKET_PAIR = isKeyPointerLike() ? new std.pairPtrUShort() : new std.pairTypeUShort()
