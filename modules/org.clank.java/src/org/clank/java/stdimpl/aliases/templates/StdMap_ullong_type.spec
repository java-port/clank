FILE_NAME = StdMapULLongType
CLASS_SUFFIX = <ValueT>
DUAL_CLASS = std.mapULLongType<ValueT>
PAIR_TYPE = std.pairULongType<ValueT>
ITERATOR = iterator<ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairULongType<ValueT>>
KEY_TYPE = Long
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = false
IS_DATA_POINTER_LIKE = false
PAIR_FACTORY_METHOD = std.make_pair_ulong_T
DEFAULT_KEYS_COMPARATOR = Native::$compare_type_ulong
ASSERT_DEFAULT_VALUE=($tryClone(defaultValue) != defaultValue)