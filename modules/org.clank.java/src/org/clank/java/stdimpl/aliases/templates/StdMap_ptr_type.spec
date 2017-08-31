FILE_NAME = StdMapPtrType
CLASS_SUFFIX = <KeyT, ValueT>
DUAL_CLASS = std.mapPtrType<KeyT, ValueT>
PAIR_TYPE = std.pairPtrType<KeyT, ValueT>
ITERATOR = iterator<KeyT, ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairPtrType<KeyT, ValueT>>
KEY_TYPE = KeyT
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = true
IS_DATA_POINTER_LIKE = false
PAIR_FACTORY_METHOD = std.make_pair_Ptr_T
DEFAULT_KEYS_COMPARATOR = Native::$compare_ptr
ASSERT_DEFAULT_VALUE=($tryClone(defaultValue) != defaultValue)