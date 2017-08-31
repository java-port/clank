FILE_NAME = StdMapIntType
CLASS_SUFFIX = <ValueT>
DUAL_CLASS = std.mapIntType<ValueT>
PAIR_TYPE = std.pairIntType<ValueT>
ITERATOR = iterator<ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairIntType<ValueT>>
KEY_TYPE = Integer
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = false
IS_DATA_POINTER_LIKE = false
PAIR_FACTORY_METHOD = std.make_pair_int_T
DEFAULT_KEYS_COMPARATOR = Native::$compare_type_int
ASSERT_DEFAULT_VALUE=($tryClone(defaultValue) != defaultValue)