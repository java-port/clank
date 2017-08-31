FILE_NAME = StdMapUIntType
CLASS_SUFFIX = <ValueT>
DUAL_CLASS = std.mapUIntType<ValueT>
PAIR_TYPE = std.pairUIntType<ValueT>
ITERATOR = iterator<ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairUIntType<ValueT>>
KEY_TYPE = Integer
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = false
IS_DATA_POINTER_LIKE = false
PAIR_FACTORY_METHOD = std.make_pair_uint_T
DEFAULT_KEYS_COMPARATOR = Native::$compare_type_uint
ASSERT_DEFAULT_VALUE=($tryClone(defaultValue) != defaultValue)