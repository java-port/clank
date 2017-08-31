FILE_NAME = StdMapTypeType
CLASS_SUFFIX = <KeyT, ValueT>
DUAL_CLASS = std.mapTypeType<KeyT, ValueT>
PAIR_TYPE = std.pairTypeType<KeyT, ValueT>
ITERATOR = iterator<KeyT, ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairTypeType<KeyT, ValueT>>
KEY_TYPE = KeyT
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = false
IS_DATA_POINTER_LIKE = false
PAIR_FACTORY_METHOD = std.make_pair_T_T
DEFAULT_KEYS_COMPARATOR = Native::$compare_type
ASSERT_DEFAULT_VALUE=($tryClone(defaultValue) != defaultValue)