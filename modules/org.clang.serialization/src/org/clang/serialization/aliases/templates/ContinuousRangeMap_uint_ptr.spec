FILE_NAME = ContinuousRangeMapUIntPtr
CLASS_SUFFIX = <ValuePtr>
KEY_TYPE = /*uint*/int
COMPARE_LESS_KEY=Unsigned.$less_uint
PAIR_TYPE = std.pairUIntPtr<ValuePtr>
RAW_PAIR_TYPE = std.pairUIntPtr
SMALL_VECTOR_TYPE=SmallVector<std.pairUIntPtr<ValuePtr>>
SMALL_VECTOR_INIT_WITH_CAPACITY = new SmallVector<std.pairUIntPtr<ValuePtr>>(InitialCapacity, std.make_pair_uint_Ptr(0, (ValuePtr/*P*/)null))
NUMBER_TO_KEY=intValue
